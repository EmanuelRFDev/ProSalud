<%-- 
    Document   : verDoctors
    Created on : 4 ene. 2024, 10:15:32
    Author     : em
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Doctor"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Doctors</h1>
    <p class="mb-4">A continuación podra visualizar la lista completa de doctors</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Doctors</h6>
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
                            <th>Especialidad</th>
                            <th>Horario Entrada</th>
                            <th>Horario Salida</th>
                            <th>Nombre Usuario</th>
                            <th style="width:210px">Acción</th>
                        </tr>
                    </thead>
                    <%-- antes de entrar al body hacemos la solicitud java para traer la lista de usuarios correspondiente
                        hacemos que de la solicitud que manda el servlet al jsp, que traigamos de ahi la session
                        de la session traemos el atributo que guardamos en el servlet y hacemos un casteo para que convierta lo que trae en una lista y lo va a gurdar en la lista
                    --%>
                    <%                        List<Doctor> listaDoctor = (List) request.getSession().getAttribute("listaDoctor");
                    %>
                    <tbody>
                        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); %>
                        <%-- recorremos la lista a traves de un for y que nos vaya trayendo los datos --%>
                        <% for (Doctor odon : listaDoctor) {%>
                        <tr>
                            <td id="id_odon<%=odon.getId()%>"><%=odon.getId()%></td>
                            <td><%=odon.getNombre()%></td>
                            <td><%=odon.getApellido()%></td>
                            <td><%=odon.getDni()%></td>
                            <td><%=odon.getTelefono()%></td>
                            <td><%=odon.getDireccion()%></td>
                            <td><%=formato.format(odon.getFecha_nac())%></td>
                            <td><%=odon.getEspecialidad()%></td>
                            <td><%=odon.getUnHorario().getHorario_inicio()%></td>
                            <td><%=odon.getUnHorario().getHorario_fin()%></td>
                            <td><%=odon.getUnUsuario().getNombreUsuario()%></td>
                            <td style="display:flex; width:230px">
                                <form name="eliminar" action="SvElimDoctor" method="POST"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-danger btn-user btn-block" style="margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i>Eliminar</button>  
                                    <input type="hidden" name="id_doctor" value="<%=odon.getId()%>"> <!-- esto es para mandar el codigo al servlet. GET para traer el id a editar --> 
                                    <input type="hidden" name="id_usuario" value="<%=odon.getUnUsuario().getId_usuario()%>">
                                    <input type="hidden" name="id_horario" value="<%=odon.getUnHorario().getId_horario()%>">
                                    <input type="hidden" name="id" value="<%=odon.getId()%>">

                                </form>
                                <form name="editar" action="SvEditDoctor" method="GET"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i>Editar</button>  
                                    <input type="hidden" name="id_doctor" value="<%=odon.getId()%>"> <!-- esto es para mandar el codigo al servlet --> 
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
