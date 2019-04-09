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
 * @author root
 */
@Entity
@Table(name = "tb_fecha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFecha.findAll", query = "SELECT t FROM TbFecha t")
    , @NamedQuery(name = "TbFecha.findByIdfecha", query = "SELECT t FROM TbFecha t WHERE t.idfecha = :idfecha")
    , @NamedQuery(name = "TbFecha.findByAnio", query = "SELECT t FROM TbFecha t WHERE t.anio = :anio")
    , @NamedQuery(name = "TbFecha.findByMes", query = "SELECT t FROM TbFecha t WHERE t.mes = :mes")
    , @NamedQuery(name = "TbFecha.findByDia", query = "SELECT t FROM TbFecha t WHERE t.dia = :dia")})
public class TbFecha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfecha")
    private Integer idfecha;
    @Basic(optional = false)
    @Column(name = "anio")
    private int anio;
    @Basic(optional = false)
    @Column(name = "mes")
    private int mes;
    @Basic(optional = false)
    @Column(name = "dia")
    private int dia;

    public TbFecha() {
    }

    public TbFecha(Integer idfecha) {
        this.idfecha = idfecha;
    }

    public TbFecha(Integer idfecha, int anio, int mes, int dia) {
        this.idfecha = idfecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public Integer getIdfecha() {
        return idfecha;
    }

    public void setIdfecha(Integer idfecha) {
        this.idfecha = idfecha;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfecha != null ? idfecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFecha)) {
            return false;
        }
        TbFecha other = (TbFecha) object;
        if ((this.idfecha == null && other.idfecha != null) || (this.idfecha != null && !this.idfecha.equals(other.idfecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbFecha[ idfecha=" + idfecha + " ]";
    }
    
}
