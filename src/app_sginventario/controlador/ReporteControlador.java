package app_sginventario.controlador;

import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.Reporte;
import app_sginventario.servicio.ReporteServicio;
import app_sginventario.vistas.ReporteVista;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ReporteControlador extends JFrame{
    
    private static ReporteVista reportView = new ReporteVista();
    private static ReporteServicio reportService = new ReporteServicio();
    private static Reporte reporte = new Reporte();
    
    public static void mostrar(){ reportView.setLocationRelativeTo(null); reportView.setVisible(true); }
    public static void ocultar(){ reportView.setVisible(false); reportView.getTblReporte().setModel(new DefaultTableModel()); reportView.getTxtDescripcion().setVisible(false);}
    
    public static void eventoBotonComponente(){
    
        reportView.getTxtDescripcion().setVisible(true);
        reportView.getTxtDescripcion().setText("Genera reporte de los componentes, mostrando fecha de adquisición, garantia y Proveedor");
        
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        reportView.getTblReporte().setRowSorter(ordenarTabla);
        
        List<Componente> listaFiltrada = reportService.reporteComponentes();
        
        tabla.addColumn("ID");
        tabla.addColumn("Descripción");
        tabla.addColumn("Nombre proveedor");
        tabla.addColumn("Fecha Adquisición");
        tabla.addColumn("Garantia");
        
        reportView.getTblReporte().setModel(tabla);
        String[] datos = new String[5];
        
        for (Componente componente : listaFiltrada) {
            
            datos[0] = String.valueOf(componente.getId());
            datos[1] = componente.getDescripcion();
            datos[2] = componente.getProveedor().getNombre();
            datos[3] = new SimpleDateFormat("dd-MM-yyyy").format(componente.getFecha_adquisicion());
            datos[4] = componente.getGarantia();
            
            tabla.addRow(datos);
        }
        reportView.getTblReporte().setModel(tabla);
    }
    
    public static void eventoBotonEquipoYEmp(){
    
        reportView.getTxtDescripcion().setVisible(true);
        reportView.getTxtDescripcion().setText("Genera reporte de los equipos que tienen asignado un empleado que esta dentro del sistema");
        
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        reportView.getTblReporte().setRowSorter(ordenarTabla);
        
        List<Equipo> listaFiltrada = reportService.reporteEquipoYEmpleado();
        tabla.addColumn("ID_Equipo");
        tabla.addColumn("Nombre Equipo");
        tabla.addColumn("ID_Empleado");
        tabla.addColumn("Nombre Empleado");
        
        reportView.getTblReporte().setModel(tabla);
        String[] datos = new String[4];
        
        for (Equipo equipo : listaFiltrada) {
            if(equipo.getEmpleado() != null){
            
                datos[0] = String.valueOf(equipo.getId());
                datos[1] = equipo.getNombre();
                datos[2] = String.valueOf(equipo.getEmpleado().getId());
                datos[3] = equipo.getEmpleado().getNombre()+" "+equipo.getEmpleado().getApellido();
            
                tabla.addRow(datos);
            }
            
        }
        reportView.getTblReporte().setModel(tabla);
    
    }
    
    public static void eventoBotonEquipoYDepa(){
    
        reportView.getTxtDescripcion().setVisible(true);
        reportView.getTxtDescripcion().setText("Genera reporte de los equipos en cada departamento");
        
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        reportView.getTblReporte().setRowSorter(ordenarTabla);
        
        List<Equipo> listaFiltrada = reportService.reporteEquipoYDepartamento();
        tabla.addColumn("ID_Equipo");
        tabla.addColumn("Nombre Equipo");
        tabla.addColumn("Departamento");
        
        reportView.getTblReporte().setModel(tabla);
        String[] datos = new String[3];
        
        for (Equipo equipo : listaFiltrada) {
            
            datos[0] = String.valueOf(equipo.getId());
            datos[1] = equipo.getNombre();
            datos[2] = equipo.getDepto().name();
            
            tabla.addRow(datos);
        }
        reportView.getTblReporte().setModel(tabla);
    }
    
    public static void eventoBotonEquipoYSoftware(){
    
        reportView.getTxtDescripcion().setVisible(true);
        reportView.getTxtDescripcion().setText("Genera reporte de los software instalados en equipo");
        
        DefaultTableModel tabla = new DefaultTableModel();   
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(tabla);
        reportView.getTblReporte().setRowSorter(ordenarTabla);
        
        List<Componente> listaFiltrada = reportService.reporteEquipoYSoftware();
        
        tabla.addColumn("ID_Equipo");
        tabla.addColumn("Nombre Equipo");
        tabla.addColumn("Nombre de Software");
        
        reportView.getTblReporte().setModel(tabla);
        String[] datos = new String[3];
        
        for (Componente componente : listaFiltrada) {

            if (componente.getEquipo() != null) {

                 datos[0] = String.valueOf(componente.getEquipo().getId());
                datos[1] = componente.getEquipo().getNombre();
                datos[2] = componente.getDescripcion();

                tabla.addRow(datos);
            }
           
        }
        reportView.getTblReporte().setModel(tabla);
    }
    
    public static void pasarEmpleadoAReporte(Empleado empleado){
    
        reporte.pasarEmpleadoAReporte(empleado);
    }
    
    public static void eventoBotonGenerarPDF(){
    
        reporte.generarDocumento();
    }

    public static void pasarBandera(int i) {
      
        reporte.pasarBanderaAReporte(i);
    }
}
