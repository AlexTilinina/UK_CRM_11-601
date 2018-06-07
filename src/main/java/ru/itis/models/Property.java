package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "property")
@Getter
@Setter
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
    private String houseNumber;

    private String buildingNumber;

    private String flatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_type_id")
    private PropertyType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    private Street street;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private Set<Meter> meters;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private Set<Bill> bills;

    @ManyToMany
    @JoinTable(name = "users_property",
            inverseJoinColumns = @JoinColumn(name = "owner_id"),
            joinColumns = @JoinColumn(name = "property_id"))
    private Set<PropertyOwner> owners;

    @Override
    public String toString() {
        return "";
    }
}
