/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.Fequipo;
import hibernate.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author gaston
 */
@WebServlet(urlPatterns = {"/Query3"})
public class Query3 extends HttpServlet {

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>DELETE</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try 
            (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // declaracion de variables
            
        String opcion = "0";
        String metodo = "";
        Fequipo eq = new Fequipo();
  //      opcion = request.getParameter("teams");
      opcion = request.getParameter("name");
    //  metodo = request.getParameter("_metodo");
              
    
      
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
                                                                                    
        session.beginTransaction();
        
   
                System.out.println("Testing 1 - Send Http DELETE request");
                   
                // param = busco id ( API FUTBOL ) del equipo en la base
                int opc = Integer.parseInt(opcion);
                eq = (Fequipo) session.getNamedQuery("Select_equipoId").setInteger(0, opc).uniqueResult();
           
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Equipo: " + eq.getEquipo() + "</h1>");
            out.println("</body>");
            out.println("</html>");
                
        session.getTransaction().commit();  
                
             
        
        }
 
    }
        
}
