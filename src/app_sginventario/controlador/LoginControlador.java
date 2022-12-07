package app_sginventario.controlador;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Rol;
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
    
    public static void eventoIniciarSesion() {

        String usuario = loginView.getTxtUsuario().getText();
        String pass = loginView.getTxtPass().getText();

        try {
            
        if(usuario.isEmpty() || pass.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
            limpiarCamposDeTexto();
        
        }else{

        Usuario user = userService.validarUsuario(pass);
        String nombre = user.getNombre_usuario();
        Empleado empleado = employeeService.buscarEmpleadoPorUsuario(user);

            if (user == null) {

                JOptionPane.showMessageDialog(null, "El ususario ingresado no existe. Intente nuevamente");
                limpiarCamposDeTexto();

            } else if (nombre.equals(usuario) && empleado.getRol() == Rol.ADMINISTRADOR) {

                JOptionPane.showMessageDialog(null, "¡Bienvenido, " + empleado.getNombre() + " " + empleado.getApellido());
                ocultar();
                limpiarCamposDeTexto();
                ReporteControlador.pasarEmpleadoAReporte(   empleado);
                PrincipalControlador.mostrar();

            } else if (nombre.equals(usuario) && empleado.getRol() == Rol.OPERADOR) {

                JOptionPane.showMessageDialog(null, "¡Bienvenido, " + empleado.getNombre() + " " + empleado.getApellido());
                ocultar();
                limpiarCamposDeTexto();
                OperadorControlador.pasarEmpleado(empleado);
                OperadorControlador.mostrar();
            }
        }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Sistema fuera de servicio");
            limpiarCamposDeTexto();
            throw e;
        }
    }
    
}
