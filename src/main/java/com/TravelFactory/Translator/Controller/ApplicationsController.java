package com.TravelFactory.Translator.Controller;

import com.TravelFactory.Translator.Model.Application;
import com.TravelFactory.Translator.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Application>> findApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Application> findApplication(@PathVariable("id") Long id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        return ResponseEntity.ok(applicationService.saveApplication(application));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteApplication(@PathVariable("id") Long id) {
        applicationService.deleteApplication(id);
        return new ResponseEntity<>("Application with the id: " + id + " was successfully deleted", HttpStatus.OK);
    }
}