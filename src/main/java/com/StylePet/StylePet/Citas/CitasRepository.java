package com.StylePet.StylePet.Citas;

import com.StylePet.StylePet.Usuarios.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CitasRepository extends CrudRepository<CitaEntity,Long> {
    public abstract List<CitaEntity> findByCodigomascota(Long codigo );
}
