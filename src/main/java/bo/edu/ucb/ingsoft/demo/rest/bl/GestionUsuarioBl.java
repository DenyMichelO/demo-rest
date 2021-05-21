package bo.edu.ucb.ingsoft.demo.rest.bl;



import bo.edu.ucb.ingsoft.demo.rest.dao.UsuarioDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionUsuarioBl {

    @Autowired
    UsuarioDao usuarioDao;

    public Usuario crearUsuario(Usuario usuario){
        return usuarioDao.crearUsuario(usuario);
    }
    public Usuario findUsuarioById(Integer usuarioId){
        return usuarioDao.findUsuarioById(usuarioId);
    }

    public List<Usuario> findAllUsuarios(){
        return usuarioDao.findAllUsuarios();
    }


}