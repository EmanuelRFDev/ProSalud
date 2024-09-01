package com.mycompany.consultoriomedico.persistencia.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Horario;
import logica.Doctor;
import logica.Persona;
import logica.Usuario;

@WebServlet(name = "SvEditDoctor", urlPatterns = {"/SvEditDoctor"})
public class SvEditDoctor extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_doctor = Integer.parseInt(request.getParameter("id_doctor"));
        Doctor doctor = control.traerDoctor(id_doctor);
        HttpSession misession = request.getSession();
        misession.setAttribute("odoEdit", doctor);

        response.sendRedirect("editarDoctor.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String nombreDoctor = request.getParameter("nombreDoctor");
            String apellidoDoctor = request.getParameter("apellidoDoctor");
            String dni = request.getParameter("dni");
            String telefono = request.getParameter("telefono");
            String direccionDoctor = request.getParameter("direccionDoctor");
            Date fechanac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanac"));
            String especialidad = request.getParameter("especialidad");
            String horario_inicio = request.getParameter("horario_inicio");
            String horario_fin = request.getParameter("horario_fin");
            String nombreUsuario = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contrasenia");
            String rol = request.getParameter("rol");

            int id_horario = Integer.parseInt(request.getParameter("id_horario"));
            Horario horario = control.traerHorario(id_horario);
            horario.setHorario_inicio(horario_inicio);
            horario.setHorario_fin(horario_fin);
            
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
            Usuario usu = control.traerUsuario(id_usuario);
            usu.setNombreUsuario(nombreUsuario);
            usu.setContrasenia(contrasenia);
            
            Doctor odon = (Doctor) request.getSession().getAttribute("odoEdit");
            odon.setNombre(nombreDoctor);
            odon.setApellido(apellidoDoctor);
            odon.setDni(dni);
            odon.setTelefono(telefono);
            odon.setDireccion(direccionDoctor);
            odon.setFecha_nac(fechanac);
            odon.setEspecialidad(especialidad);
            
            
            control.editarDoctor(horario, odon, usu);
            response.sendRedirect("SvAltaDoctor");

        } catch (ParseException ex) {
            Logger.getLogger(SvEditDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
