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
    
    public static void llenarTablaFiltroComponentes(String valorSeleccionado){
    
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        equipmentView.getTblFiltroComp().setRowSorter(ordenarTabla);
        //String descripcion, String garantia, String marca, Categoria categoria, Equipo equipo
        Categoria cate = componentService.retornarCategoria(valorSeleccionado);        
        List<Componente> listaFiltrada = componentService.filtrarPorCategoria(cate);
        
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        /*tabla.addColumn("Garantia");
        tabla.addColumn("Marca");
        tabla.addColumn("Categoria");*/
        
        equipmentView.getTblFiltroComp().setModel(tabla);        
        
        String[] datos = new String[3];
        
        for (Componente componente : listaFiltrada) {
            
            datos[0] = String.valueOf(componente.getId());
            datos[1] = componente.getDescripcion();
            /*datos[2] = componente.getGarantia();
            datos[3] = componente.getMarca();
            datos[4] = componente.getCategoria().name();*/
            
            tabla.addRow(datos);
        }
        
        equipmentView.getTblFiltroComp().setModel(tabla);
    }
    
}
