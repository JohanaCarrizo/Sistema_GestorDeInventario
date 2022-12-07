package app_sginventario.controlador;

import app_sginventario.entidades.Empleado;
import app_sginventario.vistas.OperadorVista;
import javax.swing.JFrame;

public class OperadorControlador extends JFrame{
    
    private static OperadorVista operatorView = new OperadorVista();
    
    public static void mostrar(){ operatorView.setLocationRelativeTo(null); operatorView.setVisible(true); }
    public static void ocultar(){ operatorView.setVisible(false); }

    static void pasarEmpleado(Empleado empleado) {
      
        HistorialDeCambioControlador.llenarCamposDeTexto(empleado);
    }
    
}
