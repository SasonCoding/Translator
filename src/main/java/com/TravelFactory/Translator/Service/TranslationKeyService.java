package com.TravelFactory.Translator.Service;

import com.TravelFactory.Translator.Dto.TranslationDto.TranslationPostDto;
import com.TravelFactory.Translator.Dto.TranslationKeysDto.TranslationKeysGetDto;
import com.TravelFactory.Translator.Dto.TranslationKeysDto.TranslationKeysPostDto;
import com.TravelFactory.Translator.Mapper.TranslationKeysMapper;
import com.TravelFactory.Translator.Mapper.TranslationMapper;
import com.TravelFactory.Translator.Model.Application;
import com.TravelFactory.Translator.Model.Translation;
import com.TravelFactory.Translator.Model.TranslationKey;
import com.TravelFactory.Translator.Repository.ApplicationRepository;
import com.TravelFactory.Translator.Repository.TranslationKeyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TranslationKeyService {
    @Autowired
    private TranslationKeyRepository translationKeyRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private TranslationKeysMapper translationKeysMapper;
    @Autowired
    private TranslationService translationService;
    @Autowired
    private TranslationMapper translationMapper;

    public List<TranslationKeysGetDto> getAllTranslationKeys() {
        List<TranslationKey> translationKeyList = StreamSupport
                .stream(translationKeyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return translationKeysMapper.translationKeysGetDtos(translationKeyList);
    }

    public TranslationKeysGetDto getTranslationKeyById(Long id) throws NoSuchElementException {
        return translationKeysMapper.translationKeysGetDto(translationKeyRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("TranslationKey not found with id: " + id);
        }));
    }

    public List<TranslationKeysGetDto> getTranslationKeyByAppId(Long appId) {
        if(appId == null) throw new IllegalArgumentException("appId cannot be null");
        return translationKeysMapper.translationKeysGetDtos(translationKeyRepository.findByApplicationId(appId));
    }

    public TranslationKeysGetDto saveTranslationKey(Long appId, TranslationKeysPostDto translationKeysPostDto) {
        if (appId == null) {
            throw new NoSuchElementException("Application is missing");
        }
        applicationRepository.findById(appId).orElseThrow(() -> new NoSuchElementException("Application not found with id: " + appId));

        if(translationKeysPostDto.getTranslationSummaryDtos().isEmpty()) {
            throw new IllegalStateException("TranslationKeys must have at least one translation");
        }

        TranslationKey translationKey = TranslationKey.builder()
                .key(translationKeysPostDto.getKey())
                .application(Application.builder().id(appId).build())
                .build();

        // Maby add a try catch block.
        TranslationKey savedTranslationKey = translationKeyRepository.save(translationKey);

        List<Translation> translations = translationKeysPostDto.getTranslationSummaryDtos().stream()
                .map(translationSummaryDto -> {
                    Translation translation = translationMapper.toTranslationByTranslationSummary(translationSummaryDto);
                    translation.setTranslationKey(savedTranslationKey);
                    return translation;
                }).collect(Collectors.toList());

        List<Translation> translationList = translationService.saveTranslations(translations);
        savedTranslationKey.setTranslations(translationList);

        return translationKeysMapper.translationKeysGetDto(savedTranslationKey);
    }

//    public void saveTranslationkeysJson(Long id, String translationKeyJson) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readValue(translationKeyJson, TranslationKey[].class);
//    }

    public void deleteTranslationKey(Long id) { translationKeyRepository.deleteById(id); }
}
