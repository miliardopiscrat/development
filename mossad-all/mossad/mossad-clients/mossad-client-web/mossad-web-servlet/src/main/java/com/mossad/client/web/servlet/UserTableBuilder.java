/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.client.web.servlet;

import com.mossad.jpa.lib.user.User;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author mmigdal
 */
class UserTableBuilder {
    
    public UserTableBuilder(){
   
    }
    
    public void printUserTable(PrintWriter out, List<User> users){
    
        if (users != null && users.size() > 0) {

                out.println("<table border=\"1\" cellpadding=\"5\" >");
                //out.println("<caption>My table caption</caption>");
                out.println(
                        //"<tr border=\"1\">"
                         "<th>Name</th>"
                        + "<th>Surname</th>"
                        + "<th>email</th>"
                        + "<th>password</th>"
                        + "<th>id</th>"
                        + "</tr>");


                for (User user : users) {
                    out.println("<tr>");

                    out.println("<td>");
                    out.println(user.getName());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(user.getSurname());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(user.getEmail());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(user.getPassword());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(user.getId());
                    out.println("</td>");

                    out.println("</tr>");
                    
                }
                out.println("</table>");
            }
        
    }
    
    
}
