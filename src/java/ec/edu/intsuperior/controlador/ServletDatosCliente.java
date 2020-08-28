/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Clases.Cliente;
import ec.edu.intsuperior.modelo.Crud.CrudClientes;
import ec.edu.intsuperior.vista.GeneradorEsquema;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author dellubuntu
 */
public class ServletDatosCliente extends HttpServlet {

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
            out.println("<title>Servlet ServletDatosCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletDatosCliente at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        RequestDispatcher rd = null;
        String accion = (request.getParameter("actionproceso") != null) ? request.getParameter("actionproceso") : "";
        Cliente c = new Cliente(request.getParameter("apellidos"), "", request.getParameter("nombres"), "", request.getParameter("cedula"), request.getParameter("correo"), request.getParameter("telefono"), request.getParameter("direccion"));
        Cookie[] listacookies = request.getCookies();
        Date fechaactual = new Date();
        boolean exito = false;

        for (Cookie cook : listacookies) {
            if ("ec.edu.intsuperior.cookie.iduser".equals(cook.getName())) {
                c.setClienteidUsuario(Integer.parseInt(cook.getValue()));
            }
            if ("ec.edu.intsuperior.cookie.nombreuser".equals(cook.getName())) {
                request.setAttribute("usuario", cook.getValue());
            }
        }
        c.setClientesaccion("REGISTRO");
        c.setClientesfecha(fechaactual);

        switch (accion) {
            case "SALIR": {
                rd = request.getRequestDispatcher("index.jsp");
                break;
            }

            case "Guardar": {

                CrudClientes crudClientes = new CrudClientes();
                if (crudClientes.existe(c) == 0) {
                    exito = crudClientes.insertar(c);
                }
                request.setAttribute("datos", c);
                request.setAttribute("tablalistaclinetes", GeneradorEsquema.tablalistaclientes());
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/datosCliente.jsp");
                break;
            }
            case "EDITAR": {
                CrudClientes crudClientes = new CrudClientes();
                if (crudClientes.existe(c) == 0) {
                    exito = crudClientes.actualizar(c);
                }
                request.setAttribute("datos", c);
                request.setAttribute("tablalistaclinetes", GeneradorEsquema.tablalistaclientes());
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/datosCliente.jsp");
                break;
            }
            case "ELMINAR": {
                CrudClientes crudClientes = new CrudClientes();

                if (crudClientes.existe(c) == 0) {

                    exito = crudClientes.eliminar(c);
                }

                request.setAttribute("datos", c);
                request.setAttribute("tablalistaclinetes", GeneradorEsquema.tablalistaclientes());
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/datosCliente.jsp");
                break;
            }
            case "menuPrincipal": {
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/menuprincipal.jsp");
                break;
            }
            default: {
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/datosCliente.jsp");
                break;
            }

        }
        if (rd != null) {
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
