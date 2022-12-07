package app_sginventario.servicio;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.HistorialDeCambio;
import app_sginventario.persistencia.DAO;
import java.util.List;

public class ReporteServicio extends DAO{
    
    public List reporteComponentes(){
    
        conectar();
        List<Componente> lista = em.createQuery("SELECT c FROM Componente c ").getResultList();
        desconectar();
        return lista;
    }
    
    public List reporteEquipoYEmpleado(){
    
        conectar();
        List<Equipo> lista = em.createQuery("SELECT e FROM Equipo e").getResultList();
        desconectar();
        return lista;
    }
    
    public List reporteEquipoYDepartamento(){
    
        conectar();
        List<Equipo> lista = em.createQuery("SELECT e FROM Equipo e").getResultList();
        desconectar();
        return lista;
    }
    
    public List reporteIndiceDeFalla(){
    
        conectar();
        List<HistorialDeCambio> lista = em.createQuery("SELECT h FROM HistorialDeCambio h").getResultList();
        desconectar();
        return lista;
    }
    
    public List reporteEquipoYSoftware(){
    
        Categoria categoriaS = Categoria.software;
        conectar();
        List<Componente> lista = em.createQuery("SELECT c FROM Componente c WHERE c.categoria = :categoriaS").setParameter("categoriaS", categoriaS).getResultList();
        desconectar();
        return lista;
    }
}
