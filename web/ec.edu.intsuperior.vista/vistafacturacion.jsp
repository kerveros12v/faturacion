<%-- 
    Document   : vistafacturacion
    Created on : 30 jul. 2020, 21:46:56
    Author     : dellubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css1.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form name="facturacionventas" action="MiServlet" method="POST">
            <div class="sidebar1">

                <button type="submit" name="actionproceso" value="menuPrincipal"> <img src="c7.png"  name="logo" width="110" height="60" id="logo"  /></button>
                <ul class="nav">
                    <li><a href="#">EMPRESA XYZ</a></li>
                    <!--
                    <li><a href="#">Ventas</a></li>
                    -->
                </ul>
                <ul class="nav" id="nav">

                </ul>
                <ul class="nav-derecho">
                    <!--
                    <li><a href="#"> 
                            <label>Buscar:</label>
                            <input type="search" name="buscarfactura"/>
                        </a>
                    </li>
                    -->
                    <li>
                        <a href="#">
                            <% out.print((request.getAttribute("usuario")!=null)?request.getAttribute("usuario"):""); %>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <input type="submit" name="actionproceso" value="SALIR"/>
                        </a>
                    </li>
                </ul>
                <!-- end .sidebar1 -->
            </div>
            <div>
                <%--
                seccion datos del cliente
                --%>
                <div class="linebaja">
                    <table width="100%" >
                        <tr>
                            <td>
                                <label for="name" ">NUMERO DE IDENTIFICACION</label>
                            </td>
                            <td>
                                <label for="name" >APELLIDOS Y NOMBRES</label>
                            </td>
                            <td>
                                <label for="name" ">DIRECCION</label>
                            </td>
                            <td>
                                <label for="name" ">TELEFONO</label>
                            </td>
                            <td>
                                <label for="name" ">CORREO ELECTRONICO</label>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <div class="datosclientes">
                                    <input type="text"  class="datos" id="cedula" name="cedulafactura" placeholder="NUMERO DE IDENTIFICACION" value="<% out.print ((request.getAttribute("cedula1")!=null)?request.getAttribute("cedula1"):"");%>" required pattern="[0-9]{10,13}" />
                                    <button type="submit" class="btnico" name="actionproceso" value="BUSCARCLIENTE"><img src="buscar.png" class="btnico" width="30" height="30"/></button>

                                </div>
                            </td> 
                            <td>
                                <input type="text" class="datos" id="nomuser" name="apellidosfactura" placeholder="APELLIDOS Y NOMBRES"  value="<% out.print ((request.getAttribute("apellidosynombres")!=null)?request.getAttribute("apellidosynombres"):"");%>" />
                            </td>
                            <td>
                                <input type="text" class="datos" id="direccionuser" name="direccionfactura" placeholder="DIRECCION"  value="<% out.print ((request.getAttribute("direccion1")!=null)?request.getAttribute("direccion1"):""); %>" />
                            </td>
                            <td>
                                <input type="text" class="datos" id="telefonouser" name="telefonofactura" placeholder="TELEFONO"   value="<% out.print ((request.getAttribute("telefono1")!=null)?request.getAttribute("telefono1"):""); %>" />
                            </td>
                            <td>
                                <input type="text" class="datos" id="correouser" name="correofactura" placeholder="CORREO ELECTRONICO"  value="<% out.print ((request.getAttribute("correo1")!=null)?request.getAttribute("correo1"):"");  %>" />
                            </td>
                        </tr>

                    </table>
                </div>
                <%--
                Fin seccion datos del cliente
                --%>
                <table>
                    <tr>
                        <td>
                            <%--
                            Seccion nuevo producto
                            --%>
                            <div class="linebaja">
                                <table>
                                    <tr>
                                        <th>
                                            CANTIDAD
                                        </th>
                                        <th>
                                            CODIGO
                                        </th>

                                        <th>
                                            PRODUCTO
                                        </th>
                                        <th>
                                            PRECIO
                                        </th>
                                        <th>
                                            IVA
                                        </th>
                                    </tr>
                                    <tr>

                                        <td>
                                            <input type="text" class="datos"  id="cantidad" name="cantidad" value="<% out.print((request.getAttribute("cantidad01")!=null)?request.getAttribute("cantidad01"):1);%>"/>
                                        </td>
                                        <td> 
                                            <div class="datosclientes">
                                                <input type="text" class="datos"  id="codigo" name="codigo" value="<% out.print((request.getAttribute("codigo01")!=null)?request.getAttribute("codigo01"):"");%>" />
                                                <button type="submit" class="btnico" name="actionproceso" value="BUSCARPRODUCTO"><img src="buscar.png" class="btnico" width="30" height="30"/></button>

                                            </div>
                                        </td>
                                        <td>
                                            <input type="text" class="datos" id="producto" name="producto" value="<% out.print((request.getAttribute("productosdetalle")!=null)?request.getAttribute("productosdetalle"):"");%> "/>
                                        </td>
                                        <td>
                                            <input type="text" class="datos" id="precio" name="precio" value="<% out.print((request.getAttribute("productosprecio")!=null)?request.getAttribute("productosprecio"):"");%>"/>
                                        </td>
                                        <td>
                                            <input type="text" class="datos" id="iva" name="iva" value="<% out.print((request.getAttribute("ivas_idIvas")!=null)?request.getAttribute("ivas_idIvas"):"");%>"/>
                                        </td>
                                        <td>
                                            <button type="submit"  name="actionproceso" value="AGREGARPRODUCTO"><img src="guardar.png" class="btnico" width="30" height="30"/>AGREGAR</button>

                                        </td>
                                    </tr>

                                </table>
                                <br>
                                <br>
                                <div class="lineaslaterales linebaja"> 
                                  
                                </div>

                                <br>
                                <br>

                            </div>
                            <%--
                                fin seccion nuevo producto
                            --%>
                            <br>
                            <br>
                            <br>
                            <br>
                        </td>
                        <td>
                            <table>
                                <tr>
                                    <td>
                                        <%--
                            boton de nuevo producto
                                         
                                        --%>
                                        <table>
                                            <tr>
                                                <td>

                                                </td>
                                                <%--
                                                    Seccion Totales
                                                --%>
                                                <td id="totales" class="tablatotales">

                                                    <table class="tablatotales">
                                                        <tr>
                                                            <th class="th1">IVA</th>
                                                            
                                                            <th class="th1">SUBTOTAL</th>
                                                            
                                                            <th class="th1">TOTAL</th>
                                                            <th class="th1">
                                                                DESCUENTOS
                                                            </th>
                                                            <th class="th1">
                                                                TOTAL A PAGAR
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div class="linebaja lineaslaterales">
                                                                    <label class="th2" id="iva" name="ivatotal"><% out.print((request.getAttribute("ivatotal")!=null)?request.getAttribute("ivatotal"):0); %></label>
                                                                </div>
                                                            </td>
                                                            
                                                            <td>
                                                                <div class="linebaja lineaslaterales">
                                                                    <label class="th2" id="subtotal" name="subtotal"><% out.print((request.getAttribute("subtotal")!=null)?request.getAttribute("subtotal"):0); %></label>
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <div class="linebaja lineaslaterales">
                                                                    <label class="th2" id="total" name="totalgeneral"> <% out.print((request.getAttribute("totalgeneral")!=null)?request.getAttribute("totalgeneral"):0); %> </label>
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <div class="linebaja lineaslaterales">
                                                                    <label class="th2" id="iva" name="descuentototal"><% out.print((request.getAttribute("descuentototal")!=null)?request.getAttribute("descuentototal"):0); %></label>
                                                                </div>
                                                            </td>
                                                             <td>
                                                                <div class="linebaja lineaslaterales">
                                                                    <label class="th2" id="total" name="totoal"> <% out.print((request.getAttribute("totalfinal")!=null)?request.getAttribute("totalfinal"):0); %> </label>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <%-->
                                               Fin seccion Totales
                                                --%>
                                            </tr>
                                        </table>


                                    </td>
                                </tr>
                            </table>

                        </td>

                    </tr>
                    <tr>
                        <td>
                            <%--
                                Seccion de productos regisstrados
                            --%>
                            <table width="100%" border=1> 
                                <thead>
                                    <tr>
                                        <th>

                                        </th>
                                        <th>
                                            CANTIDAD
                                        </th>
                                        <th>
                                            CODIGO
                                        </th>

                                        <th>
                                            PRODUCTO
                                        </th>
                                        <th>
                                            PRECIO
                                        </th>
                                        <th>
                                            IVA
                                        </th>
                                        <th>
                                            <!--
                                            <input type="text" id="numselect" name="numselect">
                                            
                                            -->
                                            <input type="text" id="numproductos" name="numproductos" hidden="hidden" value=<% out.print((request.getAttribute("numproductostotal")!=null)?request.getAttribute("numproductostotal"):0); %>></th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <% out.print((request.getAttribute("respuesta")!=null)?request.getAttribute("respuesta"):""); %>

                                </tbody>
                            </table>
                        </td>
                        <%-->
                        Fin seccion productos registrados
                        --%>
                        <td>

                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
