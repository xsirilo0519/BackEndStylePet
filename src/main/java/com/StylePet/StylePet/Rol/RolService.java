package com.StylePet.StylePet.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public RolModel buscarById(Integer id){
        Optional<RolEntity> rolEntity=rolRepository.findById(id);
        if(rolEntity.isPresent()){
            RolModel rolModel= new RolModel(rolEntity.get().getId(),rolEntity.get().getName());
            return rolModel;
        }
        return null;
    }

}
