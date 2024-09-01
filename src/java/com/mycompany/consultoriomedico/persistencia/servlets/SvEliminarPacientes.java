/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.consultoriomedico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Doctor;
import logica.Paciente;
import logica.Responsable;
import logica.Turno;

/**
 *
 * @author em
 */
@WebServlet(name = "SvEliminarPacientes", urlPatterns = {"/SvEliminarPacientes"})
public class SvEliminarPacientes extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List <Turno> listaTurnos = new ArrayList<Turno>();
        listaTurnos = control.traerTurnos();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaTurnos", listaTurnos);
        response.sendRedirect("verPacientesEliminar.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_turno = Integer.parseInt(request.getParameter("id_turno"));
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
        control.borrarPaciente(id_paciente);
        control.borrarTurno(id_turno);
        
        
        response.sendRedirect("SvEliminarPacientes");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
