package com.TravelFactory.Translator.Controller;

import com.TravelFactory.Translator.Model.TranslationKey;
import com.TravelFactory.Translator.Service.TranslationKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translation-keys")
public class TranslationKeyController {
    @Autowired
    private TranslationKeyService translationKeyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<TranslationKey>> findTranslationKeys() {
        return ResponseEntity.ok(translationKeyService.getAllTranslationKeys());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TranslationKey> findTranslationKey(@PathVariable("id") Long id) {
        return ResponseEntity.ok(translationKeyService.getTranslationKeyById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<TranslationKey> createTranslationKey(@RequestBody TranslationKey translationKey) {
        return ResponseEntity.ok(translationKeyService.saveTranslationKey(translationKey));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTranslationKey(@PathVariable("id") Long id) {
        translationKeyService.deleteTranslationKey(id);
        return new ResponseEntity<>("TranslationKey with the id: " + id + " was successfully deleted", HttpStatus.OK);
    }
}