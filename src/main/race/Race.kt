package race

import vehicles.AirVehicle
import vehicles.GroundVehicle
import vehicles.Vehicle

sealed class Race(private val distance: Double) {

    private val vehicles = HashSet<Vehicle>()

    class VehicleAlreadyRegisteredException(vehicle: Vehicle) :
        IllegalArgumentException("Vehicle '$vehicle' is already registered on this race")

    class NoRegisteredVehiclesException :
        IllegalStateException("No vehicles are registered for this race")

    protected open fun register(vehicle: Vehicle) {
        if (vehicle in vehicles) { //подклассы и поля
            throw VehicleAlreadyRegisteredException(vehicle)
        }
        vehicles.add(vehicle)
    }

    fun run(): Pair<Vehicle, Double> {
        val winner = vehicles.minByOrNull { vehicle -> vehicle.travellingTime(distance) }
            ?: throw NoRegisteredVehiclesException()
        return winner to winner.travellingTime(distance)
    }

}

class GroundRace(distance: Double) : Race(distance) {
    fun register(vehicle: GroundVehicle) {
        super.register(vehicle)
    }
}

class AirRace(distance: Double) : Race(distance) {
    fun register(vehicle: AirVehicle) {
        super.register(vehicle)
    }
}

class CommonRace(distance: Double) : Race(distance) {
    public override fun register(vehicle: Vehicle) {
        super.register(vehicle)
    }

}
