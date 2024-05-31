package com.TravelFactory.Translator.Repository;

import com.TravelFactory.Translator.Model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
