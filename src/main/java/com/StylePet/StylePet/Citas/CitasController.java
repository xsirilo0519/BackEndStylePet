package com.StylePet.StylePet.Citas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("citas")
public class CitasController {
    @Autowired
    CitasService CitasService;

    @GetMapping(value="/buscar")
    public List<CitasModel> listaDeCitas(){
         return  CitasService.findAll();
    }

    @PostMapping(value = "/agregar")
    public ResponseEntity<String> guardar(@RequestBody CitasModel citasModel){
        citasModel= CitasService.guardar(citasModel);
        if(citasModel!= null){
            return new ResponseEntity<String>("Mascota Registrada",HttpStatus.OK);
        }
        return  new ResponseEntity<String>("Los datos no son validos o ya se encuentra registrada la mascota",HttpStatus.BAD_REQUEST);
    }

}
