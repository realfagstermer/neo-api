package no.uio.ub.neo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import no.uio.ub.neo.service.ConceptService;

@Controller
public class ConceptController {
    @Autowired
    ConceptService conceptService;

}
