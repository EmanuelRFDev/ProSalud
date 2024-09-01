<%-- 
    Document   : editarUsuario
    Created on : 24 feb. 2024, 12:13:34
    Author     : em
--%>

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>
<h1>Editar Usuarios</h1>
<!-- cuando cargue esta pagina que nos traiga de la session los datos del usuario que nos manda a traves de la session -->

<%Usuario usu = (Usuario)request.getSession().getAttribute("usuEditar");%>
<form class="user" action="SvEditUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreusu"
                   placeholder="Nombre Usuario" value="<%=usu.getNombreUsuario()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" value="<%=usu.getContrasenia()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="rol"
                   placeholder="Rol" value="<%=usu.getRol()%>" autocomplete="off">
        </div>
        <%-- aca va a ir todo lo que respecta a horarios y usuario --%>
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Usuario Modificado
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
