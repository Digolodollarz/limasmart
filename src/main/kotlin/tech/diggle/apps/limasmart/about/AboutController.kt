package tech.diggle.apps.limasmart.about

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import tech.diggle.apps.limasmart.user.UserService

@Controller
class AboutController(@Autowired val userService: UserService) {
    @GetMapping("about")
    fun about(model: Model): String {
        val user = userService.findUserByEmail(SecurityContextHolder.getContext().authentication.name)
        model.addAttribute("user", user)
        return "about"
    }
}