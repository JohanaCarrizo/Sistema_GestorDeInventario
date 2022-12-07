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
    
    public Proveedor buscarProveedor(int id){
    
        conectar();
        Proveedor prov = em.find(Proveedor.class, id);
        desconectar();
        return prov;
    }
    
    public Proveedor buscarProveedorPorNombre(String nombreP){
    
        List<Proveedor> lista = listarProveedores();
        for (Proveedor proveedor : lista) {
            
            if(proveedor.getNombre().equals(nombreP)){
            
                return proveedor;
            }            
        }
        return null;
    }
}
