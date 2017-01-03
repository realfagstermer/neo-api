package no.uio.neo.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no.uio.neo.model.Concept;
import no.uio.neo.service.ConceptService;

@RestController
public class ConceptController {
    private static Logger logger = Logger.getLogger(ConceptController.class);

    @Autowired
    private ConceptService conceptService;

    @RequestMapping(value = "/concepts", method = RequestMethod.GET)
    public Collection<Concept> getAllConcepts(HttpServletRequest request, HttpServletResponse response) {
        String term = request.getParameter("term");

        if (term != null && !term.trim().isEmpty()) {
            // replace wildcard * with SQL wildcard %
            term = term.trim().replace('*', '%');
            logger.info("Term search string: "+ term);

            return conceptService.getConceptsMatching(term);
        } else {
            return conceptService.getAllConcepts();
        }
    }

    @RequestMapping(value = "/concepts/{conceptId}", method = RequestMethod.GET)
    public Concept getConcept(@PathVariable("conceptId") int conceptId, HttpServletRequest request, HttpServletResponse response) {
        return conceptService.getConcept(conceptId);
    }

}
