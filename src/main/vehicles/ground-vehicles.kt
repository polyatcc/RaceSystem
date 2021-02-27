package vehicles

val bovineCamel =
    GroundVehicle("Bovine Camel", 10.0, 30.0) { iter ->
        when (iter) {
            1 -> 5.0
            else -> 8.0
        }
    }

val dromedary =
    GroundVehicle("Dromedary", 40.0, 10.0) { iter ->
        when (iter) {
            1 -> 5.0
            2 -> 6.5
            else -> 8.0
        }
    }

val centaur =
    GroundVehicle("Centaur", 15.0, 8.0) { _ -> 2.0 }

val speedBoots =
    GroundVehicle("Speed Boots", 6.0, 60.0) { iter ->
        when (iter) {
            1 -> 10.0
            else -> 5.0
        }
    }