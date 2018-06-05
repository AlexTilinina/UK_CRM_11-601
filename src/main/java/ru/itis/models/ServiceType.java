package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "service_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;

    @OneToMany(mappedBy = "serviceType")
    private Set<Bill> bills;

    @OneToMany(mappedBy = "serviceType")
    private Set<Meter> meters;
}
