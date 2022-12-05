package app_sginventario.servicio;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Empresa;
import app_sginventario.entidades.Rol;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.entidades.Usuario;
import app_sginventario.persistencia.DAO;
import java.util.List;

public class EmpleadoServicio extends DAO {
    
    private UsuarioServicio userServ = new UsuarioServicio();
    
    
    
    public void guardarEmpleado(String nombre, String apellido, String domicilio, String telefono, Rol rol, TipoDepartamento depto, Usuario usuario){
    
        Empleado emp = new Empleado();
        
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setDomicilio(domicilio);
        emp.setTelefono(telefono);
        emp.setRol(rol);
        emp.setDepto(depto);
        emp.setUsuario(usuario);
        
        super.guardar(emp);
    
    }
    
    public void asignarUsuarioAEmpleado(int idEmpleado){
    
        Empleado empleado = buscarEmpleado(idEmpleado);
        Usuario usuario = userServ.buscarUsuario(idEmpleado);
        empleado.setUsuario(usuario);
        
        super.editar(empleado);
    
    }
    
    public Empleado buscarEmpleado(int id){
    
        conectar();
        Empleado emp = em.find(Empleado.class, id);
        desconectar();
        return emp;
        
    }
    
    public Empleado buscarEmpleadoPorUsuario(Usuario usuario){
    
        List<Empleado> lista = listarEmpleados();
        for (Empleado empleado : lista) {
            
            if(empleado.getUsuario().getId() == usuario.getId()){
            
                return empleado;
            }            
        }       
        return null;
    }
    
    public List listarEmpleados(){
    
        conectar();
        List<Empleado> lista = em.createQuery("SELECT e FROM Empleado e").getResultList();
        desconectar();
        return lista;
    }
    
    public Rol[] listarRoles(){
    
        return Rol.values();
        
    }
    
    public Rol retornarRolSeleccionado(String rolSelect){
    
        Rol[] listaR = listarRoles();
        for (int i = 0; i < listaR.length; i++) {
            
            if(listaR[i].name().equals(rolSelect) ){
            
                return listaR[i];
            }      
        }
        
        return null;
    }
    
    public TipoDepartamento[] listarDepartamentos(){
    
        return TipoDepartamento.values();
    }
    
    public TipoDepartamento retornarDepaSeleccionado(String depaSelect){
    
        TipoDepartamento[] listaD = listarDepartamentos();
        for (int i = 0; i < listaD.length; i++) {
            
            if(listaD[i].name().equals(depaSelect) ){
            
                return listaD[i];
            }      
        }
        
        return null;
    }
}
