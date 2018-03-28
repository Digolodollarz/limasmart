package tech.diggle.apps.limasmart.disease

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("diseases")
class DiseaseController {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("title", "Diseases")
        return "diseases"
    }
}