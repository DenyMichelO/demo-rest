package bo.edu.ucb.ingsoft.demo.rest.dao;


import bo.edu.ucb.ingsoft.demo.rest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDao {

    @Autowired
    public DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public Usuario crearUsuario(Usuario usuario){

        usuario.setUsuario_id(sequenceDao.getPrimaryKeyForTable("usuario"));
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT Into usuario values (?,?,?)");
            stmt.setInt(1,usuario.getUsuario_id());
            stmt.setString(2,usuario.getNombre_usuario());
            stmt.setString(3,usuario.getContrasena());
        stmt.executeUpdate();
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
        return usuario;
    }


    public List<Usuario> findAllUsuarios() {
        List<Usuario> result = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery("SELECT usuario_id, nombre_usuario, contrasena" +
                    "  FROM usuario");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuario_id(rs.getInt("usuario_id"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                result.add(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    public Usuario findUsuarioById(Integer usuarioId){
        Usuario result = new Usuario();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT usuario_id, nombre_usuario, contrasena" +
                    "  FROM usuario where usuario_id= ?")){
            pstmt.setInt(1,usuarioId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {

                result.setUsuario_id(rs.getInt("usuario_id")) ;
                result.setNombre_usuario(rs.getString("nombre_usuario"));
                result.setContrasena(rs.getString("contrasena"));

            } else{
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

}
