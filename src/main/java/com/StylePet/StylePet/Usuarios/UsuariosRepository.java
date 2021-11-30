package com.StylePet.StylePet.Usuarios;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepository extends CrudRepository<UsuarioEntity,Long> {
    public abstract Optional<UsuarioEntity> findByEmailAndContrasena(String email, String contrasena);
}
