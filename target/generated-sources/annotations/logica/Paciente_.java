package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Responsable;
import logica.Turno;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-31T22:21:23", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Paciente.class)
public class Paciente_ extends Persona_ {

    public static volatile SingularAttribute<Paciente, String> tiene_OS;
    public static volatile SingularAttribute<Paciente, String> tipoSangre;
    public static volatile SingularAttribute<Paciente, Responsable> unResponsable;
    public static volatile ListAttribute<Paciente, Turno> listaTurnos;

}