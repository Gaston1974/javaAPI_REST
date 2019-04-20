/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tb_rol_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRolUsuario.findAll", query = "SELECT t FROM TbRolUsuario t")
    , @NamedQuery(name = "TbRolUsuario.findByIdusuarioRol", query = "SELECT t FROM TbRolUsuario t WHERE t.idusuarioRol = :idusuarioRol")
    , @NamedQuery(name = "TbRolUsuario.findByFechaCreacion", query = "SELECT t FROM TbRolUsuario t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TbRolUsuario.findByFechaModificacion", query = "SELECT t FROM TbRolUsuario t WHERE t.fechaModificacion = :fechaModificacion")})
public class TbRolUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idusuario_rol")
    private Integer idusuarioRol;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "idusuarioRol")
    private Collection<TbUsuario> tbUsuarioCollection;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private TbRol idrol;

    public TbRolUsuario() {
    }

    public TbRolUsuario(Integer idusuarioRol) {
        this.idusuarioRol = idusuarioRol;
    }

    public TbRolUsuario(Integer idusuarioRol, Date fechaCreacion) {
        this.idusuarioRol = idusuarioRol;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdusuarioRol() {
        return idusuarioRol;
    }

    public void setIdusuarioRol(Integer idusuarioRol) {
        this.idusuarioRol = idusuarioRol;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public Collection<TbUsuario> getTbUsuarioCollection() {
        return tbUsuarioCollection;
    }

    public void setTbUsuarioCollection(Collection<TbUsuario> tbUsuarioCollection) {
        this.tbUsuarioCollection = tbUsuarioCollection;
    }

    public TbRol getIdrol() {
        return idrol;
    }

    public void setIdrol(TbRol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarioRol != null ? idusuarioRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRolUsuario)) {
            return false;
        }
        TbRolUsuario other = (TbRolUsuario) object;
        if ((this.idusuarioRol == null && other.idusuarioRol != null) || (this.idusuarioRol != null && !this.idusuarioRol.equals(other.idusuarioRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbRolUsuario[ idusuarioRol=" + idusuarioRol + " ]";
    }
    
}
