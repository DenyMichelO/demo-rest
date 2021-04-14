package bo.edu.ucb.ingsoft.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @GetMapping(path = "/usuario")
    public Usuario deny(){

        Usuario dunny = new Usuario();
        dunny.userId= 1;
        dunny.user="admin";
        dunny.password="admin123";
        dunny.nombres="Carlos";
        dunny.apellidos="Torrez";
        dunny.email="ctorrez@gmail.com";
        dunny.telefono=73281596;
        return dunny;
    }


}
