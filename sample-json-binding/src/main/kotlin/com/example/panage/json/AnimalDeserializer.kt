package com.example.panage.json

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer


class AnimalDeserializer : StdDeserializer<Animal>(Animal::class.java) {
    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): Animal {
        return jsonParser
                .takeIf { it.currentToken == JsonToken.START_OBJECT }?.readValueAsTree<JsonNode>()
                ?.takeIf { jsonNode -> jsonNode.has("name") }?.let { Animal.fromName(it.get("name").textValue()) }
                ?: throw IllegalStateException("JSON not readable.")
    }
}
