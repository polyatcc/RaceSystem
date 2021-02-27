package vehicles

import vehicles.AirVehicle.Companion.reduceByPercent
import kotlin.math.floor

val magicCarpet =
    AirVehicle("Magic carpet", 10.0) { distance ->
        val percent = when {
            distance <= 1000 -> 0.0
            distance <= 5000 -> 3.0
            distance <= 10000 -> 10.0
            else -> 5.0
        }
        reduceByPercent(distance, percent)
    }

val mortar =
    AirVehicle("Mortar (Stupa)", 8.0) { distance ->
        reduceByPercent(distance, 6.0)
    }

val broom =
    AirVehicle("Broom", 20.0) { dist ->
        val steps = floor(dist / 1000).toInt()
        if (steps >= 100) {
            10.0 * 99 * 100 / 2
        } else {
            dist - 10.0 * steps * (steps + 1) / 2
        }
    }