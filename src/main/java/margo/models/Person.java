package margo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    private Integer id;
    private String name;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(length = 512)
    private String password;
    @Column(nullable = false)
    private boolean isDeleted;

    public Person(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.isDeleted = false;
    }

}