package com.StylePet.StylePet.Turnos;

import com.StylePet.StylePet.Estilistas.EstilistasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public TurnosModel convertEntiryToModel(TurnoEntity turnoEntity){
        return new TurnosModel(turnoEntity.getId(),turnoEntity.getTurno(),null,turnoEntity.getEstado());
    }
    public TurnoEntity convertModelToEntity(TurnosModel turnosModel){
        return new TurnoEntity(turnosModel.getId(),turnosModel.getTurno(),turnosModel.getEstado(),turnosModel.getCed_estilista().getCedula());
    }


}
