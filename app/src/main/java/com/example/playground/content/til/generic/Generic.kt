package com.example.playground.content.til.generic


open class Animal

class Pig: Animal()

class Coffee<T>

fun main() {
    val animal1: Animal = Pig()
//    val animal2: Pig = Animal() // Error

    // 자료형 불일치
//    val animal3: Coffee<Animal> = Coffee<Pig>() // Error
//    val animal4: Coffee<Pig> = Coffee<Animal>() // Error

    val animal5: Coffee<Pig> = Coffee<Pig>()
}


////////////////////////////////////////////////////////////
// 무변성
// c<T> 와 c<T`>는 아무 관계가 없다.
////////////////////////////////////////////////////////////
class Box<T>(val size: Int)

fun main2() {
//    val anys: Box<Any> = Box<Int>(1) // 자료형 불일치로 인한 Error
//    val nothings: Box<Nothing> = Box<Int>(1) // 자료형 불일치로 인한 Error
}

////////////////////////////////////////////////////////////
// 공변성
//  T` 가 T의 하위 자료형이면 C<T`>는 C<T>의 하위 자료형이다.
////////////////////////////////////////////////////////////
class OutBox<out T>(val size: Int)

fun main3() {
    val anys2: OutBox<Any> = OutBox<Int>(1)
//    val nothings2: OutBox<Nothing> = OutBox<Int>(1) // 자료형 불일치로 인한 Error
}

////////////////////////////////////////////////////////////
// 반공변성
//  T` 가 T의 하위 자료형이면 C<T>는 C<T`>의 하위 자료형이다.
////////////////////////////////////////////////////////////
class InBox<in T>(val size: Int)

fun main4() {
//    val anys3: InBox<Any> = InBox<Int>(1) // 자료형 불일치로 인한 Error
    val nothings3: InBox<Nothing> = InBox<Int>(1)
}