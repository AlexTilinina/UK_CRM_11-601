package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "street")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Street {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "street")
    private Set<Property> properties;
}
