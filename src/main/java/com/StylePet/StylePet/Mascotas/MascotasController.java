package com.StylePet.StylePet.Mascotas;

import com.StylePet.StylePet.Usuarios.UsuariosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Mascotas")
public class MascotasController {
    @Autowired
    MascotasService mascotasService;

    @GetMapping(value="/buscar")
    public List<MascotasModel> listaDeMascotas(){
         return  mascotasService.findAll();
    }

    @PostMapping(value = "/agregar")
    public ResponseEntity<String> guardar(@RequestBody MascotasModel mascotasModel){
        mascotasModel=mascotasService.guardar(mascotasModel);
        if(mascotasModel!= null){
            return new ResponseEntity<String>("Mascota Registrada",HttpStatus.OK);
        }
        return  new ResponseEntity<String>("Los datos no son validos o ya se encuentra registrada la mascota",HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/editar")
    public ResponseEntity<MascotasModel> editar(@RequestBody MascotasModel mascotasModel){
        mascotasModel=mascotasService.editar(mascotasModel);
        if(mascotasModel!= null){
            return new ResponseEntity<MascotasModel>(mascotasModel,HttpStatus.OK);
        }
        return  new ResponseEntity<>(mascotasModel,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value="/eliminar/{codigo}")
    public ResponseEntity<String> eliminar(@PathVariable("codigo") Long codigo){
        if(mascotasService.eliminar(codigo)){
            return new ResponseEntity<String>("Mascota Eliminada",HttpStatus.OK);
        }
        return new ResponseEntity<String>("La mascota no fue encontrado",HttpStatus.BAD_REQUEST);
    }



}
