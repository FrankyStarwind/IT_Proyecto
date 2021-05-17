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

}
