/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
*/
import hibernate.HibernateUtil;
import entidades.TbCliente;
import entidades.TbEspecialidad;
import entidades.TbKinesiologo;
import entidades.TbTurno;
import entidades.TbUsuario;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader; 
import java.io.IOException;
import java.io.InputStreamReader;
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
//import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpResponse;
//import org.json.*  ;
import org.json.simple.parser.*;
import org.hibernate.Session; 
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.logging.*;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.simple.JSONObject;
import entidades.Jugador;
import java.io.File;
import java.util.Set;
import org.json.simple.JSONArray;


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
    
    
        private final String USER_AGENT = "Mozilla/5.0";
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
        TbTurno tur = new TbTurno();
        Leedor leedor = new Leedor();
        ImpresorHTML impresor = new ImpresorHTML();
        List<String> valores = null ;
        int i = 0;
        FileWriter fwtr1 = null;
        String rutaArchivo = "/home/gaston/javaAPI_REST/API_REST/web/WEB-INF/jugadores.html" ;
        
        opcion = request.getParameter("teams");
        fwtr1 = new FileWriter(rutaArchivo);
              
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
                                                                                    
        //session.beginTransaction();
        
        switch ( opcion ) {
            case "1":

                System.out.println("Testing 1 - Send Http GET request");
                   
                // param = busco id ( API FUTBOL ) del equipo en la base
                String param = "2616";
                String key = "&APIkey=3181aba25e0ededb5fa60883bd351da54315e3395abfbee8ab8cf6f768c63751";
                String urlImagen = "https://allsportsapi.com/logo/2615_bournemouth.png";
                
                sendGet(param, key);
              
                         }
        
            // urlImagen = busco id ( API FUTBOL ) del equipo en la base         
            String urlImagen = "https://allsportsapi.com/logo/2615_bournemouth.png";
            
            fwtr1.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Query</title>\n</head>\n<style> \n" +
                                         "body {  background-image: url(" + urlImagen + "); \n" +
                                         "background-color: green;\n" +
                                         "background-repeat: no-repeat; \n" +
                                         "background-position:center center; }\n" +
                                         "</style> \n<br>\n<table border=\"1\">" +
                                         "\n<tr>" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerKey</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerName</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerNumber</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerCountry</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerType</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerAge</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerMatchPlayed</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerGoals</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerYellowCards</font></td>\n" +
                                         "<td><font size=2 color=\"yellow\" face=\"helvetica\">playerRedCards</font></td>\n" +
                                         "</tr>" );
        

                // parseo JSON
                
                Object obj; 
                obj = new JSONParser().parse(new FileReader("/home/gaston/javaAPI_REST/API_REST/web/WEB-INF/file.json"));
                JSONObject jo = (JSONObject) obj;
                
                Iterator<Map.Entry> itr1 ;
                Iterator<Map.Entry>  itr3 ;

                
                JSONArray ja = (JSONArray) jo.get("result"); 
                Iterator itr2 = ja.iterator(); 
                
                while (itr2.hasNext())  { 
                itr1 = ((Map) itr2.next()).entrySet().iterator(); 
                       while (itr1.hasNext()) { 
                       Map.Entry element = (Map.Entry) itr1.next();
                       if (element.getKey().equals("players"))   {                          //PARSEO jugadores
                                        JSONArray value = (JSONArray) element.getValue();
                                        Iterator itr4 = value.iterator();
                                                while (itr4.hasNext())  { 
                                                itr3 = ((Map) itr4.next()).entrySet().iterator();
                                                valores = new ArrayList();
                                                    while (itr3.hasNext())  { 
                                                    Map.Entry pair = itr3.next(); 
                                                    valores.add((String) pair.getValue().toString()) ;
                                                    i++;
                                                                            } 
                                                Jugador ju = new Jugador(valores);   
                                                ju.escribirHtml(fwtr1);
                                                                        } 
                                                                 }
                                              } 
                                         } 
                fwtr1.write("\n</table>\n</body>\n</html>");
                fwtr1.close();    
		leedor.leer(out, "/home/gaston/javaAPI_REST/API_REST/web/WEB-INF/jugadores.html" );
                
        }   catch (Exception ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        //session.getTransaction().commit();    

    }
    
    	// HTTP GET request
	private void sendGet(String p, String k) throws Exception {

		String url = "https://allsportsapi.com/api/football/?&met=Teams&teamId=";
                FileWriter fwtr2 = new FileWriter("/home/gaston/javaAPI_REST/API_REST/web/WEB-INF/file.json");
                            
             
                String urlParam = url + p ;
                String urlComp = urlParam + k ;
                String line2="";
                
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(urlComp);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
                request.addHeader("Accept","application/json");
                
                       
		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + urlComp);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());
           

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			 line2 =result.append(line).toString();
                         fwtr2.write(line2);
		}

                fwtr2.close();
	
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
   response.setContentType("text/html;charset=UTF-8");
    */
    /*
            try 
            (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // declaracion de variables     */
     /*       
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String opcion = "0";
        List<TbCliente> result;
        TbCliente cli = new TbCliente();
        TbTurno tur = new TbTurno();
        Leedor leedor = new Leedor();
        ImpresorHTML impresor = new ImpresorHTML();
        //FileWriter fwtr = null; 
  
     */   
        //Map players = new HashMap();
        //List<players> jSONresult;
        
     //   opcion = request.getParameter("teams");
        
                                
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();      
                                                                                    
        //session.beginTransaction();
    /*    
        switch ( opcion ) {
            case "1":

                System.out.println("Testing 1 - Send Http GET request");
                   
                // param = busco id ( API FUTBOL ) del equipo en la base
                String param = "2616";
                String key = "&APIkey=3181aba25e0ededb5fa60883bd351da54315e3395abfbee8ab8cf6f768c63751";
                
                sendGet(param, key);
            }        
		
        }   catch (Exception ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
    */        
    /*                    
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
            
            
    }  */
     /*
    	// HTTP GET request
	private void sendGet(String p, String k) throws Exception {

		String url = "https://allsportsapi.com/api/football/?&met=Teams&teamId=";
                FileWriter fwtr2 = new FileWriter("/home/gaston/javaAPI_REST/API_REST/web/WEB-INF/respTest2.txt");
                //List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();    
                
                //BasicHttpParams bh = new BasicHttpParams();
                String urlParam = url + p ;
                String urlComp = urlParam + k ;
                String line2="";
                
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(urlComp);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
                request.addHeader("Accept","application/json");
                
                //request.setParams(bh.setParameters(, "teams"));
                
                //urlParameters.add(new BasicNameValuePair("APIkey", "3181aba25e0ededb5fa60883bd351da54315e3395abfbee8ab8cf6f768c63751"));
                //urlParameters.add(new BasicNameValuePair("met", "team"));
                //urlParameters.add(new BasicNameValuePair("teamId", "2616"));
                
                //request.setEntity(new UrlEncodedFormEntity(urlParameters));
                
		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + urlComp);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());
           

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			 line2 =result.append(line).toString();
                         fwtr2.write(line2);
		}

                fwtr2.close();
		//System.out.println(line2);   */
   // }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
/*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static class JsonProcessingException {

        public JsonProcessingException() {
        }
    }

}
*/