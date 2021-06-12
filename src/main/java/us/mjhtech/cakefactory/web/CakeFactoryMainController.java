package us.mjhtech.cakefactory.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CakeFactoryMainController {

    @GetMapping("/")
    public String showMainPage(Model model) {
        return "main";
    }

}
