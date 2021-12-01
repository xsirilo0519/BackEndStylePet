package com.StylePet.StylePet.Citas;

import com.StylePet.StylePet.Cortes.CortesModel;
import com.StylePet.StylePet.Cortes.CortesService;
import com.StylePet.StylePet.Estilistas.EstilistasModel;
import com.StylePet.StylePet.Estilistas.EstilistasService;
import com.StylePet.StylePet.Mascotas.MascotaEntity;
import com.StylePet.StylePet.Mascotas.MascotasModel;
import com.StylePet.StylePet.Mascotas.MascotasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CitasService {

    private CitasRepository citasRepository;
    private MascotasService mascotasService;
    private CortesService cortesService;
    private EstilistasService estilistasService;
    private CitaEntity citaEntity;

    @Autowired
    public CitasService(CitasRepository citasRepository, MascotasService mascotasService, CortesService cortesService,EstilistasService estilistasService ){
    this.citasRepository=citasRepository;
    this.mascotasService=mascotasService;
    this.cortesService=cortesService;
    this.estilistasService=estilistasService;
    }

    public List<CitasModel> findAll(){
        List<CitasModel> citasModels = new ArrayList<CitasModel>();
        try {
            citasRepository.findAll()
                    .forEach(cita -> {
                        CortesModel cortesModel = cortesService.buscarById(cita.getId_corte());
                        EstilistasModel estilistasModel= estilistasService.buscarById(cita.getEstilista());
                        Optional<MascotaEntity> mascotaEntity=mascotasService.findByCode(cita.getCodigo_mascota());
                        MascotasModel mascotasModel = mascotasService.convertEntityToModel(mascotaEntity.get());
                        citasModels.add(new CitasModel(cita.getCodigo(),mascotasModel, cortesModel,estilistasModel));
                            }
                    );
            return citasModels;
        }catch (Exception e){
            return null;
        }
    }
    public CitasModel guardar(CitasModel citasModel) {
        try{
            CitaEntity citaEntity= convertModelToEntity(citasModel);
            if(mascotasService.findByCode(citaEntity.getCodigo_mascota()).isPresent()
                    && (cortesService.buscarById(citaEntity.getId_corte())!=null)
                    && (estilistasService.buscarById(citaEntity.getEstilista())!=null)){

                citasRepository.save(citaEntity);
                return citasModel;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Optional<CitaEntity> findByCode(Long codigo){
       return (Optional<CitaEntity>) citasRepository.findById(codigo);
    }


    public CitaEntity convertModelToEntity(CitasModel citasModel){
        return new CitaEntity(citasModel.getCodigo(),citasModel.getCodigo_mascota().getCodigo(), citasModel.getId_corte().getId(), citasModel.getEstilista().getCedula());
    }



}
