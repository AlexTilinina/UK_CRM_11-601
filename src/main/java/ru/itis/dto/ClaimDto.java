package ru.itis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimDto {

    private String title;
    private String description;
    private String file;
}
