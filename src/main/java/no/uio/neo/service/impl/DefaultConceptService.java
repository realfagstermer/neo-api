package no.uio.neo.service.impl;

import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.uio.neo.dao.ConceptDAO;
import no.uio.neo.dao.TermDAO;
import no.uio.neo.model.Concept;
import no.uio.neo.service.ConceptService;

@Transactional
@Service
public class DefaultConceptService implements ConceptService {
    @Autowired
    private ConceptDAO conceptDAO;

    @Autowired
    private TermDAO termDAO;

    @Override
    public Collection<Concept> getAllConcepts() {
        return conceptDAO.getAllConcepts();
    }

    @Override
    public void delConcept(int conceptId) {
        final Concept concept = conceptDAO.getConcept(conceptId);
        conceptDAO.delConcept(concept);
    }

    @Override
    public Concept getConcept(int conceptId) {
        return conceptDAO.getConcept(conceptId);
    }

    @Override
    public Collection<Concept> getConceptsMatching(String term, Locale lang) {
        return conceptDAO.getConceptsWithTerm(term, lang);
    }

    @Override
    public int addConcept(Concept concept) {
        return conceptDAO.saveConcept(concept);
    }

}
