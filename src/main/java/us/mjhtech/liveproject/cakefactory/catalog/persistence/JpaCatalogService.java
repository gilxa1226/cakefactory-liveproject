package us.mjhtech.liveproject.cakefactory.catalog.persistence;

import org.springframework.stereotype.Component;
import us.mjhtech.liveproject.cakefactory.catalog.CatalogService;
import us.mjhtech.liveproject.cakefactory.catalog.PastryItem;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public
class JpaCatalogService implements CatalogService {

    private final PastryItemRepository pastryItemRepository;

    JpaCatalogService(PastryItemRepository pastryItemRepository) {
        this.pastryItemRepository = pastryItemRepository;
    }

    @Override
    public Iterable<PastryItem> getPastryItems() {
        return StreamSupport.stream(pastryItemRepository.findAll().spliterator(), false)
                .map(entity -> new PastryItem(entity.id, entity.title, entity.price))
                .collect(Collectors.toList());
    }
}
