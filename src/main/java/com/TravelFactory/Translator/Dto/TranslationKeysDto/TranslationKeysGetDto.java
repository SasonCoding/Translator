package com.TravelFactory.Translator.Dto.TranslationKeysDto;

import com.TravelFactory.Translator.Dto.TranslationDto.TranslationGetDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class TranslationKeysGetDto {
    private Long id;

    private String key;

    private String createdAt;

    @ToString.Exclude
    @JsonProperty("translations")
    private List<TranslationGetDto> translationGetDtos;
}
