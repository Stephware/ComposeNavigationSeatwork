package com.example.test

class Person(
    val name: String,
    var age: Int
) {
    fun introduce() {
        println("Hi, I am $name and I am $age years old.")
    }
}

fun main() {
    val person = Person("Stephen", 21)

    person.introduce()
}