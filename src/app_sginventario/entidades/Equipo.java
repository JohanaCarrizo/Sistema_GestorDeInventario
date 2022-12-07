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
import javax.persistence.OneToOne;

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
    
    @OneToOne
    private Empleado empleado;
    
    @Enumerated(EnumType.STRING)
    private TipoDepartamento depto;
    

    public Equipo() {}

    public Equipo(String nombre, List<HistorialDeCambio> historiales, TipoDepartamento depto, List<Componente> componentes, Empleado empleado) {
        
        this.nombre = nombre;
        this.historiales = historiales;
        this.depto = depto;
        this.componentes = componentes;
        this.empleado = empleado;
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

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        
         this.componentes = componentes;
        
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    public boolean validarCantComponentes(List<Componente> componentes){
    
        return validarComponenteUnico(componentes) && componentes.size() >= 9;      
        
    }   
    
    public boolean validarComponenteUnico(List<Componente> componentes){
    
        int indice = 0;
        int bandera = 0;
        Categoria categorias[] = Categoria.values();
        int[] listaAux = new int[categorias.length];
        
        for (int i = 0; i < categorias.length; i++) {
            
            listaAux[i] = 0;          
        }
        
        for (Componente compo : componentes) {
            
            indice = compo.getCategoria().ordinal();
            listaAux[indice]++;
        }
        
        for (int i : listaAux) {
            
            if(i != 1){
            
                bandera++;
            
            }
        }
        return bandera == 0;
    }
}
