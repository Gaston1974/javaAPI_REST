/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import hibernate.HibernateUtil;
import entidades.TbCliente;
import entidades.TbEspecialidad;
import entidades.TbKinesiologo;
import entidades.TbTurno;
import entidades.TbUsuario;
import java.io.FileWriter;
import java.io.FileReader; 
import java.io.IOException;
import java.io.PrintWriter;
import varios.Leedor;
import varios.ImpresorHTML;
//import java.sql.Timestamp; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedHashMap; 
import java.util.Map; 
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.*  ;
import org.hibernate.Session; 
//import org.eclipse.persistence.jpa.jpql.parser.DateTime;
//import org.hibernate.Criteria;
//import org.hibernate.SQLQuery;
//import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/Query"})
public class Query extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try 
            (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // declaracion de variables
    /*        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String opcion = "0";
        List<TbCliente> result;
        List<TbTurno> res;
        List<TbTurno> resdo;
        String dni = request.getParameter("documento");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        TbCliente cli = new TbCliente();
        TbTurno tur = new TbTurno();
        Leedor leedor = new Leedor();
        ImpresorHTML impresor = new ImpresorHTML();
            
           // tomo datos del formulario web
            
        if ( request.getParameter("request").equals("Consultar_cliente") ) 
                opcion = "1";
        else if ( request.getParameter("request").equals("Insertar") ) 
                opcion = "2";
        else if ( request.getParameter("request").equals("Asignar") ) 
                opcion = "3";
        else if ( request.getParameter("request").equals("Eliminar") ) 
                opcion = "4";
        else if ( request.getParameter("request").equals("Consultar_turno") )
                opcion = "5";
        else
                opcion = "6";
        
        
           // Inicio session Hibernate
            
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
                                                                                    
        session.beginTransaction(); 
            
        
           // cases
        
        switch (opcion)  {
            
            case "1":  // Consultar cliente       
                    FileWriter fw = null;
                    result = new ArrayList<TbCliente>();
                    int flag = 0;
                                        
                    if ( !dni.equals("") ) {
        
                        result = session.getNamedQuery("clientes").setString(0, dni).list();
                          flag = 1;   }    
                    else if ( !apellido.equals("") ) {
                                  result =  session.getNamedQuery("cli.apellido").setString(0, apellido).list();
                                    flag = 1;  }
                         else if ( !nombre.equals("") ) {
                                    result =  session.getNamedQuery("cli.nombre").setString(0, nombre).list();
                                    flag = 1; }               
                              else
                                    {
                                        
                                     impresor.imprimir(out, "red", "no se han completado los campos.", "Querys");   
                               
                                          }          
                    if ( flag == 1 )
                        if ( result.size() != 0)  {
                          try {
                                fw = new FileWriter("/home/gaston/Consultorio/Consultorio/Consultorio/web/WEB-INF/results.html");
                                fw.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Query</title>\n</head>\n<body>\n<br>\n<table border=\"1\">" +
                                         "<tr>" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">id cliente</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">nombre</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">apellido</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">idlocalidad</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">telefono</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">tipodni</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">nrodni</font></td>\n" +
                                         "</tr>" );
                                      
                        for ( TbCliente object: result ) {
                                      fw.write( "\n" + object.toString() ) ;                                        
                                  }
                            fw.write("\n</table>\n</body>\n</html>");
                        }  catch(Exception e){
                              e.printStackTrace();
                            }finally{
            
                            try{
                                if ( null != fw ){
                                fw.close();
                            }
                                }catch ( Exception e2){
                                e2.printStackTrace();
                                }
            
                            } 
                        
                        leedor.leer(out, "/home/gaston/Consultorio/Consultorio/Consultorio/web/WEB-INF/results.html" );
  
                    } else 
                            impresor.imprimir(out, "red", "no se han encontrado resultados.", "Querys");
                        
              break;
              
            case "2":  // Insertar Cliente

                String localidad = request.getParameter("localidad");
                String provincia = request.getParameter("provincia");
                String telefono = request.getParameter("telefono");
                Long    idCliIn;
                Long    idCliOut = Long.parseLong("0");
                                                       

                    if ( !dni.equals("") && !nombre.equals("") && !apellido.equals("") && 
                            !localidad.equals("") && !provincia.equals("") && !telefono.equals("") ) 
                    {
                        idCliOut = Long.parseLong("-1");
                        idCliIn = (Long) session.createQuery("SELECT max(t.idcliente) FROM TbCliente t").uniqueResult();
                        idCliIn += 1;
                        cli.setIdcliente(idCliIn);
                        cli.setNombre(nombre);
                        cli.setApellido(apellido);
                        cli.setIdlocalidad(localidad);
                        cli.setTelefono(telefono);
                        cli.setTipodni("DNI");
                        cli.setNrodni(dni);
                        idCliOut = (Long) session.save(cli);
                    }                     
                    else
                         {               
                             impresor.imprimir(out, "red", "no se han completado los campos.", "Querys");
                                
                          }          
            if ( idCliOut != 0 && idCliOut != -1 )
                    {
                        impresor.imprimir(out, "blue", "El cliente ha sido insertado correctamente.", "Querys");
                        
                    }
            else if ( idCliOut == Long.parseLong("-1")) {
             
                        impresor.imprimir(out, "red", "Ocurrio un erro al insertar, vuelva a intentar.", "Querys");
            }    
              
             break;
             
            case "3": // Asignar turno
                
                Long  idTurOut = Long.parseLong("0");
                
             try { 
                String fec =  request.getParameter("fecha");
                Date fecha =  (Date) (df.parse(fec));
                //Timestamp fecha = new Timestamp (fec.getTime());                
                TbEspecialidad id_especialidad = new TbEspecialidad (Integer.parseInt(request.getParameter("id_especialidad")));
                TbKinesiologo id_matricula = new TbKinesiologo (Integer.parseInt(request.getParameter("id_matricula")));
                TbUsuario id_usuario = new TbUsuario (Integer.parseInt(request.getParameter("id_usuario")));
                TbCliente idCli = new TbCliente (Long.parseLong(request.getParameter("id_cliente")));    
               
                        tur.setIdcliente(idCli);
                        tur.setfecha(fecha);
                        tur.setIdespecialidad(id_especialidad);
                        tur.setIdmatricula(id_matricula);
                        tur.setIdusuario(id_usuario);
                        session.save(tur);
                        
                   }catch(Exception e){
          
                idTurOut = Long.parseLong("1");                           
              
                impresor.imprimir(out, "red", "Error al insertar, vuelva a intentar.", "Querys");
            
            } 
            
             if ( idTurOut != 1 )
                    {
                impresor.imprimir(out, "blue", "El cliente ha sido insertado correctamente.", "Querys");
                        
                    }   
            
            
            break;
            
             case "4": // Eliminar cliente
                  try {   
                      String clnte =  request.getParameter("id_cliente"); 
                      TbCliente cliente ;
                      String hqlDeleteT = "delete TbTurno c where c.idcliente = ?";
                      String hqlDeleteC = "delete TbCliente c where c.idcliente = ?";
                      int flg = 0; 
                      int deletedEntitiesT = 0;
                      int deletedEntitiesC = 0;
                      
                      if ( !clnte.equals("") ) {
                          Long id = (Long.parseLong(clnte));
                          TbCliente idCli = new TbCliente(id); 
                          deletedEntitiesT = session.createQuery( hqlDeleteT ).setLong(0, idCli.getIdcliente()).executeUpdate();
                          deletedEntitiesC = session.createQuery( hqlDeleteC ).setLong(0, idCli.getIdcliente()).executeUpdate();
                          //session.delete(idCli); 
                          flg = 1;}
                      else if (!dni.equals("")) {
                            cliente =  (TbCliente) session.getNamedQuery("getdocument").setString(0, dni).uniqueResult();
                            deletedEntitiesT = session.createQuery( hqlDeleteT ).setLong(0, cliente.getIdcliente()).executeUpdate();
                            session.delete(cliente);
                            flg = 1;}
                   
                if ( flg == 1 ) {
                    
                        impresor.imprimir(out, "blue", "El cliente ha sido eliminado correctamente.", "Querys");   
                    
                          }           
                    }catch(Exception e){
              
                        impresor.imprimir(out, "red", "Error al eliminar, vuelva a intentar.", "Querys");
                   }
            break;
            
            
            case "5": // Consultar turno x cliente
                
                    FileWriter fwr = null;
                    res = new ArrayList<TbTurno>();
                    String cte =  request.getParameter("id_cliente"); 
                    int fg = 0;
                                        
                    if ( !cte.equals("") ) {
                        Long idCte = Long.parseLong(cte);
                        res = session.getNamedQuery("turnosCliente").setLong(0, idCte).list();
                          fg = 1;   }                 
                    else
                                    
                               impresor.imprimir(out, "red", "no se han completado los campos.", "Querys");
                                                    
                    if ( fg == 1 && res.size() != 0 )  {
                        try {
                                fwr = new FileWriter("/home/gaston/Consultorio/Consultorio/Consultorio/web/WEB-INF/results_2.html");
                                fwr.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Query</title>\n</head>\n<body>\n<br>\n<table border=\"1\">" +
                                         "<tr>" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">id cliente</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">idespecialidad</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">idmatricula</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">idusuario</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">fecha</font></td>\n" +
                                         "</tr>" );
                                      
                        for ( TbTurno object: res ) {
                                      fwr.write( "\n" + object.toString() ) ;                                        
                                  }
                            fwr.write("\n</table>\n</body>\n</html>");
                        }  catch(Exception e){
                              e.printStackTrace();
                            }finally{
            
                            try{
                                if ( null != fwr ){
                                fwr.close();
                            }
                                }catch ( Exception e2){
                                e2.printStackTrace();
                                }
            
                            } 
                        
                        leedor.leer(out, "/home/gaston/Consultorio/Consultorio/Consultorio/web/WEB-INF/results_2.html" );
           
                    } else                                   
                           
                        impresor.imprimir(out, "red", "Error al consultar, vuelva a intentar.", "Querys");
                 break;
            
            
            case "6": // Consultar turno x kinesiologo
                
                    FileWriter fwtr = null;
                    resdo = new ArrayList<TbTurno>();
                    String klogo =  request.getParameter("idmatricula"); 
                    int fag = 0;
                                        
                    if ( !klogo.equals("") ) {
                        Integer idKlogo = Integer.parseInt(klogo);
                        resdo = session.getNamedQuery("turnosKinesiologo").setInteger(0, idKlogo).list();
                          fag = 1;   }                 
                    else                                 
                               impresor.imprimir(out, "red", "no se han completado los campos.", "Querys");
                                                    
                    if ( fag == 1 ) 
                            if ( resdo.size() != 0 )  {
                        try {
                                fwtr = new FileWriter("/home/gaston/Consultorio/Consultorio/Consultorio/web/WEB-INF/results_2.html");
                                fwtr.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Query</title>\n</head>\n<body>\n<br>\n<table border=\"1\">" +
                                         "<tr>" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">id cliente</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">idespecialidad</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">idmatricula</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">idusuario</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">fecha</font></td>\n" +
                                         "</tr>" );
                                      
                        for ( TbTurno object: resdo ) {
                                      fwtr.write( "\n" + object.toString() ) ;                                        
                                  }
                            fwtr.write("\n</table>\n</body>\n</html>");
                        }  catch(Exception e){
                              e.printStackTrace();
                            }finally{
            
                            try{
                                if ( null != fwtr ){
                                fwtr.close();
                            }
                                }catch ( Exception e2){
                                e2.printStackTrace();
                                }
            
                            } 
                        
                        leedor.leer(out, "/home/gaston/Consultorio/Consultorio/Consultorio/web/WEB-INF/results_2.html" );
           
                    } else                                   
                           
                        impresor.imprimir(out, "red", "Error al consultar, vuelva a intentar.", "Querys");                           
        }
      
         session.getTransaction().commit();
    } 
}        
*/
    
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
          response.setContentType("text/html;charset=UTF-8");
     
            try 
            (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // declaracion de variables
            
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String opcion = "0";
        List<TbCliente> result;
        List<TbTurno> res;
        List<TbTurno> resdo;
        TbCliente cli = new TbCliente();
        TbTurno tur = new TbTurno();
        Leedor leedor = new Leedor();
        ImpresorHTML impresor = new ImpresorHTML();
        FileWriter fwtr = null;  
        //Map players = new HashMap();
        //List<players> jSONresult;
        
        opcion = request.getParameter("teams");
        
        fwtr = new FileWriter("/home/gaston/javaAPI_REST/API_REST/web/WEB-INF/respTest.html");
                                fwtr.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Query</title>\n</head>\n<body>\n<br>\n<table border=\"1\">" +
                                         "<tr>" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">nombre</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">numero</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">nacionalidad</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">edad</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">goles</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">amonestaciones</font></td>\n" +
                                         "<td><font size=2 color=\"black\" face=\"helvetica\">expulsiones</font></td>\n" +
                                         "</tr>" );
                                
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
                                                                                    
        //session.beginTransaction();
        
        if ( opcion.equals("1") ) {
                        
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://allsportsapi.com/api/football")
                .header("accept", "application/json")
                .queryString("APIkey", "3181aba25e0ededb5fa60883bd351da54315e3395abfbee8ab8cf6f768c63751")
                .queryString("met", "team")
                .queryString("teamId", "2616")
                .asJson();
        
        
        Object obj = jsonResponse.getBody() ;
        
        JSONObject jo = (JSONObject) obj;
            
                
        Map jSONresult = ((Map)jo.get("result"));
        
        Map players = ((Map)jSONresult.get("players")) ;
        
        Iterator<Map.Entry> itr1 = players.entrySet().iterator(); 
            while (itr1.hasNext()) { 
               Map.Entry pair = itr1.next(); 
               
               System.out.println(pair.getKey() + " : " + pair.getValue()); 
               
        } 
        
    }
    
            }   catch (UnirestException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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
