package tech.diggle.apps.limasmart.realtime

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.client.RestTemplate
import java.net.URI

@Controller
@RequestMapping("realtime")
class RealtimeController {
    @GetMapping
    fun index(model: Model): String {
        val restTemplate = RestTemplate()
        val endpoint = URI.create("https://agrisev.com/api/aos")
        val request = RequestEntity<Any>(HttpMethod.GET, endpoint)
        val respType = object : ParameterizedTypeReference<Data>() {}
        val response = restTemplate.exchange(request, respType)
        val data = response.body
        model.addAttribute("data", data)
        return "realtime"
    }
}