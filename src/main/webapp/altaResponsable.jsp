<%-- 
    Document   : altaResponsable
    Created on : 10 ene. 2024, 11:26:07
    Author     : em
--%>

<%@page import="logica.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyPrimeraParteUser.jsp"%>
<h2>Datos del paciente</h2>
<%Doctor doctor = (Doctor) request.getSession().getAttribute("odoGet");%>
<form class="user" action="SvResponsable" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre"
                   placeholder="Nombre" autocomplete="off" required >
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellido"
                   placeholder="Apellido" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono"
                   placeholder="Teléfono" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion"
                   placeholder="Dirección" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Fecha nacimiento:</label>
            <input type="date" class="form-control form-control-user" name="fechanac"
                   placeholder="Fecha nacimiento" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Obra Social:</label>
            <select class="form-control" name="tiene_OS">
                <option value="Si">Si</option>
                <option value="No">No</option>
            </select>
        </div>
        <%-- aca va a ir todo lo que respecta a horarios y usuario --%>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="tipo_sangre"
                   placeholder="Tipo Sangre" autocomplete="off">
        </div> 
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Fecha turno:</label>
            <input type="date" min="<%Date date = new Date();%>" class="form-control form-control-user" name="fecha_turno"
                   placeholder="Fecha Turno" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Seleccione horario:</label>
            <select class="form-control" name="hora_turno">
                <option value="9:00">9:00</option>
                <option value="9:30">9:30</option>
                <option value="10:00">10:00</option>
                <option value="10:30">10:30</option>
                <option value="11:00">11:00</option>
                <option value="11:30">11:30</option>
                <option value="12:00">12:00</option>
                <option value="12:30">12:30</option>
                <option value="13:00">13:00</option>
                <option value="13:30">13:30</option>
                <option value="14:00">14:00</option>
                <option value="14:30">14:30</option>
                <option value="15:00">15:00</option>
                <option value="15:30">15:30</option>
                <option value="16:00">16:00</option>
                <option value="16:30">16:30</option>
                <option value="17:00">17:00</option>
                <option value="17:30">17:30</option>
            </select>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="afeccion"
                   placeholder="Afección" autocomplete="off">
        </div>
        <h2>Datos del Responsable</h2>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreResp"
                   placeholder="Nombre" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidoResp"
                   placeholder="Apellido" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dniResp"
                   placeholder="DNI" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefonoResp"
                   placeholder="Teléfono" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccionResp"
                   placeholder="Dirección" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Fecha nacimiento:</label>
            <input type="date" class="form-control form-control-user" name="fechanacResp"
                   placeholder="Fecha nacimiento" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="tipoRespon"
                   placeholder="Tipo Responsabilidad" autocomplete="off">
        </div>
        <input type="hidden" name="id_doctor" value="<%=doctor.getId()%>">

    </div>

    <button type="submit" class="btn btn-primary btn-user btn-block">
        Dar  Turno
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>