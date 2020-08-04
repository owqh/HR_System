/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "APL_ECI_ECIVIL", catalog = "HRSYSTEM", schema = "")
@NamedQueries({
    @NamedQuery(name = "Estadocivil.findAll", query = "SELECT e FROM Estadocivil e"),
    @NamedQuery(name = "Estadocivil.findByEciId", query = "SELECT e FROM Estadocivil e WHERE e.eciId = :eciId"),
    @NamedQuery(name = "Estadocivil.findByEciNombre", query = "SELECT e FROM Estadocivil e WHERE e.eciNombre = :eciNombre")})
public class Estadocivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ECI_ID", nullable = false)
    private Integer eciId;
    @Column(name = "ECI_NOMBRE", length = 15)
    private String eciNombre;
    @OneToMany(mappedBy = "eciId", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public Estadocivil() {
    }

    public Estadocivil(Integer eciId) {
        this.eciId = eciId;
    }

    public Integer getEciId() {
        return eciId;
    }

    public void setEciId(Integer eciId) {
        this.eciId = eciId;
    }

    public String getEciNombre() {
        return eciNombre;
    }

    public void setEciNombre(String eciNombre) {
        this.eciNombre = eciNombre;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eciId != null ? eciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocivil)) {
            return false;
        }
        Estadocivil other = (Estadocivil) object;
        if ((this.eciId == null && other.eciId != null) || (this.eciId != null && !this.eciId.equals(other.eciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.Estadocivil[ eciId=" + eciId + " ]";
    }
    
}
