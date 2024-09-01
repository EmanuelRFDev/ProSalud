<%-- 
    Document   : altaSecretarios
    Created on : 7 ene. 2024, 07:21:07
    Author     : em
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>
<h1>Alta Secretarios</h1>
<form class="user" action="SvSecretarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreSecretario"
                   placeholder="Nombre" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidoSecretario"
                   placeholder="Apellido" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dniSecretario"
                   placeholder="DNI" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefonoSecretario"
                   placeholder="Teléfono" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccionSecretario"
                   placeholder="Dirección" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fechanac"
                   placeholder="Fecha nacimiento" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="sector"
                   placeholder="Sector" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreUsuario"
                   placeholder="Nombre Usuario" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="hidden" class="form-control form-control-user" name="rol" value="user">
        </div> <!-- esto es para que directamente el rol se mande como user -->
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Crear Secretario
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
