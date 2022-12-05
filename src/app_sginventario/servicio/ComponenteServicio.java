package app_sginventario.servicio;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.EstadoComponente;
import app_sginventario.persistencia.DAO;
import java.util.Date;
import java.util.List;

public class ComponenteServicio extends DAO{
    
    public void guardarComponente(String descripcion, String garantia, String marca, Categoria categoria, Equipo equipo){
    
        Componente componente = new Componente();
        
        componente.setDescripcion(descripcion);
        componente.setGarantia(garantia);
        componente.setMarca(marca);
        componente.setCategoria(categoria);
        componente.setEquipo(equipo);
        
        super.guardar(componente);
        
    }
    
    public void modificarComponente(List<Componente> componentes){
    
        for (Componente componente : componentes) {
            
            componente.setEstado(EstadoComponente.EN_ALMACEN);
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
    
}
