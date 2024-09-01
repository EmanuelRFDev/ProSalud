
package com.mycompany.consultoriomedico.persistencia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession misesssion = request.getSession();
        misesssion.invalidate();
        response.sendRedirect("login.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //trae el usuario y la contraseña
        String usuario = request.getParameter("usuario"); //este es lo que traigo del formulario
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
        
        //nos fijamos si el usaurio y la contraseña son correctos o incorrectos
        boolean validacion = false;
        //validacion es igual a la respuesta de mi controladora, a un metodo de validacion
        validacion = control.comprobarIngreso(usuario, contrasenia, rol);
        if(validacion == true){
            HttpSession misession = request.getSession(true); //get session me trae la sesion del usuario que esta actualmente
            misession.setAttribute("usuario", usuario); //con esto decimos que la sesion le corresponse a este usuario
            if(rol.equalsIgnoreCase("admin")){
               response.sendRedirect("index.jsp"); 
            } else if (rol.equals("doctor")){
                response.sendRedirect("indexDoctor.jsp");
            } else if (rol.equals("user")){
                response.sendRedirect("indexUsu.jsp");
            }
            
        } else {
            response.sendRedirect("loginError.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
