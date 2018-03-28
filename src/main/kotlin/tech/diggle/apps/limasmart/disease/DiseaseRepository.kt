package tech.diggle.apps.limasmart.disease

import org.springframework.data.repository.PagingAndSortingRepository

interface DiseaseRepository : PagingAndSortingRepository<Disease, Long> {

}