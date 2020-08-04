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

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "APL_PLA_PLANILLA", catalog = "HRSYSTEM", schema = "")
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByPlaId", query = "SELECT p FROM Planilla p WHERE p.plaId = :plaId"),
    @NamedQuery(name = "Planilla.findByPlaAfpPatronal", query = "SELECT p FROM Planilla p WHERE p.plaAfpPatronal = :plaAfpPatronal"),
    @NamedQuery(name = "Planilla.findByPlaAfpLaboral", query = "SELECT p FROM Planilla p WHERE p.plaAfpLaboral = :plaAfpLaboral"),
    @NamedQuery(name = "Planilla.findByPlaIsssPatronal", query = "SELECT p FROM Planilla p WHERE p.plaIsssPatronal = :plaIsssPatronal"),
    @NamedQuery(name = "Planilla.findByPlaIsssLaboral", query = "SELECT p FROM Planilla p WHERE p.plaIsssLaboral = :plaIsssLaboral"),
    @NamedQuery(name = "Planilla.findByPlaRenta", query = "SELECT p FROM Planilla p WHERE p.plaRenta = :plaRenta")})
public class Planilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLA_ID", nullable = false)
    private Integer plaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PLA_AFP_PATRONAL", precision = 12, scale = 0)
    private Float plaAfpPatronal;
    @Column(name = "PLA_AFP_LABORAL", precision = 12, scale = 0)
    private Float plaAfpLaboral;
    @Column(name = "PLA_ISSS_PATRONAL", precision = 12, scale = 0)
    private Float plaIsssPatronal;
    @Column(name = "PLA_ISSS_LABORAL", precision = 12, scale = 0)
    private Float plaIsssLaboral;
    @Column(name = "PLA_RENTA", precision = 12, scale = 0)
    private Float plaRenta;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empId;

    public Planilla() {
    }

    public Planilla(Integer plaId) {
        this.plaId = plaId;
    }

    public Integer getPlaId() {
        return plaId;
    }

    public void setPlaId(Integer plaId) {
        this.plaId = plaId;
    }

    public Float getPlaAfpPatronal() {
        return plaAfpPatronal;
    }

    public void setPlaAfpPatronal(Float plaAfpPatronal) {
        this.plaAfpPatronal = plaAfpPatronal;
    }

    public Float getPlaAfpLaboral() {
        return plaAfpLaboral;
    }

    public void setPlaAfpLaboral(Float plaAfpLaboral) {
        this.plaAfpLaboral = plaAfpLaboral;
    }

    public Float getPlaIsssPatronal() {
        return plaIsssPatronal;
    }

    public void setPlaIsssPatronal(Float plaIsssPatronal) {
        this.plaIsssPatronal = plaIsssPatronal;
    }

    public Float getPlaIsssLaboral() {
        return plaIsssLaboral;
    }

    public void setPlaIsssLaboral(Float plaIsssLaboral) {
        this.plaIsssLaboral = plaIsssLaboral;
    }

    public Float getPlaRenta() {
        return plaRenta;
    }

    public void setPlaRenta(Float plaRenta) {
        this.plaRenta = plaRenta;
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
        hash += (plaId != null ? plaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.plaId == null && other.plaId != null) || (this.plaId != null && !this.plaId.equals(other.plaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.Planilla[ plaId=" + plaId + " ]";
    }
    
}
