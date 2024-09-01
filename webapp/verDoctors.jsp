<%-- 
    Document   : verDoctors
    Created on : 13 ene. 2024, 11:28:05
    Author     : em
--%>

<%@page import="logica.Turno"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Doctor"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyDoctor.jsp"%>

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
                            <th>Nombre</th>
                            <th>Apellido</th>
                        </tr>
                    </thead>
                    <%-- antes de entrar al body hacemos la solicitud java para traer la lista de usuarios correspondiente
                        hacemos que de la solicitud que manda el servlet al jsp, que traigamos de ahi la session
                        de la session traemos el atributo que guardamos en el servlet y hacemos un casteo para que convierta lo que trae en una lista y lo va a gurdar en la lista
                    --%>
                    <%                       
                        List<Doctor> listaDoctor = (List) request.getSession().getAttribute("listaDoctor");
                    %>
                    <tbody>
                        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); %>
                        <%-- recorremos la lista a traves de un for y que nos vaya trayendo los datos --%>
                        <% for (Doctor doctor : listaDoctor) {%>
                        <tr>
                            <td><%=doctor.getNombre()%></td>
                            <td><%=doctor.getApellido()%></td>
                            <td style="display:flex; width:230px">
                                <form name="editar" action="SvDoctorPac" method="GET"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-user"></i>Ver Pacientes</button>  
                                        <input type="hidden" name="id_doctor" value="<%=doctor.getId()%>">
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

