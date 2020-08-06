/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import sv.bitlab.conexion.Conexion;
import sv.bitlab.entidades.Usuario;

/**
 *
 * @author Manuel Ramos
 */
public class UsuarioControlador extends ControladorAbstracto<Usuario> {

    public UsuarioControlador() {
        super(Usuario.class);
    }
    
    public Usuario ObtenerUsuario(String usuario){
        Query q = obtenerManejadorEntidades().createQuery("SELECT u FROM Usuario u WHERE u.usrAcceso = :usuario");
        q.setParameter("usuario", usuario);
        return (Usuario) q.getSingleResult();
    }

    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return Conexion.obtenerInstancia().getManejadorDeConexion().createEntityManager();
    }
    
}
