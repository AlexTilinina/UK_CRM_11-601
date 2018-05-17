package ru.itis.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormApartment {

    private int number;

    private boolean gas;

    private boolean water;

    private boolean electricity;
}
