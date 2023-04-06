package com.example.playground.content.til.copy

import android.graphics.Color


data class InnerBox(var size: Int)
data class Box(var size: Int, var name: String, var subBox: InnerBox)

fun boxCopy() {

    val innerBox1 = InnerBox(10)

    val box1 = Box(10, "box1", innerBox1)
    val box2 = box1.copy(subBox = InnerBox(10))
    val box3 = box1.copy()
    val box4 = box1.copy(subBox = box1.subBox.copy())

    val result1 = box1.subBox === box2.subBox
    val result2 = box1.subBox === box3.subBox
    val result3 = box1.subBox === box4.subBox

    innerBox1.size = 9

    println("$result1")
    println("$result2")
    println("$result3")

    println("$box1")
    println("$box2")
    println("$box3")
    println("$box4")


    val degrees = 9

    val list1 = listOf(1, 2, 3, 4, 5, 6)
    val (odd, even) = list1.partition { it % 2 == 1 }
    val map = mapOf(1 to "KRW", 2 to "USD")

    val (description, color) = when {
        degrees < 5 -> "cold" to Color.BLUE
        degrees < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }


    data class FullName(
        val firstName: String,
        val lastName: String
    )

    fun String.parseName(): FullName? {
        val indexOfLastSpace = this.trim().lastIndexOf(' ')
        if(indexOfLastSpace < 0) return null
        val firstName = this.take(indexOfLastSpace)
        val lastName = this.drop(indexOfLastSpace)
        return FullName(firstName, lastName)
    }
    val fullName = "Marcin Moskala"
    val (abc, lastName) = fullName.parseName() ?: return

}

data class Player(
    val id: Int,
    val name: String,
    val position: String,
    val box: Box
)