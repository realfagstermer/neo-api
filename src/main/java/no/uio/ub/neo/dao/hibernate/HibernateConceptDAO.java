package no.uio.ub.neo.dao.hibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import no.uio.ub.neo.dao.ConceptDAO;
import no.uio.ub.neo.model.Concept;

public class HibernateConceptDAO implements ConceptDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Concept getConcept(int id) {
	return sessionFactory.getCurrentSession().get(Concept.class, id);
    }

    @Override
    public int saveConcept(Concept concept) {
	return (Integer) sessionFactory.getCurrentSession().save(concept);
    }

    @Override
    public Collection<Concept> getAllConcepts() {
	Session session = sessionFactory.getCurrentSession();
	Query<Concept> query = session.getNamedQuery("Concept.findAll");
	return query.list();

    }

    @Override
    public void delConcept(Concept concept) {
	sessionFactory.getCurrentSession().delete(concept);
    }

}
