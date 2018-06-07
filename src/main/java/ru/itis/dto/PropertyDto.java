package ru.itis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDto {

    private String city;
    private String street;
    private String houseNumber;
    private String type;

    private String buildingNumber;
    private String flatNumber;
}
