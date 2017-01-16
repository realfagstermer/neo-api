package no.uio.neo.dao;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import no.uio.neo.model.Concept;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/WEB-INF/mvc-dispatcher-servlet-test.xml"
})
@Rollback
@Transactional
// @WebAppConfiguration
public class ConceptDAOTest {

    @Autowired
    private ConceptDAO conceptDAO;

    @Test
    public void saveAndGetConcept() {
        Concept concept = new Concept();
        int id = conceptDAO.saveConcept(concept);
        Concept test = conceptDAO.getConcept(id);
        assertEquals(concept, test);
    }

    @Test
    public void getAllConcepts() {
        final Concept concept = new Concept();
        final Concept concept2 = new Concept();
        conceptDAO.saveConcept(concept);
        conceptDAO.saveConcept(concept2);
        Collection<Concept> test = conceptDAO.getAllConcepts();
        assertTrue(test.size() >= 2);
        assertTrue(test.contains(concept));
        assertTrue(test.contains(concept2));
    }

    @Test
    public void delConcept() {
        Concept concept = new Concept();
        int id = conceptDAO.saveConcept(concept);
        conceptDAO.delConcept(concept);
        assertNull(conceptDAO.getConcept(id));
    }

}
