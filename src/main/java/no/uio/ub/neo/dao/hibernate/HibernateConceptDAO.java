package no.uio.ub.neo.dao.hibernate;

import java.util.Collection;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.uio.ub.neo.dao.ConceptDAO;
import no.uio.ub.neo.model.Concept;

@Component("conceptDAO")
public class HibernateConceptDAO implements ConceptDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Concept getConcept(int id) {
	final Concept concept = sessionFactory.getCurrentSession().get(Concept.class, id);
//	Hibernate.initialize(concept.getTerms());
	return concept;
    }

    @Override
    public int saveConcept(Concept concept) {
	return (Integer) sessionFactory.getCurrentSession().save(concept);
    }

    @Override
    public Collection<Concept> getAllConcepts() {
	Session session = sessionFactory.getCurrentSession();
	Query<Concept> query = session.createQuery("from Concept");
	return query.list();

    }

    @Override
    public void delConcept(Concept concept) {
	sessionFactory.getCurrentSession().delete(concept);
    }

}
