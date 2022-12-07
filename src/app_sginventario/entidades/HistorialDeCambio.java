package app_sginventario.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HistorialDeCambio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String descripcion;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_cambio;
    
    @ManyToOne
    private Equipo equipo;
    
    @Enumerated(EnumType.STRING)
    private TipoDeCambio tipoCambio;

    public HistorialDeCambio() {
    
        this.fecha_cambio = new Date();
    }

    public HistorialDeCambio(String descripcion, TipoDeCambio tipoCambio, Equipo equipo) {
       
        this.descripcion = descripcion;
        this.fecha_cambio = new Date();
        this.tipoCambio = tipoCambio;
        this.equipo = equipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_cambio() {
        return fecha_cambio;
    }

    public void setFecha_cambio(Date fecha_cambio) {
        this.fecha_cambio = fecha_cambio;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public TipoDeCambio getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(TipoDeCambio tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
    
}
