/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "APL_SAL_SALARIO", catalog = "HRSYSTEM", schema = "")
@NamedQueries({
    @NamedQuery(name = "SalSalario.findAll", query = "SELECT s FROM SalSalario s"),
    @NamedQuery(name = "SalSalario.findBySalId", query = "SELECT s FROM SalSalario s WHERE s.salId = :salId"),
    @NamedQuery(name = "SalSalario.findBySalSalario", query = "SELECT s FROM SalSalario s WHERE s.salSalario = :salSalario"),
    @NamedQuery(name = "SalSalario.findBySalFechaInicio", query = "SELECT s FROM SalSalario s WHERE s.salFechaInicio = :salFechaInicio"),
    @NamedQuery(name = "SalSalario.findBySalFechaFin", query = "SELECT s FROM SalSalario s WHERE s.salFechaFin = :salFechaFin")})
public class SalSalario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SAL_ID", nullable = false)
    private Integer salId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SAL_SALARIO", precision = 12, scale = 0)
    private Float salSalario;
    @Column(name = "SAL_FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date salFechaInicio;
    @Column(name = "SAL_FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date salFechaFin;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empId;

    public SalSalario() {
    }

    public SalSalario(Integer salId) {
        this.salId = salId;
    }

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public Float getSalSalario() {
        return salSalario;
    }

    public void setSalSalario(Float salSalario) {
        this.salSalario = salSalario;
    }

    public Date getSalFechaInicio() {
        return salFechaInicio;
    }

    public void setSalFechaInicio(Date salFechaInicio) {
        this.salFechaInicio = salFechaInicio;
    }

    public Date getSalFechaFin() {
        return salFechaFin;
    }

    public void setSalFechaFin(Date salFechaFin) {
        this.salFechaFin = salFechaFin;
    }

    public Empleado getEmpId() {
        return empId;
    }

    public void setEmpId(Empleado empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salId != null ? salId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalSalario)) {
            return false;
        }
        SalSalario other = (SalSalario) object;
        if ((this.salId == null && other.salId != null) || (this.salId != null && !this.salId.equals(other.salId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.SalSalario[ salId=" + salId + " ]";
    }
    
}
