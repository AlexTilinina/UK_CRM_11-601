package model;

import lombok.*;
import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;

    private boolean gas;

    private boolean water;

    private boolean electricity;
}
