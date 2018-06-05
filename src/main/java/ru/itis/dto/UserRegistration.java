package ru.itis.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistration {

    @NotNull
    @Size(max = 15)
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    private String lastName;

    @Email
    private String email;

    private String city;
}
