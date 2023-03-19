package com.example.playground.content.til.effective

import java.util.regex.Matcher

data class FullName(
    var name: String,
    var surName: String
)

fun test () {
    val person = FullName("Jerry", "Seo")
    val s = mutableSetOf<FullName>()

    s.add(person)
    person.surName = "Kim"
    println(person)
    println(person in s)
    println(s.first() == person)
}