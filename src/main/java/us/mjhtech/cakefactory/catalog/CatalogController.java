package us.mjhtech.cakefactory.catalog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/")
    ModelAndView index(Model model) {
        model.addAttribute("pastries", this.catalogService.getPastryItems());

        return new ModelAndView("main", model.asMap());
    }

}
