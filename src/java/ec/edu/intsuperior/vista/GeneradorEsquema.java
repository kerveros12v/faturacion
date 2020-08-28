/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.vista;

import ec.edu.intsuperior.modelo.Clases.Articulos;
import ec.edu.intsuperior.modelo.Clases.Cliente;
import ec.edu.intsuperior.modelo.Clases.Facturacion;
import ec.edu.intsuperior.modelo.Clases.Ivas;
import ec.edu.intsuperior.modelo.Crud.CrudArticulos;
import ec.edu.intsuperior.modelo.Crud.CrudClientes;
import ec.edu.intsuperior.modelo.Crud.CrudIvas;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dellubuntu
 */
public class GeneradorEsquema {

    public static String tablalistaproductos() {
        CrudArticulos cc = new CrudArticulos();
        String salida = "";
        Object[] lista;
        lista = cc.mostrar().toArray();
        int a = 0;
        String fondos = "";
        for (Object dato : lista) {
            if (a % 2 == 0) {
                fondos = "class='fondos'";
            } else {
                fondos = "";
            }
            Articulos c1 = (Articulos) dato;
            salida = salida + "<tr " + fondos + ">"
                    + "<td></td>"
                    + "<td>"
                    + c1.getProductoscodigo()
                    + "</td>"
                    + "<td>"
                    + c1.getProductosdetalle()
                    + "</td>"
                    + "<td>"
                    + "<select disabled>"
                    + selectoptioniva(c1.getIvas_idIvas())
                    + "</select>"
                    + "</td>"
                    + "<td>"
                    + c1.getProductosprecio()
                    + "</td>"
                    + "<td>"
                    + "<input type=\"image\" name=\"actionproceso\" class=\"btnico\" value=\"EDITAR-" + c1.getIdProductos() + "\"  src=\"editar.png\" )>"
                    + "<input type=\"image\" name=\"actionproceso\" class=\"btnico\" value=\"ELMINAR-" + c1.getIdProductos() + "\"  src=\"eliminar.png\" )>"
                    + "</td>"
                    + "</tr>";
            a++;
        }
        return salida;
    }

    /**
     * Carga el formato para la carga dinamica de iva Si el parametro es 0 el
     * iva no se seleccionara ninguno
     *
     * @param idiva
     * @return
     */
    public static String selectoptioniva(int idiva) {
        String salida = "";
        CrudIvas cc = new CrudIvas();

        Object[] lista;
        lista = cc.mostrar().toArray();
        for (Object datos : lista) {

            Ivas c1 = (Ivas) datos;
            salida = (idiva == c1.getIdIvas()) ? salida
                    + "<option value='" + c1.getIdIvas() + "'>" + c1.getIvasporcentaje() + "</option>" : salida + "<option value='" + c1.getIdIvas() + "'>" + c1.getIvasporcentaje() + "</option>";
        }
        return salida;
    }

    public static String tablalistaclientes() {
        CrudClientes cc = new CrudClientes();
        String salida = "";
        Object[] lista;
        lista = cc.mostrar().toArray();
        int a = 0;
        String fondos = "";
        for (Object cliente1 : lista) {
            if (a % 2 == 0) {
                fondos = "class='fondos'";
            } else {
                fondos = "";
            }
            Cliente c1 = (Cliente) cliente1;
            salida = salida + "<tr " + fondos + ">"
                    + "<td></td>"
                    + "<td>"
                    + c1.getCedula()
                    + "</td>"
                    + "<td>"
                    + c1.getApellido1() + " " + c1.getApellido2()
                    + " "
                    + c1.getNombre1() + " " + c1.getNombre2()
                    + "</td>"
                    + "<td>"
                    + c1.getDireccion()
                    + "</td>"
                    + "<td>"
                    + c1.getTelefono()
                    + "</td>"
                    + "<td>"
                    + c1.getCorreo()
                    + "</td>"
                    + "<td>"
                    + "<input type=\"image\" name=\"actionproceso\" class=\"btnico\" value=\"EDITAR-" + a + "\"  src=\"editar.png\" onclick='seleccliente(" + c1.getIdcliente() + "')>"
                    + "<input type=\"image\" name=\"actionproceso\" class=\"btnico\" value=\"ELMINAR-" + a + "\"  src=\"eliminar.png\" onclick='seleccliente(" + c1.getIdcliente() + "')>"
                    + "</td>"
                    + "</tr>";
            a++;
        }
        return salida;
    }

    public static String fecha(Date f) {
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return objSDF.format(f);
    }
 public static String fomatodecimales(Double f) {
        String strDateFormat = "#.##";
        DecimalFormat objSDF = new DecimalFormat(strDateFormat);
        objSDF.setMaximumFractionDigits(2);
        return objSDF.format(f);
    }
    public static String estructuraventas(Facturacion f) {
        CrudIvas crudIvas = new CrudIvas();

        String r = "";
        int a = 0;
        String fondos = "";
        for (Articulos i : (ArrayList<Articulos>) f.listaArticulos()) {
            Ivas iv = (Ivas) crudIvas.obtenerDato(i.getIvas_idIvas());
            if (a % 2 == 0) {
                fondos = "class='fondos'";
            } else {
                fondos = "";
            }
            r += " <tr " + fondos + ">\n"
                    + "<td>\n"
                    + "</td>\n"
                    + "<td>\n"
                    + "<input type=\"text\" class=\"datos\"  id=\"cantidad\" name=\"cantidad" + a + "\" value=\"" + i.getCantidad() + "\" />\n"
                    + "</td>\n"
                    + "<td>\n"
                    + "<div class=\"datosclientes\">\n"
                    + "<input type=\"text\" class=\"datos\"  id=\"codigo\" name=\"codigo" + a + "\" value=\"" + i.getProductoscodigo() + "\" /> \n"
                    + "</div>\n"
                    + "</td>\n"
                    + "<td>\n"
                    + "<input type=\"text\" class=\"datos\" id=\"producto\" name=\"producto" + a + "\" value=\"" + i.getProductosdetalle() + "\" disabled />\n"
                    + "</td>\n"
                    + "<td>\n"
                    + "<input type=\"text\" class=\"datos\" id=\"precio\" name=\"precio" + a + "\" value=\"" + i.getProductosprecio() + "\" disabled />\n"
                    + "</td>\n"
                    + "<td>\n"
                    + "<input type=\"text\" class=\"datos\" id=\"iva\" name=\"iva" + a + "\" value=\"" + iv.getIvasporcentaje() + "\" disabled />\n"
                    + "</td>"
                    + "<td>\n"
                    + "<button type=\"submit\" class=\"btnico\" name=\"actionproceso\" value=\"ELIMINARRPRODUCTO-" + a + "\"><img src=\"eliminar.png\" class=\"btnico\" width=\"30\" height=\"30\"/></button>"
                    + "</td>\n"
                    + "</tr>";
            a++;
        }
//                             

        return r;
    }
}
