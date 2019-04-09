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
@Table(name = "tb_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRol.findAll", query = "SELECT t FROM TbRol t")
    , @NamedQuery(name = "TbRol.findByIdrol", query = "SELECT t FROM TbRol t WHERE t.idrol = :idrol")
    , @NamedQuery(name = "TbRol.findByDescripcion", query = "SELECT t FROM TbRol t WHERE t.descripcion = :descripcion")})
public class TbRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idrol")
    private Integer idrol;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idrol")
    private Collection<TbRolUsuario> tbRolUsuarioCollection;

    public TbRol() {
    }

    public TbRol(Integer idrol) {
        this.idrol = idrol;
    }

    public TbRol(Integer idrol, String descripcion) {
        this.idrol = idrol;
        this.descripcion = descripcion;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<TbRolUsuario> getTbRolUsuarioCollection() {
        return tbRolUsuarioCollection;
    }

    public void setTbRolUsuarioCollection(Collection<TbRolUsuario> tbRolUsuarioCollection) {
        this.tbRolUsuarioCollection = tbRolUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRol)) {
            return false;
        }
        TbRol other = (TbRol) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbRol[ idrol=" + idrol + " ]";
    }
    
}
