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
@Table(name = "APL_EEM_ESTADO_EMPLEADO", catalog = "HRSYSTEM", schema = "")
@NamedQueries({
    @NamedQuery(name = "EstadoEmpleado.findAll", query = "SELECT e FROM EstadoEmpleado e"),
    @NamedQuery(name = "EstadoEmpleado.findByEemId", query = "SELECT e FROM EstadoEmpleado e WHERE e.eemId = :eemId"),
    @NamedQuery(name = "EstadoEmpleado.findByEemNombre", query = "SELECT e FROM EstadoEmpleado e WHERE e.eemNombre = :eemNombre")})
public class EstadoEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EEM_ID", nullable = false)
    private Integer eemId;
    @Column(name = "EEM_NOMBRE", length = 45)
    private String eemNombre;
    @OneToMany(mappedBy = "eemId", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public EstadoEmpleado() {
    }

    public EstadoEmpleado(Integer eemId) {
        this.eemId = eemId;
    }

    public Integer getEemId() {
        return eemId;
    }

    public void setEemId(Integer eemId) {
        this.eemId = eemId;
    }

    public String getEemNombre() {
        return eemNombre;
    }

    public void setEemNombre(String eemNombre) {
        this.eemNombre = eemNombre;
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
        hash += (eemId != null ? eemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEmpleado)) {
            return false;
        }
        EstadoEmpleado other = (EstadoEmpleado) object;
        if ((this.eemId == null && other.eemId != null) || (this.eemId != null && !this.eemId.equals(other.eemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.EstadoEmpleado[ eemId=" + eemId + " ]";
    }
    
}
