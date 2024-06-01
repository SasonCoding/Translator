package com.TravelFactory.Translator.Service;

import com.TravelFactory.Translator.Dto.TranslationDto.TranslationPostDto;
import com.TravelFactory.Translator.Dto.TranslationKeysDto.TranslationKeysGetDto;
import com.TravelFactory.Translator.Mapper.TranslationMapper;
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
    @Autowired
    private TranslationMapper translationMapper;

    public List<TranslationKeysGetDto> getAllTranslation() {
        List<Translation> translationList = StreamSupport
                .stream(translationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return translationMapper.translationGetDtos(translationList);
    }

    public Translation getTranslationById(Long id) throws NoSuchElementException {
        return translationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Translation not found with id: " + id));
    }

    public Translation saveTranslation(Translation translation) { return translationRepository.save(translation); }

    public List<Translation> saveTranslations(List<Translation> translations) {
        return (List<Translation>) translationRepository.saveAll(translations);
    }

    public void deleteTranslation(Long id) { translationRepository.deleteById(id); }
}
