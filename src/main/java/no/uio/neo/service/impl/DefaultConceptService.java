package no.uio.neo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import no.uio.neo.dao.ConceptDAO;
import no.uio.neo.model.Concept;
import no.uio.neo.service.ConceptService;

@Transactional
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
