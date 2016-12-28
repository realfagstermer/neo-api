package no.uio.neo.dao.hibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.uio.neo.dao.TermDAO;
import no.uio.neo.model.Term;

@Component("termDAO")
public class HibernateTermDAO implements TermDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Term getTerm(int id) {
	final Term term = sessionFactory.getCurrentSession().get(Term.class, id);
//	Hibernate.initialize(term.getTerms());
	return term;
    }

    @Override
    public int saveTerm(Term term) {
	return (Integer) sessionFactory.getCurrentSession().save(term);
    }

    @Override
    public Collection<Term> getAllTerms() {
	Session session = sessionFactory.getCurrentSession();
	Query<Term> query = session.createQuery("from Term");
	return query.list();

    }

    @Override
    public void delTerm(Term term) {
	sessionFactory.getCurrentSession().delete(term);
    }

}
