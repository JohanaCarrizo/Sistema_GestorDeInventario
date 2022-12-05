package app_sginventario.controlador;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.servicio.ComponenteServicio;
import app_sginventario.servicio.EmpleadoServicio;
import app_sginventario.servicio.EquipoServicio;
import app_sginventario.vistas.EquipoVista;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class EquipoControlador extends JFrame{
    
    private static EquipoVista equipmentView = new EquipoVista();
    private static EquipoServicio equipmentService = new EquipoServicio();
    private static EmpleadoServicio employeeService = new EmpleadoServicio();
    private static ComponenteServicio componentService = new ComponenteServicio();
    private static ComponenteControlador componentController = new ComponenteControlador();
    
    public static void mostrar(){
    
        llenarcomboBoxCategoria();
        llenarComboBoxDepa();
        llenarTablaEquipo();
        llenarTablaFiltroComponentes(equipmentView.getCbxCotegorias().getSelectedItem().toString());
        equipmentView.setLocationRelativeTo(null);  
        equipmentView.setVisible(true);
        
    }
    
    public static void ocultar(){ equipmentView.setVisible(false); }
    
    public static void llenarComboBoxDepa(){
    
        JComboBox<String> comboDepa = equipmentView.getCbxDepa();
        
        for (TipoDepartamento depa : employeeService.listarDepartamentos()) {
            
            comboDepa.addItem(depa.name());
        }
    }
    
    public static void llenarcomboBoxCategoria(){
        
        JComboBox<String> comboCategoria = equipmentView.getCbxCotegorias();
    
        for (Categoria cate : componentService.listarCategorias()) {
            
            comboCategoria.addItem(cate.name());            
        }        
    }
    
    
    
    public static void llenarTablaEquipo(){
    
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        equipmentView.getTblEquipos().setRowSorter(ordenarTabla);
        
        List<Equipo> listaFiltrada = equipmentService.listarEquipos();
        
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Departamento");
        
        equipmentView.getTblEquipos().setModel(tabla);
        String[] datos = new String[3];
        
        for (Equipo equipo : listaFiltrada) {
            
            datos[0] = String.valueOf(equipo.getId());
            datos[1] = equipo.getNombre();
            datos[2] = equipo.getDepto().name();
            
            tabla.addRow(datos);
        }
        equipmentView.getTblEquipos().setModel(tabla);
    }
    
    public static void llenarTablaFiltroComponentes(String valorSeleccionado){
    
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        equipmentView.getTblFiltroComp().setRowSorter(ordenarTabla);
        Categoria cate = componentService.retornarCategoria(valorSeleccionado);        
        List<Componente> listaFiltrada = componentService.filtrarPorCategoria(cate);
        
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        
        equipmentView.getTblFiltroComp().setModel(tabla);        
        
        String[] datos = new String[2];
        
        for (Componente componente : listaFiltrada) {
            
            datos[0] = String.valueOf(componente.getId());
            datos[1] = componente.getDescripcion();
            
            tabla.addRow(datos);
        }
        
        equipmentView.getTblFiltroComp().setModel(tabla);
    }
    
    public static void eventoBotonConfirmar(){
        
        String nombre = equipmentView.getTxtNombre().getText();
        String depa = equipmentView.getCbxDepa().getSelectedItem().toString();
    
        //equipmentService.guardarEquipo(nombre, historiales, TipoDepartamento.VENTA, componentes);
        
    }
    
}
