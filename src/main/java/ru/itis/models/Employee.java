package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Claim> claims;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private User user;
}
