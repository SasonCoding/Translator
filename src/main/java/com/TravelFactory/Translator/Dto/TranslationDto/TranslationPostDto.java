package com.TravelFactory.Translator.Dto.TranslationDto;

import com.TravelFactory.Translator.Model.Translation;
import com.TravelFactory.Translator.Model.TranslationKey;
import lombok.Data;

import java.util.Date;

@Data
public class TranslationPostDto {
    private Long translationKey;
    private String languageCode;
    private String text;

    @Override
    public boolean equals(Object object) {
        if(object instanceof Translation) {
            return ((Translation) object).getId().equals(this.getLanguageCode());
        }
        return false;
    }
}
