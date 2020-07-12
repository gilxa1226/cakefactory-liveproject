package us.mjhtech.liveproject.cakefactory.orders;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import us.mjhtech.liveproject.cakefactory.basket.BasketService;

import java.util.Map;

@Controller
public class OrdersController {

    BasketService basketService;

    OrdersController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/order")
    ModelAndView placeOrder() {
        basketService.resetBasket();
        return new ModelAndView("order", Map.of("name", "Mike",
                "basketSize", 0));
    }


}
