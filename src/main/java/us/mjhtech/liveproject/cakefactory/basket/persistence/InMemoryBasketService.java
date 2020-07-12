package us.mjhtech.liveproject.cakefactory.basket.persistence;

import org.springframework.stereotype.Component;
import us.mjhtech.liveproject.cakefactory.basket.BasketService;
import us.mjhtech.liveproject.cakefactory.catalog.PastryItem;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryBasketService implements BasketService {

    List<PastryItem> basket;

    public InMemoryBasketService() {
        basket = new ArrayList<>();
    }

    @Override
    public void addToBasket(PastryItem pastryItem) {
        basket.add(pastryItem);
    }

    @Override
    public void removeFromBasket(PastryItem pastryItem) {
        basket.remove(basket.indexOf(pastryItem));
    }

    @Override
    public void resetBasket() {
        basket = new ArrayList<>();
    }

    @Override
    public Iterable<PastryItem> getBasketItems() {
        return basket;
    }

    @Override
    public int getNumberOfItems() {
        return basket.size();
    }
}
