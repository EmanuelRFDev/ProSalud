<%-- 
    Document   : altaUsuario
    Created on : 26 feb. 2024, 11:24:09
    Author     : em
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>
<h1>Alta Usuario</h1>
<form class="user" action="SvUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreusu"
                   placeholder="Nombre Usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña">
        </div>
        <div class="form-group form-control-user col-sm-6 mb-3">
            <label for="exampleFormControlSelect1"><b>Seleccione el rol:</b></label>
            <select class="form-control" name="rol">
                <option value="admin">admin</option>
                <option value="user">user</option>
                <option value="doctor">doctor</option>
            </select>
        </div>
        <%-- aca va a ir todo lo que respecta a horarios y usuario --%>
    </div>
    <button class="btn btn-primary btn-user btn-block col-sm-6 mb-3" type="submit">
        Crear Usuario
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>