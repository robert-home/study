package pl.rbudner.study.kotlin.nested

import java.util.function.Supplier

class Outer {
    private val outerMember: String = "outer private member"

    class Nested1 {
        fun action() = println("1. in nested class")
    }

    internal inner class Nested2 {
        fun action() = println("2. in inner nested class ${this@Outer}")
    }

    interface Provider {
        fun provide(): String
    }

    fun action(provider: Provider): String = "3. Outer action provides ${provider.provide()}"
    fun action(supplier: java.util.function.Supplier<String>): String = "4. Outer action provides ${supplier.get()}"
}

fun main(args: Array<String>) {
    Outer.Nested1().action()
    Outer().Nested2().action()

    println(Outer().action(
            object: Outer.Provider {
                override fun provide() = "anonymous provider"}
    ))

    println(Outer().action(Supplier { "anonymous supplier" }))

}
