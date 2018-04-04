package tech.diggle.apps.limasmart.disease

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Disease {
    @Id
    val number: Long = 0

    var crop: String? = null
    var disease: String? = null
    var rainfall: Int? = null
    var temperature: Int? = null
    var radiation: Int? = null
    var moisture: Int? = null
    var humidity: Int? = null
    var windspeed: Int? = null

    //    Sir Munde named the database improperly
    @Column(name = "sympton")
    var symptom: String? = null
    var chemical: String? = null
    var price: Int? = null
}