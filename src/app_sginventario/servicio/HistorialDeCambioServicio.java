package app_sginventario.servicio;

import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.HistorialDeCambio;
import app_sginventario.entidades.TipoDeCambio;
import app_sginventario.persistencia.DAO;

public class HistorialDeCambioServicio extends DAO{
    
    public void guardarHistorial(String descripcion, TipoDeCambio cambio, Equipo equipo){
    
        HistorialDeCambio historial = new HistorialDeCambio();
        historial.setDescripcion(descripcion);
        historial.setTipoCambio(cambio);
        historial.setEquipo(equipo);
        super.guardar(historial);
    }
    
}
