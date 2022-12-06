package app_sginventario.entidades;

import app_sginventario.entidades.Equipo;
import app_sginventario.entidades.TipoDeCambio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-06T09:47:24")
@StaticMetamodel(HistorialDeCambio.class)
public class HistorialDeCambio_ { 

    public static volatile SingularAttribute<HistorialDeCambio, String> descripcion;
    public static volatile SingularAttribute<HistorialDeCambio, TipoDeCambio> tipoCambio;
    public static volatile SingularAttribute<HistorialDeCambio, Equipo> equipo;
    public static volatile SingularAttribute<HistorialDeCambio, Date> fecha_cambio;
    public static volatile SingularAttribute<HistorialDeCambio, Integer> id;

}