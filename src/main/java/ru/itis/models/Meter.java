package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private PropertyOwner propertyOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type")
    private ServiceType serviceType;

    @Override
    public String toString() {
        return "";
    }
}
