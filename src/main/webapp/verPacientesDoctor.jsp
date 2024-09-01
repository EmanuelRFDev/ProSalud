<%-- 
    Document   : verPacientesDoctor
    Created on : 13 ene. 2024, 10:26:20
    Author     : em
--%>

<%@page import="logica.Responsable"%>
<%@page import="logica.Paciente"%>
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
    <%Doctor doctor = (Doctor) request.getSession().getAttribute("odoTraer");%>
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
    <p class="mb-4">A continuación podra visualizar la lista completa de pacientes con turnos</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Fecha turno</th>
                            <th>Horario del turno</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Afección</th>
                            <th>Asistencia</th>
                        </tr>
                    </thead>
                    <%-- antes de entrar al body hacemos la solicitud java para traer la lista de usuarios correspondiente
                        hacemos que de la solicitud que manda el servlet al jsp, que traigamos de ahi la session
                        de la session traemos el atributo que guardamos en el servlet y hacemos un casteo para que convierta lo que trae en una lista y lo va a gurdar en la lista
                    --%>
                    <%List<Turno> listaTurnos = (List) request.getSession().getAttribute("listaTurnos");%>
                    <tbody>
                        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); %>
                        <%-- recorremos la lista a traves de un for y que nos vaya trayendo los datos --%>
                        <% for (Turno tur : listaTurnos) {%>
                        <%if (tur.getDoctor().getId() == doctor.getId()) {%>
                        <tr>
                            <td><%=formato.format(tur.getFecha_turno())%></td>
                            <td><%=tur.getHora_turno()%></td>
                            <td><%=tur.getPacien().getNombre()%></td>
                            <td><%=tur.getPacien().getApellido()%></td>
                            <td><%=tur.getAfeccion()%></td> 
                            <td>
                                <form action="SvDoctorElim" method="GET">
                                    <button type="submit">Atentido</button>
                                    <input type="hidden" name="id_turno" value="<%= tur.getId_turno() %>">
                                </form>
                            </td>
                        </tr>
                        <% }%>
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