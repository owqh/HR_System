/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.controladores;

import javax.persistence.EntityManager;
import sv.bitlab.conexion.Conexion;
import sv.bitlab.entidades.EstadoDepartamento;

/**
 *
 * @author Manuel Ramos
 */
public class EstadoDepartamentoControlador extends ControladorAbstracto<EstadoDepartamento>{

    public EstadoDepartamentoControlador() {
        super(EstadoDepartamento.class);
    }

    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return Conexion.obtenerInstancia().getManejadorDeConexion().createEntityManager();
    }
    
}
