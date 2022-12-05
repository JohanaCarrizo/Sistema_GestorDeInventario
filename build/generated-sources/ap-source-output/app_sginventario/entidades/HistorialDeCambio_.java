package app_sginventario.entidades;

import app_sginventario.entidades.Equipo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-04T22:17:04")
@StaticMetamodel(HistorialDeCambio.class)
public class HistorialDeCambio_ { 

    public static volatile SingularAttribute<HistorialDeCambio, String> descripcion;
    public static volatile SingularAttribute<HistorialDeCambio, Equipo> equipo;
    public static volatile SingularAttribute<HistorialDeCambio, Date> fecha_cambio;
    public static volatile SingularAttribute<HistorialDeCambio, Integer> id;

}