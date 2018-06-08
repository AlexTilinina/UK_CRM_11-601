package ru.itis.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimDto {

    private String title;
    private String description;
    private MultipartFile file;
}
