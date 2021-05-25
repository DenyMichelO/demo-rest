package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionPublicidadBl;
import bo.edu.ucb.ingsoft.demo.rest.bl.GestionTipsBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.PublicidadEmpresa;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.TipsVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
@RestController
public class PublicidadController {


    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionPublicidadBl gestionPublicidadBl;

    /**
     *
     * Metodo para listar las publicidades registradas
     *
     */

   @GetMapping(path = "/empresapublicidad")
    public ResponseDto findAllPublicidad(){
        return new ResponseDto(true,gestionPublicidadBl.findAllPublicidad(),null);
    }
    /**
     *
     * Metodo para registrar un publicidad
     *
     */

    @PostMapping(path = "/empresapublicidad")
    public ResponseDto crearPublicidad(@RequestBody PublicidadEmpresa publicidadEmpresa){

        if (publicidadEmpresa.getNombre_anuncio() == null || publicidadEmpresa.getNombre_anuncio().trim().equals("")){
            return new ResponseDto(false,null,"El nombre del anuncio debe ser obligatorio:");

        }

        if (publicidadEmpresa.getMarca_producto() == null || publicidadEmpresa.getMarca_producto().trim().equals("")){
            return new ResponseDto(false,null,"La marca del produco debe ser obligatorio:");

        }
        if(publicidadEmpresa.getNombre_empresa() == null || publicidadEmpresa.getNombre_empresa().trim().equals("") ){
            return new ResponseDto(false,null,"El nombre de la Empresa debe ser obligatorio:");

        }

        if (publicidadEmpresa.getNum_telef() == null || publicidadEmpresa.getNum_telef().trim().equals("")){
            return new ResponseDto(false,null,"El numero de telefono debe ser obligatorio:");

        }
        if (publicidadEmpresa.getEmail() == null || publicidadEmpresa.getEmail().trim().equals("")){
            return new ResponseDto(false,null,"El Email debe ser obligatorio:");

        }
        return new ResponseDto(true,gestionPublicidadBl.crearPublicidad(publicidadEmpresa),null);

    }

}
