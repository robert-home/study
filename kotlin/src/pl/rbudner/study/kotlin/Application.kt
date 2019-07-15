package pl.rbudner.study.kotlin

import pl.rbudner.study.kotlin.instrument.guitars.ElectricGuitar
import pl.rbudner.study.kotlin.instrument.guitars.overdrive

fun maxOf(a: Int, b: Int = 10) = if (a > b) a else b
fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null
    // `obj` is automatically cast to `String` in this branch
    return obj.length
}

val items = listOf("apple", "banana", "kiwifruit")
val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
val customer = Customer("robert", "robert@gmail.com")

fun surprise(a: Int, b: Int): Boolean? = if (a > b) true else null

fun main(args: String) {
    println(maxOf(3, 4))
    println(getStringLength(4))
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    println(customer)
    println(customer.component1())

    println(maxOf(3))

    val filtered = items.filter { it.startsWith("a") }

    println("Name $filtered")

    var b: kotlin.Boolean?
    b = surprise(5, 5)

    var a: kotlin.Boolean? = true
    a = b.also { b = a }

    Application().playGuitar()
}

class Application {
    fun playGuitar() {
        val guitar = ElectricGuitar()
        guitar.overdrive(19)
    }
}
