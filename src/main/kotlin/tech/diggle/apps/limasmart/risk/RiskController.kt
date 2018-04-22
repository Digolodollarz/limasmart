package tech.diggle.apps.limasmart.risk

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import tech.diggle.apps.limasmart.user.UserService

@Controller
@RequestMapping("risk")
class RiskController(val service: RiskService
                     , @Autowired val userService: UserService) {
    @GetMapping
    fun getIndex(model: Model) {
        model.addAttribute("title", "Risk")
        val user = userService.findUserByEmail(SecurityContextHolder.getContext().authentication.name)
        model.addAttribute("user", user)
    }


}