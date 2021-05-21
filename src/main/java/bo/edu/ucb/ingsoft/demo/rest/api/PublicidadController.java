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

   /* @GetMapping(path = "/tips")
    public ResponseDto findAllTips(){
        return new ResponseDto(true,gestionTipsBl.findAllTips(),null);
    }

    @GetMapping(path = "/tips/{tipsId}")
    public ResponseDto findTipsById(@PathVariable Integer tipsId){
        TipsVeterinario tipsVeterinario = gestionTipsBl.T(tipsId);
        if(tipsVeterinario != null){
            return new ResponseDto(true,tipsVeterinario,null);
        }else {
            return new ResponseDto(false,null, "No existe el usuario");

        }

    }*/
    @PostMapping(path = "/empresac")
    public ResponseDto crearPublicidad(@RequestBody PublicidadEmpresa publicidadEmpresa){
        if(publicidadEmpresa.getNombre_empresa() == null || publicidadEmpresa.getNombre_empresa().trim().equals("") ){
            return new ResponseDto(false,null,"El nombre de la imagen debe ser obligatorio:");

        }
        if (publicidadEmpresa.getMarca_producto() == null || publicidadEmpresa.getMarca_producto().trim().equals("")){
            return new ResponseDto(false,null,"La url de la imagen debe ser obligatoria:");

        }
        if (publicidadEmpresa.getNum_telef() == null || publicidadEmpresa.getNum_telef().trim().equals("")){
            return new ResponseDto(false,null,"El titulo debe ser obligatoria:");

        }   if (publicidadEmpresa.getNombre_anuncio() == null || publicidadEmpresa.getNombre_anuncio().trim().equals("")){
            return new ResponseDto(false,null,"La descripcion debe ser obligatoria:");

        }
        if (publicidadEmpresa.getEmail() == null || publicidadEmpresa.getEmail().trim().equals("")){
            return new ResponseDto(false,null,"La descripcion debe ser obligatoria:");

        }
        return new ResponseDto(true,gestionPublicidadBl.crearPublicidad(publicidadEmpresa),null);

    }

}
