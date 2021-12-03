package com.StylePet.StylePet.Estilistas;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Estilista")
public class EstilistasController {
    @Autowired
    private EstilistasService estilistasService;

    @GetMapping(value="/buscar")
    public List<EstilistasModel> buscar(){
        return estilistasService.buscar();
    }


}
