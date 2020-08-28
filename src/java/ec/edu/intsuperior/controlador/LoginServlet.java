/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Clases.Usuarios;
import ec.edu.intsuperior.modelo.Crud.CrudUsuarios;
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
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher rd = null;
        String accion = "";
        String respuesta = "Usuarios Existentes: ";
        Usuarios user = new Usuarios();
        accion = request.getParameter("actionproceso");
        user.setUsuarioNik(request.getParameter("usuario"));
        user.setUsuarioclave(request.getParameter("clave"));
        if (accion.equalsIgnoreCase("INICIAR SESION")) {
            CrudUsuarios crud = new CrudUsuarios();

            if (crud.existe(user) != 0) {

                Usuarios userfinal = (Usuarios) crud.obtenerDato(user);
                Cookie cookieu = new Cookie("ec.edu.intsuperior.cookie.user", userfinal.getUsuarioNik());
                Cookie cookiep = new Cookie("ec.edu.intsuperior.cookie.pass", userfinal.getUsuarioclave());
                Cookie cookienombre = new Cookie("ec.edu.intsuperior.cookie.nombreuser", userfinal.getUsuarioNombre());
                Cookie cookieiduser = new Cookie("ec.edu.intsuperior.cookie.iduser", userfinal.getIdUsuario() + "");
                cookieiduser.setMaxAge(365 * 24 * 60 * 60);
                cookienombre.setMaxAge(365 * 24 * 60 * 60);
                cookiep.setMaxAge(365 * 24 * 60 * 60);
                cookieu.setMaxAge(365 * 24 * 60 * 60);
                response.addCookie(cookiep);
                response.addCookie(cookieu);
                response.addCookie(cookienombre);
                response.addCookie(cookieiduser);
                request.setAttribute("usuario", userfinal.getUsuarioNombre());
                rd = request.getRequestDispatcher("ec.edu.intsuperior.vista/menuprincipal.jsp");

            } else {
                request.setAttribute("respuesta", +crud.existe(user) + "\n " + user);
                rd = request.getRequestDispatcher("index.jsp");

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
