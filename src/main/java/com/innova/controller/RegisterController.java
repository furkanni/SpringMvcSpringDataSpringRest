package com.innova.controller;

import com.innova.dto.RegisterDto;
import com.innova.entity.RegisterEntity;
import com.innova.repository.IRegisterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@Log4j2
public class RegisterController {

    @Autowired
    IRegisterRepository iRegisterRepository;

    /////SAVE
    // http://localhost:8080/user/create
    @GetMapping("/user/create")
    @ResponseBody
    public String getCreateUser(){
        RegisterEntity registerEntity=RegisterEntity
                .builder()
                .userId(0L)
                .userName("Furkan")
                .userSurname("Nişancı")
                .userEmail("Furkan@nisanci.com")
                .userPassword("123456")
                .build();

        iRegisterRepository.save(registerEntity);
        return "Ekleme başarılı";
    }

    //REGISTER
    // http://localhost:8080/register
    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("key_form", new RegisterDto());
        return "register";
    }

    // http://localhost:8080/register
    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("key_form") RegisterDto registerDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata Oluştu");
            log.info(registerDto);
            return "register";
        }else{
            RegisterEntity registerEntity = RegisterEntity.builder()
                    .userId(0L)
                    .userName(registerDto.getUserName())
                    .userSurname(registerDto.getUserSurname())
                    .userEmail(registerDto.getEmailAddress())
                    .userPassword(registerDto.getUserPassword())
                    .build();

            iRegisterRepository.save(registerEntity);
            return "success";
        }
    }

}
