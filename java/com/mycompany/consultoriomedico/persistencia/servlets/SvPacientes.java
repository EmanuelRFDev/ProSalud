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

@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {

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
        misession.setAttribute("odoGet", doctor);

        response.sendRedirect("edadPaciente.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Date fecha_nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanac"));
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Instant instant = fecha_nacimiento.toInstant();
            LocalDate fecha_nac = instant.atZone(defaultZoneId).toLocalDate();
            LocalDate fecha_actual = LocalDate.now();
            Period period = Period.between(fecha_nac, fecha_actual);
            if (period.getYears() < 18) {

                response.sendRedirect("altaResponsable.jsp");

            } else {
                response.sendRedirect("altaPaciente.jsp");
            }

        } catch (ParseException ex) {
            Logger.getLogger(SvPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
/*
            LocalDate fecha_nac = LocalDate.parse(request.getParameter("fechanac"), date);
            LocalDate fecha_actual = LocalDate.now();
            Period period = Period.between(fecha_nac, fecha_actual);
            Date fechanac = Date.from(fecha_nac.atStartOfDay(defaultZoneId).toInstant());
 */
