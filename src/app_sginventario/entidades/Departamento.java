package app_sginventario.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Departamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String nombre;
    
    @OneToMany(mappedBy = "depto")
    private List<Empleado> empleados;
    
    @OneToMany(mappedBy = "depto")
    private List<Equipo> equipos;

    public Departamento() {}

    public Departamento(int id, String nombre, List<Empleado> empleados, List<Equipo> equipos) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = empleados;
        this.equipos = equipos;
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    
}
