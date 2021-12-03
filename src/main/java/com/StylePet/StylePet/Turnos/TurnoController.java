package com.StylePet.StylePet.Turnos;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Turno")
public class TurnoController {
    @Autowired
    private TurnosService turnosService;

    @PutMapping(value = "/editar")
    public TurnosModel editar(@RequestBody TurnosModel turnosModel){
        return turnosService.Editar(turnosModel);

    }


}
