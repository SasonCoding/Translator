package com.TravelFactory.Translator.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TranslationKeysMapper {
    TranslationKeysMapper INSTANCE = Mappers.getMapper(TranslationKeysMapper.class);
}
