package no.uio.ub.neo.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Component;

import no.uio.ub.neo.model.Concept;
import no.uio.ub.neo.service.ConceptService;

@Component("conceptService")
public class DefaultConceptService implements ConceptService {

    @Override
    public Collection<Concept> getAllConcepts() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delConcept(int conceptId) {
	// TODO Auto-generated method stub

    }

    @Override
    public Concept getConcept(int conceptId) {
	// TODO Auto-generated method stub
	return null;
    }

}
