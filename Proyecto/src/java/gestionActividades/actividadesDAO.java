package gestionActividades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Laura
 */
public class actividadesDAO {

    Session s1 = null;

    public Usuario login(String dni, String password) throws SQLException {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Usuario where dni ='" + dni + "' and password ='" + password + "'");
        Usuario u = (Usuario) q1.uniqueResult();
        tx.commit();

        return u;
    }

    public List<Usuario> consultaTodosUsuarios() {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Usuario");
        List<Usuario> lista = (List<Usuario>) q1.list();
        tx.commit();
        return lista;
    }

    public List<Usuario> busquedaUsuarioPorDni(String dni) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Usuario where dni='" + dni + "'");
        List<Usuario> lista = (List<Usuario>) q1.list();
        tx.commit();
        return lista;
    }

    public void insertarUsuario(Usuario usu) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        s1.save(usu);
        tx.commit();
    }

    public void editarUsuario(Usuario usu) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        s1.update(usu);
        tx.commit();
    }

    public void eliminarUsuario(String dni) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        s1.createSQLQuery("delete from Usuario where dni='" + dni + "'").executeUpdate();
        tx.commit();
    }

    public List<Pago> consultaTodosPagos() {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Pago");
        List<Pago> lista = (List<Pago>) q1.list();
        tx.commit();
        return lista;
    }

    public List<Pago> busquedaPagoPorDni(int id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Usuario where id='" + id + "'");
        List<Pago> lista = (List<Pago>) q1.list();
        tx.commit();
        return lista;
    }

    public void insertarSede(Sede se) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.save(se);

        s1.getTransaction().commit();
    }

    public List<Sede> consultaSedes() {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Sede");
        List<Sede> lista = (List<Sede>) q1.list();
        tx.commit();
        return lista;
    }

    public void eliminarSede(int id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        s1.beginTransaction();

        s1.createSQLQuery("delete from Sede where id=" + id + "").executeUpdate();

        s1.getTransaction().commit();
    }

    public List<Sede> buscarSede(int id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Sede where id = " + id + "");
        List<Sede> listSede = q1.list();
        tx.commit();
        return listSede;
    }

    public void editarSede(Sede s) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.update(s);

        s1.getTransaction().commit();
    }

    public List<Reserva> consultalistaReserva() {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Reserva");
        List<Reserva> lista = (List<Reserva>) q1.list();
        tx.commit();
        return lista;
    }

    public void insertarReserva(Reserva re) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.save(re);

        s1.getTransaction().commit();
    }

    public void eliminarReserva(Integer id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        s1.beginTransaction();

        s1.createSQLQuery("delete from Reserva where id=" + id + "").executeUpdate();

        s1.getTransaction().commit();

    }

    public List<Reserva> buscarlistaReserva(Integer id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Reserva where id = " + id + "");
        List<Reserva> listR = q1.list();
        tx.commit();
        return listR;
    }

    public void editarReserva(Reserva r) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.update(r);

        s1.getTransaction().commit();
    }

    public List<Actividad> consultaActividades() {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("from Actividad where activo=1");
        List<Actividad> lista = (List<Actividad>) q1.list();
        tx.commit();
        return lista;
    }

    public List<Actividad> buscarACtividadId(Integer id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Actividad where id = " + id + " and activo=1");
        List<Actividad> listActivi = q1.list();
        tx.commit();
        return listActivi;
    }

    public List<Pago> busquedaPagoPorReserva(Integer id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Pago where idReservaFk = " + id + "");
        List<Pago> listaP = q1.list();
        tx.commit();
        return listaP;
    }

    public void insertarPago(Pago p) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.save(p);

        s1.getTransaction().commit();
    }

    public void eliminarPago(Integer id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        s1.beginTransaction();

        s1.createSQLQuery("delete from Pago where id=" + id + "").executeUpdate();

        s1.getTransaction().commit();
    }

    public List<Reserva> buscarActidadReserva(int id) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Reserva where idActividadFk = " + id + "");
        List<Reserva> list = q1.list();
        tx.commit();
        return list;
    }

    public List<Actividad> buscarACtividadNombre(String nombreActividad) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Actividad where nombre = '" + nombreActividad + "' and activo=1");
        List<Actividad> listActivi = q1.list();
        tx.commit();
        return listActivi;
    }

    public List<Sede> buscarSedeNombre(String nombre) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        Query q1 = s1.createQuery("From Sede where nombre = '" + nombre + "'");
        List<Sede> list = q1.list();
        tx.commit();
        return list;
    }

    public void insertarActividad(Actividad ac) {
        s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.save(ac);

        s1.getTransaction().commit();
    }

    public void desactivarActividad(Actividad ac) {
    s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.update(ac);

        s1.getTransaction().commit();

    }



    public void editarActividad(Actividad ac) {
            s1 = HibernateUtil.getSessionFactory().getCurrentSession();

        s1.beginTransaction();

        s1.update(ac);

        s1.getTransaction().commit();
    }





}
