package app_sginventario.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Empresa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String nombre;
    private String CUIT;
    private String direccion;
    private String telefono;
    
    /*@OneToMany(mappedBy = "empresa")
    private List<Equipo> equipos;*/
    
    //@OneToMany(mappedBy = "depto")
    //private List<Departamento> departamentos;
    
    public Empresa() {
        /*this.nombre = "CorporacionUmbrella";
        this.CUIT = "20-13569854-4";
        this.direccion = "Av.Siempre Viva";
        this.telefono = "4368579";*/
    }

    /*public Empresa(List<Equipo> equipos) {
        this.equipos = equipos;
        //this.departamentos = departamentos;
    }   */ 
    
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

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }*/

    /*public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }*/

    
}
