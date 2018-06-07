package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "street")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Street {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private City city;

    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL)
    private Set<Property> properties;

    @Override
    public String toString() {
        return "";
    }
}
