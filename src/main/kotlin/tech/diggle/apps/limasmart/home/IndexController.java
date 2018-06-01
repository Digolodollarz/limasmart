package tech.diggle.apps.limasmart.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tech.diggle.apps.limasmart.user.User;
import tech.diggle.apps.limasmart.user.UserService;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView Home() {
        ModelAndView index = new ModelAndView("index");

        User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        index.addObject("user", user);
        return index;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}