package app_sginventario.entidades;

import app_sginventario.entidades.Categoria;
import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.EstadoComponente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-05T16:31:22")
@StaticMetamodel(Componente.class)
public class Componente_ { 

    public static volatile SingularAttribute<Componente, String> descripcion;
    public static volatile SingularAttribute<Componente, String> marca;
    public static volatile SingularAttribute<Componente, Date> fecha_adquisicion;
    public static volatile SingularAttribute<Componente, EstadoComponente> estado;
    public static volatile SingularAttribute<Componente, Categoria> categoria;
    public static volatile SingularAttribute<Componente, Equipo> equipo;
    public static volatile SingularAttribute<Componente, Integer> id;
    public static volatile SingularAttribute<Componente, String> garantia;

}