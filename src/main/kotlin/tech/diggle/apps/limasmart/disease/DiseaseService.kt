package tech.diggle.apps.limasmart.disease

interface DiseaseService {
    fun getAll(): List<Disease>
    fun getRisk(): List<DiseaseRisk>
}