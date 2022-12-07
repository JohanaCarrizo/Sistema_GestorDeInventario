package app_sginventario.controlador;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Proveedor;
import app_sginventario.servicio.ComponenteServicio;
import app_sginventario.servicio.ProveedorServicio;
import app_sginventario.vistas.ComponenteVista;
import app_sginventario.vistas.EquipoVista;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ComponenteControlador extends JFrame{
    
    private static ComponenteVista componentView = new ComponenteVista();
    private static ComponenteServicio componentService = new ComponenteServicio();
    private static ProveedorServicio supplierService = new ProveedorServicio();
    
    public static void mostrar(){ 
        
        llenarTablaComponente();
        llenarComboBoxCategoria(); 
        llenarComboBoxProveedor();
        componentView.setLocationRelativeTo(null);
        componentView.setVisible(true); 
    }
    public static void ocultar(){ componentView.setVisible(false); }
    
    public static void ocultarBotonConfirmar(){ componentView.getBtnConfirmar().setVisible(false);}
    public static void mostrarBotonConfirmar(){ componentView.getBtnConfirmar().setVisible(true); }
    
    public static void mostrarBotonEditar(){ componentView.getBtnEditar().setVisible(true); }
    public static void ocultarBotonEditar(){ componentView.getBtnEditar().setVisible(false); }
    
    public static void mostrarBotonCancelarEdicion(){ componentView.getBtnCancelarEdi().setEnabled(true); }
    public static void ocultarBotonCancelarEdicion(){ componentView.getBtnCancelarEdi().setEnabled(false); }
    
    public static void mostrarBotonEliminarYConfEdicion(){ componentView.getBtnConfirmarEdi().setEnabled(true); componentView.getBtnEliminar().setEnabled(true);}
    public static void ocultarBotonEliminarYConfEdicion(){ componentView.getBtnConfirmarEdi().setEnabled(false); componentView.getBtnEliminar().setEnabled(false);}
    
    public static void llenarComboBoxCategoria(){
    
        JComboBox<String> comboCategoria = componentView.getCbxCategoria();
    
        for (Categoria cate : componentService.listarCategorias()) {
            
            comboCategoria.addItem(cate.name());            
        }  
    }
    
    public static void llenarComboBoxProveedor(){
    
        JComboBox<String> comboProve = componentView.getCbxProveedor();
        
        List<Proveedor> lista = supplierService.listarProveedores();
        for (Proveedor prov : lista) {
            
            comboProve.addItem(prov.getNombre());
        }
    }
    
    public static void llenarTablaComponente(){
    
        DefaultTableModel tabla = new DefaultTableModel();    
         
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
         
        componentView.getTblComponente().setRowSorter(ordenarTabla);
        
        tabla.addColumn("ID" );
        tabla.addColumn("Descripcion");
        tabla.addColumn("Garantia");
        tabla.addColumn("Marca");
        tabla.addColumn("Estado");
        tabla.addColumn("Fecha alta");
        tabla.addColumn("Id_Equipo");
        tabla.addColumn("Proveedor");
        
        componentView.getTblComponente().setModel(tabla);
        
        List<Componente> listaComponente = componentService.listarComponentes();
        String[] datos = new String[8];
        
        for (Componente comp : listaComponente) {
            
            datos[0] = String.valueOf(comp.getId());
            datos[1] = comp.getDescripcion();
            datos[2] = comp.getGarantia();
            datos[3] = comp.getMarca();
            datos[4] = comp.getEstado().name();            
            datos[5] = new SimpleDateFormat("dd-MM-yyyy").format(comp.getFecha_adquisicion());
            
            if(comp.getEquipo()==null){
            
                datos[6] = "Sin equipo asignado";
               
            }else{
            
                 datos[6] = String.valueOf(comp.getEquipo().getId());
            }
            
            datos[7] = comp.getProveedor().getNombre();
            
            tabla.addRow(datos);
        }
        
        componentView.getTblComponente().setModel(tabla);
    }
    
    public static void eventoBotonConfimar(){
    
        String descripcion = componentView.getTxtDescripcion().getText();
        String garantia = componentView.getTxtGarantia().getText();
        String marca = componentView.getTxtMarca().getText();
        String categoria = componentView.getCbxCategoria().getSelectedItem().toString();
        String proveedor = componentView.getCbxProveedor().getSelectedItem().toString();
        
        if(!(descripcion.isEmpty() || garantia.isEmpty() || marca.isEmpty())){
        
            componentService.guardarComponente(descripcion, garantia, marca, componentService.retornarCategoria(categoria), 
                                                                          null, supplierService.buscarProveedorPorNombre(proveedor));
            
            JOptionPane.showMessageDialog(null, "Se guardó con éxito!.");
        
        }else{
        
            JOptionPane.showMessageDialog(null, "No se puede guardar. Campos vacio.");
        }
    }
    
}
