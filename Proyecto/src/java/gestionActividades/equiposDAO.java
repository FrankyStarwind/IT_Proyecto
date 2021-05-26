/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionActividades;

import gestionActividades.Equipo;
import gestionActividades.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author frank
 */
public class equiposDAO {

    Session s1 = null;

    /**
     * Lista todos los equipos
     *
     * @return
     */
    public List<Equipo> consultaTodosLosEquipos() {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Equipo");
        List<Equipo> lista = (List<Equipo>) q1.list();
        tx.commit();
        return lista;
    }

    /**
     * Busca el equipo por su nombre
     *
     * @param nombre
     * @return
     */
    public Equipo busquedaEquipoPorNombre(String nombre) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Equipo where nombre='" + nombre + "'");

        Equipo equipo = (Equipo) q1.uniqueResult();
        tx.commit();
        return equipo;
    }/**
     * Busca el equipo por su nombre
     *
     * @param id
     * @return
     */
    public Equipo busquedaEquipoPorId(int id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Equipo where id='" + id + "'");

        Equipo equipo = (Equipo) q1.uniqueResult();
        tx.commit();
        return equipo;
    }

    /**
     * Elimina un equipo de la base de datos
     * @param e 
     */
    public void eliminarEquipo(Equipo e){
        s1= HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx= s1.beginTransaction();
        
        s1.delete(e);
        tx.commit();
    }
    
    
    /**
     * Muestra los jugadores de un equipo
     * @param idEquipo
     * @return
     */
    public List<Jugador> listarJugadores(String idEquipo) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Jugadores where equipoFK" + idEquipo);

        List<Jugador> jugadores = (List<Jugador>) q1.list();
        tx.commit();
        return jugadores;
    }
}
