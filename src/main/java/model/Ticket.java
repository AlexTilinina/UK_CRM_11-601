package model;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private String theme;

    @ManyToMany
    @JoinColumn(name = "status_id", referencedColumnName = "id", table = "Ticket_status")
    private int statusId;
}
