/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "APL_CON_CONFIGURACION", catalog = "HRSYSTEM", schema = "")
@NamedQueries({
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c"),
    @NamedQuery(name = "Configuracion.findByConId", query = "SELECT c FROM Configuracion c WHERE c.conId = :conId"),
    @NamedQuery(name = "Configuracion.findByConCorreo", query = "SELECT c FROM Configuracion c WHERE c.conCorreo = :conCorreo"),
    @NamedQuery(name = "Configuracion.findByConPcorreo", query = "SELECT c FROM Configuracion c WHERE c.conPcorreo = :conPcorreo"),
    @NamedQuery(name = "Configuracion.findByConPort", query = "SELECT c FROM Configuracion c WHERE c.conPort = :conPort"),
    @NamedQuery(name = "Configuracion.findByConServer", query = "SELECT c FROM Configuracion c WHERE c.conServer = :conServer"),
    @NamedQuery(name = "Configuracion.findByConSeguridad", query = "SELECT c FROM Configuracion c WHERE c.conSeguridad = :conSeguridad")})
public class Configuracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "CON_CORREO", length = 300)
    private String conCorreo;
    @Column(name = "CON_PCORREO", length = 300)
    private String conPcorreo;
    @Column(name = "CON_PORT", length = 300)
    private String conPort;
    @Column(name = "CON_SERVER", length = 300)
    private String conServer;
    @Column(name = "CON_SEGURIDAD", length = 100)
    private String conSeguridad;

    public Configuracion() {
    }

    public Configuracion(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConCorreo() {
        return conCorreo;
    }

    public void setConCorreo(String conCorreo) {
        this.conCorreo = conCorreo;
    }

    public String getConPcorreo() {
        return conPcorreo;
    }

    public void setConPcorreo(String conPcorreo) {
        this.conPcorreo = conPcorreo;
    }

    public String getConPort() {
        return conPort;
    }

    public void setConPort(String conPort) {
        this.conPort = conPort;
    }

    public String getConServer() {
        return conServer;
    }

    public void setConServer(String conServer) {
        this.conServer = conServer;
    }

    public String getConSeguridad() {
        return conSeguridad;
    }

    public void setConSeguridad(String conSeguridad) {
        this.conSeguridad = conSeguridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.Configuracion[ conId=" + conId + " ]";
    }
    
}
