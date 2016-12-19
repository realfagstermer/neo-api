package no.uio.ub.neo.service;

import java.util.Collection;

import no.uio.ub.neo.model.Concept;

public interface ConceptService {
    Collection<Concept> getAllConcepts();

    void delConcept(int conceptId);

    Concept getConcept(int conceptId);
}
