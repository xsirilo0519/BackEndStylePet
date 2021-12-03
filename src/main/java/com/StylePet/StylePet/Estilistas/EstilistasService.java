package com.StylePet.StylePet.Estilistas;

import com.StylePet.StylePet.Mascotas.MascotaEntity;
import com.StylePet.StylePet.Mascotas.MascotasModel;
import com.StylePet.StylePet.Turnos.TurnoEntity;
import com.StylePet.StylePet.Turnos.TurnosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstilistasService {
    @Autowired
    EstilistasRepository cortesRepository;

    public EstilistasModel buscarById(Long id){
        Optional<EstilistasEntity> estilistasEntity =cortesRepository.findById(id);
        if(estilistasEntity.isPresent()){
            EstilistasModel estilistasModel= new EstilistasModel(estilistasEntity.get().getCedula(),estilistasEntity.get().getName(),ListEntityToModel(estilistasEntity.get().getTurnoEntities()));
            return estilistasModel;
        }
         return null;
    }

    public List<EstilistasModel> buscar (){
        List<EstilistasModel> listEstilistas=new ArrayList<>();
        cortesRepository.findAll().forEach(estilista->{
            listEstilistas.add(convertEntityToModel(estilista));
        });
        return listEstilistas;
    }

    private EstilistasModel convertEntityToModel(EstilistasEntity estilistasEntity){

        return new EstilistasModel(estilistasEntity.getCedula(),estilistasEntity.getName(),ListEntityToModel(estilistasEntity.getTurnoEntities()));
    }

    private List<TurnosModel> ListEntityToModel(List<TurnoEntity> list){
        List<TurnosModel>turnosModels=new ArrayList<>();
            list.forEach(item->{
                turnosModels.add(new TurnosModel(item.getId(),item.getTurno(),null,item.getEstado()));
        });
        return turnosModels;
    }
}
