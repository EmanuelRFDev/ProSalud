/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.consultoriomedico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;
import logica.Doctor;
import logica.Paciente;
import logica.Turno;

/**
 *
 * @author em
 */
@WebServlet(name = "SvDoctorElim", urlPatterns = {"/SvDoctorElim"})
public class SvDoctorElim extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        List<Turno> listaTurnos = (List) request.getSession().getAttribute("listaTurnos");
        try {
            for (Turno tur : listaTurnos) {
                int id_turno = Integer.parseInt(request.getParameter("id_turno"));
                if (tur.getId_turno() == id_turno) {
                    listaTurnos.remove(tur);
                }
            }
        } catch (ConcurrentModificationException c) {
            for (Turno tur : listaTurnos) {
                int id_turno = Integer.parseInt(request.getParameter("id_turno"));
                if (tur.getId_turno() == id_turno) {
                    listaTurnos.remove(tur);
                }
            }
            
        }
        response.sendRedirect("verPacientesDoctor.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
