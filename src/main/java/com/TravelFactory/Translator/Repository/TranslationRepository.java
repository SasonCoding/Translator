package com.TravelFactory.Translator.Repository;

import com.TravelFactory.Translator.Model.Translation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends CrudRepository<Translation, Long> {
}
