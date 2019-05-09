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
@WebServlet(urlPatterns = {"/Query2"})
public class Query2 extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>PUT</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
                    try 
            (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // declaracion de variables
        System.out.println("Send Http POST request");   
            // declaracion de variables
        int max = 0;    
        int paisId = 0;
        String equipo = "";
        int equipoId = 0;
        Fequipo eq = new Fequipo();
    
        paisId = Integer.parseInt( request.getParameter("pais"));
        equipo = request.getParameter("equipo");
        equipoId = Integer.parseInt( request.getParameter("equipo_id"));
   
      
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
                                                                                    
        session.beginTransaction();                     
                               
                max =  (int) session.createQuery("SELECT MAX(equipo_id) FROM f_equipo").uniqueResult();
                max++;
                
                session.createQuery("INSERT INTO f_equipo (pais_id, equipo, api_id, status, equipo_id, logo_url) "
                        + "VALUES ( paisId, equipo, equipoId, 'none', max, null ); ").uniqueResult();
                
             
        session.getTransaction().commit();  
                
        }
        
    }

    
}
