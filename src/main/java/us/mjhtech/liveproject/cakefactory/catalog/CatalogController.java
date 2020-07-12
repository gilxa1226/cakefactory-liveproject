package us.mjhtech.liveproject.cakefactory.catalog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import us.mjhtech.liveproject.cakefactory.basket.BasketService;

@Slf4j
@Controller
public class CatalogController {

    private final CatalogService catalogService;
    private final BasketService basketService;

    public CatalogController(CatalogService catalogService, BasketService basketService) {
        this.catalogService = catalogService;
        this.basketService = basketService;
    }

    @GetMapping("/")
    ModelAndView index(Model model) {

        model.addAttribute("pastries", this.catalogService.getPastryItems());
        model.addAttribute("name", "Mike");
        model.addAttribute("basketSize", basketService.getNumberOfItems() );

        return new ModelAndView("main", model.asMap());
    }
}
