package bo.edu.ucb.ingsoft.demo.rest.dao;

import bo.edu.ucb.ingsoft.demo.rest.dto.Tips;
import bo.edu.ucb.ingsoft.demo.rest.dto.TipsVeterinario;
import bo.edu.ucb.ingsoft.demo.rest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TipsDao {
    @Autowired
    public DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public TipsVeterinario crearTipsVeterinario(TipsVeterinario tipsVeterinario){

        tipsVeterinario.setImagen_id(sequenceDao.getPrimaryKeyForTable("imagen"));
        tipsVeterinario.setTips_id(sequenceDao.getPrimaryKeyForTable("tips"));
        Connection conn = null;



        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT Into imagen values (?,?,?)");
            stmt.setInt(1,tipsVeterinario.getImagen_id());
            stmt.setString(2,tipsVeterinario.getNombre_imagen());
            stmt.setString(3,tipsVeterinario.getUrl());

            stmt.executeUpdate();

            PreparedStatement stmt1 = conn.prepareStatement("INSERT Into tips values (?,?,?,?,?)");
            stmt1.setInt(1,tipsVeterinario.getTips_id());
            stmt1.setInt(2,tipsVeterinario.getImagen_id());
            stmt1.setInt(3,tipsVeterinario.getVeterinario_id());
            stmt1.setString(4,tipsVeterinario.getTitulo());
            stmt1.setString(5,tipsVeterinario.getDescripcion());
            stmt1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                }catch (SQLException sqex){
                    //no hacer nada intencionalmente
                }
            }
        }
        return tipsVeterinario;
    }


    public List<TipsVeterinario> findAllTips() {
        List<TipsVeterinario> result = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery("Select t.tips_id,i.imagen_id,c.veterinario_id,t.titulo,t.descripcion,c.nombre,c.apellido,i.url from tips t join veterinario c on t.veterinario_id = c.veterinario_id join imagen i on t.imagen_id = i.imagen_id");


            while (rs.next()) {
                TipsVeterinario tipsVeterinario = new TipsVeterinario();
                tipsVeterinario.setTips_id(rs.getInt(1));
                tipsVeterinario.setImagen_id(rs.getInt(2));
                tipsVeterinario.setVeterinario_id(rs.getInt(3));
                tipsVeterinario.setTitulo(rs.getString(4));
                tipsVeterinario.setDescripcion(rs.getString(5));
                tipsVeterinario.setNombre(rs.getString(6));
                tipsVeterinario.setApellido(rs.getString(7));
                tipsVeterinario.setUrl(rs.getString(8));


                result.add(tipsVeterinario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    public TipsVeterinario findTipsById(Integer tipsId){
        TipsVeterinario result = new TipsVeterinario();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("Select t.tips_id,i.imagen_id,c.veterinario_id,t.titulo,t.descripcion,c.nombre,c.apellido,i.url from tips t join veterinario c on t.veterinario_id = c.veterinario_id join imagen i on t.imagen_id = i.imagen_id where tips_id= ?")){
            pstmt.setInt(1,tipsId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {

                result.setTips_id(rs.getInt("tips_id")); ;
                result.setImagen_id(rs.getInt("imagen_id"));
                result.setVeterinario_id(rs.getInt("veterinario_id"));
                result.setTitulo(rs.getString("titulo"));
                result.setDescripcion(rs.getString("descripcion"));
                result.setNombre(rs.getString("nombre"));
                result.setApellido(rs.getString("apellido"));
                result.setUrl(rs.getString("url"));

            } else{
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

}


