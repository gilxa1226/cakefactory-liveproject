package us.mjhtech.liveproject.cakefactory.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table(name="PASTRY")
public class Pastry {

    @Id
    private final String id;
    private final String title;
    private final double price;

}
