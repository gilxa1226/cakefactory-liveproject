package us.mjhtech.liveproject.cakefactory.basket.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import us.mjhtech.liveproject.cakefactory.basket.BasketService;
import us.mjhtech.liveproject.cakefactory.catalog.PastryItem;

public class InMemoryBasketServiceTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    BasketService basketService;

    private InMemoryBasketService inMemoryBasketService;

    @BeforeEach
    void setup() {
        this.inMemoryBasketService = new InMemoryBasketService();
    }

    @Test
    @DisplayName("adds item to basket")
    void addsItemToBasket() {
        PastryItem pastryItem = new PastryItem("vs", "Victoria Sponge", 5.55);

        inMemoryBasketService.addToBasket(pastryItem);

        org.assertj.core.api.Assertions.assertThat(inMemoryBasketService.getNumberOfItems()).isEqualTo(1);
    }

    @Test
    @DisplayName("removes an item from the bakset")
    void removeItemFromBasket() {
        PastryItem pastryItem = new PastryItem("vs", "Victoria Sponge", 5.55);

        inMemoryBasketService.addToBasket(pastryItem);
        inMemoryBasketService.removeFromBasket(pastryItem);

        org.assertj.core.api.Assertions.assertThat(inMemoryBasketService.getNumberOfItems()).isEqualTo(0);
    }

    @Test
    @DisplayName("resets the basket")
    void resetBasket() {
        PastryItem pastryItem = new PastryItem("vs", "Victoria Sponge", 5.55);
        inMemoryBasketService.addToBasket(pastryItem);
        org.assertj.core.api.Assertions.assertThat(inMemoryBasketService.getNumberOfItems()).isEqualTo(1);
        inMemoryBasketService.resetBasket();
        org.assertj.core.api.Assertions.assertThat(inMemoryBasketService.getNumberOfItems()).isEqualTo(0);
    }

}
