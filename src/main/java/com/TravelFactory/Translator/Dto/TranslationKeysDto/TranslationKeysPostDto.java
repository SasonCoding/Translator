package com.TravelFactory.Translator.Dto.TranslationKeysDto;

import com.TravelFactory.Translator.Dto.TranslationDto.TranslationGetDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class TranslationKeysPostDto {
    @NotNull
    private String key;
    @NotNull
    private Long applicationId;
    @NotNull
    private List<TranslationGetDto> translationGetDtoList;
}
