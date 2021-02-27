import race.*
import vehicles.*
import java.lang.IllegalStateException

fun main() {

    val groundRace = GroundRace(10000.0)

    groundRace.apply {
        register(bovineCamel)
        register(centaur)
        register(speedBoots)
    }
    println(groundRace.run())

    val airRace = AirRace(10000.0)
    airRace.apply {
        register(magicCarpet)
        register(broom)
    }
    println(airRace.run())

    val commonRace = CommonRace(4000.0)
    commonRace.apply {
        register(dromedary)
        register(mortar)
        register(centaur)
        register(broom)
    }
    println(commonRace.run())

}