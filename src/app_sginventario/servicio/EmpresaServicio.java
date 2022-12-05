package app_sginventario.servicio;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Empresa;
import app_sginventario.persistencia.DAO;

public class EmpresaServicio extends DAO{
    
    EmpleadoServicio empleadoService = new EmpleadoServicio();
    UsuarioServicio userService = new UsuarioServicio();
        
    public void guardarEmpresa(){
        
        Empresa empresa = new Empresa();
        empresa.setNombre("CorporacionUmbrella");
        empresa.setCUIT("12-25998668-4");
        empresa.setDireccion("Av.Siempre viva");
        empresa.setTelefono("452968548");
        
        super.guardar(empresa);
    
    }
    
    public Empresa buscarEmpresa(int id){
    
        conectar();
        Empresa empresa = em.find(Empresa.class, id);
        desconectar();
        return empresa;    
    }
    
    /*public void asignarEmpresaAEmpleado(int idEmpleado, int idEmpresa){
    
        Empleado empleado = empleadoService.buscarEmpleado(idEmpleado);
        Empresa empresa = buscarEmpresa(idEmpresa);
        empleado.setEmpresa(empresa);
        
        super.editar(empleado);
    
    }*/
}
