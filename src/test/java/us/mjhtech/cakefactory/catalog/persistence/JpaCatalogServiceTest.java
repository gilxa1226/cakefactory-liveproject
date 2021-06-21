package us.mjhtech.cakefactory.catalog.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import us.mjhtech.cakefactory.catalog.PastryItem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JpaCatalogServiceTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PastryItemRepository itemRepository;

    private JpaCatalogService jpaCatalogService;

    @BeforeEach
    void setup() {
        this.jpaCatalogService = new JpaCatalogService(this.itemRepository);
    }

    @Test
    @DisplayName("Returns data from the database")
    void returnsDataFromDatabase() {
        String expectedTitle = "Victoria Sponge";
        saveTestItem(expectedTitle, 5.55);

        Iterable<PastryItem> items = jpaCatalogService.getPastryItems();

        assertThat(items).anyMatch(item -> expectedTitle.equals(item.getTitle()));
    }

    private void saveTestItem(String title, double price) {
        PastryItemEntity itemEntity = new PastryItemEntity();
        itemEntity.id = "tst-itm-1";
        itemEntity.title = title;
        itemEntity.price = price;

        testEntityManager.persistAndFlush(itemEntity);
    }


}