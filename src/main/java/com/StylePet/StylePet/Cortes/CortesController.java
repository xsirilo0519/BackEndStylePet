package com.StylePet.StylePet.Cortes;

import com.StylePet.StylePet.Estilistas.EstilistasModel;
import com.StylePet.StylePet.Estilistas.EstilistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Cortes")
public class CortesController {
    @Autowired
    private CortesService cortesService;

    @GetMapping(value="/buscar")
    public List<CortesModel> buscar(){
        return cortesService.buscar();
    }


}
