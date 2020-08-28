/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Clases.Articulos;
import ec.edu.intsuperior.modelo.Clases.Facturacion;
import ec.edu.intsuperior.modelo.Clases.Ivas;
import ec.edu.intsuperior.modelo.Crud.CrudArticulos;
import ec.edu.intsuperior.modelo.Crud.CrudClientes;
import ec.edu.intsuperior.modelo.Crud.CrudIvas;
import ec.edu.intsuperior.vista.GeneradorEsquema;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author dellubuntu
 */
public class MiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MiServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        //zona de variables
        String accion = request.getParameter("actionproceso");
        //Inicio Seccion productos
        int num = Integer.parseInt(request.getParameter("numproductos"));
        Facturacion f = new Facturacion();
        double productosprecio = 0;
        double cantidad = 0;
        int ivas_idIvas = 0;
        int idProductos = 0;
        String productoscodigo = "";
        int productosidUsuario = 0;
        String productosdetalle = "";
        String productosaccion = "";
        int proveedoreseliminar = 0;
        Date proveedoresfecha = new Date();
        CrudArticulos crudArticulos = new CrudArticulos();
        
        for (int i = 0; i < num; i++) {
            // productosprecio = (!"".equals(request.getParameter("precio" + i)) && request.getParameter("precio" + i) != null) ? Double.parseDouble(request.getParameter("precio" + i)) : 0;
            cantidad = (!"".equals(request.getParameter("cantidad" + i)) && request.getParameter("cantidad" + i) != null) ? Double.parseDouble(request.getParameter("cantidad" + i)) : 0;
            productoscodigo = request.getParameter("codigo" + i);
            Articulos a = (Articulos) crudArticulos.obtenerDato(productoscodigo);
            a.setCantidad(cantidad);
            //ivas_idIvas = a.getIvas_idIvas();
            //productosdetalle = request.getParameter("producto" + i);
            f.agregarP(a);
        }

//Fin datos de productos
//Seccion Datos Clientes
        String cedulafactura = (request.getParameter("cedulafactura") != null && !"".equals(request.getParameter("cedulafactura"))) ? request.getParameter("cedulafactura") : "9999999999";
        CrudClientes crudClientes = new CrudClientes();
        f.setCliente(crudClientes.obtenerDato(cedulafactura));
        request.setAttribute("cedula1", f.getCliente().getCedula());
        request.setAttribute("apellidosynombres", f.getCliente().getApellido1() + " " + f.getCliente().getApellido2() + " " + f.getCliente().getNombre1() + " " + f.getCliente().getNombre2());
        request.setAttribute("direccion1", f.getCliente().getDireccion());
        request.setAttribute("telefono1", f.getCliente().getTelefono());
        request.setAttribute("correo1", f.getCliente().getCorreo());
        String[] menuaccion = accion.split("-");
        switch (menuaccion[0]) {
            case "BUSCARCLIENTE": {
                request.setAttribute("cedula1", f.getCliente().getCedula());
                request.setAttribute("apellidosynombres", f.getCliente().getApellido1() + " " + f.getCliente().getApellido2() + " " + f.getCliente().getNombre1() + " " + f.getCliente().getNombre2());
                request.setAttribute("direccion1", f.getCliente().getDireccion());
                request.setAttribute("telefono1", f.getCliente().getTelefono());
                request.setAttribute("correo1", f.getCliente().getCorreo());
                break;
            }
            case "AGREGARPRODUCTO": {
                productosprecio = (!"".equals(request.getParameter("precio")) && request.getParameter("precio") != null) ? Double.parseDouble(request.getParameter("precio")) : 0;
                cantidad = (!"".equals(request.getParameter("cantidad")) && request.getParameter("cantidad") != null) ? Double.parseDouble(request.getParameter("cantidad")) : 0;
                //idProductos = Integer.parseInt(request.getParameter("idproducto"));
                productoscodigo = request.getParameter("codigo");
                Articulos a = (Articulos) crudArticulos.obtenerDato(productoscodigo);
                productosdetalle = request.getParameter("producto");
                ivas_idIvas = a.getIvas_idIvas();
                a.setCantidad(cantidad);
                f.agregarP(a);
                
                break;
            }
            case "ELIMINARRPRODUCTO": {
                int seleccion = Integer.parseInt(menuaccion[1]);
                f.eliminar(seleccion);
            }
            
            case "BUSCARPRODUCTO": {
                CrudIvas crudIvas = new CrudIvas();
                productoscodigo = request.getParameter("codigo");
                Articulos art = (Articulos) crudArticulos.obtenerDato(productoscodigo);
                Ivas i = (Ivas) crudIvas.obtenerDato(art.getIvas_idIvas());
                
                cantidad = (!"".equals(request.getParameter("cantidad")) && request.getParameter("cantidad") != null) ? Double.parseDouble(request.getParameter("cantidad")) : 0;
                request.setAttribute("cantidad01", cantidad);
                request.setAttribute("codigo01", productoscodigo);
                request.setAttribute("productosdetalle", art.getProductosdetalle());
                request.setAttribute("productosprecio", art.getProductosprecio());
                request.setAttribute("ivas_idIvas", i.getIvasporcentaje());
                break;
            }
            
            case "SALIR": {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            case "menuPrincipal": {
                RequestDispatcher rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/menuprincipal.jsp");
                rd.forward(request, response);
                break;
            }
        }
        try {
            request.setAttribute("numproductostotal", f.numeroitems());
            request.setAttribute("ivatotal", "" + GeneradorEsquema.fomatodecimales(f.totaliva()) + " ");
            request.setAttribute("subtotal", GeneradorEsquema.fomatodecimales(f.subtotalgeneral()));
            request.setAttribute("totalfinal", GeneradorEsquema.fomatodecimales(f.totaldescuentos()));
            request.setAttribute("totalgeneral", GeneradorEsquema.fomatodecimales(f.totalgeneral()));
            request.setAttribute("descuentototal", GeneradorEsquema.fomatodecimales(f.totalporcentajeDescuentos()) + "%("+GeneradorEsquema.fomatodecimales(f.descuentos())+")");
            request.setAttribute("respuesta", GeneradorEsquema.estructuraventas(f));
            RequestDispatcher rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/vistafacturacion.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("respuesta", e);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
