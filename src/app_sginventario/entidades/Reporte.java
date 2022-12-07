package app_sginventario.entidades;
import app_sginventario.servicio.ComponenteServicio;
import app_sginventario.servicio.EquipoServicio;
import app_sginventario.servicio.ReporteServicio;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Reporte {
    
    ComponenteServicio compService = new ComponenteServicio();
    EquipoServicio equipoService = new EquipoServicio();
    ReporteServicio reportService  = new ReporteServicio();
    Empleado empleado;
    int bandera = 0;
    
    
    public void generarDocumento(){
    
        
        EquipoServicio equipoServicio = new EquipoServicio();
        Document documento = new Document();
         String titulo = "";
         String direccion = "";
        try {
            
            String ruta = System.getProperty("user.home");
            
            switch(bandera){
            
                case 1:
                    direccion = "/Desktop/Reporte_Componente.pdf";
                    titulo = "Reporte de Componentes";
                    break;
                case 2:
                    direccion = "/Desktop/Reporte_Equipo_Empleado.pdf";
                    titulo = "Reporte de Equipo y Empleados";
                    break;
                case 3:
                    
                    direccion = "/Desktop/Reporte_Equipo_Departamento.pdf";
                    titulo = "Reporte de Equipo y Departamento";                    
                    break;
                case 4:
                    direccion = "/Desktop/Reporte_Equipo_Software.pdf";
                    titulo = "Reporte de Equipo y Software";  
                    break;
                default:
                    break;
            }
            
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + direccion));
            
            documento.open();
            Paragraph parrafo = new Paragraph(titulo);
            parrafo.setAlignment(1);
            documento.add(parrafo);
            
            documento.add(new Paragraph("Nombre: " + empleado.getNombre()+" "+empleado.getApellido()));
            documento.add(new Paragraph("Equipo: " + equipoServicio.buscarEquipoConEmpleado(empleado.getId()).getNombre()));
            documento.add(new Paragraph("Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date())+"\n\n"));
                     
            switch(bandera){
            
                case 1:        
                    
                    documento.add(datosTablaReporteComponente());
                    break;
                case 2:
                    documento.add(datosTablaReporteEquipoYEmpleado());
                    break;
                case 3:
                    documento.add(datosTablaReporteEquipoYDepartamento());
                    break;
                case 4:
                    documento.add(datosTablaReporteEquipoYSoftware());
                    break;
                    
                default:
                    break;
            }
                       
            documento.close();
            
        } catch (Exception e) {
        }
    
        
    }

    public void pasarEmpleadoAReporte(Empleado empleado) {
       
        this.empleado = empleado;
    }
    
    public PdfPTable datosTablaReporteComponente(){
    
        PdfPTable tabla = new PdfPTable(5);
            
            tabla.addCell("ID");
            tabla.addCell("Descripcion");
            tabla.addCell("Nombre proveedor");
            tabla.addCell("Fecha de adquisición");
            tabla.addCell("Garantia");
            
            List<Componente> lista = compService.listarComponentes();
            
            for (Componente componente : lista) {
                
                tabla.addCell(String.valueOf(componente.getId()));
                tabla.addCell(componente.getDescripcion());
                tabla.addCell(componente.getProveedor().getNombre());
                String fecha = new SimpleDateFormat("dd-MM-yyyy").format(componente.getFecha_adquisicion());
                tabla.addCell(fecha);
                tabla.addCell(componente.getGarantia());
                
            }
            
            return tabla;
    }
    
    public PdfPTable datosTablaReporteEquipoYEmpleado() {

        PdfPTable tabla = new PdfPTable(4);

        tabla.addCell("ID_Equipo");
        tabla.addCell("Nombre");
        tabla.addCell("ID_Empleado");
        tabla.addCell("Nombre Empleado");

        List<Equipo> lista = equipoService.listarEquipos();

        for (Equipo equipo : lista) {
            if (equipo.getEmpleado() != null) {

                tabla.addCell(String.valueOf(equipo.getId()));
                tabla.addCell(equipo.getNombre());
                tabla.addCell(String.valueOf(equipo.getEmpleado().getId()));
                tabla.addCell(equipo.getEmpleado().getNombre() + " " + equipo.getEmpleado().getApellido());

            }

        }
        return tabla;
    }
    
    public PdfPTable datosTablaReporteEquipoYDepartamento(){
        
        PdfPTable tabla = new PdfPTable(3);
            
            tabla.addCell("ID_Equipo");
            tabla.addCell("Nombre Equipo");
            tabla.addCell("Departamento");
            
            List<Equipo> lista = equipoService.listarEquipos();
            
            for (Equipo equipo : lista) {
                
                tabla.addCell(String.valueOf(equipo.getId()));
                tabla.addCell(equipo.getNombre());
                tabla.addCell(equipo.getDepto().name());                
            }
            
            return tabla;
    }
    
    public PdfPTable datosTablaReporteEquipoYSoftware(){
    
        PdfPTable tabla = new PdfPTable(3);
            
            tabla.addCell("ID_Equipo");
            tabla.addCell("Nombre Equipo");
            tabla.addCell("Nombre Software");
   
        List<Componente> lista = reportService.reporteEquipoYSoftware();

        for (Componente componente : lista) {

            if(componente.getEquipo() != null){
            
                tabla.addCell(String.valueOf(componente.getEquipo().getId()));
                tabla.addCell(componente.getEquipo().getNombre());
                tabla.addCell(componente.getDescripcion());                
            }

        }
            
            return tabla;
    }

    public void pasarBanderaAReporte(int i) {
      
        this.bandera = i;
    }
}
