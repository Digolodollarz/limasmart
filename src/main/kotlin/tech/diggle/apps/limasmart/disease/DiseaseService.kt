package tech.diggle.apps.limasmart.disease

import tech.diggle.apps.limasmart.risk.Risk

interface DiseaseService {
    fun getAll(): List<Disease>
    fun getRisk(): List<DiseaseRisk>
    fun getCropRisk(): List<Risk>
}