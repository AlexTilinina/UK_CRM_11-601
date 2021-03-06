package ru.itis.models;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "property_owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @ManyToMany
    @JoinTable(name = "users_property",
            inverseJoinColumns = @JoinColumn(name = "property_id"),
            joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Property> properties;

    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL)
    private Set<Claim> claims;

    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL)
    private Set<Meter> meters;

    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL)
    private Set<Payment> payments;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private User user;

    @Override
    public String toString() {
        return "";
    }
}
