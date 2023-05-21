package ru.vitnine.aggregationservice.configuration

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import jakarta.annotation.PostConstruct
import org.bson.types.Binary
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoClientFactoryBean
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import java.nio.ByteBuffer
import java.util.*
import java.util.Arrays.asList


@Configuration
class MongoConfig(
    private val mappingMongoConverter: MappingMongoConverter,

    @Value("\${spring.data.mongodb.host}")
    private val mongoHost: String,

    @Value("\${spring.data.mongodb.port}")
    private val mongoPort: Int,

    @Value("\${spring.data.mongodb.database}")
    private val database: String,

) {

    @PostConstruct
    fun setUpMongoEscapeCharacterConversion() {
        mappingMongoConverter.setTypeMapper(DefaultMongoTypeMapper(null))
    }

    @Bean
    fun mongoTemplate(mongoClient: MongoClient): MongoTemplate {
        val template = MongoTemplate(mongoClient, database)
        val mmc = template.converter as MappingMongoConverter
        mmc.customConversions = MongoCustomConversions(
            asList(
                BinaryToUuidConverter(),
//                UuidToBinaryConverter()
            )
        )
        mmc.afterPropertiesSet()
        return template
    }


    class BinaryToUuidConverter : Converter<Binary, UUID> {
        override fun convert(binary: Binary): UUID {
            val byteBuffer: ByteBuffer = ByteBuffer.wrap(binary.getData())
            val high: Long = byteBuffer.getLong()
            val low: Long = byteBuffer.getLong()
            return UUID(high, low)
        }
    }

//    class UuidToBinaryConverter : Converter<UUID, Binary> {
//        override fun convert(uuid: UUID): Binary {
//            val bb: ByteBuffer = ByteBuffer.wrap(ByteArray(16))
//            bb.putLong(uuid.mostSignificantBits)
//            bb.putLong(uuid.leastSignificantBits)
//            return Binary(bb.array())
//        }
//    }
}
