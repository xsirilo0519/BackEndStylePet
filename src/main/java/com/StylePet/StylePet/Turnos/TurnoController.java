package com.StylePet.StylePet.Turnos;

import com.StylePet.StylePet.Estilistas.EstilistasModel;
import com.StylePet.StylePet.Estilistas.EstilistasService;
import com.StylePet.StylePet.Usuarios.UsuariosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
