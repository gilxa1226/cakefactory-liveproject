package us.mjhtech.cakefactory.catalog.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import us.mjhtech.cakefactory.catalog.CatalogService;
import us.mjhtech.cakefactory.catalog.PastryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class StaticCatalogService implements CatalogService {

    private List<PastryItemEntity> pastryItemEntityList = new ArrayList<>() {{
        add(new PastryItemEntity("abcr", "All Butter Croissant", 0.75));
        add(new PastryItemEntity("ccr", "Chocolate Croissant", 0.95));
        add(new PastryItemEntity("b", "Fresh Baguette", 1.60));
        add(new PastryItemEntity("rv", "Red Velvet", 3.95));
        add(new PastryItemEntity("vs", "Victoria Sponge", 5.45));
        add(new PastryItemEntity("cc", "Carrot Cake", 3.45));
    };};

    @Override
    public Iterable<PastryItem> getPastryItems() {
        return StreamSupport.stream(pastryItemEntityList.spliterator(), false)
                .map(entity -> new PastryItem(entity.id, entity.title, entity.price))
                .collect(Collectors.toList());
    }
}
