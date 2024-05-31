package com.TravelFactory.Translator.Dto.ApplicationDto;

import com.TravelFactory.Translator.Dto.TranslationKeysDto.TranslationKeysGetDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class ApplicationListGetDto {
    private Long id;

    private String name;

    private String createdAt;

    @ToString.Exclude
    @JsonProperty("translationKeys")
    private List<TranslationKeysGetDto> translationKeysGetDtos;
}
