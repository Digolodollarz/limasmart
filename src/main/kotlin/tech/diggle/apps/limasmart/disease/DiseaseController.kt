package tech.diggle.apps.limasmart.disease

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import tech.diggle.apps.limasmart.user.UserService

@Controller
@RequestMapping("diseases")
class DiseaseController(@Autowired val userService: UserService) {
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("title", "Diseases")
        val user = userService.findUserByEmail(SecurityContextHolder.getContext().authentication.name)
        model.addAttribute("user", user)
        return "diseases"
    }
}