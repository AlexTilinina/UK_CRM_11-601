package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "city")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<PropertyOwner> owners;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Property> properties;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Street> streets;

    @Override
    public String toString() {
        return "";
    }
}
