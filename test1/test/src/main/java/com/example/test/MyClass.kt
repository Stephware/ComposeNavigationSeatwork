package com.example.test

fun main(){
    val name: String = "Stephen"
    var age: Int = 20
    age = 34


    println("Name: " + name)
    println("Age: " + age)


    println("Name: $name")
    println("Age: $age" )


    var char: Char = 'A'
    var longVar = 123456789L
    var myDouble = 10.50
    var myFloat = 12.122F
    var conditional = true


    var firstName = "Jan"
    var lastName = "Vince"


    println("Full Name: $firstName $lastName" )
    println("Name Length:  ${firstName.length} ")


    val score = 74


    if(score >= 75){
        println("Passed")
    }else{
        println("Failed")
    }


    val rating = if (score >= 75) {"Passed"} else {"Failed"}
    println(rating)


    val day = 8


    when (day) {
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        6 -> println("Saturday")
        7 -> println("Sunday")
        else -> println("Out of bounds")
    }


    var dayName =  when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "Out of bounds"
    }


    for (i in 1..5){
        println(i)
    }


    var counter = 1


    while(counter<=5){
        println("counter: $counter")
        counter++
    }


    counter = 1


    do{
        println("Number: $counter")
        counter++
    }while (counter <=5)


    val value : Any = true


    if(value is String){
        println(value.length)
        println(value.uppercase())
    }else if (value is Int){
        println(value.inc())
    }else if(value is Char){
        print(value.uppercase())
    }else if(value is Boolean){
        println(value)
    }


    var message: String? = null


    if (message != null){
        println(message)
    }


    println(message?.length)


    val messageLength = message?.length ?: 0
}

