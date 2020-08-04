/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.controladores;

import javax.persistence.EntityManager;
import sv.bitlab.conexion.Conexion;
import sv.bitlab.entidades.Planilla;

/**
 *
 * @author Manuel Ramos
 */
public class PlanillaControlador extends ControladorAbstracto<Planilla>{

    public PlanillaControlador() {
        super(Planilla.class);
    }

    @Override
    protected EntityManager obtenerManejadorEntidades() {
        return Conexion.obtenerInstancia().getManejadorDeConexion().createEntityManager();
    }
    
}
