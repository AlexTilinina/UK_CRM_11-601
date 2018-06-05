package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "property")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean gas;

    @NotNull
    private boolean water;

    @NotNull
    private boolean electricity;

    @NotNull
    private boolean garbageRemoval;

    @NotNull
    private boolean intercom;

    @NotNull
    private Integer houseNumber;

    private Integer buildingNumber;

    private Integer flatNumber;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType type;

    @ManyToOne
    private City city;

    @ManyToOne
    private Street street;

    @OneToMany(mappedBy = "property")
    private Set<Meter> meters;

    @OneToMany(mappedBy = "property")
    private Set<Bill> bills;

    @ManyToMany
    @JoinTable(name = "users_property",
    inverseJoinColumns = @JoinColumn(name = "owner_id"),
    joinColumns = @JoinColumn(name = "property_id"))
    private Set<PropertyOwner> owners;

}
