package com.StylePet.StylePet.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("Usuario")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping(value = "/agregar")
    public ResponseEntity<UsuariosModel> guardar(@RequestBody UsuariosModel usuariosModel){
        usuariosModel=usuariosService.guardar(usuariosModel);
        if(usuariosModel!= null){
            return new ResponseEntity<UsuariosModel>(usuariosModel,HttpStatus.OK);
        }
        return  new ResponseEntity<UsuariosModel>(usuariosModel,HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<UsuariosModel> editar(@RequestBody UsuariosModel usuariosModel){
        usuariosModel=usuariosService.editar(usuariosModel);
        if(usuariosModel!= null){
            return new ResponseEntity<UsuariosModel>(usuariosModel,HttpStatus.OK);
        }
        return  new ResponseEntity<>(usuariosModel,HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UsuariosModel> login(@RequestBody LoginModel loginModel){
            UsuariosModel usuariosModel=usuariosService.login(loginModel);
        if(usuariosModel!= null){
            return new ResponseEntity<UsuariosModel>(usuariosModel,HttpStatus.OK);
        }
        return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

}
