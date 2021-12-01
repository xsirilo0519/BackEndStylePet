package com.StylePet.StylePet.Turnos;

import com.StylePet.StylePet.Estilistas.EstilistasRepository;
import com.StylePet.StylePet.Estilistas.EstilistasService;
import com.StylePet.StylePet.TipoMascota.TipoService;
import com.StylePet.StylePet.Usuarios.UsuarioEntity;
import com.StylePet.StylePet.Usuarios.UsuariosModel;
import com.StylePet.StylePet.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnosService {
    private TurnosRepository turnosRepository;
    private EstilistasService estilistasService;
    @Autowired
    public TurnosService (TurnosRepository turnosRepository, EstilistasService estilistasService){
        this.estilistasService=estilistasService;
        this.turnosRepository=turnosRepository;
    }

    public TurnosModel Editar(TurnosModel turnosModel){
        try {
            return convertEntiryToModel(turnosRepository.save(convertModelToEntity(turnosModel)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public TurnosModel buscarById(Integer id){
        Optional<TurnoEntity> turnoEntity=turnosRepository.findById(id);
        if(turnoEntity.isPresent()){
            TurnosModel turnosModel= new TurnosModel(turnoEntity.get().getId(),turnoEntity.get().getTurno(),estilistasService.buscarById(turnoEntity.get().getCed_estilista()),turnoEntity.get().getEstado());
            return turnosModel;
        }
         return null;
    }
    public TurnosModel convertEntiryToModel(TurnoEntity turnoEntity){
        return new TurnosModel(turnoEntity.getId(),turnoEntity.getTurno(),null,turnoEntity.getEstado());
    }
    public TurnoEntity convertModelToEntity(TurnosModel turnosModel){
        return new TurnoEntity(turnosModel.getId(),turnosModel.getTurno(),turnosModel.getEstado(),turnosModel.getCed_estilista().getCedula());
    }


}
