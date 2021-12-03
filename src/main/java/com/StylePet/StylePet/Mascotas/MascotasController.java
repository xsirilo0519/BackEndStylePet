package com.StylePet.StylePet.Mascotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Mascotas")
public class MascotasController {
    @Autowired
    private MascotasService mascotasService;

    @PostMapping(value = "/agregar")
    public MascotasModel guardar(@RequestBody MascotasModel mascotasModel){
        return mascotasService.guardar(mascotasModel);
    }
    @PutMapping(value = "/editar")
    public ResponseEntity<MascotasModel> editar(@RequestBody MascotasModel mascotasModel){
        mascotasModel=mascotasService.editar(mascotasModel);
        if(mascotasModel!= null){
            return new ResponseEntity<MascotasModel>(mascotasModel,HttpStatus.OK);
        }
        return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value="/eliminar/{codigo}")
    public ResponseEntity<String> eliminar(@PathVariable("codigo") Long codigo){
        if(mascotasService.eliminar(codigo)){
            return new ResponseEntity<String>("Mascota Eliminada",HttpStatus.OK);
        }
        return new ResponseEntity<String>("La mascota no fue encontrado",HttpStatus.BAD_REQUEST);
    }



}
