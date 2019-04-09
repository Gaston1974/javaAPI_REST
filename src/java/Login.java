/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.TbCliente;
import entidades.TbUsuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hibernate.HibernateUtil; 
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
    
                      
        String usuario = null;
            usuario = request.getParameter("usuario");
        String password = null;
            password = request.getParameter("password");
        
    // Instancio las clases de HIBERNATE    
       
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
                                                                                      
        session.beginTransaction();                                                   

        
        String result = (String) session.createQuery("SELECT t.pasword FROM TbUsuario t WHERE t.nombre = ? " ).setString(0, usuario).uniqueResult();
  
                
        session.getTransaction().commit();

        
    // Validacion de resultados    
                
    if ( !result.equals(null) && password.equals(result) ) {
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
                
        try {
            
            archivo = new File ("/root/NetBeansProjects/Consultorio/web/WEB-INF/opciones.html");
            fr = new FileReader (archivo);
            br = new BufferedReader (fr);
            
            String linea;
            linea = br.readLine();
                    
            while ( linea != null) {           
            out.println(linea);
            linea = br.readLine();           
        }    
            
        }
        
        catch(Exception e){
          e.printStackTrace();
         }finally{
            
            try{
                if ( null != fr ){
                    fr.close();
                }
           }catch ( Exception e2){
                e2.printStackTrace();
           }
            
        }        

    }else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Principal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br><br><br><br><br><br><br><br><br><br><br><br>");
            out.println("<h1><label><p align=center><font size=2 color=red face=\"helvetica\">  el nombre de usuario y/o el" +
            "password son incorrectos:   </p></label></h1>");
            out.println("</body>");
            out.println("</html>");
            
        
        }  
    }
}        

    @Override
    public boolean equals(Object obj) {
        
        
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
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
