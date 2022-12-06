package app_sginventario;

import app_sginventario.controlador.LoginControlador;
import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Empleado;
import app_sginventario.entidades.Empresa;
import app_sginventario.entidades.Equipo;
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
        
        LoginControlador.mostrar();
        
        
//        List<Componente> lista = compoService.filtrarPorCategoria(Categoria.monitor);
        
        
        /*Categoria cat = compoService.retornarCategoria("memoria_ram");
        List<Componente> lista = compoService.filtrarPorCategoria(cat);*/
        
//        for (Componente componente : lista) {
//            
//            System.out.println(componente);
//            
//        }
        
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
        
        /*compoService.guardarComponente("500w", "1 año", "Noga", Categoria.fuente, null);
        compoService.guardarComponente("750w", "6 meses", "Cooler Master", Categoria.fuente, null);
        compoService.guardarComponente("750w", "9 meses", "Aerocool", Categoria.fuente, null);
        compoService.guardarComponente("600w", "1 año", "Segotep", Categoria.fuente, null);
        compoService.guardarComponente("500w", "1 año", "Redragon", Categoria.fuente, null);

        compoService.guardarComponente("Ryzen 5 5600", "1 año", "Amd", Categoria.procesador, null);
        compoService.guardarComponente("Intel i7 9400", "2 años", "Intel", Categoria.procesador, null);
        compoService.guardarComponente("Intel i3 10100", "1 año", "Intel", Categoria.procesador, null);
        compoService.guardarComponente("Ryzen 7 5700", "1 año", "Amd", Categoria.procesador, null);
        compoService.guardarComponente("Intel Celeron G4560", "6 meses", "Intel", Categoria.procesador, null);

        compoService.guardarComponente("Disco ssd 256Gb", "1 año", "Western Digital", Categoria.almacenamiento, null);
        compoService.guardarComponente("Disco SSD 1Tb", "8 meses", "WesternDigital", Categoria.almacenamiento, null);
        compoService.guardarComponente("Disco Duro 1Tb", "2 años", "Seagate", Categoria.almacenamiento, null);
        compoService.guardarComponente("Disco Duro 2Tb", "6 meses", "Kingston", Categoria.almacenamiento, null);
        compoService.guardarComponente("Disco M2 980 Gb", "15 meses", "Samsung", Categoria.almacenamiento, null);

        compoService.guardarComponente("Memoria Ram 16Gb DDR4", "8 meses", "HyperX", Categoria.memoria_ram, null);
        compoService.guardarComponente("Memoria Ram 16Gb DDR4", "1 año", "Kingston", Categoria.memoria_ram, null);
        compoService.guardarComponente("Memoria Ram 8Gb DDR4", "2 años", "Crucial", Categoria.memoria_ram, null);
        compoService.guardarComponente("Memoria Ram 32Gb DDR4", "6 meses", "Patriot Viper", Categoria.memoria_ram, null);
        compoService.guardarComponente("Memoria Ram 8Gb DDR4", "1 año", "Vengeance", Categoria.memoria_ram, null);

        compoService.guardarComponente("Radeon Rx570 4Gb", "2 años", "Asus", Categoria.placa_video, null);
        compoService.guardarComponente("GeForce GTX 1080ti 4Gb", "1 año", "Asus", Categoria.placa_video, null);
        compoService.guardarComponente("GeForce RTX 2060 12Gb", "8 meses", "Gigabyte", Categoria.placa_video, null);
        //compoService.guardarComponente("Radeon Rx6650 8Gb", "1 año", "Gigabyte" Categoria.placa_video, null);
        compoService.guardarComponente("GeForce RTX 3070ti", "2 años", "Msi", Categoria.placa_video, null);

        compoService.guardarComponente("MB B450m-Plus", "1 año", "Asus", Categoria.placa_madre, null);
        compoService.guardarComponente("A320M-H", "6 meses", "Gigabyte", Categoria.placa_madre, null);
        compoService.guardarComponente("H510M-H", "9 meses", "Gigabyte", Categoria.placa_madre, null);
        compoService.guardarComponente("Z590 Pro AX", "1 año", "Aorus", Categoria.placa_madre, null);
        compoService.guardarComponente("X570 TUF", "2 años", "Asus", Categoria.placa_madre, null);

        compoService.guardarComponente("Licencia paquete Office", "-", "Microsoft", Categoria.software, null);
        compoService.guardarComponente("Windows 10 Pro", "-", "Microsoft", Categoria.software, null);
        compoService.guardarComponente("Ubuntu", "-", "Linux", Categoria.software, null);
        compoService.guardarComponente("Vegas Pro 11", "-", "Sony", Categoria.software, null);
        compoService.guardarComponente("Visual Studio 11", "-", "Microsoft", Categoria.software, null);

        compoService.guardarComponente("Teclado K120", "3 meses", "Logitech", Categoria.teclado, null);
        compoService.guardarComponente("Teclado K509", "6 meses", "Redragon", Categoria.teclado, null);
        compoService.guardarComponente("Teclado Alloy Origins", "3 meses", "HyperX", Categoria.teclado, null);
        compoService.guardarComponente("Teclado K60 Pro", "1 año", "Corsair", Categoria.teclado, null);
        compoService.guardarComponente("Teclado NKB-500", "2 años", "Noganet", Categoria.teclado, null);

        compoService.guardarComponente("Mouse Dx-120", "3 meses", "Genius", Categoria.mouse, null);
        compoService.guardarComponente("Mouse Gxt 144", "6 meses", "Trust", Categoria.mouse, null);
        compoService.guardarComponente("Mouse Cobra", "1 año", "Redragon", Categoria.mouse,  null);
        compoService.guardarComponente("Mouse G300", "9 meses", "Logitech", Categoria.mouse, null);
        compoService.guardarComponente("Mouse DeathAdder V2", "15 meses", "Razer", Categoria.mouse, null);

        compoService.guardarComponente("Monitor 24 E2420H ", "2 año", "Dell", Categoria.monitor, null);
        compoService.guardarComponente("Monitor 24 Odissey G3", "1 año", "Samsung", Categoria.monitor, null);
        compoService.guardarComponente("Monitor 24 C24RG5", "1 año", "Samsung", Categoria.monitor, null);
        compoService.guardarComponente("Monitor 24 221V8", "2 año", "Philips", Categoria.monitor, null);
        compoService.guardarComponente("Monitor 24 Va2215-H", "1 año", "ViewSonic", Categoria.monitor, null);*/
        
        //List<Componente> listaComponentes = compoService.listarComponentes();
        
        //compoService.modificarComponente(listaComponentes);
        
        //compoService.modificarComponente(listaComponentes);
        
        //List<HistorialDeCambio> listaHistorial = new ArrayList();
        
        //listaHistorial.add(new HistorialDeCambio("Cambio de memoria Ram de 4gb por una de 8gb", equipoService.buscarEquipo(3)));
        
        //equipoService.asignarHistorialAEquipo(3, listaHistorial);
        
        
        //equipoService.guardarEquipo("PC-01", listaHistorial, TipoDepartamento.SISTEMA, listaComponentes);
        //equipoService.guardarEquipo("PC-02", listaHistorial, TipoDepartamento.MARKETING, listaComponentes);
        
        
        //equipoService.asignarEquipoConComponente(3);
        
        /*proveedorService.guardarProveedor("CompraGamer");
        proveedorService.guardarProveedor("Microsoft");
        proveedorService.guardarProveedor("Elit");
        proveedorService.guardarProveedor("Meximus");
        
        proveedorService.guardarProveedor("Venex");
        proveedorService.guardarProveedor("Linux");
        proveedorService.guardarProveedor("Mercado Libre");
        proveedorService.guardarProveedor("Samsung");
        proveedorService.guardarProveedor("Noga");
        proveedorService.guardarProveedor("Redragon");
        proveedorService.guardarProveedor("Asus");
        proveedorService.guardarProveedor("Alberto Perez SA");
        proveedorService.guardarProveedor("Delider Informatica");*/
    }
    
}
