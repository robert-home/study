package pl.rbudner.study.kotlin

fun maxOf(a: Int, b: Int = 10) = if (a > b) a else b
fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null
    // `obj` is automatically cast to `String` in this branch
    return obj.length
}

val items = listOf("apple", "banana", "kiwifruit")
val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
val customer = Customer("robert", "robert@gmail.com")

fun main() {
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
}
class Application {

}
