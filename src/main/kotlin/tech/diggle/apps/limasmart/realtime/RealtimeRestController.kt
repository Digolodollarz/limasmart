package tech.diggle.apps.limasmart.realtime

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.net.URI

@RestController
@RequestMapping("api")
class RealtimeRestController {
    @GetMapping("realtime")
    fun getRealtime(): List<Realtime> {
        val restTemplate = RestTemplate()
        val endpoint = URI.create("https://agrisev.com/api/aos")
        val request = RequestEntity<Any>(HttpMethod.GET, endpoint)
        val respType = object : ParameterizedTypeReference<Data>() {}
        val response = restTemplate.exchange(request, respType)
        val data = response.body
        return data.data!!
    }
}