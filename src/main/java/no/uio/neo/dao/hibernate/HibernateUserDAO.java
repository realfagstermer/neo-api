package no.uio.neo.dao.hibernate;

import java.util.Collection;

import javax.persistence.criteria.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import no.uio.neo.dao.UserDAO;
import no.uio.neo.model.User;
import no.uio.neo.model.User_;

@Repository
public class HibernateUserDAO implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user);
        query.where(builder.equal(user.get(User_.username), username));
        return session.createQuery(query).uniqueResult();
    }

    @Override
    public User getUser(int id) {
        final User user = sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public int saveUser(User user) {
        return (Integer) sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Collection<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user);
        return session.createQuery(query).getResultList();
    }

    @Override
    public void delUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User updateUser(User user) {
        return (User) sessionFactory.getCurrentSession().merge(user);
    }

}
