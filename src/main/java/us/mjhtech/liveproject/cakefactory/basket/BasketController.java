package us.mjhtech.liveproject.cakefactory.basket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import us.mjhtech.liveproject.cakefactory.catalog.PastryItem;

import java.util.Map;

@Slf4j
@Controller
public class BasketController {

    BasketService basketService;

    BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/basket")
    ModelAndView addToBasket(@ModelAttribute PastryItem pastryItem) {
        basketService.addToBasket(pastryItem);

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/basket")
    ModelAndView viewBasket() {
        return new ModelAndView("basket", Map.of("name", "Mike",
                "basket", basketService.getBasketItems(),
                "basketSize", basketService.getNumberOfItems()));
    }

    @PostMapping("/basket/remove")
    ModelAndView removeFromBasket(@ModelAttribute PastryItem pastryItem) {

        basketService.removeFromBasket(pastryItem);

        return new ModelAndView("redirect:/basket");
    }
}
