<%-- 
    Document   : DatosCliente
    Created on : 30 jul. 2020, 20:32:20
    Author     : dellubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css1.css" rel="stylesheet" type="text/css"/>
        <title>Datos del Cliente</title>
    </head>
    <body>
        <form name="Salir" action="ServletDatosCliente" method="POST">
            <div class="sidebar1">

                <button type="submit" name="actionproceso" value="menuPrincipal"> <img src="c7.png"  name="logo" width="110" height="60" id="logo"  /></button>
                <ul class="nav">
                    <li>Nuevo Cliente</li>
                </ul>
                <ul class="nav" id="nav">
                </ul>
                <ul class="nav-derecho">
                    <li><% out.print((request.getAttribute("usuario")!=null)?request.getAttribute("usuario"):""); %></li>
                    <li><input type="submit" name="actionproceso" value="SALIR"/></li>
                </ul>

                <!-- end .sidebar1 -->
            </div>

            <div   class="newCliente">

                <table   title="DATOS DEL CLIENTE" width="100%">
                    <tr>
                        <td>
                            <div class="seccion">
                                <table  class="centrar" width="100%">
                                    <tr>
                                        <td class="centrar">
                                            <label for="name">NUMERO DE IDENTIFICACION</label>
                                        </td>
                                        <td>
                                            <input type="text"  id="cedula" name="cedula" placeholder="NUMERO DE IDENTIFICACION" required pattern="[0-9]{10,13}"/>

                                        </td>
                                        <td class="centrar">
                                            <label for="name" >APELLIDOS</label>
                                        </td>
                                        <td class="centrar">
                                            <input type="text"  id="apellidos" name="apellidos" placeholder="APELLIDOS"  required pattern="[A-Za-z]+"/>
                                        </td>
                                        <td class="centrar">
                                            <label for="name" >NOMBRES</label> 
                                        </td>
                                        <td class="centrar">
                                            <input type="text"  id="nombres" name="nombres" placeholder="NOMBRES" required pattern="[A-Za-z]+" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="centrar">
                                            <label for="name" >TELEFONO</label>
                                        </td>
                                        <td class="centrar">
                                            <input type="tel"  id="telefono" name="telefono" placeholder="TELEFONO" required pattern="[0-9]+"  />
                                        </td>
                                        <td class="centrar">
                                            <label for="name" >DIRECCION</label>
                                        </td>
                                        <td class="centrar">
                                            <input type="text" id="direccion" name="direccion" placeholder="DIRECCION" />
                                        </td>
                                        <td class="centrar">
                                            <label for="name" >CORREO ELECTRONICO</label>
                                        </td>
                                        <td class="centrar">
                                            <input type="email"  id="correo" name="correo" placeholder="CORREO ELECTRONICO"  />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>

                                        </td>
                                        </td>
                                        <td>
                                        <td>
                                            <input type="submit" name="actionproceso" class="btndoble" value="Guardar" id="sesion" >
                                        </td>
                                        <td>

                                        </td>
                                        <td>
                                            <% out.print((request.getAttribute("exito")!=null)?request.getAttribute("exito"):""); %>
                                        </td>
                                        <td>

                                        </td>
                                    </tr>
                                </table>
                            </div>

                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table>
                                <thead>
                                    <tr>
                                        <th>

                                        </th>
                                        <th>
                                            NUMERO DE IDENTIFICACION
                                        </th>
                                        <th>
                                            APELLIDOS Y NOMBRES
                                        </th>
                                        <th>
                                            DIRECCION
                                        </th>
                                        <th>
                                            TELEFONO
                                        </th>
                                        <th>
                                            CORREO ELECTRONICO
                                        </th>
                                        <th>

                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% out.print((request.getAttribute("tablalistaclinetes")!=null)?request.getAttribute("tablalistaclinetes"):""); %>
                                </tbody>
                            </table>
                        </td>
                    </tr>

                </table>

            </div>
        </form>
    </body>
</html>
