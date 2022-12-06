package app_sginventario.controlador;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.servicio.ComponenteServicio;
import app_sginventario.vistas.EquipoVista;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ComponenteControlador extends JFrame{
    
    private static EquipoVista equipmentView = new EquipoVista();
    private static ComponenteServicio componentService = new ComponenteServicio();
    
    
    
}
