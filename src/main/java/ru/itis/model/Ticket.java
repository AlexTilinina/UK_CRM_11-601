package ru.itis.model;

import lombok.*;
import ru.itis.utils.Status;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private String theme;

    @Enumerated(EnumType.STRING)
    private Status status;
}
