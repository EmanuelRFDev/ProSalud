
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Doctor extends Persona implements Serializable{
    
    //private int id_doctorlogo;
    private String especialidad;
    @OneToMany(mappedBy = "doctor") //mediante el objeto doctor hacemos el mapeo
    private List<Turno> listaTurnos; //un doctorlogo puede tener varios turnos
    @OneToOne 
    private Usuario unUsuario; //un doctorlogo va a tener un usuario
    @OneToOne 
    private Horario unHorario; //un doctorlogo va a tener un horario

    public Doctor() {
    }

    public Doctor(String especialidad, List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    /*
    public int getId_doctorlogo() {
        return id_doctorlogo;
    }

    public void setId_doctorlogo(int id_doctorlogo) {
        this.id_doctorlogo = id_doctorlogo;
    }
    */
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }
    
}
