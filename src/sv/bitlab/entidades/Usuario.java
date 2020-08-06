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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "APL_USR_USUARIO", catalog = "HRSYSTEM", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"USR_ACCESO"})})
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsrId", query = "SELECT u FROM Usuario u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "Usuario.findByUsrAcceso", query = "SELECT u FROM Usuario u WHERE u.usrAcceso = :usrAcceso"),
    @NamedQuery(name = "Usuario.findByUsrNombre", query = "SELECT u FROM Usuario u WHERE u.usrNombre = :usrNombre"),
    @NamedQuery(name = "Usuario.findByUsrApellido", query = "SELECT u FROM Usuario u WHERE u.usrApellido = :usrApellido"),
    @NamedQuery(name = "Usuario.findByUsrContrasena", query = "SELECT u FROM Usuario u WHERE u.usrContrasena = :usrContrasena")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USR_ID", nullable = false)
    private Integer usrId;
    @Column(name = "USR_ACCESO", length = 70)
    private String usrAcceso;
    @Column(name = "USR_NOMBRE", length = 45)
    private String usrNombre;
    @Column(name = "USR_APELLIDO", length = 45)
    private String usrApellido;
    @Column(name = "USR_CONTRASENA", length = 300)
    private String usrContrasena;
    @JoinColumn(name = "TIP_ID", referencedColumnName = "TIP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoUsuario tipId;

    public Usuario() {
    }

    public Usuario(Integer usrId) {
        this.usrId = usrId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrAcceso() {
        return usrAcceso;
    }

    public void setUsrAcceso(String usrAcceso) {
        this.usrAcceso = usrAcceso;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrContrasena() {
        return usrContrasena;
    }

    public void setUsrContrasena(String usrContrasena) {
        this.usrContrasena = usrContrasena;
    }

    public TipoUsuario getTipId() {
        return tipId;
    }

    public void setTipId(TipoUsuario tipId) {
        this.tipId = tipId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.Usuario[ usrId=" + usrId + " ]";
    }
    
}
