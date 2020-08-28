<%-- 
    Document   : menuprincipal
    Created on : 9 ago. 2020, 14:54:07
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
        <form name="menugeneral" action="MenuGeneral" method="POST">
            <div class="sidebar1">

                <img src="c7.png"  name="logo" width="110" height="60" id="logo"  />
                <ul class="nav">
                    <li>EMPRESA XYZ</li>
                </ul>
                <ul class="nav" id="nav">

                </ul>
                <ul class="nav-derecho">
                    <li><% out.print((request.getAttribute("usuario")!=null)?request.getAttribute("usuario"):""); %></li>
                    <li><input type="submit" name="accionmenu" value="SALIR"/></li>
                </ul>

                <!-- end .sidebar1 -->
            </div>

            <div class="row">
                <div >
                    <table>
                        <tr>
                            <td>
                                <button type="submit" class="btnimg" name="accionmenu" value="ClIENTES"><img src="cliente.png" class="btnimg"  width="300px" height="300px" /></button>
                            </td>
                            <td>
                                <button type="submit" class="btnimg" name="accionmenu" value="VENTAS"><img src="ventas.png" class="btnimg"  width="300px" height="300px" /></button>
                            </td>
                            <td>
                                <button type="submit" class="btnimg" name="accionmenu" value="REPORTES"><img src="reportes.png" class="btnimg"  width="300px" height="300px" /></button>
                            </td>
                        </tr>
                        <tr>
                            <td> 
                                <button type="submit" class="btnimg" name="accionmenu" value="PROVEEDORES"><img src="proveedor.png" class="btnimg"  width="300px" height="300px" /></button>
                            </td>
                            <td>
                                <button type="submit" class="btnimg" name="accionmenu" value="COMPRAS"><img src="compras.png" class="btnimg"  width="300px" height="300px" /></button>
                            </td>
                            <td> 
                                <button type="submit" class="btnimg" name="accionmenu" value="PRODUCTOS"><img src="productos.png" class="btnimg"  width="300px" height="300px" /></button>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

        </form>
    </body>
</html>
