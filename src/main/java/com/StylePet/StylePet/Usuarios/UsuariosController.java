package com.StylePet.StylePet.Usuarios;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Usuario")
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;

    @GetMapping(value="/buscar")
    public List<UsuariosModel> listarUsuarios(){
         return  usuariosService.findAll();
    }

    @PostMapping(value = "/agregar")
    public ResponseEntity<String> guardar(@RequestBody UsuariosModel usuariosModel){
        usuariosModel=usuariosService.guardar(usuariosModel);
        if(usuariosModel!= null){
            return new ResponseEntity<String>("Usuario Registrado",HttpStatus.OK);
        }
        return  new ResponseEntity<String>("La cedula ingresada no es valida o ya se encuentra registrada",HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<UsuariosModel> editar(@RequestBody UsuariosModel usuariosModel){
        usuariosModel=usuariosService.editar(usuariosModel);
        if(usuariosModel!= null){
            return new ResponseEntity<UsuariosModel>(usuariosModel,HttpStatus.OK);
        }
        return  new ResponseEntity<>(usuariosModel,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value="/eliminar/{cedula}")
    public ResponseEntity<String> eliminar(@PathVariable("cedula") Long cedula){
        if(usuariosService.eliminar(cedula)){
            return new ResponseEntity<String>("Usuario Eliminado",HttpStatus.OK);
        }
        return new ResponseEntity<String>("El usuario no fue encontrado",HttpStatus.BAD_REQUEST);
    }

}
