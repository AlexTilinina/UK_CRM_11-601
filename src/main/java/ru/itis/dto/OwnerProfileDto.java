package ru.itis.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerProfileDto {

    private String firstName;
    private String lastName;
    private String secondName;
    private String city;
    private String street;
    private String homeType;
    private Integer houseNumber;
    private Integer buildingNumber;
    private Integer flatNumber;
}
