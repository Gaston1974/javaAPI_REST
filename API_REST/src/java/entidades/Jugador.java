/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author gaston
 */
public class Jugador {
    
 private String  playerKey = "";
 private String  playerName = "";
 private String  playerNumber = "";
 private String  playerCountry = "";
 private String  playerType = "";
 private String  playerAge = "";
 private String  playerMatchPlayed = "";
 private String  playerGoals = "";
 private String  playerYellowCards = "";
 private String  playerRedCards = ""; 

 
 
 public Jugador( List<String> lista) {
        
   playerKey = lista.get(0) ;
   playerName = lista.get(7);
   playerNumber = lista.get(4);
   playerCountry = lista.get(5);
   playerType = lista.get(9);
   playerAge = lista.get(2);
   playerMatchPlayed = lista.get(1);
   playerGoals = lista.get(6);
   playerYellowCards = lista.get(8);
   playerRedCards = lista.get(3);   
        
    }

    public void escribirHtml (FileWriter fw) throws IOException {
                
        fw.append(toString());
        //fw.close();
    }
 
 
    @Override
    public String toString() {
        return 
                               
                "\n<tr>" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerKey + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerName + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerNumber + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerCountry + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerType + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerAge + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerMatchPlayed + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerGoals + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerYellowCards + "</font></td>\n" +
                 "<td><font size=2 color=\"white\" face=\"helvetica\">" + playerRedCards + "</font></td>\n" +
                "</tr>" ;
    }
    
    
    
    
}
