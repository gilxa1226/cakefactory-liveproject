package us.mjhtech.liveproject.cakefactory.catalog.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PASTRY")
public class PastryItemEntity {
    @Id
    String id;
    String title;
    double price;
}
