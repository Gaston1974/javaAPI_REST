/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tb_especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEspecialidad.findAll", query = "SELECT t FROM TbEspecialidad t")
    , @NamedQuery(name = "TbEspecialidad.findByIdespecialidad", query = "SELECT t FROM TbEspecialidad t WHERE t.idespecialidad = :idespecialidad")
    , @NamedQuery(name = "TbEspecialidad.findByDescripcion", query = "SELECT t FROM TbEspecialidad t WHERE t.descripcion = :descripcion")})
public class TbEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idespecialidad")
    private Integer idespecialidad;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idespecialidad")
    private Collection<TbKinesiologo> tbKinesiologoCollection;

    public TbEspecialidad() {
    }

    public TbEspecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public TbEspecialidad(Integer idespecialidad, String descripcion) {
        this.idespecialidad = idespecialidad;
        this.descripcion = descripcion;
    }

    public Integer getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<TbKinesiologo> getTbKinesiologoCollection() {
        return tbKinesiologoCollection;
    }

    public void setTbKinesiologoCollection(Collection<TbKinesiologo> tbKinesiologoCollection) {
        this.tbKinesiologoCollection = tbKinesiologoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecialidad != null ? idespecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEspecialidad)) {
            return false;
        }
        TbEspecialidad other = (TbEspecialidad) object;
        if ((this.idespecialidad == null && other.idespecialidad != null) || (this.idespecialidad != null && !this.idespecialidad.equals(other.idespecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbEspecialidad[ idespecialidad=" + idespecialidad + " ]";
    }
    
}
