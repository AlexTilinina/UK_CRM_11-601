package ru.itis.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer billNumber;

    private Integer sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type")
    private ServiceType serviceType;

    @OneToOne(mappedBy = "bill", cascade = CascadeType.ALL)
    private Payment payment;

    @Override
    public String toString() {
        return "";
    }
}
