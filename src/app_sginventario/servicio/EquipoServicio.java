package app_sginventario.servicio;

import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.HistorialDeCambio;
import app_sginventario.entidades.TipoDepartamento;
import app_sginventario.persistencia.DAO;
import java.util.List;

public class EquipoServicio extends DAO{
    
    public boolean guardarEquipo(String nombre, List<HistorialDeCambio> historiales, TipoDepartamento depto, List<Componente> componentes){
    
        Equipo equipo = new Equipo();
        
        if(equipo.validarCantComponentes(componentes)){
        
            equipo.setNombre(nombre);
            equipo.setHistoriales(historiales);
            equipo.setDepto(depto);
            equipo.setComponentes(componentes);
            
            super.guardar(equipo);            
            return true;
        
        }else{ return false; }
    }
    
    
    public void asignarEquipoConComponente(int id){
    
      Equipo equipo = buscarEquipo(id);  
      List<Componente> listaComp = equipo.getComponentes();
    
        for (Componente componente : listaComp) {
            
            componente.setEquipo(equipo);
            super.editar(componente);
        }
    }
    
    public void asignarHistorialAEquipo(int id, List<HistorialDeCambio> historiales){
    
        Equipo equipo = buscarEquipo(id); 
        equipo.setHistoriales(historiales);
        super.editar(equipo);
    }

    public Equipo buscarEquipo(int id) {
        
        conectar();
        Equipo equipo = em.find(Equipo.class, id);
        desconectar();
        return equipo;
    }
}
