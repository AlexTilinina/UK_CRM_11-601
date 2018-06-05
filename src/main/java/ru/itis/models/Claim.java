package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "claim")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private State state;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PropertyOwner propertyOwner;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
