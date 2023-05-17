package ru.vitnine.aggregationservice.configuration

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter


@Configuration
class MongoConfig(
    private val mappingMongoConverter: MappingMongoConverter
) {

    @PostConstruct
    fun setUpMongoEscapeCharacterConversion() {
        mappingMongoConverter.setTypeMapper(DefaultMongoTypeMapper(null))
    }
}