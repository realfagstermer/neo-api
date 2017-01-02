package no.uio.neo.dao.hibernate;

import java.util.Collection;

import javax.persistence.criteria.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.uio.neo.dao.ConceptDAO;
import no.uio.neo.model.Concept;
import no.uio.neo.model.Concept_;
import no.uio.neo.model.Term;
import no.uio.neo.model.Term_;

@Component("conceptDAO")
public class HibernateConceptDAO implements ConceptDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Concept getConcept(int id) {
        final Concept concept = sessionFactory.getCurrentSession().get(Concept.class, id);
        // Hibernate.initialize(concept.getTerms());
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
    public Collection<Concept> getConceptsWithTerm(String term) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Concept> query = builder.createQuery(Concept.class);
        Root<Concept> concept = query.from(Concept.class);

        //terms are in a separate table, we need to join
        Join<Concept, Term> join = concept.join(Concept_.terms);
        query.select(concept).distinct(true);

        // lowercase both sides of comparison, for case insensitive search
        query.where(builder.like(builder.lower(join.get(Term_.lexicalValue)), "%" + term.toLowerCase() + "%"));
        Collection<Concept> result = session.createQuery(query).getResultList();
        return result;
    }

    @Override
    public void delConcept(Concept concept) {
        sessionFactory.getCurrentSession().delete(concept);
    }

}
