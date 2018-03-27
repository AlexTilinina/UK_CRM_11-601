package model;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class ApartmentsHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    private String street;

    private int number;

    private boolean garbageRemoval;

    private boolean yardman;

    private boolean concierge;

    private boolean wetCleaning;
}
