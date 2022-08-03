package com.example.playground.content.enum

enum class Alphabet(val key: String) {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G");


    companion object{

        fun getFromKey(key: String): Alphabet {
            return values().first { it.key == key }
        }

        fun gets() = values()
    }
}