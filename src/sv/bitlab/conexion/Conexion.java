/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.bitlab.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Manuel Ramos
 */
public class Conexion {
    
    private  EntityManagerFactory manejadorDeConexion; //Conexion que vamos a usar del JPA
    
    //Instancia tipo clase debe ser la misma de manejadorDeConexion asi creamos el objeto singleton.
    private static Conexion con = new Conexion(); /* ...A partir de aqui comienza
    la funcionalidad del singleton donde se le dice que es una new Fabrica de conexion.
    */
    
    //Armando el Singleton Con un CONSTRUCTOR PRIVADO.
    private Conexion(){
        //Dentro de este constructor completamos nuestro atributo de EMF para la conexion.
        manejadorDeConexion = Persistence.createEntityManagerFactory("Proyecto5PU");
    }
    
    /*Metodo para usar la instacia con y asi
    conectarnos a la unica instancia publica que existe.*/
    public static Conexion obtenerInstancia(){
        return con;
    }
    
    //Accesador publico.
    //Solo insertamos el getter del EntityManagerFactory para finalizar la coneccion con este metodo.
    public EntityManagerFactory getManejadorDeConexion() {
        return manejadorDeConexion;
    }
    
}
