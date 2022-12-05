package app_sginventario.controlador;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Usuario;
import app_sginventario.servicio.EmpleadoServicio;
import app_sginventario.servicio.UsuarioServicio;
import app_sginventario.vistas.LoginVista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginControlador extends JFrame{
    
    private static LoginVista loginView = new LoginVista();
    private static final UsuarioServicio userService = new UsuarioServicio();
    private static final EmpleadoServicio employeeService = new EmpleadoServicio();
        
    
    public static void mostrar(){ loginView.setLocationRelativeTo(null);  loginView.setVisible(true); }
    
    public static void ocultar(){ loginView.setVisible(false); }
    
    public static void limpiarCamposDeTexto(){
    
        loginView.getTxtUsuario().setText("");
        loginView.getTxtPass().setText("");
    }
    
    public static void eventoIniciarSesion(){
    
        String usuario = loginView.getTxtUsuario().getText();
        String pass = loginView.getTxtPass().getText();
        
        Usuario user = userService.validarUsuario(pass);
        String nombre = user.getNombre_usuario();
        if( user != null &&  nombre.equals(usuario)){
        
            Empleado empleado = employeeService.buscarEmpleadoPorUsuario(user);
            JOptionPane.showMessageDialog(null, "¡Bienvenido, "+empleado.getNombre()+" "+empleado.getApellido());
            ocultar();
            limpiarCamposDeTexto();
            PrincipalControlador.mostrar();
        
        }else{
        
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor intente nuevamente");
            limpiarCamposDeTexto();
        }    
    }
    
}
