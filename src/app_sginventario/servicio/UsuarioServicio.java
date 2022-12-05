package app_sginventario.servicio;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Usuario;
import app_sginventario.persistencia.DAO;
import java.util.List;

public class UsuarioServicio extends DAO {
    
    
    
    public void guardarUsuario(String nomUsuario, String password){
    
        Usuario usuario = new Usuario();
        
        usuario.setNombre_usuario(nomUsuario);
        usuario.setPass(password);
        
        super.guardar(usuario);
    
    }
    
    public Usuario buscarUsuario(int id){
    
        conectar();
        Usuario usuario = em.find(Usuario.class, id);
        desconectar();
        return usuario;
    
    }
    
    public Usuario obtenerUltimoIdCreado(){
    
        conectar();
        Usuario user = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.id = (SELECT MAX(u.id) FROM Usuario u)").getSingleResult();
        desconectar();
        buscarUsuario(user.getId());
        return user;
    }
    
    public List listarUsuarios(){
    
        conectar();
        List<Usuario> listaU = em.createQuery("SELECT u FROM Usuario u").getResultList();
        desconectar();
        return listaU;
    }
    
    public Usuario validarUsuario(String pass){
    
        try {
            
            conectar();
            Usuario usuario = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.pass LIKE :pass").setParameter("pass", pass).getSingleResult();
            desconectar();
            return usuario;
            
        } catch (Exception e) {
            
            //throw e;
            return null;
        }
        
    }
}
