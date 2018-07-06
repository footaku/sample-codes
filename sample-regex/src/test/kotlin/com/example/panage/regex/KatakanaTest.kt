package com.example.panage.regex

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class KatakanaTest {

    @ParameterizedTest
    @ValueSource(strings = [
        "アイウエオ", "カキクケコ", "サシスセソ", "タチツテト", "ナニヌネノ", "ハヒフヘホ", "マミムメモ",
        "ヤユヨ", "ラリルレロ", "ワヲン", "ガギグゲゴ", "ザジズゼゾ", "ダヂヅデド", "バビブベボ", "パピプペポ",
        "ァィゥェォヵヶッャュョヮ"
    ])
    fun testValidate(input: String) {
        Assertions.assertTrue(Katakana.validate(input))
    }
}
