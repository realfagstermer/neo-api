package no.uio.neo.dao;

import java.util.Collection;

import no.uio.neo.model.Concept;

public interface ConceptDAO {
    /**
     * return a concept
     *
     * @param id the id of the concept
     * @return the concept
     */
    Concept getConcept(int id);

    /**
     * save a concept
     *
     * @param concept the concept to be saved
     * @return the new id generated
     */
    int saveConcept(Concept concept);

    /**
     * Returns all concepts
     *
     * @return Collection of all concepts
     */
    Collection<Concept> getAllConcepts();

    /**
     * Delete a concept from the database
     *
     * @param concept the concept to delete
     */
    void delConcept(Concept concept);

    /**
     * search for concepts with terms matching term
     *
     * @param term search string
     * @return Collection of matching concepts
     */
    Collection<Concept> getConceptsWithTerm(String term);
}
