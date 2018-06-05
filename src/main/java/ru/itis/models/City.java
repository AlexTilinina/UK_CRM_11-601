package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "city")
@Data@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<PropertyOwner> owners;

    @OneToMany(mappedBy = "city")
    private Set<Property> properties;

    @OneToMany(mappedBy = "city")
    private Set<Street> streets;
}
