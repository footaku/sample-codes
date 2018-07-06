package com.example.panage.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnimalTest {

    lateinit var objectMapper: ObjectMapper

    @BeforeAll
    internal fun setup() {
        objectMapper = ObjectMapper().registerModule(
                SimpleModule()
                        .addSerializer(Animal::class.java, AnimalSerializer())
                        .addDeserializer(Animal::class.java, AnimalDeserializer())
        )
    }

    @Test
    fun serializeTest() {
        // given
        val source = Animal.DOG
        val expected = """{"name":"${source.name}","label":"${source.label}"}"""

        // when
        val actual = objectMapper.writeValueAsString(source)

        // then
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun deserializeTest() {
        //given
        val expected = Animal.CAT
        val source = """{"name":"${expected.name}","label":"${expected.label}"}"""

        //when
        val actual = objectMapper.readValue(source, Animal::class.java)

        //then
        Assertions.assertEquals(expected, actual)
    }
}
