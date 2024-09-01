<%-- 
    Document   : editarSecretarios
    Created on : 7 ene. 2024, 07:21:01
    Author     : em
--%>

<%@page import="logica.Secretario"%>
<%@page import="logica.Horario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Doctor"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>
<h1>Editar Usuarios</h1>
<!-- cuando cargue esta pagina que nos traiga de la session los datos del usuario que nos manda a traves de la session -->
<%Secretario secre = (Secretario) request.getSession().getAttribute("secreEdit");%>
<form class="user" action="SvEditSecre" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreSecre"
                   placeholder="Nombre" value="<%=secre.getNombre() %>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidoSecre"
                   placeholder="Apellido" value="<%=secre.getApellido() %>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" value="<%=secre.getDni() %>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono"
                   placeholder="Telefono" value="<%=secre.getTelefono() %>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccionSecre"
                   placeholder="Direccion" value="<%=secre.getDireccion() %>" autocomplete="off">
        </div>
        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");%>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fechanac"
                   value="<%=formato.format(secre.getFecha_nac()) %>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="sector"
                   placeholder="Sector" value="<%=secre.getSector() %>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreUsuario"
                   placeholder="Nombre Usuario" value="<%=secre.getUnUsuario().getNombreUsuario() %>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" value="<%=secre.getUnUsuario().getContrasenia() %>" autocomplete="off">
        </div>
        <input type="hidden" name="id_usuario" value="<%=secre.getUnUsuario().getId_usuario() %>" autocomplete="off">

    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Secretario Modificado
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>