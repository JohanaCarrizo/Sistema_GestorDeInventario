package app_sginventario;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Empresa;
import app_sginventario.entidades.Rol;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.servicio.EmpleadoServicio;
import app_sginventario.servicio.UsuarioServicio;

public class App_SGInventario {

    public static void main(String[] args) {
        
        EmpleadoServicio emp = new EmpleadoServicio();
        UsuarioServicio userServ = new UsuarioServicio();
        
        /*MESSI CREADO SIN USUARIO Y EMPRESA*/
        //Empleado e1 = new Empleado("Lionel", "Messi", "Pje.Vieytes", "45698526", Rol.ADMINISTRADOR, TipoDepartamento.SISTEMA, null);
        
        /*SE CREO LA EMPRESA*/
        //emp.guardarEmpresa();
        
        
        /*SE BUSCA LA EMPRESA YA CREADA Y SE LE ASIGNA A JOHANA*/
        Empresa empresa = emp.buscarEmpresa();
        //emp.guardarEmpleado("Johana", "Carrizo", "Av.Peron", "452198236", Rol.OPERADOR, TipoDepartamento.RRHH, null, empresa);
        
        
        /*SE CREA EL USUARIO PARA EL CRACK Y SE LE ASIGNA*/
        userServ.guardarUsuario("LMessi", "1234");
        emp.asignarUsuarioAEmpleado(1);
        
        
        
    }
    
}
