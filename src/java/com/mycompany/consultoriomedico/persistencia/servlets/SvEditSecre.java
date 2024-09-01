
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
import logica.Secretario;
import logica.Usuario;

@WebServlet(name = "SvEditSecre", urlPatterns = {"/SvEditSecre"})
public class SvEditSecre extends HttpServlet {
    
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_secre = Integer.parseInt(request.getParameter("id_secre"));
        Secretario secre = control.traerSecretario(id_secre);
        HttpSession misession = request.getSession();
        misession.setAttribute("secreEdit", secre);
        response.sendRedirect("editarSecretarios.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            String nombreSecre = request.getParameter("nombreSecre");
            String apellidoSecre = request.getParameter("apellidoSecre");
            String dni = request.getParameter("dni") ;
            String telefono = request.getParameter("telefono");
            String direccionSecre = request.getParameter("direccionSecre");
            Date fechanac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanac"));
            String sector = request.getParameter("sector");
            
            String nombreUsuario = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contrasenia");
            
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
            Usuario usu = control.traerUsuario(id_usuario);
            usu.setNombreUsuario(nombreUsuario);
            usu.setContrasenia(contrasenia);
            
            Secretario secre = (Secretario) request.getSession().getAttribute("secreEdit");
            secre.setNombre(nombreSecre);
            secre.setApellido(apellidoSecre);
            secre.setDni(dni);
            secre.setTelefono(telefono);
            secre.setDireccion(direccionSecre);
            secre.setFecha_nac(fechanac);
            secre.setSector(sector);
            
            control.editarSecretario(usu, secre);
            response.sendRedirect("SvSecretarios");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEditSecre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
