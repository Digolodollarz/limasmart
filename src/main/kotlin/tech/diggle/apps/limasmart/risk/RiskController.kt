package tech.diggle.apps.limasmart.risk

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("risk")
class RiskController(val service: RiskService) {
    @GetMapping
    fun getIndex(model: Model) {
        model.addAttribute("title", "Risk")
    }


}