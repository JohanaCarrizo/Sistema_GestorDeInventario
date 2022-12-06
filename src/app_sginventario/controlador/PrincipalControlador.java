package app_sginventario.controlador;

import app_sginventario.vistas.PrincipalVista;
import javax.swing.JFrame;

public class PrincipalControlador extends JFrame{
    
    private static PrincipalVista principalView = new PrincipalVista();
    
    public static void mostrar(){ principalView.setLocationRelativeTo(null);  principalView.setVisible(true); }
    
    public static void ocultar(){ principalView.setVisible(false); }
    
    
    
}
