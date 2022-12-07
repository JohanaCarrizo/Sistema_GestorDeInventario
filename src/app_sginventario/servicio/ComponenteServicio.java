package app_sginventario.servicio;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.EstadoComponente;
import app_sginventario.entidades.Proveedor;
import app_sginventario.persistencia.DAO;
import java.util.Date;
import java.util.List;

public class ComponenteServicio extends DAO{
    
    public void guardarComponente(String descripcion, String garantia, String marca, Categoria categoria, Equipo equipo, Proveedor proveedor){
    
        Componente componente = new Componente();
        
        componente.setDescripcion(descripcion);
        componente.setGarantia(garantia);
        componente.setMarca(marca);
        componente.setCategoria(categoria);
        componente.setEstado(EstadoComponente.EN_ALMACEN);
        componente.setEquipo(equipo);
        componente.setProveedor(proveedor);
        
        super.guardar(componente);
        
    }
    
    public void modificarComponente(List<Componente> componentes){
    
        for (Componente componente : componentes) {
            
            componente.setEstado(EstadoComponente.EN_USO);
            super.editar(componente);
        }   
        
    }
    
    public void guardarModificacion(List<Componente> componentes) {

        for (Componente componente : componentes) {
            
            super.editar(componente);
        }
    }
    
    public List listarComponentes(){
    
        conectar();
        em.getTransaction().begin();
        List<Componente> lista = em.createQuery("SELECT c FROM Componente c").getResultList();
        desconectar();
        return lista;
    
    }
    
    public Categoria[] listarCategorias(){
    
        return Categoria.values();
    }
    
    public Categoria retornarCategoria(String valor){
    
        Categoria[] listaC = listarCategorias();
        for (int i = 0; i < listaC.length; i++) {
            
            if(listaC[i].name().equals(valor) ){
            
                return listaC[i];
            }      
        }        
        return null;
    }
    
    public List filtrarPorCategoria(Categoria nomCategoria){
    
        conectar();
        em.getTransaction().begin();
        List<Componente> lista = em.createQuery("SELECT c FROM Componente c WHERE c.categoria = :nomCategoria")
                                                      .setParameter("nomCategoria", nomCategoria)
                                                      .getResultList();
        desconectar();
        return lista;
    }
    
    public List filtrarEntre(){
    
        conectar();
        em.getTransaction().begin();
        List<Componente> lista = em.createQuery("SELECT c FROM Componente c WHERE c.id BETWEEN 61 AND 63").getResultList();
        desconectar();
        return lista;
    }
    
    public Componente buscarComponente(int id){
    
        conectar();
        em.getTransaction().begin();
        Componente c = em.find(Componente.class, id);
        desconectar();
        return c;
    }
    
}
