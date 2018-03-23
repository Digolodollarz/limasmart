package tech.diggle.apps.limasmart.realtime

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("realtime")
class RealtimeController {
    @GetMapping
    fun index() = "realtime"
}