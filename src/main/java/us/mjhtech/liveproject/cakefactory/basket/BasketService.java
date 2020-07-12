package us.mjhtech.liveproject.cakefactory.basket;

import us.mjhtech.liveproject.cakefactory.catalog.PastryItem;

public interface BasketService {

    void addToBasket(PastryItem pastryItem);

    void removeFromBasket(PastryItem pastryItem);

    void resetBasket();

    Iterable<PastryItem> getBasketItems();

    int getNumberOfItems();

}
