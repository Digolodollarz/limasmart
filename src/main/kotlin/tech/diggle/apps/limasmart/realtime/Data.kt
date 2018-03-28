package tech.diggle.apps.limasmart.realtime

class Data {
    val data: List<Realtime>? = null

    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String {
        if (this.data == null) return "No data"
        var string = ""
        this.data.forEach { d -> string += d.toString() }
        return string

    }
}