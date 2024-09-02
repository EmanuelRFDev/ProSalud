<%-- 
    Document   : edadPaciente
    Created on : 10 ene. 2024, 14:14:01
    Author     : em
--%>

<%@page import="logica.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="components/header.jsp"%>
<%@include file="components/bodyPrimeraParteUser.jsp"%>
<h1>Ingrese la fecha de nacimiento del paciente</h1>
<%Doctor doctor = (Doctor) request.getSession().getAttribute("odoGet");%>
<form class="user" action="SvPacientes" method="POST">
    
    <div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Fecha nacimiento:</label>
            <input type="date" class="form-control form-control-user" name="fechanac"
                   placeholder="Fecha nacimiento" autocomplete="off">
        </div>
    </div> 
    
        <input type="hidden" name="id_doctor" value="<%=doctor.getId()%>">
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Dar  Turno
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
