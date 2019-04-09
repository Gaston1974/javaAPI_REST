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
@Table(name = "tb_provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProvincia.findAll", query = "SELECT t FROM TbProvincia t")
    , @NamedQuery(name = "TbProvincia.findByIdprovincia", query = "SELECT t FROM TbProvincia t WHERE t.idprovincia = :idprovincia")
    , @NamedQuery(name = "TbProvincia.findByNombre", query = "SELECT t FROM TbProvincia t WHERE t.nombre = :nombre")})
public class TbProvincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idprovincia")
    private Integer idprovincia;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idprovincia")
    private Collection<TbLocalidad> tbLocalidadCollection;

    public TbProvincia() {
    }

    public TbProvincia(Integer idprovincia) {
        this.idprovincia = idprovincia;
    }

    public TbProvincia(Integer idprovincia, String nombre) {
        this.idprovincia = idprovincia;
        this.nombre = nombre;
    }

    public Integer getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Integer idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<TbLocalidad> getTbLocalidadCollection() {
        return tbLocalidadCollection;
    }

    public void setTbLocalidadCollection(Collection<TbLocalidad> tbLocalidadCollection) {
        this.tbLocalidadCollection = tbLocalidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprovincia != null ? idprovincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProvincia)) {
            return false;
        }
        TbProvincia other = (TbProvincia) object;
        if ((this.idprovincia == null && other.idprovincia != null) || (this.idprovincia != null && !this.idprovincia.equals(other.idprovincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbProvincia[ idprovincia=" + idprovincia + " ]";
    }
    
}
