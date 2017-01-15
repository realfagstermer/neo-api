package no.uio.neo.service;

import java.util.Collection;
import java.util.Locale;

import no.uio.neo.model.Concept;

public interface ConceptService {
    Collection<Concept> getAllConcepts();

    void delConcept(int conceptId);

    Concept getConcept(int conceptId);

    Collection<Concept> getConceptsMatching(String term, Locale lang);
}
