package logica;

import com.mycompany.consultoriomedico.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {
        //creo un usuario vacio para luego asignarle los valores
        Usuario usu = new Usuario();
        //seteo los valores (o sea se los asigno)
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        controlPersis.crearUsuario(usu);
    }

    public List<Usuario> getUsuarios() {

        return controlPersis.getUsuarios();

    }

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia, String rol) {

        boolean ingreso = false;
        //la logica en este caso tiene que buscar el usuario en la BD, y una vez que lo encuentre despues valida si la contraseña es correcta
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        //decimos que lista de usuarios es igual a traer todos los usuarios de la BD
        listaUsuarios = controlPersis.getUsuarios();
        //recorremos la lista
        for (Usuario usu : listaUsuarios) {
            //preguntamos si el nombre de usuario coincide con el nombre de usuario que estamos recibiendo (el del formulario dei ngreso)
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    if (usu.getRol().equalsIgnoreCase(rol)) { //si estas tres condiciones se cumplen quiere decir que mi ingreso es correcto
                        ingreso = true;
                    }
                } else {
                    ingreso = false;
                }
            }

        }
        return ingreso; //nos devuelve si el ingreso es valido o no

    }

    public void crearDoctor(String nombreDoctor, String apellidoDoctor, String dniDoctor, String telefonoDoctor, String direccionDoctor, Date fecha_nac, String especialidad, String horario_entrada, String horario_salida, String nombreUsu, String contrasenia, String rol) {

        Horario horario = new Horario();
        horario.setHorario_inicio(horario_entrada);
        horario.setHorario_fin(horario_salida);
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsu);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        Doctor doctor = new Doctor();
        doctor.setNombre(nombreDoctor);
        doctor.setApellido(apellidoDoctor);
        doctor.setDireccion(direccionDoctor);
        doctor.setDni(dniDoctor);
        doctor.setTelefono(telefonoDoctor);
        doctor.setFecha_nac(fecha_nac);
        doctor.setEspecialidad(especialidad);
        horario.setHorario_inicio(horario_entrada);
        horario.setHorario_fin(horario_salida);
        doctor.setUnHorario(horario);
        usu.setNombreUsuario(nombreUsu);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        doctor.setUnUsuario(usu);
        
        controlPersis.crearDoctor(horario, usu, doctor);
    }

    public List<Doctor> traerListaDoctors() {
        return controlPersis.traerListaDoctors();
    }

    public Doctor traerDoctor(int id_doctor) {
        return controlPersis.traerDoctor(id_doctor);
    }

    public void borrarDoctor(int id_doctor) {
        controlPersis.borrarDoctor(id_doctor);
    }

    public Horario traerHorario(int id_horario) {
        return controlPersis.traerHorario(id_horario);
    }

    public void borrarHorario(int id_horario) {
        controlPersis.borrarHorario(id_horario);
    }

    public void editarDoctor(Horario horario, Doctor odon, Usuario usu) {
        controlPersis.editarDoctor(horario, odon, usu);
    }

    public void crearSecretario(String nombreSecretario, String apellidoSecretario, String dniSecretario, String telefonoSecretario, String direccionSecretario, Date fechanac, String sector, String nombreUsuario, String contrasenia, String rol) {

        Usuario usu = new Usuario();

        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);

        Secretario secre = new Secretario();
        secre.setNombre(nombreSecretario);
        secre.setApellido(apellidoSecretario);
        secre.setDni(dniSecretario);
        secre.setTelefono(telefonoSecretario);
        secre.setDireccion(direccionSecretario);
        secre.setFecha_nac(fechanac);
        secre.setSector(sector);
        secre.setUnUsuario(usu);
        
        controlPersis.crearSecretario(usu, secre);
        
    }

    public List<Secretario> traerSecretarios() {
        return controlPersis.traerSecretarios();
    }

    public void borrarSecretario(int id_secre) {
        controlPersis.borrarSecretario(id_secre);
    }

    public Secretario traerSecretario(int id_secre) {
        return controlPersis.traerSecretario(id_secre);
    }

    public void editarSecretario(Usuario usu, Secretario secre) {
        controlPersis.editarSecretario(usu, secre);
    }

    public void crearPaciente(String nombre, String apellido, String dni, String telefono, String direccion, Date fechanac, String tiene_OS, String tipo_sangre, Date fecha_turno, String hora_turno, String afeccion, String nombreResp, String apellidoResp, String dniResp, String telefonoResp, String direccionResp, Date fechanacResp, String tipoRespon , int id_doctor) {
        
        Paciente pac = new Paciente();
        Responsable resp = new Responsable();
        Turno tur = new Turno();
        Doctor odon = new Doctor();
        
        pac.setNombre(nombre);
        pac.setApellido(apellido);
        pac.setDni(dni);
        pac.setTelefono(telefono);
        pac.setDireccion(direccion);
        pac.setFecha_nac(fechanac);
        pac.setTiene_OS(tiene_OS);
        pac.setTipoSangre(tipo_sangre);
        
        resp.setNombre(nombreResp);
        resp.setApellido(apellidoResp);
        resp.setDni(dniResp);
        resp.setTelefono(telefonoResp);
        resp.setDireccion(direccionResp);
        resp.setFecha_nac(fechanacResp);
        resp.setTipoRespon(tipoRespon);
        
        pac.setUnResponsable(resp);
        odon.setId(id_doctor);
        tur.setAfeccion(afeccion);
        tur.setFecha_turno(fecha_turno);
        tur.setHora_turno(hora_turno);
        tur.setPacien(pac);
        tur.setDoctor(odon);
        
        controlPersis.crearPacienteConResp(resp, pac, tur);
    }

    public void crearPaciente(String nombre, String apellido, String dni, String telefono, String direccion, Date fechanac, String tiene_OS, String tipo_sangre, Date fecha_turno, String hora_turno, String afeccion, int id_doctor) {
         Paciente pac = new Paciente();
        Turno tur = new Turno();
        Doctor odon = new Doctor();
        
        pac.setNombre(nombre);
        pac.setApellido(apellido);
        pac.setDni(dni);
        pac.setTelefono(telefono);
        pac.setDireccion(direccion);
        pac.setFecha_nac(fechanac);
        pac.setTiene_OS(tiene_OS);
        pac.setTipoSangre(tipo_sangre);
        
        odon.setId(id_doctor);
        tur.setAfeccion(afeccion);
        tur.setFecha_turno(fecha_turno);
        tur.setHora_turno(hora_turno);
        tur.setPacien(pac);
        tur.setDoctor(odon);
        
        controlPersis.crearPacienteConResp(pac, tur);
    }

    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();
    }

    public List<Paciente> traerPacientes() {
        return controlPersis.traerPacientes();
    }

    public void borrarTurno(int id_turno) {
        controlPersis.borrarTurno(id_turno);
    }

    public void borrarPaciente(int id_paciente) {
        controlPersis.borrarPaciente(id_paciente);
    }


    public Turno traerTurno(int id_turno) {
        return controlPersis.traerTurno(id_turno);

    }

    public Paciente traerPaciente(int id_paciente) {
        return controlPersis.traerPaciente(id_paciente);
    }

    public void editarTurno(Paciente pac, Turno turno) {
        controlPersis.editarTurno(pac, turno);
    }

    public void crearResponsable(String nombreResp, String apellidoResp, String dniResp, String telefonoResp, String direccionResp, Date fechanacResp, String tipoRespon) {
        Responsable resp = new Responsable();
        resp.setApellido(apellidoResp);
        resp.setNombre(nombreResp);
        resp.setDni(dniResp);
        resp.setTelefono(telefonoResp);
        resp.setDireccion(direccionResp);
        resp.setFecha_nac(fechanacResp);
        resp.setTipoRespon(tipoRespon);
        controlPersis.crearResponsable(resp);
    }


}
