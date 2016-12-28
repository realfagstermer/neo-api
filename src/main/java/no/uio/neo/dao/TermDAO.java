package no.uio.neo.dao;

import java.util.Collection;

import no.uio.neo.model.Term;

public interface TermDAO {
    /**
     * return a term
     *
     * @param id the id of the term
     * @return the term
     */
    Term getTerm(int id);

    /**
     * save a term
     *
     * @param term the term to be saved
     * @return the new id generated
     */
    int saveTerm(Term term);

    /**
     * Returns all terms
     *
     * @return Collection of all terms
     */
    Collection<Term> getAllTerms();

    /**
     * Delete a term from the database
     *
     * @param term the term to delete
     */
    void delTerm(Term term);
}
