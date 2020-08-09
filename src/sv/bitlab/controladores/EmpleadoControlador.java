
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.bitlab.controladores;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sv.bitlab.conexion.Conexion;
import sv.bitlab.entidades.Empleado;

/**
 *
 * @author Manuel Ramos
 */
public class EmpleadoControlador extends ControladorAbstracto<Empleado> {
    
    public List<Empleado> EmpleadoPorEstado (String nombreEstado) throws Exception {
        //funcion que retorna los cliente activos
        EntityManager em = obtenerManejadorEntidades();
        try {
            Query q = em.createQuery("select c from Empleado c where c.eemId.eemNombre = :nombreEstado");
            q.setParameter("nombreEstado", nombreEstado);
            return q.getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    
    public List<Empleado> empleadoPlanilla () throws Exception {
        //funcion que retorna los cliente activos
        EntityManager em = obtenerManejadorEntidades();
        try {
            Query q = em.createQuery("select e from Empleado e where e.eemId.eemId = :valor ");
            q.setParameter("valor", 1);
            return q.getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    
    
    public EmpleadoControlador() {
        super(Empleado.class);
    }
    
    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return Conexion.obtenerInstancia().getManejadorDeConexion().createEntityManager();
    }
    
}

