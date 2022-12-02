package app_sginventario.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String nombre;
    
    @OneToMany(mappedBy = "equipo")
    private List<HistorialDeCambio> historiales;
    
    @OneToMany(mappedBy = "equipo")
    private List<Componente> componentes;
    
    //@ManyToOne
    //private Departamento depto;
    
    @Enumerated(EnumType.STRING)
    private TipoDepartamento depto;
    
    @ManyToOne
    private Empresa empresa;

    public Equipo() {}

    public Equipo(String nombre, List<HistorialDeCambio> historiales, TipoDepartamento depto) {
        
        this.nombre = nombre;
        this.historiales = historiales;
        this.depto = depto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<HistorialDeCambio> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<HistorialDeCambio> historiales) {
        this.historiales = historiales;
    }

    public TipoDepartamento getDepto() {
        return depto;
    }

    public void setDepto(TipoDepartamento depto) {
        this.depto = depto;
    }
    
    
    
}
