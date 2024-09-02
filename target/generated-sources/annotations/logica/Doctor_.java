package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Horario;
import logica.Turno;
import logica.Usuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-31T22:21:23", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Doctor.class)
public class Doctor_ extends Persona_ {

    public static volatile SingularAttribute<Doctor, Usuario> unUsuario;
    public static volatile SingularAttribute<Doctor, String> especialidad;
    public static volatile ListAttribute<Doctor, Turno> listaTurnos;
    public static volatile SingularAttribute<Doctor, Horario> unHorario;

}