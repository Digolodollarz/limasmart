package tech.diggle.apps.limasmart.disease

import org.springframework.stereotype.Service

@Service
class DiseaseServiceImpl(val repository: DiseaseRepository) : DiseaseService {
    override fun getAll(): List<Disease> {
        return repository.findAll() as List<Disease>
    }
}