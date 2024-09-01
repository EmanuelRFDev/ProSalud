/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.consultoriomedico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import logica.Doctor;

/**
 *
 * @author em
 */
@WebServlet(name = "SvResponsable", urlPatterns = {"/SvResponsable"})
public class SvResponsable extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Doctor doctor = (Doctor) request.getSession().getAttribute("odoGet");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            Date fechanac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanac"));
            String tiene_OS = request.getParameter("tiene_OS");
            String tipo_sangre = request.getParameter("tipo_sangre");
            Date fecha_turno = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_turno"));
            String hora_turno = request.getParameter("hora_turno");
            String afeccion = request.getParameter("afeccion");
            int id_doctor = doctor.getId();
            String nombreResp = request.getParameter("nombreResp");
            String apellidoResp = request.getParameter("apellidoResp");
            String dniResp = request.getParameter("dniResp");
            String telefonoResp = request.getParameter("telefonoResp");
            String direccionResp = request.getParameter("direccionResp");
            Date fechanacResp = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanacResp"));
            String tipoRespon = request.getParameter("tipoRespon");
            
            control.crearPaciente(nombre, apellido, dni, telefono, direccion, fechanac, tiene_OS, tipo_sangre,
                    fecha_turno, hora_turno, afeccion, nombreResp, apellidoResp, dniResp, telefonoResp, direccionResp,
                    fechanacResp, tipoRespon, id_doctor);
            
            response.sendRedirect("indexUsu.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvResponsable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
