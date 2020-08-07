/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "APL_EMP_EMPLEADO", catalog = "HRSYSTEM", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"EMP_DUI"})})
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByEmpId", query = "SELECT e FROM Empleado e WHERE e.empId = :empId"),
    @NamedQuery(name = "Empleado.findByEmpNombre", query = "SELECT e FROM Empleado e WHERE e.empNombre = :empNombre"),
    @NamedQuery(name = "Empleado.findByEmpApellido", query = "SELECT e FROM Empleado e WHERE e.empApellido = :empApellido"),
    @NamedQuery(name = "Empleado.findByEmpCorreo", query = "SELECT e FROM Empleado e WHERE e.empCorreo = :empCorreo"),
    @NamedQuery(name = "Empleado.findByEmpTelefono", query = "SELECT e FROM Empleado e WHERE e.empTelefono = :empTelefono"),
    @NamedQuery(name = "Empleado.findByEmpDui", query = "SELECT e FROM Empleado e WHERE e.empDui = :empDui"),
    @NamedQuery(name = "Empleado.findByEmpDireccion", query = "SELECT e FROM Empleado e WHERE e.empDireccion = :empDireccion"),
    @NamedQuery(name = "Empleado.findByEmpFechaNac", query = "SELECT e FROM Empleado e WHERE e.empFechaNac = :empFechaNac"),
    @NamedQuery(name = "Empleado.findByEmpFechaContrato", query = "SELECT e FROM Empleado e WHERE e.empFechaContrato = :empFechaContrato")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMP_ID", nullable = false)
    private Integer empId;
    @Column(name = "EMP_NOMBRE", length = 45)
    private String empNombre;
    @Column(name = "EMP_APELLIDO", length = 45)
    private String empApellido;
    @Column(name = "EMP_CORREO", length = 50)
    private String empCorreo;
    @Column(name = "EMP_TELEFONO", length = 8)
    private String empTelefono;
    @Column(name = "EMP_DUI", length = 9)
    private String empDui;
    @Column(name = "EMP_DIRECCION", length = 255)
    private String empDireccion;
    @Column(name = "EMP_FECHA_NAC")
    @Temporal(TemporalType.DATE)
    private Date empFechaNac;
    @Column(name = "EMP_FECHA_CONTRATO")
    @Temporal(TemporalType.DATE)
    private Date empFechaContrato;
    @OneToMany(mappedBy = "empId", fetch = FetchType.LAZY)
    private List<SalSalario> salSalarioList;
    @JoinColumn(name = "CAR_ID", referencedColumnName = "CAR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo carId;
    @JoinColumn(name = "DEP_ID", referencedColumnName = "DEP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento depId;
    @JoinColumn(name = "ECI_ID", referencedColumnName = "ECI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estadocivil eciId;
    @JoinColumn(name = "EEM_ID", referencedColumnName = "EEM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoEmpleado eemId;
    @JoinColumn(name = "SEX_ID", referencedColumnName = "SEX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sexo sexId;

    public Empleado() {
    }

    public Empleado(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpApellido() {
        return empApellido;
    }

    public void setEmpApellido(String empApellido) {
        this.empApellido = empApellido;
    }

    public String getEmpCorreo() {
        return empCorreo;
    }

    public void setEmpCorreo(String empCorreo) {
        this.empCorreo = empCorreo;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public String getEmpDui() {
        return empDui;
    }

    public void setEmpDui(String empDui) {
        this.empDui = empDui;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public Date getEmpFechaNac() {
        return empFechaNac;
    }

    public void setEmpFechaNac(Date empFechaNac) {
        this.empFechaNac = empFechaNac;
    }

    public Date getEmpFechaContrato() {
        return empFechaContrato;
    }

    public void setEmpFechaContrato(Date empFechaContrato) {
        this.empFechaContrato = empFechaContrato;
    }

    public List<SalSalario> getSalSalarioList() {
        return salSalarioList;
    }

    public void setSalSalarioList(List<SalSalario> salSalarioList) {
        this.salSalarioList = salSalarioList;
    }

    public Cargo getCarId() {
        return carId;
    }

    public void setCarId(Cargo carId) {
        this.carId = carId;
    }

    public Departamento getDepId() {
        return depId;
    }

    public void setDepId(Departamento depId) {
        this.depId = depId;
    }

    public Estadocivil getEciId() {
        return eciId;
    }

    public void setEciId(Estadocivil eciId) {
        this.eciId = eciId;
    }

    public EstadoEmpleado getEemId() {
        return eemId;
    }

    public void setEemId(EstadoEmpleado eemId) {
        this.eemId = eemId;
    }

    public Sexo getSexId() {
        return sexId;
    }

    public void setSexId(Sexo sexId) {
        this.sexId = sexId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.bitlab.entidades.Empleado[ empId=" + empId + " ]";
    }
    
}
