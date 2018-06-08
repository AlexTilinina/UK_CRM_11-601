package ru.itis.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeterDto {

    private Date date;
    private Integer number;
    private String propertyId;
    private String serviceId;
}
