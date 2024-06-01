package com.TravelFactory.Translator.Controller;

import com.TravelFactory.Translator.Dto.TranslationDto.TranslationPostDto;
import com.TravelFactory.Translator.Dto.TranslationKeysDto.TranslationKeysGetDto;
import com.TravelFactory.Translator.Model.Translation;
import com.TravelFactory.Translator.Service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {
    @Autowired
    private TranslationService translationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<TranslationKeysGetDto>> findTranslations() {
        return ResponseEntity.ok(translationService.getAllTranslation());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Translation> findTranslation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(translationService.getTranslationById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Translation> createTranslation(@RequestBody Translation translation) {
        return ResponseEntity.ok(translationService.saveTranslation(translation));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTranslation(@PathVariable("id") Long id) {
        translationService.deleteTranslation(id);
        return new ResponseEntity<>("Translation with the id: " + id + " was successfully deleted", HttpStatus.OK);
    }
}