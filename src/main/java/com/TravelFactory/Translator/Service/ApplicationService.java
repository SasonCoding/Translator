package com.TravelFactory.Translator.Service;

import com.TravelFactory.Translator.Model.Application;
import com.TravelFactory.Translator.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return StreamSupport
                .stream(applicationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Application getApplicationById(Long id) throws NoSuchElementException {
        return applicationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Application not found"));
    }

    public Application saveApplication(Application application) { return applicationRepository.save(application); }

    public void deleteApplication(Long id) { applicationRepository.deleteById(id); }
}
