package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private PropertyOwner propertyOwner;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Override
    public String toString() {
        return "";
    }
}
