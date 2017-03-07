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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packageelecciones.DAO.Operaciones;
import packageelecciones.MODELO.*;

/**
 *
 * @author pc
 */
public class servletControladorVotacion extends HttpServlet {

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
        Partidos parti = new Partidos(request.getParameter("radiob"));
        HttpSession recupera = request.getSession(true);
        Votantes vota = (Votantes) recupera.getAttribute("votante");
        Operaciones opera = new Operaciones();
        int aux;
        try {
            aux = opera.votar(Conexion, vota, parti);
        } catch (SQLException ex) {
            aux = 0;
        }
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("partido", parti.getNombre());
        HttpSession sesionb = request.getSession(true);
        sesionb.setAttribute("votar", aux);
        response.sendRedirect("VISTAS/Votar.jsp");
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
