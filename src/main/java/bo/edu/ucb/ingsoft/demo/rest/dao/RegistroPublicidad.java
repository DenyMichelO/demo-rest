package bo.edu.ucb.ingsoft.demo.rest.dao;

import bo.edu.ucb.ingsoft.demo.rest.dto.PublicidadEmpresa;
import bo.edu.ucb.ingsoft.demo.rest.dto.TipsVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroPublicidad {
    @Autowired
    public DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public PublicidadEmpresa crearPublicidad(PublicidadEmpresa publicidadEmpresa ){

        publicidadEmpresa.setEmpresa_id(sequenceDao.getPrimaryKeyForTable("empresap"));
        publicidadEmpresa.setEmpresacli_id(sequenceDao.getPrimaryKeyForTable("empresac"));
        Connection conn = null;



        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT Into empresap values (?,?,?,?)");
            stmt.setInt(1,publicidadEmpresa.getEmpresa_id());
            stmt.setInt(2,publicidadEmpresa.getTarifa_id());
            stmt.setString(3,publicidadEmpresa.getNombre_anuncio());
            stmt.setString(4,publicidadEmpresa.getMarca_producto());


            stmt.executeUpdate();

            PreparedStatement stmt1 = conn.prepareStatement("INSERT Into empresac values (?,?,?,?)");
            stmt1.setInt(1,publicidadEmpresa.getEmpresacli_id());
            stmt1.setString(2,publicidadEmpresa.getNombre_empresa());
            stmt1.setString(3,publicidadEmpresa.getNum_telef());
            stmt1.setString(4,publicidadEmpresa.getEmail());

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
        return publicidadEmpresa;
    }


    public List<PublicidadEmpresa> findAllPublicidad() {
        List<PublicidadEmpresa> result = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery("select e.empresacli_id,e2.empresa_id,t.tarifa_id,e.nombre_empresa,e2.marca_producto,t.cantidad_meses,e.num_telef,e2.nombre_anuncio,e.email from empresac e join empresap e2 on e.empresacli_id = e2.empresacli_id join tarifa t on e2.tarifa_id = t.tarifa_id");


            while (rs.next()) {
                PublicidadEmpresa publicidadEmpresa = new PublicidadEmpresa();
                publicidadEmpresa.setEmpresacli_id(rs.getInt(1));
                publicidadEmpresa.setEmpresa_id(rs.getInt(2));
                publicidadEmpresa.setTarifa_id(rs.getInt(3));
                publicidadEmpresa.setNombre_empresa(rs.getString(4));
                publicidadEmpresa.setMarca_producto(rs.getString(5));
                publicidadEmpresa.setCantidad_meses(rs.getString(6));
                publicidadEmpresa.setNum_telef(rs.getString(7));
                publicidadEmpresa.setNombre_anuncio(rs.getString(8));
                publicidadEmpresa.setEmail(rs.getString(9));


                result.add(publicidadEmpresa);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
/*
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

    }*/
}
