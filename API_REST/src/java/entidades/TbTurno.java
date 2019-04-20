/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.sql.Timestamp; 
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author root
 */
@Entity
@Table(name = "tb_turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTurno.findAll", query = "SELECT t FROM TbTurno t")
    , @NamedQuery(name = "turnosCliente", query = "SELECT t FROM TbTurno t WHERE t.idcliente = ?")
    , @NamedQuery(name = "TbTurno.findByespecialidad", query = "SELECT t FROM TbTurno t WHERE t.idespecialidad = :idespecialidad")
    , @NamedQuery(name = "TbTurno.findByFecha", query = "SELECT t FROM TbTurno t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "turnosKinesiologo", query = "SELECT t FROM TbTurno t WHERE t.idmatricula = ?")
    , @NamedQuery(name = "TbTurno.findByUsuario", query = "SELECT t FROM TbTurno t WHERE t.idusuario = :idusuario")})
public class TbTurno implements Serializable {

        private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private TbCliente idcliente;
    @Basic(optional = false)
    @JoinColumn(name = "idespecialidad", referencedColumnName = "idespecialidad")
    @ManyToOne
    private TbEspecialidad idespecialidad;
    @Basic(optional = false)
    @Column(name = "fecha")
    private Date fecha;
    @Basic(optional = false)
    @JoinColumn(name = "idmatricula", referencedColumnName = "idmatricula")
    @ManyToOne
    private TbKinesiologo idmatricula;
    @Basic(optional = false)
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private TbUsuario idusuario;
  
    public TbTurno() {
    }
    
    public TbCliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(TbCliente idcliente) {
        this.idcliente = idcliente;
    }

    public TbEspecialidad getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(TbEspecialidad idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public Date getfecha() {
        return fecha;
    }

    public void setfecha(Date fecha) {
        this.fecha = fecha;
    }

    public TbKinesiologo getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(TbKinesiologo idmatricula) {
        this.idmatricula = idmatricula;
    }

    public TbUsuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(TbUsuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.idcliente);
        hash = 73 * hash + Objects.hashCode(this.idespecialidad);
        hash = 73 * hash + Objects.hashCode(this.fecha);
        hash = 73 * hash + Objects.hashCode(this.idmatricula);
        hash = 73 * hash + Objects.hashCode(this.idusuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TbTurno other = (TbTurno) obj;
        if (!Objects.equals(this.idespecialidad, other.idespecialidad)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.idmatricula, other.idmatricula)) {
            return false;
        }
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        if (!Objects.equals(this.idcliente, other.idcliente)) {
            return false;
        }
        return true;
    }

    @Override
        public String toString() {
return 
"	<tr>\n" +
"       <td><font size=2 color=\"green\" face=\"helvetica\">" + idcliente.getIdcliente() + "</font></td>\n" +
"   	<td><font size=2 color=\"green\" face=\"helvetica\">" + idespecialidad.getIdespecialidad() + "</font></td>\n" +
"   	<td><font size=2 color=\"green\" face=\"helvetica\">" + idmatricula.getIdmatricula() + "</font></td>\n" +                
"   	<td><font size=2 color=\"green\" face=\"helvetica\">" + idusuario.getIdusuario() + "</font></td>\n" +
"   	<td><font size=2 color=\"green\" face=\"helvetica\">" + fecha + "</font></td>\n" +                
"	</tr>" ;     
    }
    
    
}
