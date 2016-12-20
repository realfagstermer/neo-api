package no.uio.ub.neo.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import no.uio.ub.neo.model.Concept;
import no.uio.ub.neo.service.ConceptService;

@Controller
public class ConceptController {
    @Autowired
    private ConceptService conceptService;

    @RequestMapping(value = "/api/concept", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Concept> getAllConcepts(HttpServletRequest request, HttpServletResponse response) {
	return conceptService.getAllConcepts();
    }

    @RequestMapping(value = "/api/concept/{conceptId}", method = RequestMethod.GET)
    @ResponseBody
    public Concept getConcept(@PathVariable("conceptId") int conceptId, HttpServletRequest request, HttpServletResponse response) {
	return conceptService.getConcept(conceptId);
    }

}
