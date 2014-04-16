/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.client.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mossad.irp.interfaces.task.IServiceTaskRemote;
import com.mossad.irp.interfaces.user.IServiceUser;
import javax.ejb.EJB;

/**
 *
 * @author mmigdal
 */
@WebServlet(name = "ServletMossadReader", urlPatterns = {"/ServletMossadReader"})
public class ServletMossadReader extends HttpServlet {

     
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    //injection remote
    @EJB
    private IServiceTaskRemote iServiceTaskRemote;
    
    @EJB
    private IServiceUser serviceUser;
    
    private String aaa;
    
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMossad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletMossad at " + request.getContextPath() + "</h1>");
            
            out.println("<table>");
            
            //headers
            out.println(
                "<tr>" +
                "<th>Name</th>" +
                "<th>Surname</th>" +
                "<th>email</th>" +
                "<th>login</th>" +
                "<th>password</th>" +
                "</tr>");
            
            
            
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            
            
            
        } finally {            
            out.flush();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
        return "Short description for Mossad Servlet";
    }// </editor-fold>
}
