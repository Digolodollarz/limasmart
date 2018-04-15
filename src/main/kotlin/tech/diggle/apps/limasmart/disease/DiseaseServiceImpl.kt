package tech.diggle.apps.limasmart.disease

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import tech.diggle.apps.limasmart.realtime.Data
import tech.diggle.apps.limasmart.realtime.Realtime
import tech.diggle.apps.limasmart.risk.Risk
import java.net.URI
import java.util.ArrayList

@Service
class DiseaseServiceImpl(val repository: DiseaseRepository) : DiseaseService {
    override fun getAll(): List<Disease> {
        return repository.findAll() as List<Disease>
    }

    override fun getRisk(): List<DiseaseRisk> {
        val diseaseThresholdsl = repository.findAll()
        val restTemplate = RestTemplate()
        val endpoint = URI.create("https://agrisev.com/api/aos")
        val realtimeData = ArrayList<Realtime>()
        val diseaseRisks: MutableList<DiseaseRisk> = mutableListOf()
        try {
            val data = restTemplate.getForObject(endpoint, Data::class.java)
            println("\n\n This$data")
            val realtimeList = data.data ?: return emptyList()
            val deta = realtimeList[realtimeList.size - 1]

            for (dat in diseaseThresholdsl) {
                val risk = DiseaseRisk()
                risk.crop = dat.crop
                risk.chemical = dat.chemical
                risk.disease = dat.disease
                risk.symptom = dat.symptom
                risk.price = dat.price?.toFloat()

                var ri = 0.10f
                if (Math.abs(dat.rainfall!! - deta.rain!!) < 5)
                    ri += 0.15f
                if (Math.abs(dat.temperature!! - deta.temp!!) < 5)
                    ri += 0.15f
                if (Math.abs(dat.radiation!! - deta.radiation!!) < 5)
                    ri += 0.15f
                if (Math.abs(dat.moisture!! - deta.moisture!!) < 5)
                    ri += 0.15f
                if (Math.abs(dat.humidity!! - deta.humidity!!) < 5)
                    ri += 0.15f
                if (Math.abs(dat.windspeed!! - deta.wind!!) < 5)
                    ri += 0.15f

                ri = if (ri <= 90) ri else 90f

                risk.risk = ri
                diseaseRisks.add(risk)
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return diseaseRisks
    }

    override fun getCropRisk(): List<Risk> {
        val diseaseRisks = this.getRisk()
        val risks: MutableList<Risk> = mutableListOf()

        for (diseaseRisk in diseaseRisks) {
            var risk = risks.find { it -> it.crop?.trim() == diseaseRisk.crop?.trim() }
            if (risk != null) {
                val index = risks.indexOf(risk)
                risk.risk = diseaseRisk.risk!! + risk.risk!!
                risk.diseaseCount++
                if (diseaseRisk.risk!! > 0.1f)
                    risk.diseases = if (risk.diseases.isNullOrBlank())
                        diseaseRisk.disease
                    else risk.diseases + ", " + diseaseRisk.disease
                risks[index] = risk
            } else {
                risk = Risk()
                risk.crop = diseaseRisk.crop
                risk.risk = diseaseRisk.risk
                risk.diseaseCount = 1
                if (diseaseRisk.risk!! > 0.1f)
                    risk.diseases = if (risk.diseases.isNullOrBlank())
                        diseaseRisk.disease
                    else risk.diseases + ", " + diseaseRisk.disease
                risks.add(risk)
            }
        }
        return risks.map { risk -> average(risk) }
    }

    fun average(risk: Risk): Risk {
        risk.risk = risk.risk!! / risk.diseaseCount
        return risk
    }
}