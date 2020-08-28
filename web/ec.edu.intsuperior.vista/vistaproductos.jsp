<%-- 
    Document   : vistaproductos
    Created on : 18 ago. 2020, 22:07:56
    Author     : dellubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css1.css" rel="stylesheet" type="text/css"/>
        <title>Productos</title>
    </head>
    <body>
        <form name="Salir" action="ServletDatosProducto" method="POST">
            <div class="sidebar1">

                <img src="c7.png"  name="logo" width="110" height="50" id="logo"  />
                <ul class="nav">
                    <li>Productos</li>
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

                <table   title="DATOS DEL PRODUCTO" width="100%">
                    <tr>
                        <td>
                            <div class="seccion">
                                <table  class="centrar" width="100%">
                                    <tr>
                                        <td class="centrar">
                                            <label for="name">CODIGO</label>
                                        </td>
                                        <td>
                                            <input type="text"  id="codigo" name="codigo" placeholder="Codigo"  />

                                        </td>
                                        <td class="centrar">
                                            <label for="name" >DETALLE</label>
                                        </td>
                                        <td class="centrar">
                                            <input type="text"  id="detalle" name="detalle" placeholder="Detalle" />
                                        </td>
                                        <td class="centrar">
                                            <label for="name" >IVA</label> 
                                        </td>
                                        <td class="centrar">
                                            <select name="iva" placeholder="Iva">
                                                <% out.print((request.getAttribute("ivageneral")!=null)?request.getAttribute("ivageneral"):""); %>
                                            </select>
                                        </td>
                                        <td class="centrar">
                                            <label for="name" >PRECIO</label>
                                        </td>
                                        <td class="centrar">
                                            <input type="text"  id="precio" name="precio" placeholder="Precio"  />
                                        </td>
                                    </tr>
                                    <tr>


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
                                            CODIGO                                       
                                        </th>
                                        <th>
                                            DETALLE
                                        </th>
                                        <th>
                                            IVA
                                        </th>
                                        <th>
                                            PRECIO
                                        </th>
                                        <th>

                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% out.print((request.getAttribute("tablaproductos")!=null)?request.getAttribute("tablaproductos"):""); %>
                                </tbody>
                            </table>
                        </td>
                    </tr>

                </table>

            </div>
        </form>
    </body>
</html>
