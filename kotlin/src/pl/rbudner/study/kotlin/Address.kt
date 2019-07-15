package pl.rbudner.study.kotlin

const val COLOR = "red"
const val TIMEOUT = 10
lateinit var a: Any

open class Address {
    var name = "kuku"
        set(name) {
            println("setting property name = $name")
            field = name
        }

    private val _today: String
    val yesterday: String
    lateinit var tomorrow: String

    init {
        yesterday = "Thursday"
        println("Global lateinit a = $a")
    }

    constructor() {
        _today = "Friday"
    }

    fun defaultAddress(): Address {
        val address = Address()
        // address.tomorrow = "Sunday"
        return address
    }
}

class BetterAddress: Address() {

}

fun copyAddress(address: Address): Address {
    return Address()
}

fun main(args: Array<String>) {
    val test = Address()
    println(test.name)
    test.name = "ryku"
    println(test.name)

}
