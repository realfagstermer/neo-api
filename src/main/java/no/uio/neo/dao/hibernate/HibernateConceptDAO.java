package no.uio.neo.dao.hibernate;

import java.util.Collection;
import java.util.Locale;

import javax.persistence.criteria.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import no.uio.neo.dao.ConceptDAO;
import no.uio.neo.model.Concept;
import no.uio.neo.model.Concept_;
import no.uio.neo.model.Term;
import no.uio.neo.model.Term_;

@Repository
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
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Concept> query = builder.createQuery(Concept.class);
        Root<Concept> concept = query.from(Concept.class);
        query.select(concept);
        return session.createQuery(query).getResultList();
    }

    @Override
    public Collection<Concept> getConceptsWithTerm(String term, Locale lang) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Concept> query = builder.createQuery(Concept.class);
        Root<Concept> concept = query.from(Concept.class);

        // terms are in a separate table, we need to join
        Join<Concept, Term> join = concept.join(Concept_.terms);
        query.select(concept).distinct(true);

        // lowercase both sides of comparison, for case insensitive search
        Predicate matches = builder.like(builder.lower(join.get(Term_.lexicalValue)), term.toLowerCase());

        // optionally narrow to specified lang
        if (lang != null) {
            matches = builder.and(matches, join.get(Term_.langId).in(lang.getLanguage()));
        }

        return session.createQuery(query.where(matches)).getResultList();
    }

    @Override
    public void delConcept(Concept concept) {
        sessionFactory.getCurrentSession().delete(concept);
    }

}
