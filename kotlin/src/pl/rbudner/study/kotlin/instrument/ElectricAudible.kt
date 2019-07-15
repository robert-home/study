package pl.rbudner.study.kotlin.instrument

import pl.rbudner.study.kotlin.instrument.Audible

interface ElectricAudible: Audible {
    fun plugIn()
    fun unplug()
}
