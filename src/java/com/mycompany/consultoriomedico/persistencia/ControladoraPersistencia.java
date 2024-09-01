package com.mycompany.consultoriomedico.persistencia;

import com.mycompany.consultoriomedico.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import logica.Doctor;
import logica.Paciente;
import logica.Responsable;
import logica.Secretario;
import logica.Turno;
import logica.Usuario;

public class ControladoraPersistencia {

    HorarioJpaController horarioJPA = new HorarioJpaController();
    DoctorJpaController doctorJPA = new DoctorJpaController();
    PacienteJpaController pacJPA = new PacienteJpaController();
    PersonaJpaController perJPA = new PersonaJpaController();
    ResponsableJpaController respJPA = new ResponsableJpaController();
    SecretarioJpaController secreJPA = new SecretarioJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();

    public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);
    }

    public List<Usuario> getUsuarios() {

        return usuJPA.findUsuarioEntities();

    }

    public void borrarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {

        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Doctor> traerListaDoctors() {
        return doctorJPA.findDoctorEntities();
    }

    public void crearDoctor(Horario horario, Usuario usu, Doctor doctor) {
        horarioJPA.create(horario);
        usuJPA.create(usu);
        doctorJPA.create(doctor);

    }

    public Doctor traerDoctor(int id_doctor) {
        return doctorJPA.findDoctor(id_doctor);
    }

    public void borrarDoctor(int id_doctor) {
        try {
            doctorJPA.destroy(id_doctor);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Horario traerHorario(int id_horario) {
        return horarioJPA.findHorario(id_horario);
    }

    public void borrarHorario(int id_horario) {
        try {
            horarioJPA.destroy(id_horario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarDoctor(Horario horario, Doctor odon, Usuario usu) {
        try {
            horarioJPA.edit(horario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            doctorJPA.edit(odon);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearSecretario(Usuario usu, Secretario secre) {
        usuJPA.create(usu);
        secreJPA.create(secre);
    }

    public List<Secretario> traerSecretarios() {
        return secreJPA.findSecretarioEntities();
    }

    public void borrarSecretario(int id_secre) {
        try {
            secreJPA.destroy(id_secre);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Secretario traerSecretario(int id_secre) {
        return secreJPA.findSecretario(id_secre);
    }

    public void editarSecretario(Usuario usu, Secretario secre) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            secreJPA.edit(secre);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearPacienteConResp(Responsable resp, Paciente pac, Turno tur) {
        respJPA.create(resp);
        pacJPA.create(pac);

        turnoJPA.create(tur);

    }

    public void crearPacienteConResp(Paciente pac, Turno tur) {
        pacJPA.create(pac);
        turnoJPA.create(tur);
    }

    public List<Turno> traerTurnos() {
        return turnoJPA.findTurnoEntities();
    }

    public List<Paciente> traerPacientes() {
        return pacJPA.findPacienteEntities();
    }

    public void borrarPaciente(int id_paciente) {
        try {
            pacJPA.destroy(id_paciente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarTurno(int id_turno) {
        try {
            turnoJPA.destroy(id_turno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turno traerTurno(int id_turno) {
        return turnoJPA.findTurno(id_turno);
    }

    public Paciente traerPaciente(int id_paciente) {
        return pacJPA.findPaciente(id_paciente);
    }

    public void editarTurno(Paciente pac, Turno turno) {
        try {
            pacJPA.edit(pac);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearResponsable(Responsable resp) {
        respJPA.create(resp);
    }

}
