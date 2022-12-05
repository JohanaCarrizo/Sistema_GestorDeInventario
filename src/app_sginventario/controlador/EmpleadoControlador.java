package app_sginventario.controlador;

import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Rol;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.entidades.Usuario;
import app_sginventario.servicio.EmpleadoServicio;
import app_sginventario.servicio.UsuarioServicio;
import app_sginventario.vistas.EmpleadoVista;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class EmpleadoControlador extends JFrame{
    
    private static EmpleadoVista employeeView = new EmpleadoVista();
    private static EmpleadoServicio employeeService = new EmpleadoServicio();
    private static UsuarioServicio userService = new UsuarioServicio();
    
    public static void mostrar(){
        llenarComboBoxDepa(); 
        llenarComboBoxRol(); 
        llenarTabla();
        employeeView.setLocationRelativeTo(null);  
        employeeView.setVisible(true); }
    
    public static void ocultar(){ employeeView.setVisible(false); }
    
    public static void mostrarBotonEdicionYEliminar(){ employeeView.getBtnConfirmarEdicion().setEnabled(true); employeeView.getBtnEliminar().setEnabled(true); }
    
    public static void ocultarBotonConfirmar(){ employeeView.getBtnConfirmar().setVisible(false); }
    
    public static void limpiarCampoTexto(){
    
        employeeView.getTxtNombre().setText("");
        employeeView.getTxtApellido().setText("");
        employeeView.getTxtDomicilio().setText("");
        employeeView.getTxtTelefono().setText("");
        employeeView.getTxtUsuario().setText("");
        employeeView.getTxtPass().setText("");
    }
    
    public static void llenarComboBoxRol(){
        
        JComboBox<String> comboRol = employeeView.getCbxRol();
        
        for (Rol rol : employeeService.listarRoles()) {
            
            comboRol.addItem(rol.name());
            
        }        
        employeeView.setCbxRol(comboRol);
    }
    
    public static void llenarComboBoxDepa(){
    
        JComboBox<String> comboDepa = employeeView.getCbxDepa();
        
        for (TipoDepartamento depa : employeeService.listarDepartamentos()) {
            
            comboDepa.addItem(depa.name());
            
        }        
        employeeView.setCbxDepa(comboDepa);
        
    }
    
    public static void llenarTabla(){
    
        DefaultTableModel tabla = new DefaultTableModel();    
         
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
         
        employeeView.getTblEmpleados().setRowSorter(ordenarTabla);
        
        tabla.addColumn("ID" );
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Direccion");
        tabla.addColumn("Telefono");
        tabla.addColumn("Rol");
        tabla.addColumn("Departamento");
        tabla.addColumn("Id_Usuario");
        
        employeeView.getTblEmpleados().setModel(tabla);
        
        List<Empleado> listaEmpleados = employeeService.listarEmpleados();
        String[] datos = new String[8];
        
        for (Empleado e : listaEmpleados) {
            
            datos[0] = String.valueOf(e.getId());
            datos[1] = e.getNombre();
            datos[2] = e.getApellido();
            datos[3] = e.getDomicilio();
            datos[4] = e.getTelefono();
            datos[5] = e.getRol().name();
            datos[6] = e.getDepto().name();
            datos[7] = String.valueOf(e.getUsuario().getId());
            
            tabla.addRow(datos);
        }
        
        employeeView.getTblEmpleados().setModel(tabla);
    }
    
    public static void eventoGuardarEmpleado(){
    
        String nombre = employeeView.getTxtNombre().getText();
        String apellido = employeeView.getTxtApellido().getText();
        String domicilio = employeeView.getTxtDomicilio().getText();
        String telefono = employeeView.getTxtTelefono().getText();
        String rol = employeeView.getCbxRol().getSelectedItem().toString();
        String depa = employeeView.getCbxDepa().getSelectedItem().toString();
        String usuario = employeeView.getTxtUsuario().getText();
        String pass = employeeView.getTxtPass().getText();
        
        if(nombre.isEmpty() || apellido.isEmpty() || domicilio.isEmpty() || telefono.isEmpty() || usuario.isEmpty()|| pass.isEmpty()){
        
            JOptionPane.showMessageDialog(null, "No es posible guardar. Complete todo los campos.");            
        
        }else{
        
            userService.guardarUsuario(usuario, pass);
            employeeService.guardarEmpleado(nombre, apellido, domicilio, telefono, employeeService.retornarRolSeleccionado(rol), 
                                                               employeeService.retornarDepaSeleccionado(depa), userService.obtenerUltimoIdCreado());
            
            JOptionPane.showMessageDialog(null, "Empleado guardado con éxito!");
            employeeView.getTblEmpleados().setModel(new DefaultTableModel());
            llenarTabla();
            limpiarCampoTexto();
        }
    }
    
    public static void eventoBotonEditar(){
    
        int fila = employeeView.getTblEmpleados().getSelectedRow();
        
        if(fila >= 0){
        
            employeeView.getTxtId().setText(employeeView.getTblEmpleados().getValueAt(fila, 0).toString());
            employeeView.getTxtNombre().setText(employeeView.getTblEmpleados().getValueAt(fila, 1).toString());
            employeeView.getTxtApellido().setText(employeeView.getTblEmpleados().getValueAt(fila, 2).toString());
            employeeView.getTxtDomicilio().setText(employeeView.getTblEmpleados().getValueAt(fila, 3).toString());
            employeeView.getTxtTelefono().setText(employeeView.getTblEmpleados().getValueAt(fila, 4).toString());
            employeeView.getCbxRol().getModel().setSelectedItem(employeeView.getTblEmpleados().getModel().getValueAt(fila, 5));
            employeeView.getCbxDepa().getModel().setSelectedItem(employeeView.getTblEmpleados().getModel().getValueAt(fila, 6));
            Empleado e = employeeService.buscarEmpleado(Integer.parseInt(employeeView.getTblEmpleados().getValueAt(fila, 0).toString()));
            employeeView.getTxtUsuario().setText(e.getUsuario().getNombre_usuario());
            employeeView.getTxtPass().setText(e.getUsuario().getPass());
            
            ocultarBotonConfirmar();
            mostrarBotonEdicionYEliminar();
            
        }else{
        
            JOptionPane.showMessageDialog(null, "Por favor seleccione un registro de la tabla para poder editar");
        }
    }
}
