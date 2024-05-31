package com.TravelFactory.Translator.Service;

import com.TravelFactory.Translator.Model.TranslationKey;
import com.TravelFactory.Translator.Repository.TranslationKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TranslationKeyService {
    @Autowired
    private TranslationKeyRepository translationKeyRepository;

    public List<TranslationKey> getAllTranslationKeys() {
        return StreamSupport
                .stream(translationKeyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public TranslationKey getTranslationKeyById(Long id) throws NoSuchElementException {
        return translationKeyRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("TranslationKey not found with id: " + id);
        });
    }

    public TranslationKey saveTranslationKey(TranslationKey translationKey) { return translationKeyRepository.save(translationKey); }

    public void deleteTranslationKey(Long id) { translationKeyRepository.deleteById(id); }
}
