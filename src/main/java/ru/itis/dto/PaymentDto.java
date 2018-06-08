package ru.itis.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Date date;
    private Integer sum;
    private String serviceType;
    private String propertyId;
}
