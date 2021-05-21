package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionUsuarioBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionUsuarioBl gestionUsuarioBl;

    @GetMapping(path = "/usuario")
    public ResponseDto findAllUsuarios(){
        return new ResponseDto(true,gestionUsuarioBl.findAllUsuarios(),null);
    }

    @GetMapping(path = "/usuario/{usuarioId}")
    public ResponseDto findUsuarioById(@PathVariable Integer usuarioId){
        Usuario usuario = gestionUsuarioBl.findUsuarioById(usuarioId);
        if(usuario != null){
            return new ResponseDto(true,usuario,null);
        }else {
            return new ResponseDto(false,null, "No existe el usuario");

        }

    }
    @PostMapping(path = "/usuario")
    public ResponseDto createUsuario(@RequestBody Usuario usuario){
        if(usuario.getNombre_usuario() == null || usuario.getNombre_usuario().trim().equals("") ){
            return new ResponseDto(false,null,"El nombre de usuario debe ser obligatorio:");

        }
        if (usuario.getContrasena() == null || usuario.getContrasena().trim().equals("")){
            return new ResponseDto(false,null,"La contraseña debe ser obligatoria:");

        }

        return new ResponseDto(true,gestionUsuarioBl.crearUsuario(usuario),null);

    }
}
