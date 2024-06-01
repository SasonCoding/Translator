package com.TravelFactory.Translator.Mapper;

import com.TravelFactory.Translator.Dto.ApplicationDto.ApplicationGetDto;
import com.TravelFactory.Translator.Model.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
    ApplicationGetDto applicationGetDto(Application application);
    List<ApplicationGetDto> applicationGetDtos(List<Application> applications);
}
