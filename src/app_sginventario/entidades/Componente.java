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
public class Componente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String descripcion;
    private String garantia;
    private String marca;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_adquisicion;
    
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    @Enumerated(EnumType.STRING)
    private EstadoComponente estado;    
    
    @ManyToOne
    private Equipo equipo;
    
    
    

    public Componente() {}

    public Componente(int id, String descripcion, String garantia, String marca, Date fecha_adquisicion, Categoria categoria, EstadoComponente estado, Equipo equipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.garantia = garantia;
        this.marca = marca;
        this.fecha_adquisicion = fecha_adquisicion;
        this.categoria = categoria;
        this.estado = estado;
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

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public EstadoComponente getEstado() {
        return estado;
    }

    public void setEstado(EstadoComponente estado) {
        this.estado = estado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
}
