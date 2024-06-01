package com.TravelFactory.Translator.Controller;

import com.TravelFactory.Translator.Dto.TranslationKeysDto.TranslationKeysGetDto;
import com.TravelFactory.Translator.Dto.TranslationKeysDto.TranslationKeysPostDto;
import com.TravelFactory.Translator.Service.TranslationKeyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/translation-keys")
public class TranslationKeyController {
    @Autowired
    private TranslationKeyService translationKeyService;

    //TODO: The translations isn't retrieving currently.
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<TranslationKeysGetDto>> findTranslationKeys() {
        return ResponseEntity.ok(translationKeyService.getAllTranslationKeys());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TranslationKeysGetDto> findTranslationKey(@PathVariable("id") Long id) {
        return ResponseEntity.ok(translationKeyService.getTranslationKeyById(id));
    }

    @RequestMapping(value = "/{appId}", method = RequestMethod.POST)
    public ResponseEntity<TranslationKeysGetDto> createTranslationKey(@PathVariable Long appId, @RequestBody @Valid TranslationKeysPostDto translationKeysPostDto) {
        return ResponseEntity.ok(translationKeyService.saveTranslationKey(appId, translationKeysPostDto));
    }
//    @RequestMapping(value = "/{appId}/deploy", method = RequestMethod.POST)
//    public ResponseEntity<?> createApplication(@PathVariable Long appId, @RequestBody String translationKeyJson) throws JsonProcessingException {
//        translationKeyService.saveTranslationkeysJson(appId, translationKeyJson);
//        return ResponseEntity.ok("All good!");
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTranslationKey(@PathVariable("id") Long id) {
        translationKeyService.deleteTranslationKey(id);
        return new ResponseEntity<>("TranslationKey with the id: " + id + " was successfully deleted", HttpStatus.OK);
    }
}