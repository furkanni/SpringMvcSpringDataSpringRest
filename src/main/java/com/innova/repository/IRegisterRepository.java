package com.innova.repository;

import com.innova.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRegisterRepository extends CrudRepository<RegisterEntity,Long> {

    List<RegisterEntity>  findRegisterEntitiesByUserEmail(String userEmail);

}
