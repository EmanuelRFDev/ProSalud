package com.mycompany.consultoriomedico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Doctor;

@WebServlet(name = "SvAltaDoctor", urlPatterns = {"/SvAltaDoctor"})
public class SvAltaDoctor extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Doctor> listaDoctor = new ArrayList<Doctor>();
        listaDoctor = control.traerListaDoctors();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaDoctor", listaDoctor);
        response.sendRedirect("verDoctors.jsp");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nombreDoctor = request.getParameter("nombreDoctor");
            String apellidoDoctor = request.getParameter("apellidoDoctor");
            String dniDoctor = request.getParameter("dni");
            String telefonoDoctor = request.getParameter("telefono");
            String direccionDoctor = request.getParameter("direccionDoctor");
            Date fecha_nac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanac"));
            String especialidad = request.getParameter("especialidad");
            String horario_entrada = request.getParameter("horario_inicio");
            String horario_salida = request.getParameter("horario_fin");
            String nombreUsu = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contrasenia");
            String rol = request.getParameter("rol");
            control.crearDoctor(nombreDoctor, apellidoDoctor, dniDoctor, telefonoDoctor, direccionDoctor, fecha_nac,
                    especialidad, horario_entrada, horario_salida, nombreUsu, contrasenia, rol);
            response.sendRedirect("index.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvAltaDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
