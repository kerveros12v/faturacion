<%-- 
    Document   : index
    Created on : 21 jul. 2020, 20:41:13
    Author     : dellubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css1.css" rel="stylesheet" type="text/css"/>
        <title>EMPRESA XYZ</title>
    </head>
    <body>
        <div class="contenedorg">
            <form name="login" action="LoginServlet" method="POST">
                <table>
                    <tr>
                        <td class="linea">
                            <img src="c7.png" alt=""/>
                            <h2>EMPRESA XYZ</h2>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="login">
                                <div class="form__group1">
                                    <input type="text" class="form__input" id="usuario" name="usuario" placeholder="Usuario" required="" />
                                    <label for="name" class="form__label">Usuario</label>
                                </div>

                                <div class="form__group1">
                                    <input type="password" class="form__input" id="clave" name="clave" placeholder="Contraseña" required="" />
                                    <label for="name" class="form__label">Contraseña</label>
                                </div>
                                <div class="form__group1">
                                    <input type="submit" name="actionproceso" value="INICIAR SESION" id="sesion" class="btndoble">
                                </div>
                                <div> <label for="name" class="form__label"><% out.print((request.getAttribute("respuesta")!=null)?request.getAttribute("respuesta"):""); %></label></div>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
