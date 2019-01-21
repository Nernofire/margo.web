package margo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public @Data
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String login;
    private String password;
    private boolean isDeleted;


    public Person() {
    }

    public Person(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.isDeleted = false;
    }
}