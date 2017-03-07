/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageelecciones.CONTROLADORES;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packageelecciones.DAO.Operaciones;
import packageelecciones.MODELO.ConectarBD;
import packageelecciones.MODELO.Votantes;

/**
 *
 * @author pc
 */
public class servletControladorVota extends HttpServlet {

    private Connection Conexion;

    @Override
    public void init() throws ServletException {
        try {
            ConectarBD ConexBD = ConectarBD.GetConexion();
            Conexion = ConexBD.GetCon();
        } catch (ClassNotFoundException | SQLException cnfe) {
        }
    }

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
        Votantes vota = new Votantes(request.getParameter("nif"), request.getParameter("passw"));
        Operaciones opera = new Operaciones();
        ArrayList aux = new ArrayList();
        int cont;
        try {
            cont = opera.comprobar(Conexion, vota);
        } catch (SQLException ex) {
            cont = 0;
        }
        if (cont == 1) {
            try {
                aux = opera.listaPartidos(Conexion);
            } catch (SQLException ex) {
                aux.add(2);
            }
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("votante", vota);
            HttpSession sesionb = request.getSession(true);
            sesionb.setAttribute("partidos", aux);
            response.sendRedirect("VISTAS/Votacion.jsp");
        } else {
            HttpSession sesione = request.getSession(true);
            sesione.setAttribute("error", cont);
            response.sendRedirect("VISTAS/Error.jsp");
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
        processRequest(request, response);
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
