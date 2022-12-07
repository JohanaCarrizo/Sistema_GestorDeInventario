package app_sginventario.controlador;

import app_sginventario.entidades.Empleado;
import app_sginventario.servicio.EquipoServicio;
import app_sginventario.vistas.HistorialDeCambioVista;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

public class HistorialDeCambioControlador extends JFrame{
    
    private static HistorialDeCambioVista changeHistoryView = new HistorialDeCambioVista();
    
    public static void mostrar(){ changeHistoryView.setLocationRelativeTo(null); changeHistoryView.setVisible(true); }
    public static void ocultar(){ changeHistoryView.setVisible(false); }
    
    
    static void llenarCamposDeTexto(Empleado empleado) {
       
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        changeHistoryView.getTxtFecha().setText(fecha);
        EquipoServicio equipoService = new EquipoServicio();
        changeHistoryView.getTxtEquipo().setText(equipoService.buscarEquipoConEmpleado(empleado.getId()).getNombre());
        changeHistoryView.getTxtUsuario().setText(empleado.getNombre()+" "+empleado.getApellido());
    }
    
    public void AñadirRegistroAlHistorial(){
    
        
    }
    
}
