package com.myapp.candles.utils

import java.util.*

class Utilities {

    fun stringToUUID(someString: String?) : UUID {
        return UUID.fromString(someString)
    }

    fun uuidToString(uuid: UUID?) : String {
        return uuid.toString()
    }
}