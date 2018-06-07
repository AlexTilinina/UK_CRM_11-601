package ru.itis.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StreetDto {

    private String city;
    private String street;
}
