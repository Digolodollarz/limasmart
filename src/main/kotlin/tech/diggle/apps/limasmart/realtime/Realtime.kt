package tech.diggle.apps.limasmart.realtime

import java.util.*
import javax.persistence.Id

class Realtime {
    //    @Id
    var _id: String? = null
    var updatedAt: Date? = null
    var createdAt: Date? = null
    var marker: Int? = null
    var temp: Int? = null
    var humidity: Int? = null
    var radiation: Int? = null
    var rain: Int? = null
    var moisture: Int? = null
    var wind: Int? = null
    var pH: Int? = null
    var lat: Float? = null
    var lng: Float? = null
    var __v: Int? = null

    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String {
        return "Marker " + this.marker + this.createdAt
    }

    fun add(real2: Realtime) {
        temp = temp!! + real2.temp!!
        humidity = humidity!! + real2.humidity!!
        radiation = radiation!! + real2.radiation!!
        moisture = moisture!! + real2.moisture!!
        rain = rain!! + real2.rain!!
        wind = wind!! + real2.wind!!
        pH = pH!! + real2.pH!!
    }

    fun average(size: Int) {
        temp = temp!! / size
        humidity = humidity!! / size
        radiation = radiation!! / size
        moisture = moisture!! / size
        rain = rain!! / size
        wind = wind!! / size
        pH = pH!! / size
    }
}