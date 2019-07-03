fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

val a: Int = 0
val b = 2
val c = 'a'

fun main() {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    println(sum2(4 , 7))
    println(printSum(32,55))

    val d: Int
    d = 3
    println("a = $a, b = $b, c = $c, d = $d")

    var x: Int = 3
    x++
    println("variable x = ${++x}")

    if (b > a) {
        println("b greater than a")
    } else {
        println("a greater than b")
    }
}
