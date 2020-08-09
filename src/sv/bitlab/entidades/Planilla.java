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
@Table(name = "APL_PLA_PLANILLA", catalog = "HRSYSTEM", schema = "")
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByPlaId", query = "SELECT p FROM Planilla p WHERE p.plaId = :plaId"),
    @NamedQuery(name = "Planilla.findByPlaCodigo", query = "SELECT p FROM Planilla p WHERE p.plaCodigo = :plaCodigo"),
    @NamedQuery(name = "Planilla.findByPlaSalarioNeto", query = "SELECT p FROM Planilla p WHERE p.plaSalarioNeto = :plaSalarioNeto"),
    @NamedQuery(name = "Planilla.findByPlaHorasExtras", query = "SELECT p FROM Planilla p WHERE p.plaHorasExtras = :plaHorasExtras"),
    @NamedQuery(name = "Planilla.findByPlaAfpPatronal", query = "SELECT p FROM Planilla p WHERE p.plaAfpPatronal = :plaAfpPatronal"),
    @NamedQuery(name = "Planilla.findByPlaAfpLaboral", query = "SELECT p FROM Planilla p WHERE p.plaAfpLaboral = :plaAfpLaboral"),
    @NamedQuery(name = "Planilla.findByPlaIsssPatronal", query = "SELECT p FROM Planilla p WHERE p.plaIsssPatronal = :plaIsssPatronal"),
    @NamedQuery(name = "Planilla.findByPlaIsssLaboral", query = "SELECT p FROM Planilla p WHERE p.plaIsssLaboral = :plaIsssLaboral"),
    @NamedQuery(name = "Planilla.findByPlaRenta", query = "SELECT p FROM Planilla p WHERE p.plaRenta = :plaRenta"),
    @NamedQuery(name = "Planilla.findByPlaDescuentos", query = "SELECT p FROM Planilla p WHERE p.plaDescuentos = :plaDescuentos"),
    @NamedQuery(name = "Planilla.findByPlaTotalPagar", query = "SELECT p FROM Planilla p WHERE p.plaTotalPagar = :plaTotalPagar"),
    @NamedQuery(name = "Planilla.findByPlaFechaInicio", query = "SELECT p FROM Planilla p WHERE p.plaFechaInicio = :plaFechaInicio"),
    @NamedQuery(name = "Planilla.findByPlaFechaFin", query = "SELECT p FROM Planilla p WHERE p.plaFechaFin = :plaFechaFin")})
public class Planilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLA_ID", nullable = false)
    private Integer plaId;
    @Basic(optional = false)
    @Column(name = "PLA_CODIGO", nullable = false, length = 6)
    private String plaCodigo;
    @Basic(optional = false)
    @Column(name = "PLA_SALARIO_NETO", nullable = false)
    private float plaSalarioNeto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PLA_HORAS_EXTRAS", precision = 12, scale = 0)
    private Float plaHorasExtras;
    @Basic(optional = false)
    @Column(name = "PLA_AFP_PATRONAL", nullable = false)
    private float plaAfpPatronal;
    @Basic(optional = false)
    @Column(name = "PLA_AFP_LABORAL", nullable = false)
    private float plaAfpLaboral;
    @Basic(optional = false)
    @Column(name = "PLA_ISSS_PATRONAL", nullable = false)
    private float plaIsssPatronal;
    @Basic(optional = false)
    @Column(name = "PLA_ISSS_LABORAL", nullable = false)
    private float plaIsssLaboral;
    @Basic(optional = false)
    @Column(name = "PLA_RENTA", nullable = false)
    private float plaRenta;
    @Column(name = "PLA_DESCUENTOS", precision = 12, scale = 0)
    private Float plaDescuentos;
    @Basic(optional = false)
    @Column(name = "PLA_TOTAL_PAGAR", nullable = false)
    private float plaTotalPagar;
    @Basic(optional = false)
    @Column(name = "PLA_FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plaFechaInicio;
    @Basic(optional = false)
    @Column(name = "PLA_FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plaFechaFin;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empId;

    public Planilla() {
    }

    public Planilla(Integer plaId) {
        this.plaId = plaId;
    }

    public Planilla(Integer plaId, String plaCodigo, float plaSalarioNeto, float plaAfpPatronal, float plaAfpLaboral, float plaIsssPatronal, float plaIsssLaboral, float plaRenta, float plaTotalPagar, Date plaFechaInicio, Date plaFechaFin) {
        this.plaId = plaId;
        this.plaCodigo = plaCodigo;
        this.plaSalarioNeto = plaSalarioNeto;
        this.plaAfpPatronal = plaAfpPatronal;
        this.plaAfpLaboral = plaAfpLaboral;
        this.plaIsssPatronal = plaIsssPatronal;
        this.plaIsssLaboral = plaIsssLaboral;
        this.plaRenta = plaRenta;
        this.plaTotalPagar = plaTotalPagar;
        this.plaFechaInicio = plaFechaInicio;
        this.plaFechaFin = plaFechaFin;
    }

    public Integer getPlaId() {
        return plaId;
    }

    public void setPlaId(Integer plaId) {
        this.plaId = plaId;
    }

    public String getPlaCodigo() {
        return plaCodigo;
    }

    public void setPlaCodigo(String plaCodigo) {
        this.plaCodigo = plaCodigo;
    }

    public float getPlaSalarioNeto() {
        return plaSalarioNeto;
    }

    public void setPlaSalarioNeto(float plaSalarioNeto) {
        this.plaSalarioNeto = plaSalarioNeto;
    }

    public Float getPlaHorasExtras() {
        return plaHorasExtras;
    }

    public void setPlaHorasExtras(Float plaHorasExtras) {
        this.plaHorasExtras = plaHorasExtras;
    }

    public float getPlaAfpPatronal() {
        return plaAfpPatronal;
    }

    public void setPlaAfpPatronal(float plaAfpPatronal) {
        this.plaAfpPatronal = plaAfpPatronal;
    }

    public float getPlaAfpLaboral() {
        return plaAfpLaboral;
    }

    public void setPlaAfpLaboral(float plaAfpLaboral) {
        this.plaAfpLaboral = plaAfpLaboral;
    }

    public float getPlaIsssPatronal() {
        return plaIsssPatronal;
    }

    public void setPlaIsssPatronal(float plaIsssPatronal) {
        this.plaIsssPatronal = plaIsssPatronal;
    }

    public float getPlaIsssLaboral() {
        return plaIsssLaboral;
    }

    public void setPlaIsssLaboral(float plaIsssLaboral) {
        this.plaIsssLaboral = plaIsssLaboral;
    }

    public float getPlaRenta() {
        return plaRenta;
    }

    public void setPlaRenta(float plaRenta) {
        this.plaRenta = plaRenta;
    }

    public Float getPlaDescuentos() {
        return plaDescuentos;
    }

    public void setPlaDescuentos(Float plaDescuentos) {
        this.plaDescuentos = plaDescuentos;
    }

    public float getPlaTotalPagar() {
        return plaTotalPagar;
    }

    public void setPlaTotalPagar(float plaTotalPagar) {
        this.plaTotalPagar = plaTotalPagar;
    }

    public Date getPlaFechaInicio() {
        return plaFechaInicio;
    }

    public void setPlaFechaInicio(Date plaFechaInicio) {
        this.plaFechaInicio = plaFechaInicio;
    }

    public Date getPlaFechaFin() {
        return plaFechaFin;
    }

    public void setPlaFechaFin(Date plaFechaFin) {
        this.plaFechaFin = plaFechaFin;
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
