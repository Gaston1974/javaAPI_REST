/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaston
 */
@Entity
@Table(name = "Fpais")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "equipoId", query = "SELECT t FROM Fpais t WHERE t.nrodni = ?")
    , @NamedQuery(name = "equipoStatus", query = "SELECT t FROM Fpais t WHERE t.idcliente = :idcliente")})

public class Fpais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @Basic(optional = false)
    @Column(name = "pais_id")
    //@SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN",initialValue=2, allocationSize=12)
    //@GeneratedValue(strategy= GenerationType.TABLE)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long pais_id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    
    
public Fpais () {
    
}

}