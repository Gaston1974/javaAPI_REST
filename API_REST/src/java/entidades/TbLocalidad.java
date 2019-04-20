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
@Table(name = "tb_localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbLocalidad.findAll", query = "SELECT t FROM TbLocalidad t")
    , @NamedQuery(name = "TbLocalidad.findByIdlocalidad", query = "SELECT t FROM TbLocalidad t WHERE t.idlocalidad = :idlocalidad")
    , @NamedQuery(name = "TbLocalidad.findByNombre", query = "SELECT t FROM TbLocalidad t WHERE t.nombre = :nombre")})
public class TbLocalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idlocalidad")
    private Integer idlocalidad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idprovincia", referencedColumnName = "idprovincia")
    @ManyToOne
    private TbProvincia idprovincia;

    public TbLocalidad() {
    }

    public TbLocalidad(Integer idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public TbLocalidad(Integer idlocalidad, String nombre) {
        this.idlocalidad = idlocalidad;
        this.nombre = nombre;
    }

    public Integer getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Integer idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TbProvincia getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(TbProvincia idprovincia) {
        this.idprovincia = idprovincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocalidad != null ? idlocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLocalidad)) {
            return false;
        }
        TbLocalidad other = (TbLocalidad) object;
        if ((this.idlocalidad == null && other.idlocalidad != null) || (this.idlocalidad != null && !this.idlocalidad.equals(other.idlocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbLocalidad[ idlocalidad=" + idlocalidad + " ]";
    }
    
}
