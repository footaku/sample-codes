package com.example.panage.regex


class Katakana {
    companion object {
        fun validate(source: String): Boolean {
            return source.matches("""\p{InKatakana}+""".toRegex())
        }
    }
}
