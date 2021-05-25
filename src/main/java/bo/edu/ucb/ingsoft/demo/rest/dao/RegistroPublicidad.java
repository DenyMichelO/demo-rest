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

        publicidadEmpresa.setEmpresacliente_id(sequenceDao.getPrimaryKeyForTable("empresacliente"));
        publicidadEmpresa.setEmpresa_id(sequenceDao.getPrimaryKeyForTable("empresapublicidad"));
        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            PreparedStatement stmt3 = conn.prepareStatement("INSERT Into empresacliente values (?,?,?,?,?)");
            stmt3.setInt(1,publicidadEmpresa.getEmpresacliente_id());
            stmt3.setInt(2,publicidadEmpresa.getUsuario_id());
            stmt3.setString(3,publicidadEmpresa.getNombre_empresa());
            stmt3.setString(4,publicidadEmpresa.getNum_telef());
            stmt3.setString(5,publicidadEmpresa.getEmail());

            stmt3.executeUpdate();


            PreparedStatement stmt2 = conn.prepareStatement("INSERT Into empresapublicidad values (?,?,?,?)");
            stmt2.setInt(1,publicidadEmpresa.getEmpresa_id());
            stmt2.setInt(2,publicidadEmpresa.getTarifa_id());
            stmt2.setString(3,publicidadEmpresa.getNombre_anuncio());
            stmt2.setString(4,publicidadEmpresa.getMarca_producto());


            stmt2.executeUpdate();


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

            ResultSet rs = stmt.executeQuery("select e2.empresa_id,e.empresacliente_id,t.tarifa,e2.nombre_anuncio,e2.marca_producto,e.nombre_empresa,e.email,e.num_telef,t.cantidad_meses from empresapublicidad e2 join empresacliente e on e2.empresacli_id = e.empresacliente_id join tarifa t on e2.tarifa_id = t.tarifa_id;");


            while (rs.next()) {
                PublicidadEmpresa publicidadEmpresa = new PublicidadEmpresa();
                publicidadEmpresa.setEmpresa_id(rs.getInt(1));
                publicidadEmpresa.setEmpresacliente_id(rs.getInt(2));
                publicidadEmpresa.setTarifa_id(rs.getInt(3));
                publicidadEmpresa.setNombre_anuncio(rs.getString(4));
                publicidadEmpresa.setMarca_producto(rs.getString(5));
                publicidadEmpresa.setNombre_empresa(rs.getString(6));
                publicidadEmpresa.setEmail(rs.getString(7));
                publicidadEmpresa.setNum_telef(rs.getString(8));
                publicidadEmpresa.setCantidad_meses(rs.getString(9));

                result.add(publicidadEmpresa);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
}
