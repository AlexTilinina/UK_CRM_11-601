package ru.itis.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditProfileDto {

    private String firstName;
    private String lastName;
    private String secondName;
    private String city;
    private String position;
}
