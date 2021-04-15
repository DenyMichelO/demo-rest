package bo.edu.ucb.ingsoft.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/usuario")
    public List<Usuario> findAllUsuarios() {
        List<Usuario> result = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT user_id, user, password,nombres,apellidos,email,telefono" +
                    "  FROM usuario");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.userId = rs.getInt("user_id");
                usuario.user = rs.getString("user");
                usuario.password = rs.getString("password");
                usuario.nombres = rs.getString("nombres");
                usuario.apellidos = rs.getString("apellidos");
                usuario.email = rs.getString("email");
                usuario.telefono = rs.getInt("telefono");
                result.add(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
    @GetMapping(path = "/usuario/{usuarioId}")
    public Usuario findUsuarioById(@PathVariable Integer usuarioId){
        Usuario result = new Usuario();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT user_id, user, password,nombres,apellidos,email,telefono" +
                    "  FROM usuario where user_id="+usuarioId);
            if(rs.next()) {

                result.userId = rs.getInt("user_id");
                result.user = rs.getString("user");
                result.password = rs.getString("password");
                result.nombres = rs.getString("nombres");
                result.apellidos = rs.getString("apellidos");
                result.email = rs.getString("email");
                result.telefono = rs.getInt("telefono");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
    @PostMapping(path = "/usuario")
    public Usuario createUsuario(@RequestBody Usuario usuario){

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT Into usuario values (" + usuario.userId+", '"
                            +usuario.user+"','"
                            +usuario.password+"','"
                            +usuario.nombres+"','"
                            +usuario.apellidos+"','"
                            +usuario.email+"','"
                            +usuario.telefono+"')");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;

    }
}
