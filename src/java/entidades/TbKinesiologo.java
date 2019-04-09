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
@Table(name = "tb_kinesiologo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbKinesiologo.findAll", query = "SELECT t FROM TbKinesiologo t")
    , @NamedQuery(name = "TbKinesiologo.findByIdmatricula", query = "SELECT t FROM TbKinesiologo t WHERE t.idmatricula = :idmatricula")
    , @NamedQuery(name = "TbKinesiologo.findByNombre", query = "SELECT t FROM TbKinesiologo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TbKinesiologo.findByApellido", query = "SELECT t FROM TbKinesiologo t WHERE t.apellido = :apellido")})
public class TbKinesiologo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmatricula")
    private Integer idmatricula;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @JoinColumn(name = "idespecialidad", referencedColumnName = "idespecialidad")
    @ManyToOne
    private TbEspecialidad idespecialidad;

    public TbKinesiologo() {
    }

    public TbKinesiologo(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public TbKinesiologo(Integer idmatricula, String nombre, String apellido) {
        this.idmatricula = idmatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TbEspecialidad getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(TbEspecialidad idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatricula != null ? idmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbKinesiologo)) {
            return false;
        }
        TbKinesiologo other = (TbKinesiologo) object;
        if ((this.idmatricula == null && other.idmatricula != null) || (this.idmatricula != null && !this.idmatricula.equals(other.idmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbKinesiologo[ idmatricula=" + idmatricula + " ]";
    }
    
}
