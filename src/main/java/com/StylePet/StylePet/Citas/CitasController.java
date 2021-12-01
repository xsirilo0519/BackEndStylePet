package com.StylePet.StylePet.Citas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Citas")
public class CitasController {
    @Autowired
    CitasService CitasService;

    @GetMapping(value="/buscar")
    public List<CitasModel> listaDeCitas(){
         return  CitasService.findAll();
    }
    @GetMapping(value="/buscar/{codigo}")
    public List<CitasModel> listaDeCitas(@PathVariable("codigo") Long codigo){
        return  CitasService.findByPet(codigo);
    }

    @PostMapping(value = "/agregar")
    public CitasModel guardar(@RequestBody CitasModel citasModel){
        return CitasService.guardar(citasModel);
    }

    @PutMapping(value = "/editar")
    public CitasModel editar(@RequestBody CitasModel citasModel){
        return CitasService.guardar(citasModel);
    }

    @DeleteMapping(value="/eliminar/{codigo}")
    public ResponseEntity<String> eliminar(@PathVariable("codigo") Long codigo){
        if(CitasService.eliminar(codigo)){
            return new ResponseEntity<String>("Mascota Eliminada",HttpStatus.OK);
        }
        return new ResponseEntity<String>("La mascota no fue encontrado",HttpStatus.BAD_REQUEST);
    }

}
