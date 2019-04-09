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
@Table(name = "tb_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t")
    , @NamedQuery(name = "TbUsuario.findByIdusuario", query = "SELECT t FROM TbUsuario t WHERE t.idusuario = :idusuario")
    , @NamedQuery(name = "TbUsuario.findByNombre", query = "SELECT t FROM TbUsuario t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TbUsuario.findByApellido", query = "SELECT t FROM TbUsuario t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "TbUsuario.findByPasword", query = "SELECT t FROM TbUsuario t WHERE t.pasword = :pasword")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "pasword")
    private String pasword;
    @JoinColumn(name = "idusuario_rol", referencedColumnName = "idusuario_rol")
    @ManyToOne
    private TbRolUsuario idusuarioRol;

    public TbUsuario() {
    }

    public TbUsuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public TbUsuario(Integer idusuario, String nombre, String apellido) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
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

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public TbRolUsuario getIdusuarioRol() {
        return idusuarioRol;
    }

    public void setIdusuarioRol(TbRolUsuario idusuarioRol) {
        this.idusuarioRol = idusuarioRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbUsuario[ idusuario=" + idusuario + " ]";
    }
    
}
