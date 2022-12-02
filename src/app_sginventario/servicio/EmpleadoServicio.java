package app_sginventario.servicio;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Empresa;
import app_sginventario.entidades.Rol;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.entidades.Usuario;
import app_sginventario.persistencia.DAO;

public class EmpleadoServicio extends DAO {
    
    UsuarioServicio userServ = new UsuarioServicio();
    
    public void guardarEmpleado(String nombre, String apellido, String domicilio, String telefono, Rol rol, TipoDepartamento depto, Usuario usuario, Empresa empresa){
    
        Empleado emp = new Empleado();
        
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setDomicilio(domicilio);
        emp.setTelefono(telefono);
        emp.setRol(rol);
        emp.setDepto(depto);
        emp.setUsuario(usuario);
        emp.setEmpresa(empresa);
        
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
    
    public void guardarEmpresa(){
        
        Empresa em = new Empresa();
        em.setNombre("CorporacionUmbrella");
        em.setCUIT("12-25998668-4");
        em.setDireccion("Av.Siempre viva");
        em.setTelefono("452968548");
        
        super.guardar(em);
    
    }
    
    public Empresa buscarEmpresa(){
    
        conectar();
        Empresa emp = em.find(Empresa.class, 1);
        desconectar();
        return emp;
    
    }
    
}
