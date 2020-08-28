/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.vista.GeneradorEsquema;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author dellubuntu
 */
public class MenuGeneral extends HttpServlet {

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
            out.println("<title>Servlet MenuGeneral</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MenuGeneral at " + request.getContextPath() + "</h1>");
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
        String accion = request.getParameter("accionmenu");
        RequestDispatcher rd = null;
        switch (accion) {
            case "SALIR": {
                rd = request.getRequestDispatcher("index.jsp");
                break;
            }

            case "ClIENTES": {

                request.setAttribute("tablalistaclinetes", GeneradorEsquema.tablalistaclientes());
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/datosCliente.jsp");
                break;
            }

            case "VENTAS": {
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/vistafacturacion.jsp");
                break;
            }

            case "REPORTES": {
                rd = request.getRequestDispatcher("index.jsp");
                break;
            }

            case "PROVEEDORES": {
                rd = request.getRequestDispatcher("index.jsp");
                break;
            }
            case "COMPRAS": {
                rd = request.getRequestDispatcher("index.jsp");
                break;
            }

            case "PRODUCTOS": {
                request.setAttribute("ivageneral", GeneradorEsquema.selectoptioniva(0));
                request.setAttribute("tablaproductos", GeneradorEsquema.tablalistaproductos());
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/vistaproductos.jsp");
                break;
            }

        }
        if (rd != null) {
            Cookie[] listacookies = request.getCookies();

            for (Cookie cook : listacookies) {
                if ("ec.edu.intsuperior.cookie.nombreuser".equals(cook.getName())) {
                    request.setAttribute("usuario", cook.getValue());
                    break;
                }
            }
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
