package com.StylePet.StylePet.Citas;

import com.StylePet.StylePet.Cortes.CortesModel;
import com.StylePet.StylePet.Cortes.CortesService;
import com.StylePet.StylePet.Estilistas.EstilistasModel;
import com.StylePet.StylePet.Estilistas.EstilistasService;
import com.StylePet.StylePet.Mascotas.MascotaEntity;
import com.StylePet.StylePet.Mascotas.MascotasModel;
import com.StylePet.StylePet.Mascotas.MascotasService;

import com.StylePet.StylePet.Usuarios.LoginModel;
import com.StylePet.StylePet.Usuarios.UsuarioEntity;
import com.StylePet.StylePet.Usuarios.UsuariosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
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
                        Optional<MascotaEntity> mascotaEntity=mascotasService.findByCode(cita.getCodigomascota());
                        MascotasModel mascotasModel = mascotasService.convertEntityToModel(mascotaEntity.get());
                        citasModels.add(new CitasModel(cita.getCodigo(),mascotasModel, cortesModel,estilistasModel,cita.getHora()));
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
            if(mascotasService.findByCode(citaEntity.getCodigomascota()).isPresent()
                    && (cortesService.buscarById(citaEntity.getId_corte())!=null)
                    && (estilistasService.buscarById(citaEntity.getEstilista())!=null)){

                return convertEntityToModel(citasRepository.save(citaEntity));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public boolean eliminar(Long codigo){
        Optional<CitaEntity> citaEntity=findByCode(codigo);
        if(citaEntity.isPresent()) {
            citasRepository.delete(citaEntity.get());
            return true;
        }
        return false;
    }

    public List<CitasModel> findByPet(Long mascota){
        List<CitaEntity> listCita =  citasRepository.findByCodigomascota(mascota);
        if(!listCita.isEmpty()){
            return listEntityToModel(listCita);
        }
        return null;
    }

    private List<CitasModel> listEntityToModel(List<CitaEntity> list){
        List<CitasModel> listmodel=new ArrayList<>();
        list.forEach(item->{
            listmodel.add(convertEntityToModel(item));
        });
        return listmodel;
    }

    private Optional<CitaEntity> findByCode(Long codigo){
       return (Optional<CitaEntity>) citasRepository.findById(codigo);
    }


    private CitaEntity convertModelToEntity(CitasModel citasModel){
        return new CitaEntity(citasModel.getCodigo(),citasModel.getCodigo_mascota().getCodigo(), citasModel.getId_corte().getId(), citasModel.getEstilista().getCedula(),citasModel.getHora());
    }
    private CitasModel convertEntityToModel(CitaEntity citas){
        CortesModel cortesModel = cortesService.buscarById(citas.getId_corte());
        EstilistasModel estilistasModel= estilistasService.buscarById(citas.getEstilista());
        Optional<MascotaEntity> mascotaEntity=mascotasService.findByCode(citas.getCodigomascota());
        MascotasModel mascotasModel = mascotasService.convertEntityToModel(mascotaEntity.get());
        return new CitasModel(citas.getCodigo(),mascotasModel,cortesModel ,estilistasModel ,citas.getHora());
    }



}
