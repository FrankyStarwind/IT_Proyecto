/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionActividades;

import gestionActividades.HibernateUtil;
import gestionActividades.Jugador;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author frank
 */
public class jugadoresDAO {

    Session s1 = null;

    /**
     * Localiza todos los jugadores de la base de datos
     *
     * @return
     */
    public List<Jugador> consultaTodosJugadores() {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Jugador");
        List<Jugador> listaJugadores = (List<Jugador>) q1.list();
        if (listaJugadores.size() == 0) {
            System.out.println("Esta vacio");
        }
        tx.commit();
        return listaJugadores;
    }

    /**
     * Localiza el jugador por el dorsal y el nombre
     *
     * @param nombre
     * @param dorsal
     * @return
     */
    public Jugador busquedaJugadorPorNombreDorsal(String nombre, int dorsal) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Jugador where nombre='" + nombre + "' and dorsal='" + dorsal + "'");

        Jugador jugador = (Jugador) q1.uniqueResult();
        tx.commit();
        return jugador;
    }

    /**
     * Edita un jugador de la bd
     * @param jug
     */
    

    public void editarJugador(Jugador jug) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        s1.update(jug);
        tx.commit();
    }
    /**
     * Eliminar un jugador de la bd
     * @param j 
     */

    public void eliminarJugador(Jugador j) {
        s1= HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx= s1.beginTransaction();
        
        s1.delete(j);
        tx.commit();
    }
    
}
