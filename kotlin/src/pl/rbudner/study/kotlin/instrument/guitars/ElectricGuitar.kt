package pl.rbudner.study.kotlin.instrument.guitars

import pl.rbudner.study.kotlin.instrument.ElectricAudible

internal val NAME = "guitar"

class ElectricGuitar: ElectricAudible {

    private var plugged: Boolean = false

    override fun plugIn() {
        this.plugged = true
    }

    override fun unplug() {
        this.plugged = false
    }

    override var volume: Int = 0

    public var lenght: Int =  40
        private set

    class Str {
        fun jerk(): String  {
            return "Bzzzzz"
        }
    }

    override fun makeSound() {
        fun calculateWave(): String {
            fun pi() = 3.14
            return "wave" + pi()
        }
        println("bzzzzzz ${calculateWave()}")
    }
}

fun ElectricGuitar.overdrive(level: Int) {
    this.makeSound()
    val map: HashMap<String, String>
    // map.put("1", "2")
}

fun main(args: Array<String>) {
    val guitar = ElectricGuitar()
    guitar.overdrive(7)
}
