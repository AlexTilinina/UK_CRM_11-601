package model;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;

    private String role;

    private String name;

    private String surname;

    private String city;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id", table = "photo")
    private long photoId;

    public User(String login, String password, String role, String name, String surname, String city, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
}
