package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.RegistroPublicidad;
import bo.edu.ucb.ingsoft.demo.rest.dao.TipsDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.PublicidadEmpresa;
import bo.edu.ucb.ingsoft.demo.rest.dto.TipsVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionPublicidadBl {

    @Autowired
    RegistroPublicidad registroPublicidad;

    public PublicidadEmpresa crearPublicidad(PublicidadEmpresa publicidadEmpresa){
        return registroPublicidad.crearPublicidad(publicidadEmpresa);
    }
    public List<PublicidadEmpresa> findAllPublicidad(){
        return registroPublicidad.findAllPublicidad();
    }
}
