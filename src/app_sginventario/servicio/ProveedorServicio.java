package app_sginventario.servicio;

import app_sginventario.entidades.Proveedor;
import app_sginventario.persistencia.DAO;
import java.util.List;

public class ProveedorServicio extends DAO{
    
    public void guardarProveedor(String nombre){
    
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        super.guardar(proveedor);
    }
    
    public List listarProveedores(){
    
        conectar();
        List<Proveedor> proveedores = em.createQuery("SELECT p FROM Proveedor p").getResultList();
        desconectar();
        return proveedores;
    }
}
