package bo.edu.ucb.ingsoft.demo.rest.bl;

import bo.edu.ucb.ingsoft.demo.rest.dao.TipsDao;
import bo.edu.ucb.ingsoft.demo.rest.dao.UsuarioDao;
import bo.edu.ucb.ingsoft.demo.rest.dto.Tips;
import bo.edu.ucb.ingsoft.demo.rest.dto.TipsVeterinario;
import bo.edu.ucb.ingsoft.demo.rest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionTipsBl {

   @Autowired
    TipsDao tipsDao;

    public TipsVeterinario crearTipsVeterinario(TipsVeterinario tipsVeterinario){
        return tipsDao.crearTipsVeterinario(tipsVeterinario);
    }
    public TipsVeterinario T(Integer tipsId){
        return tipsDao.findTipsById(tipsId);
    }

    public List<TipsVeterinario> findAllTips(){
        return tipsDao.findAllTips();
    }

}
