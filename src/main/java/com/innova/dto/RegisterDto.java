package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


import javax.validation.constraints.*;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2


// NEMM :  @NotEmpty @Email @Min @Max @Size
public class RegisterDto {

    @NotEmpty(message = "Adınızı Yazmadan Devam Edemezsiniz!")
    private String userName;

    @NotEmpty(message = "Soyadınızı Yazmadan Devam Edemezsiniz!")
    private String userSurname;

    @NotEmpty(message = "Lütfen e-mail adresi giriniz! Boş Bırakılamaz!")
    @Email(message = "Uygun formatlarda bir e-mail adresi giriniz!")
    private String emailAddress;

    @NotEmpty(message = "Şifrenizi Giriniz!!!")
    @Size(min=6,max=12)
    private String userPassword;
}
