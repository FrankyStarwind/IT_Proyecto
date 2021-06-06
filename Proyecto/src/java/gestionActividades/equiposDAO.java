/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionActividades;

import java.util.List;
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
    public List<Equipo> busquedaUsuarioPorDni(String dni) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Equipo where id='" + dni + "'");
        List<Equipo> lista = (List<Equipo>) q1.list();
        tx.commit();
        return lista;
    }

    public Equipo busquedaEquipoPorNombre(int nombre) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Equipo where nombre='" + nombre + "'");

        Equipo equipo = (Equipo) q1.uniqueResult();
        tx.commit();
        return equipo;
    }
    /**
     * Elimina un equipo de la base de datos
     * 
     * @param id
     */
    public void eliminarEquipo(int id){
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        s1.createSQLQuery("delete from Equipo where id=" + id + "").executeUpdate();
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
    
    public void crearEquipo(Equipo equipo) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.save(equipo);

        s1.getTransaction().commit();
    }

    public List<Equipo> busquedaUsuarioPorID(int id) {
               s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Equipo where id = " + id + "");
        List<Equipo> list = q1.list();
        tx.commit();
        return list;
    }

    public void editarEquipo(Equipo eq) {
    
         s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.update(eq);

        s1.getTransaction().commit();
    }

    public void desactivarEquipo(Equipo equipo) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.update(equipo);

        s1.getTransaction().commit();

    }

    public List<Equipo> buscarEquipoNombre(String nombre) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Equipo where nombre = '" + nombre + "' and activo=1");
        List<Equipo> list = q1.list();
        tx.commit();
        return list;

    }

    public List<Equipo> consultaTodosLosEquiposActivos() {
 s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Equipo where activo=1");
        List<Equipo> lista = (List<Equipo>) q1.list();
        tx.commit();
        return lista;
    }
}
