<%-- 
    Document   : verUsuarios
    Created on : 24 feb. 2024, 09:07:22
    Author     : em
--%>

<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
    <p class="mb-4">A continuación podra visualizar la lista completa de usuarios</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Rol</th>
                            <th style="width:210px">Acción</th>
                        </tr>
                    </thead>
                    <%-- antes de entrar al body hacemos la solicitud java para traer la lista de usuarios correspondiente
                        hacemos que de la solicitud que manda el servlet al jsp, que traigamos de ahi la session
                        de la session traemos el atributo que guardamos en el servlet y hacemos un casteo para que convierta lo que trae en una lista y lo va a gurdar en la lista
                    --%>
                    <% 
                    List<Usuario> listaUsuarios = (List)request.getSession().getAttribute("listaUsuarios");
                    %>
                    <tbody>
                        <%-- recorremos la lista a traves de un for y que nos vaya trayendo los datos --%>
                        <% for(Usuario usu:listaUsuarios){ %>
                        <tr>
                            <td id="id_usu<%=usu.getId_usuario()%>"><%= usu.getId_usuario() %></td>
                            <td><%= usu.getNombreUsuario() %></td>
                            <td><%= usu.getRol()%></td>
                            <td style="display:flex; width:230px">
                                <form name="eliminar" action="SvElimUsuarios" method="POST"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-danger btn-user btn-block" style="margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i>Eliminar</button>  
                                        <input type="hidden" name="id" value="<%=usu.getId_usuario()%>"> <!-- esto es para mandar el codigo al servlet. GET para traer el id a editar --> 
                                </form>
                                <form name="editar" action="SvEditUsuarios" method="GET"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i>Editar</button>  
                                        <input type="hidden" name="id" value="<%=usu.getId_usuario()%>"> <!-- esto es para mandar el codigo al servlet --> 
                                </form>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="components/bodyfinal.jsp"%>