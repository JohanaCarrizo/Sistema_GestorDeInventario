package app_sginventario.servicio;

import app_sginventario.entidades.Usuario;
import app_sginventario.persistencia.DAO;

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
}
