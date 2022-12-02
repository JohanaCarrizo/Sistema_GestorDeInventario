package app_sginventario.entidades;

import app_sginventario.entidades.Componente;
import app_sginventario.entidades.Empresa;
import app_sginventario.entidades.HistorialDeCambio;
import app_sginventario.entidades.TipoDepartamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-01T22:09:04")
@StaticMetamodel(Equipo.class)
public class Equipo_ { 

    public static volatile ListAttribute<Equipo, Componente> componentes;
    public static volatile ListAttribute<Equipo, HistorialDeCambio> historiales;
    public static volatile SingularAttribute<Equipo, TipoDepartamento> depto;
    public static volatile SingularAttribute<Equipo, Integer> id;
    public static volatile SingularAttribute<Equipo, Empresa> empresa;
    public static volatile SingularAttribute<Equipo, String> nombre;

}