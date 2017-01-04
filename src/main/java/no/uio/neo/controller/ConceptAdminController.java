package no.uio.neo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no.uio.neo.model.Concept;
import no.uio.neo.service.ConceptService;

@RestController
public class ConceptAdminController {
    @Autowired
    private ConceptService conceptService;

    @RequestMapping(value = "/concepts", method = RequestMethod.POST)
    public Concept createConcept(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @RequestMapping(value = "/concepts/{conceptId}", method = RequestMethod.DELETE)
    public Concept deleteConcept(@PathVariable("conceptId") int conceptId, HttpServletRequest request, HttpServletResponse response) {
        conceptService.delConcept(conceptId);
        return null;
    }

}
