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
@Table(name = "f_equipo")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Select_equipoId", query = "SELECT t FROM Fequipo t WHERE t.equipoId = ?")})
    //, @NamedQuery(name = "Select_Max", query = "SELECT MAX(equipo_id) FROM Fequipo")})

public class Fequipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @Basic(optional = false)
    @Column(name = "pais_id")
    //@SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN",initialValue=2, allocationSize=12)
    //@GeneratedValue(strategy= GenerationType.TABLE)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long pais_id;
    @Basic(optional = true)
    @Column(name = "equipo_id")
    private Long equipoId;
    @Basic(optional = false)
    @Column(name = "equipo")
    private String equipo;
    @Basic(optional = true)
    @Column(name = "logo_url")
    private String logo_url;
    @Basic(optional = true)
    @Column(name = "api_id")
    private Long api_id;
    @Basic(optional = true)
    @Column(name = "status")
    private String status;
    
    
public Fequipo () {
    
}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public Long getApi_id() {
        return api_id;
    }

    public String getStatus() {
        return status;
    }

    public Long getEquipoId() {
        return equipoId;
    }



}
