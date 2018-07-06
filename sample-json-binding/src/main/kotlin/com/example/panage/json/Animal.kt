package com.example.panage.json

enum class Animal(val label: String) {
    ALPACA("アルパカ"),
    BEAR("クマ"),
    CAT("ネコ"),
    DOG("イヌ");

    companion object {
        private val animals = Animal.values()

        fun fromName(name: String): Animal {
            return animals.find { it.name == name } ?: throw IllegalArgumentException("Invalid name: $name.")
        }
    }
}
