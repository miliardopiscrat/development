/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.client.web.servlet;

import com.mossad.irp.interfaces.task.IServiceTask;
import com.mossad.irp.interfaces.task.IServiceTaskLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mossad.irp.interfaces.task.IServiceTaskRemote;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelper;
import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperLocal;
import com.mossad.irp.interfaces.user.IServiceUser;
import com.mossad.irp.interfaces.user.IServiceUserLocal;
import com.mossad.jpa.lib.task.Task;
import com.mossad.jpa.lib.task.TaskPriority;
import com.mossad.jpa.lib.task.TaskStatus;
import com.mossad.jpa.lib.task.TaskType;
import com.mossad.jpa.lib.user.User;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mmigdal
 */
@WebServlet(name = "ServletMossadAdmin", urlPatterns = {"/ServletMossadAdmin"})
public class ServletMossadAdmin extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //injection remote
    @EJB
    private IServiceTask serviceTask;
    //@EJB
    //private IServiceUser serviceUser;
    
    
    @EJB
    private IServiceTaskHelper serviceTaskHelper;
    
    
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

            
            //TODO add renedering for these 'outputs'
            
            /*
            List<User> users = serviceUser.getUsers();

            for (User user : users) {

                System.out.println(user.getName());
                System.out.println(user.getSurname());
                System.out.println(user.getEmail());
                System.out.println(user.getId());
                System.out.println(user.getPassword());

            }
            */

            List<Task> tasks = serviceTask.getTasks();

            List<TaskPriority> taskPriorities = serviceTaskHelper.getTaskPriorities();
            
            for( TaskPriority taskPriority : taskPriorities){
            
                System.out.println(taskPriority.getValue());
                
            }
            
            List<TaskStatus> taskStatuses = serviceTaskHelper.getTaskStatuses();
            
            for(TaskStatus ts : taskStatuses){
            
                System.out.println(ts.getValue());
            }
            
            List<TaskType> taskTypes =  serviceTaskHelper.getTaskTypes();
            
            for(TaskType tt: taskTypes){
                System.out.println(tt.getValue());
            }
            
            for(Task task : tasks){
                System.out.println(task.getId());
                System.out.println(task.getTitle());
                System.out.println(task.getPriority());
                System.out.println(task.getStatus());
                System.out.println(task.getType());
            }

            //headers
            out.println(
                    "<tr><th>Name</th><th>Surname</th><th>email</th><th>login</th><th>password</th></tr>");




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
