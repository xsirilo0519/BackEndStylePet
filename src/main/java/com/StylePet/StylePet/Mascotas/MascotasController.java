package com.StylePet.StylePet.Mascotas;

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
            return new ResponseEntity<String>("Usuario Registrado",HttpStatus.OK);
        }
        return  new ResponseEntity<String>("La cedula ingresada no es valida o ya se encuentra registrada",HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<MascotasModel> editar(@RequestBody MascotasModel usuariosModel){
        usuariosModel=mascotasService.editar(usuariosModel);
        if(usuariosModel!= null){
            return new ResponseEntity<MascotasModel>(usuariosModel,HttpStatus.OK);
        }
        return  new ResponseEntity<>(usuariosModel,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value="/eliminar/{cedula}")
    public ResponseEntity<String> eliminar(@PathVariable("cedula") Long cedula){
        if(mascotasService.eliminar(cedula)){
            return new ResponseEntity<String>("Usuario Eliminado",HttpStatus.OK);
        }
        return new ResponseEntity<String>("El usuario no fue encontrado",HttpStatus.BAD_REQUEST);
    }

}
