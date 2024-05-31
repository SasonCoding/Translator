package com.TravelFactory.Translator.Repository;

import com.TravelFactory.Translator.Model.TranslationKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationKeyRepository extends CrudRepository<TranslationKey, Long> {
}