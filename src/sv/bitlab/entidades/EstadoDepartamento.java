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
@Table(name = "APL_EDE_ESTADO_DEP", catalog = "HRSYSTEM", schema = "")
@NamedQueries({
    @NamedQuery(name = "EstadoDepartamento.findAll", query = "SELECT e FROM EstadoDepartamento e"),
    @NamedQuery(name = "EstadoDepartamento.findByEdeId", query = "SELECT e FROM EstadoDepartamento e WHERE e.edeId = :edeId"),
    @NamedQuery(name = "EstadoDepartamento.findByEdeNombre", query = "SELECT e FROM EstadoDepartamento e WHERE e.edeNombre = :edeNombre")})
public class EstadoDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EDE_ID", nullable = false)
    private Integer edeId;
    @Column(name = "EDE_NOMBRE", length = 35)
    private String edeNombre;
    @OneToMany(mappedBy = "edeId", fetch = FetchType.LAZY)
    private List<Departamento> departamentoList;

    public EstadoDepartamento() {
    }

    public EstadoDepartamento(Integer edeId) {
        this.edeId = edeId;
    }

    public Integer getEdeId() {
        return edeId;
    }

    public void setEdeId(Integer edeId) {
        this.edeId = edeId;
    }

    public String getEdeNombre() {
        return edeNombre;
    }

    public void setEdeNombre(String edeNombre) {
        this.edeNombre = edeNombre;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edeId != null ? edeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDepartamento)) {
            return false;
        }
        EstadoDepartamento other = (EstadoDepartamento) object;
        if ((this.edeId == null && other.edeId != null) || (this.edeId != null && !this.edeId.equals(other.edeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.EstadoDepartamento[ edeId=" + edeId + " ]";
    }
    
}
