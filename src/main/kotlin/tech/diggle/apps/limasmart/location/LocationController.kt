package tech.diggle.apps.limasmart.location

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("location")
class LocationController {
    @GetMapping
    fun index() = "location"
}