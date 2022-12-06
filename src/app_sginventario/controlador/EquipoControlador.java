package app_sginventario.controlador;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.EstadoComponente;
import app_sginventario.entidades.HistorialDeCambio;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.servicio.ComponenteServicio;
import app_sginventario.servicio.EmpleadoServicio;
import app_sginventario.servicio.EquipoServicio;
import app_sginventario.vistas.EquipoVista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class EquipoControlador extends JFrame{
    
    private static EquipoVista equipmentView = new EquipoVista();
    private static EquipoServicio equipmentService = new EquipoServicio();
    private static EmpleadoServicio employeeService = new EmpleadoServicio();
    private static ComponenteServicio componentService = new ComponenteServicio();
    private static ComponenteControlador componentController = new ComponenteControlador();
    public static List<Componente> lista = new ArrayList();
    
    public static void mostrar(){
    
        llenarcomboBoxCategoria();
        llenarComboBoxDepa();
        llenarTablaEquipo();
        llenarTablaFiltroComponentes(equipmentView.getCbxCotegorias().getSelectedItem().toString());
        equipmentView.setLocationRelativeTo(null);  
        equipmentView.setVisible(true);
        
    }
    
    public static void ocultar(){ equipmentView.setVisible(false); }
    
    public static void ocultarBotonConfirmar(){ equipmentView.getBtnConfirmar().setVisible(false);}
    public static void mostrarBotonConfirmar(){ equipmentView.getBtnConfirmar().setVisible(true); }
    
    public static void mostrarBotonEditar(){ equipmentView.getBtnEditar().setVisible(true); }
    public static void ocultarBotonEditar(){ equipmentView.getBtnEditar().setVisible(false); }
    
    public static void mostrarBotonCancelarEdicion(){ equipmentView.getBtnCancelarEdi().setEnabled(true); }
    public static void ocultarBotonCancelarEdicion(){ equipmentView.getBtnCancelarEdi().setEnabled(false); }
    
    public static void mostrarBotonEliminarYConfEdicion(){ equipmentView.getBtnConfirmarEdi().setEnabled(true); equipmentView.getBtnEliminar().setEnabled(true);}
    public static void ocultarBotonEliminarYConfEdicion(){ equipmentView.getBtnConfirmarEdi().setEnabled(false); equipmentView.getBtnEliminar().setEnabled(false);}
    
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
        tabla.addColumn("Cant_Componentes");
        
        equipmentView.getTblEquipos().setModel(tabla);
        String[] datos = new String[4];
        
        for (Equipo equipo : listaFiltrada) {
            
            datos[0] = String.valueOf(equipo.getId());
            datos[1] = equipo.getNombre();
            datos[2] = equipo.getDepto().name();
            datos[3] = String.valueOf(equipo.getComponentes().size());
            
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
        List<Componente> listaAux = new ArrayList();
        
        
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        
        equipmentView.getTblFiltroComp().setModel(tabla);        
        
        String[] datos = new String[2];
        
        for (Componente comp : listaFiltrada) {
            
            if(comp.getEstado() == EstadoComponente.EN_ALMACEN){
            
                listaAux.add(comp);
            }
        }
        
        for (Componente componente : listaAux) {
            
            datos[0] = String.valueOf(componente.getId());
            datos[1] = componente.getDescripcion();
            
            tabla.addRow(datos);
        }
        
        equipmentView.getTblFiltroComp().setModel(tabla);
    }
    
    public static void seleccionarFilaTablaFiltroComp(){
    
        int fila = equipmentView.getTblFiltroComp().getSelectedRow();
        
        if(fila >= 0){
            
            int id = Integer.parseInt(equipmentView.getTblFiltroComp().getValueAt(fila, 0).toString());
            lista.add(componentService.buscarComponente(id));
            
            DefaultTableModel tabla = new DefaultTableModel();   
            TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
            
            equipmentView.getTblCompAgregados().setRowSorter(ordenarTabla);
            
            tabla.addColumn("ID");
            tabla.addColumn("Nombre");
        
            equipmentView.getTblCompAgregados().setModel(tabla); 
            
            String[] datos = new String[2];
        
            for (Componente componente : lista) {
            
                datos[0] = String.valueOf(componente.getId());
                datos[1] = componente.getDescripcion();  
                
                tabla.addRow(datos);                
             }
            
            equipmentView.getTblCompAgregados().setModel(tabla);
            
        }else{
        
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguan componente");
        }
        
    }
    
    public static void botonQuitar() {

        int fila = equipmentView.getTblCompAgregados().getSelectedRow();

        if (fila >= 0) {

            lista.remove(fila);
            
            DefaultTableModel tabla = new DefaultTableModel();   
            TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
            
            equipmentView.getTblCompAgregados().setRowSorter(ordenarTabla);
            
            tabla.addColumn("ID");
            tabla.addColumn("Nombre");
        
            equipmentView.getTblCompAgregados().setModel(tabla); 
            
            String[] datos = new String[2];
        
            for (Componente componente : lista) {
            
                datos[0] = String.valueOf(componente.getId());
                datos[1] = componente.getDescripcion();  
                
                tabla.addRow(datos);                
             }
            
            equipmentView.getTblCompAgregados().setModel(tabla);
        
        }else{
        
             JOptionPane.showMessageDialog(null, "No se seleccionó ninguan componente");
        }
    }
    
    public static void eventoBotonConfirmar(){
        
        String nombre = equipmentView.getTxtNombre().getText();
        String depa = equipmentView.getCbxDepa().getSelectedItem().toString();
        List<HistorialDeCambio> historial = new ArrayList();
    
        if(equipmentService.guardarEquipo(nombre, historial, employeeService.retornarDepaSeleccionado(depa), lista)){
        
            JOptionPane.showMessageDialog(null, "Se guardo con exito el equipo");
        
        }else{
        
            JOptionPane.showMessageDialog(null, "Campo vacio o minima cantidad de componente >= 9");
        }
        
    }
    
}
