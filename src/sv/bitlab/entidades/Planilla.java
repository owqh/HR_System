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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Planilla.findByPlaSalario", query = "SELECT p FROM Planilla p WHERE p.plaSalario = :plaSalario"),
    @NamedQuery(name = "Planilla.findByPlaHorasExtras", query = "SELECT p FROM Planilla p WHERE p.plaHorasExtras = :plaHorasExtras"),
    @NamedQuery(name = "Planilla.findByPlaAfpPatronal", query = "SELECT p FROM Planilla p WHERE p.plaAfpPatronal = :plaAfpPatronal"),
    @NamedQuery(name = "Planilla.findByPlaAfpLaboral", query = "SELECT p FROM Planilla p WHERE p.plaAfpLaboral = :plaAfpLaboral"),
    @NamedQuery(name = "Planilla.findByPlaIsssPatronal", query = "SELECT p FROM Planilla p WHERE p.plaIsssPatronal = :plaIsssPatronal"),
    @NamedQuery(name = "Planilla.findByPlaIsssLaboral", query = "SELECT p FROM Planilla p WHERE p.plaIsssLaboral = :plaIsssLaboral"),
    @NamedQuery(name = "Planilla.findByPlaRenta", query = "SELECT p FROM Planilla p WHERE p.plaRenta = :plaRenta"),
    @NamedQuery(name = "Planilla.findByPlaDescuentos", query = "SELECT p FROM Planilla p WHERE p.plaDescuentos = :plaDescuentos"),
    @NamedQuery(name = "Planilla.findByPlaTotalPagar", query = "SELECT p FROM Planilla p WHERE p.plaTotalPagar = :plaTotalPagar"),
    @NamedQuery(name = "Planilla.findByPlaFechaInicio", query = "SELECT p FROM Planilla p WHERE p.plaFechaInicio = :plaFechaInicio"),
    @NamedQuery(name = "Planilla.findByPlaFechaFin", query = "SELECT p FROM Planilla p WHERE p.plaFechaFin = :plaFechaFin"),
    @NamedQuery(name = "Planilla.findByEmpId", query = "SELECT p FROM Planilla p WHERE p.empId = :empId")})
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PLA_SALARIO", precision = 12, scale = 0)
    private Float plaSalario;
    @Column(name = "PLA_HORAS_EXTRAS", precision = 12, scale = 0)
    private Float plaHorasExtras;
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
    @Column(name = "PLA_DESCUENTOS", precision = 12, scale = 0)
    private Float plaDescuentos;
    @Column(name = "PLA_TOTAL_PAGAR", precision = 12, scale = 0)
    private Float plaTotalPagar;
    @Basic(optional = false)
    @Column(name = "PLA_FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plaFechaInicio;
    @Basic(optional = false)
    @Column(name = "PLA_FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plaFechaFin;
    @Column(name = "EMP_ID")
    private Integer empId;

    public Planilla() {
    }

    public Planilla(Integer plaId) {
        this.plaId = plaId;
    }

    public Planilla(Integer plaId, String plaCodigo, Date plaFechaInicio, Date plaFechaFin) {
        this.plaId = plaId;
        this.plaCodigo = plaCodigo;
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

    public Float getPlaSalario() {
        return plaSalario;
    }

    public void setPlaSalario(Float plaSalario) {
        this.plaSalario = plaSalario;
    }

    public Float getPlaHorasExtras() {
        return plaHorasExtras;
    }

    public void setPlaHorasExtras(Float plaHorasExtras) {
        this.plaHorasExtras = plaHorasExtras;
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

    public Float getPlaDescuentos() {
        return plaDescuentos;
    }

    public void setPlaDescuentos(Float plaDescuentos) {
        this.plaDescuentos = plaDescuentos;
    }

    public Float getPlaTotalPagar() {
        return plaTotalPagar;
    }

    public void setPlaTotalPagar(Float plaTotalPagar) {
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
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
