package com.example.panage.json

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

class AnimalSerializer : StdSerializer<Animal>(Animal::class.java) {
    override fun serialize(animal: Animal, jsonGenerator: JsonGenerator, provider: SerializerProvider) {
        jsonGenerator.writeStartObject()
        jsonGenerator.writeStringField("name", animal.name)
        jsonGenerator.writeStringField("label", animal.label)
        jsonGenerator.writeEndObject()
    }
}
