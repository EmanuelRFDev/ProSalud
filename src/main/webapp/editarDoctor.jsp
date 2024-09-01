<%-- 
    Document   : editarDoctor
    Created on : 5 ene. 2024, 10:08:10
    Author     : em
--%>

<%@page import="logica.Horario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Doctor"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>
<h1>Editar Usuarios</h1>
<!-- cuando cargue esta pagina que nos traiga de la session los datos del usuario que nos manda a traves de la session -->
<%Doctor doctor = (Doctor) request.getSession().getAttribute("odoEdit");%>
<form class="user" action="SvEditDoctor" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreDoctor"
                   placeholder="Nombre" value="<%=doctor.getNombre()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidoDoctor"
                   placeholder="Apellido" value="<%=doctor.getApellido()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" value="<%=doctor.getDni()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono"
                   placeholder="Telefono" value="<%=doctor.getTelefono()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccionDoctor"
                   placeholder="Direccion" value="<%=doctor.getDireccion()%>" autocomplete="off">
        </div>
        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");%>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fechanac"
                   value="<%= formato.format(doctor.getFecha_nac())%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="especialidad"
                   placeholder="Especialidad" value="<%=doctor.getEspecialidad()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horario_inicio"
                   placeholder="Horario inicio" value="<%=doctor.getUnHorario().getHorario_inicio()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horario_fin"
                   placeholder="Horario Fin" value="<%=doctor.getUnHorario().getHorario_fin()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreUsuario"
                   placeholder="Nombre Usuario" value="<%=doctor.getUnUsuario().getNombreUsuario()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" value="<%=doctor.getUnUsuario().getContrasenia()%>" autocomplete="off">
        </div>
        <input type="hidden" name="id_usuario" value="<%=doctor.getUnUsuario().getId_usuario()%>">
        <input type="hidden" name="id_horario" value="<%=doctor.getUnHorario().getId_horario()%>">

    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Doctor Modificado
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
