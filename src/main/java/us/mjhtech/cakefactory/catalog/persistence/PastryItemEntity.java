package us.mjhtech.cakefactory.catalog.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
*/

/*@Entity
@Table(name="PASTRY") */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class PastryItemEntity {
//    @Id
    String id;
    String title;
    double price;
}
