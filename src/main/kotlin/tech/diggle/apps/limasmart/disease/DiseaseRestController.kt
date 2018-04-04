package tech.diggle.apps.limasmart.disease

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/disease")
class DiseaseRestController(val service: DiseaseService) {
    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("risk")
    fun getRisk() = service.getRisk()
}