package no.uio.neo.controller;

import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no.uio.neo.model.Concept;
import no.uio.neo.service.ConceptService;

@RestController
@RequestMapping("/api/concepts")
public class ConceptController {
    private static Logger logger = Logger.getLogger(ConceptController.class);

    @Autowired
    private ConceptService conceptService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Concept> getAllConcepts(HttpServletRequest request, HttpServletResponse response) {
        Locale lang = null;
        String term = request.getParameter("term");

        if (request.getParameter("lang") != null) {
            String l = request.getParameter("lang").trim();

            // Ignore empty lang parameter
            if (!l.isEmpty()) {
                lang = new Locale(l);
            }
        }

        if (term != null && !term.trim().isEmpty()) {
            // replace wildcard * with SQL wildcard %
            term = term.trim().replace('*', '%');
            logger.info("Term search string: " + term);

            return conceptService.getConceptsMatching(term, lang);
        } else {
            return conceptService.getAllConcepts();
        }
    }

    @RequestMapping(value = "/{conceptId}", method = RequestMethod.GET)
    public Concept getConcept(@PathVariable("conceptId") int conceptId, HttpServletRequest request, HttpServletResponse response) {
        return conceptService.getConcept(conceptId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Concept createConcept(@RequestBody Concept concept) {
        int id = conceptService.addConcept(concept);
        return conceptService.getConcept(id);
    }

    @RequestMapping(value = "/{conceptId}", method = RequestMethod.DELETE)
    public Concept deleteConcept(@PathVariable("conceptId") int conceptId, HttpServletRequest request, HttpServletResponse response) {
        conceptService.delConcept(conceptId);
        return null;
    }
}
