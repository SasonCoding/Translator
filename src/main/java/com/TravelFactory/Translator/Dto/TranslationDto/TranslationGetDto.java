package com.TravelFactory.Translator.Dto.TranslationDto;

import lombok.Data;

@Data
public class TranslationGetDto {
    private Long id;
    private String languageCode;
    private String text;
}
