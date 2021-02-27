package vehicles

sealed class Vehicle(open val name: String, open val speed: Double) {
    abstract fun travellingTime(distance: Double): Double //наследники переопределят
}

data class GroundVehicle( //все поля конструктора поля
    override val name: String, override val speed: Double,
    val timeUntilRest: Double, val restTime: (Int) -> Double
) : Vehicle(name, speed) {

    override fun travellingTime(distance: Double): Double {
        var iter = 1
        var time = 0.0
        var dist = 0.0

        while (true) {
            if (dist + timeUntilRest * speed >= distance) {
                return time + (distance - dist) / speed
            }
            dist += timeUntilRest * speed
            time += timeUntilRest + restTime(iter)
            iter++
        }
    }

    override fun toString(): String { //изменяем станд функцию
        return "'$name'(GROUND,speed=$speed,timeUntilRest=$timeUntilRest)"
    }

}

data class AirVehicle( //равенство, хэши, стринги
    override val name: String, override val speed: Double,
    val reduceDistance: (Double) -> Double
) : Vehicle(name, speed) {

    companion object { //без объекта класса статик
        fun reduceByPercent(distance: Double, percent: Double) =
            distance / 100.0 * (100.0 - percent)
    }

    override fun travellingTime(distance: Double): Double {
        return reduceDistance(distance) / speed
    }

    override fun toString(): String {
        return "'$name'(AIR,speed=$speed)"
    }

}