package bo.edu.ucb.ingsoft.demo.rest.api;

import bo.edu.ucb.ingsoft.demo.rest.bl.GestionTipsBl;
import bo.edu.ucb.ingsoft.demo.rest.bl.GestionUsuarioBl;
import bo.edu.ucb.ingsoft.demo.rest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demo.rest.dto.TipsVeterinario;
import bo.edu.ucb.ingsoft.demo.rest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
@RestController
public class TipsController {

    @Autowired
    public DataSource dataSource;

    @Autowired
    private GestionTipsBl gestionTipsBl;
    /**
     *
     * Metodo para listar los tips que fueron agregados por los veterinarios registrados
     *
     */
    @GetMapping(path = "/tips")
    public ResponseDto findAllTips(){
        return new ResponseDto(true,gestionTipsBl.findAllTips(),null);
    }

    /**
     *
     * Metodo para listar los tips registrados por ID
     *
     */
    @GetMapping(path = "/tips/{tipsId}")
    public ResponseDto findTipsById(@PathVariable Integer tipsId){
        TipsVeterinario tipsVeterinario = gestionTipsBl.T(tipsId);
        if(tipsVeterinario != null){
            return new ResponseDto(true,tipsVeterinario,null);
        }else {
            return new ResponseDto(false,null, "No existe el usuario");

        }

    }
    /**
     *
     * Metodo para registrar un Tip a la vez.
     *
     */
    @PostMapping(path = "/tips")
    public ResponseDto creartipsVeterinario(@RequestBody TipsVeterinario tipsVeterinario){
        if(tipsVeterinario.getNombre_imagen() == null || tipsVeterinario.getNombre_imagen().trim().equals("") ){
            return new ResponseDto(false,null,"El nombre de la imagen debe ser obligatorio:");

        }
        if (tipsVeterinario.getUrl() == null || tipsVeterinario.getUrl().trim().equals("")){
            return new ResponseDto(false,null,"La url de la imagen debe ser obligatoria:");

        }
        if (tipsVeterinario.getTitulo() == null || tipsVeterinario.getTitulo().trim().equals("")){
            return new ResponseDto(false,null,"El titulo debe ser obligatoria:");

        }   if (tipsVeterinario.getDescripcion() == null || tipsVeterinario.getDescripcion().trim().equals("")){
            return new ResponseDto(false,null,"La descripcion debe ser obligatoria:");

        }
        return new ResponseDto(true,gestionTipsBl.crearTipsVeterinario(tipsVeterinario),null);

    }

}

