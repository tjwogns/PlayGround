package com.example.playground.content.til.build


class Build {


}

class Pizza2 private constructor(
    val size: String,
    val cheese: Int,
    val olives: Int,
    val bacon: Int
) {
    class Builder(private val size: String) {
        private var cheese: Int = 0
        private var olives: Int = 0
        private var bacon: Int = 0

        fun setCheese(value: Int): Builder = apply {
            cheese = value
        }

        // ...

        fun build() = Pizza2(size, cheese, olives, bacon)
    }
}