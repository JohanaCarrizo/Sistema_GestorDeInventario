package app_sginventario.entidades;

import app_sginventario.entidades.Equipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-01T22:09:04")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> CUIT;
    public static volatile SingularAttribute<Empresa, String> direccion;
    public static volatile SingularAttribute<Empresa, Integer> id;
    public static volatile SingularAttribute<Empresa, String> telefono;
    public static volatile SingularAttribute<Empresa, String> nombre;
    public static volatile ListAttribute<Empresa, Equipo> equipos;

}