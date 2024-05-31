package com.TravelFactory.Translator.Dto.ApplicationDto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ApplicationPostDto {
    @NotNull
    private String name;
}
