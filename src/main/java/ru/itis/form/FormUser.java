package ru.itis.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//формочка
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormUser {

    private String login;

    private String password;

    private String name;

    private String surname;

    private String city;

    private String phoneNumber;
}
