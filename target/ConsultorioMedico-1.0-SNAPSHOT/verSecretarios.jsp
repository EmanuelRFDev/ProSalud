<%-- 
    Document   : verSecretarios
    Created on : 7 ene. 2024, 11:28:04
    Author     : em
--%>

<%@page import="logica.Secretario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Secretarios</h1>
    <p class="mb-4">A continuación podra visualizar la lista completa de secretarios</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Secretarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>Fecha Nac.</th>
                            <th>Nombre Usuario</th>
                            <th style="width:210px">Acción</th>
                        </tr>
                    </thead>
                    <%-- antes de entrar al body hacemos la solicitud java para traer la lista de usuarios correspondiente
                        hacemos que de la solicitud que manda el servlet al jsp, que traigamos de ahi la session
                        de la session traemos el atributo que guardamos en el servlet y hacemos un casteo para que convierta lo que trae en una lista y lo va a gurdar en la lista
                    --%>
                    <%
                        List<Secretario> listaSecre = (List) request.getSession().getAttribute("listaSecre");
                    %>
                    <tbody>
                        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); %>
                        <%-- recorremos la lista a traves de un for y que nos vaya trayendo los datos --%>
                        <% for (Secretario secre : listaSecre) {%>
                        <tr>
                            <td id="id_secre<%=secre.getId() %>"><%=secre.getId()%></td>
                            <td><%=secre.getNombre() %></td>
                            <td><%=secre.getApellido() %></td>
                            <td><%=secre.getDni() %></td>
                            <td><%=secre.getTelefono() %></td>
                            <td><%=secre.getDireccion() %></td>
                            <td><%=formato.format(secre.getFecha_nac())%></td>
                            <td><%=secre.getUnUsuario().getNombreUsuario() %></td>
                            <td style="display:flex; width:230px">
                                <form name="eliminar" action="SvElimSecre" method="POST"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-danger btn-user btn-block" style="margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i>Eliminar</button>  
                                    <input type="hidden" name="id_secre" value="<%=secre.getId()%>"> <!-- esto es para mandar el codigo al servlet. GET para traer el id a editar --> 
                                    <input type="hidden" name="id_usuario" value="<%=secre.getUnUsuario().getId_usuario()%>">
                                </form>
                                <form name="editar" action="SvEditSecre" method="GET"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i>Editar</button>  
                                    <input type="hidden" name="id_secre" value="<%=secre.getId()%>"> <!-- esto es para mandar el codigo al servlet --> 
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
