package no.uio.ub.neo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.uio.ub.neo.dao.ConceptDAO;
import no.uio.ub.neo.model.Concept;
import no.uio.ub.neo.service.ConceptService;

@Component("conceptService")
public class DefaultConceptService implements ConceptService {
    @Autowired
    private ConceptDAO conceptDAO;

    @Override
    public Collection<Concept> getAllConcepts() {
	return conceptDAO.getAllConcepts();
    }

    @Override
    public void delConcept(int conceptId) {
	// TODO Auto-generated method stub

    }

    @Override
    public Concept getConcept(int conceptId) {
	return conceptDAO.getConcept(conceptId);
    }

}
