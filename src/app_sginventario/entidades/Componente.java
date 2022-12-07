package app_sginventario.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    
    @OneToOne
    private Proveedor proveedor;
    
    
    public Componente() {
    
        this.fecha_adquisicion = new Date();
        this.estado = EstadoComponente.EN_ALMACEN;
    }

    public Componente(String descripcion, String garantia, String marca, Categoria categoria, Equipo equipo, Proveedor proveedor) {
       
        this.descripcion = descripcion;
        this.garantia = garantia;
        this.marca = marca;
        this.fecha_adquisicion = new Date();
        this.categoria = categoria;
        this.estado = EstadoComponente.EN_ALMACEN;
        this.equipo = equipo;
        this.proveedor = proveedor;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
