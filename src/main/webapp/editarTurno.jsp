<%-- 
    Document   : editarTurno
    Created on : 8 ene. 2024, 14:14:03
    Author     : em
--%>

<%@page import="logica.Turno"%>
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
<h1>Editar Turno</h1>
<%Turno turno = (Turno) request.getSession().getAttribute("turnoEdit");%>
<form class="user" action="SvEditTurno" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre"
                   placeholder="Nombre" autocomplete="off" value="<%=turno.getPacien().getNombre() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellido"
                   placeholder="Apellido" autocomplete="off" value="<%=turno.getPacien().getApellido() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" autocomplete="off" value="<%=turno.getPacien().getDni() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono"
                   placeholder="Teléfono" autocomplete="off" value="<%=turno.getPacien().getTelefono() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion"
                   placeholder="Dirección" autocomplete="off" value="<%=turno.getPacien().getDireccion() %>">
        </div>
        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");%>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Fecha nacimiento:</label>
            <input type="date" class="form-control form-control-user" name="fechanac"
                   placeholder="Fecha nacimiento" autocomplete="off" value="<%=formato.format(turno.getFecha_turno())%>">
        </div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Obra Social:</label>
            <select class="form-control" name="tiene_OS">
                <option value="<%=turno.getPacien().isTiene_OS() %>">Si</option>
                <option value="<%=turno.getPacien().isTiene_OS() %>">No</option>
            </select>
        </div>
        <%-- aca va a ir todo lo que respecta a horarios y usuario --%>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="tipo_sangre"
                   placeholder="Tipo Sangre" autocomplete="off" value="<%=turno.getPacien().getTipoSangre() %>">
        </div> 
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Fecha turno:</label>
            <input type="date"  class="form-control form-control-user" name="fecha_turno"
                   placeholder="Fecha Turno" autocomplete="off" value="<%=formato.format(turno.getFecha_turno()) %>">
        </div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Seleccione horario:</label>
            <select class="form-control" name="hora_turno">
                <option value="<%=turno.getHora_turno() %>">9:00</option>
                <option value="<%=turno.getHora_turno() %>">9:30</option>
                <option value="<%=turno.getHora_turno() %>">10:00</option>
                <option value="<%=turno.getHora_turno() %>">10:30</option>
                <option value="<%=turno.getHora_turno() %>">11:00</option>
                <option value="<%=turno.getHora_turno() %>">11:30</option>
                <option value="<%=turno.getHora_turno() %>">12:00</option>
                <option value="<%=turno.getHora_turno() %>">12:30</option>
                <option value="<%=turno.getHora_turno() %>">13:00</option>
                <option value="<%=turno.getHora_turno() %>">13:30</option>
                <option value="<%=turno.getHora_turno() %>">14:00</option>
                <option value="<%=turno.getHora_turno() %>">14:30</option>
                <option value="<%=turno.getHora_turno() %>">15:00</option>
                <option value="<%=turno.getHora_turno() %>">15:30</option>
                <option value="<%=turno.getHora_turno() %>">16:00</option>
                <option value="<%=turno.getHora_turno() %>">16:30</option>
                <option value="<%=turno.getHora_turno() %>">17:00</option>
                <option value="<%=turno.getHora_turno() %>">17:30</option>
            </select>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="afeccion"
                   placeholder="Afección" autocomplete="off" value="<%=turno.getAfeccion() %>">
        </div>
                   <input type="hidden" name="id_turno" value="<%=turno.getId_turno() %>">
                   <input type="hidden" name="id_paciente" value="<%=turno.getPacien().getId() %>">
    </div>

    <button type="submit" class="btn btn-primary btn-user btn-block">
        Editar  Turno
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
