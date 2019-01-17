package margo.models;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long person_id;
    private String person_name;
    private String person_login;
    private String person_password;
    private Long person_role;
    private boolean person_is_deleted;
}
