package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "service_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private Set<Bill> bills;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private Set<Meter> meters;

    @Override
    public String toString() {
        return "";
    }
}
