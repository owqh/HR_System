/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.bitlab.controladores;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author  Manuel Ramos
 * @param <T>
 */
public abstract class ControladorAbstracto <T>{/*La referencia T significa que vamos a
    recibir una clase entidad pero no sabemos cual
    es una referencia nada mas para usar multipes clases o objetos
    esto nos da la referencia de la clase.*/
    
    private final Class<T> claseEntidad;
    
    //Constructor para asignar el entityclass.
    public ControladorAbstracto(Class<T> claseEntidad) {
        this.claseEntidad = claseEntidad;
    }
    
    
    //Metodo para crear nueva entidad.
    public void crear(T entidad) throws Exception{
        EntityManager em = obtenerManejadorEntidades();
        try {
            em.getTransaction().begin();
            em.persist(entidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e);
        }finally{
            if(em.isOpen())
                em.close();
        }
    }
    
    
    //Metodo para crear una lista de muchos clientes
    public void crear(List<T> entidades) throws Exception{
        EntityManager em = obtenerManejadorEntidades();
        try {
            em.getTransaction().begin();
            for(T e : entidades)
                em.persist(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e);
        }finally{
            if(em.isOpen())
                em.close();
        }
    }
    
    
    //Metodo para modificar o crear (si no existe lo creará).
    public void editar(T entidad) throws Exception{
        EntityManager em = obtenerManejadorEntidades();
        try {
            em.getTransaction().begin();
            em.merge(entidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }finally{
            if(em.isOpen())
                em.close();
        }
    }
    
    
    //Metodo para eliminar una entidad.
    public void destruir(T entidad) throws Exception{
        EntityManager em = obtenerManejadorEntidades();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entidad));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }finally{
            if(em.isOpen())
                em.close();
        }
    }
    
    
    //Metodo para encontrar una entidad.
    public T encontrar(Object id) throws Exception{
        EntityManager em = obtenerManejadorEntidades();
        try {
            return em.find(claseEntidad, id);
        } catch (Exception e) {
            throw new Exception(e);
        }finally{
            if(em.isOpen())
                em.close();
        }
    }
    
    
    //Metodos para generar un SELECT *
    public List<T> encontrarEntidades() {
        return encontrarEntidades(true, -1, -1);
    }
    
    public List<T> encontrarEntidades(int maxResults, int firstResult) {
        return encontrarEntidades(false, maxResults, firstResult);
    }
    
    private List<T> encontrarEntidades(boolean all, int maxResults, int firstResult) {
        EntityManager em = obtenerManejadorEntidades();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseEntidad));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            List<T> entidades = q.getResultList();
            for(T e : entidades){
                em.refresh(e);
            }
            return entidades;
        } finally {
            em.close();
        }
    }
    
    
    //Metodo abstracto para el manejo de entidades.
    protected abstract EntityManager obtenerManejadorEntidades();
    
}
