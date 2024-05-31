package com.TravelFactory.Translator.Service;

import com.TravelFactory.Translator.Model.Translation;
import com.TravelFactory.Translator.Repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TranslationService {
    @Autowired
    private TranslationRepository translationRepository;

    public List<Translation> getAllTranslation() {
        return StreamSupport
                .stream(translationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Translation getTranslationById(Long id) throws NoSuchElementException {
        return translationRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Translation not found with id: " + id);
        });
    }

    public Translation saveTranslationKey(Translation translation) { return translationRepository.save(translation); }

    public void deleteTranslation(Long id) { translationRepository.deleteById(id); }
}
