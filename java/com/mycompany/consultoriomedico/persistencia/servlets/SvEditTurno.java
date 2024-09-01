/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.consultoriomedico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import logica.Paciente;
import logica.Turno;

/**
 *
 * @author em
 */
@WebServlet(name = "SvEditTurno", urlPatterns = {"/SvEditTurno"})
public class SvEditTurno extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_turno = Integer.parseInt(request.getParameter("id_turno"));
        Turno turno = control.traerTurno(id_turno);
        HttpSession misession = request.getSession();
        misession.setAttribute("turnoEdit", turno);
        response.sendRedirect("editarTurno.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
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
            
            int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
            Paciente pac = control.traerPaciente(id_paciente);
            pac.setApellido(apellido);
            pac.setDireccion(direccion);
            pac.setDni(dni);
            pac.setFecha_nac(fechanac);
            pac.setNombre(nombre);
            pac.setTelefono(telefono);
            pac.setTiene_OS(tiene_OS);
            pac.setTipoSangre(tipo_sangre);
            
            Turno turno = (Turno) request.getSession().getAttribute("turnoEdit");
            turno.setAfeccion(afeccion);
            turno.setFecha_turno(fecha_turno);
            turno.setHora_turno(hora_turno);
            turno.setPacien(pac);
            
            control.editarTurno(pac, turno);
            
            response.sendRedirect("SvEliminarPacientes");
            
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEditTurno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
