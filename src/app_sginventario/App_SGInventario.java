package app_sginventario;

import app_sginventario.controlador.LoginControlador;
import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Empresa;
import app_sginventario.entidades.EstadoComponente;
import app_sginventario.entidades.HistorialDeCambio;
import app_sginventario.entidades.Rol;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.entidades.Usuario;
import app_sginventario.servicio.ComponenteServicio;
import app_sginventario.servicio.EmpleadoServicio;
import app_sginventario.servicio.EmpresaServicio;
import app_sginventario.servicio.EquipoServicio;
import app_sginventario.servicio.ProveedorServicio;
import app_sginventario.servicio.UsuarioServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App_SGInventario {

    public static void main(String[] args) {
        
        EmpleadoServicio empleadoService = new EmpleadoServicio();
        UsuarioServicio userServ = new UsuarioServicio();
        EmpresaServicio empresaService = new EmpresaServicio();
        ComponenteServicio compoService = new ComponenteServicio();
        EquipoServicio equipoService = new EquipoServicio();
        ProveedorServicio proveedorService = new ProveedorServicio();
        
        //LoginControlador.mostrar();
        
        //userServ.guardarUsuario("Lmessi", "1234");
        
        //empleadoService.guardarEmpleado("Lionel", "Messi", "Pje.Vieytes", "45698526", Rol.ADMINISTRADOR, TipoDepartamento.SISTEMA, userServ.buscarUsuario(1));
        //empleadoService.guardarEmpleado("Johana", "Carrizo", "Av.Alem", "152874851", Rol.OPERADOR, TipoDepartamento.VENTA, userServ.buscarUsuario(2));
        
        
        /*SE CREO LA EMPRESA*/
        //emp.guardarEmpresa();
        
        
        /*SE BUSCA LA EMPRESA YA CREADA Y SE LE ASIGNA A JOHANA*/
        //Empresa empresa = emp.buscarEmpresa();
        //emp.guardarEmpleado("Johana", "Carrizo", "Av.Peron", "452198236", Rol.OPERADOR, TipoDepartamento.RRHH, null, empresa);
        
        
        /*SE CREA EL USUARIO PARA EL CRACK Y SE LE ASIGNA*/
        //userServ.guardarUsuario("LMessi", "1234");
        //emp.asignarUsuarioAEmpleado(1);
        
        //userServ.guardarUsuario("Jcarrizo", "0000");
        //emp.asignarUsuarioAEmpleado(2);
        
        //empresaService.asignarEmpresaAEmpleado(1, 1);
        
        //Empresa empresa = empresaService.buscarEmpresa(1);
        
        //empleadoService.guardarEmpleado("Emiliano", "Martinez", "Av.Jujuy", "156849623", Rol.ADMINISTRADOR, TipoDepartamento.CONTABILIDAD, null, empresa);
        
        
        /*compoService.guardarComponente("Disco duro SATA3 1Tb", "6 meses", "Kingstong", new Date(), Categoria.almacenamiento, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("Memoria Ram 8Gb DDR4", "8 meses", "corsair", new Date(), Categoria.memoria_ram, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("GeForce GTX 1050Ti", "1 año", "Asus", new Date(), Categoria.placa_video, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("Disco SSD 1Tb", "8 meses", "WesternDigital", new Date(), Categoria.almacenamiento, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("GeForce GTX 1080 Xtre", "1 año", "MSI", new Date(), Categoria.placa_video, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("MB B450m-Plus", "1 año", "Asus", new Date(), Categoria.placa_madre, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("Licencia paquete Office", "-", "Microsoft", new Date(), Categoria.software, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("Teclado K650", "3 meses", "Logitech", new Date(), Categoria.teclado, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("Mouse Xp", "3 meses", "Logitech", new Date(), Categoria.mouse, EstadoComponente.EN_USO, null);
        compoService.guardarComponente("Monitor 24'' LED ", "2 año", "LG", new Date(), Categoria.monitor, EstadoComponente.EN_USO, null);*/
        //compoService.guardarComponente("Windows 10 Pro", "-", "Microsoft", Categoria.software, null);
        //compoService.guardarComponente("Intel i5", "1 año", "Intel", Categoria.procesador, null);
        //compoService.guardarComponente("EVGA 500w", "1 año", "ThermalTake", Categoria.fuente, null);
        
        //List<Componente> listaComponentes = compoService.listarComponentes();
        
        //compoService.modificarComponente(listaComponentes);
        
        //List<HistorialDeCambio> listaHistorial = new ArrayList();
        
        //listaHistorial.add(new HistorialDeCambio("Cambio de memoria Ram de 4gb por una de 8gb", equipoService.buscarEquipo(3)));
        
        //equipoService.asignarHistorialAEquipo(3, listaHistorial);
        
        
        //equipoService.guardarEquipo("PC-01", listaHistorial, TipoDepartamento.SISTEMA, listaComponentes);
        //equipoService.guardarEquipo("PC-02", listaHistorial, TipoDepartamento.MARKETING, listaComponentes);
        
        
        //equipoService.asignarEquipoConComponente(3);
        
        proveedorService.guardarProveedor("CompraGamer");
        proveedorService.guardarProveedor("Microsoft");
        proveedorService.guardarProveedor("Elit");
        proveedorService.guardarProveedor("Meximus");
    }
    
}
