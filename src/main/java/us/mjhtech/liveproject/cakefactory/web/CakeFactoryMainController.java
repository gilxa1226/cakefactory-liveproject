package us.mjhtech.liveproject.cakefactory.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CakeFactoryMainController {

    @GetMapping("/")
    public String showMainPage(Model model) {

        model.addAttribute("name", "Mike");

        return "main";
    }
}
