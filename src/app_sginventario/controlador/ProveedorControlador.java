package app_sginventario.controlador;

import app_sginventario.entidades.Proveedor;
import app_sginventario.servicio.ProveedorServicio;
import app_sginventario.vistas.ProveedorVista;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProveedorControlador extends JFrame{
    
    private static ProveedorVista supplierView = new ProveedorVista();
    private static ProveedorServicio supplierService = new ProveedorServicio();
    
    public static void mostrar(){ supplierView.setLocationRelativeTo(null); supplierView.setVisible(true); llenarTablaProveedor();}

    public static void ocultar(){ supplierView.setVisible(false); }
    
    public static void llenarTablaProveedor(){
    
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        supplierView.getTblProveedore().setRowSorter(ordenarTabla);
        
        List<Proveedor> listaProv = supplierService.listarProveedores();
        
        tabla.addColumn("Id");
        tabla.addColumn("Nombre Proveedor");
        
        supplierView.getTblProveedore().setModel(tabla);
        String[] datos = new String[2];
        
        for (Proveedor proveedor : listaProv) {
            
            datos[0] = String.valueOf(proveedor.getId());
            datos[1] = proveedor.getNombre();
            
            tabla.addRow(datos);
        }
        supplierView.getTblProveedore().setModel(tabla);
    }
}
