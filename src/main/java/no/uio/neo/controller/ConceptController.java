package no.uio.neo.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no.uio.neo.model.Concept;
import no.uio.neo.service.ConceptService;

@RestController
public class ConceptController {
    @Autowired
    private ConceptService conceptService;

    @RequestMapping(value = "/concept", method = RequestMethod.GET)
    public Collection<Concept> getAllConcepts(HttpServletRequest request, HttpServletResponse response) {
	return conceptService.getAllConcepts();
    }

    @RequestMapping(value = "/concept/{conceptId}", method = RequestMethod.GET)
    public Concept getConcept(@PathVariable("conceptId") int conceptId, HttpServletRequest request, HttpServletResponse response) {
	return conceptService.getConcept(conceptId);
    }

}
