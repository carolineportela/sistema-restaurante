package br.senai.sp.menu.restaurante.entities;
import br.senai.sp.menu.restaurante.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "tbl_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

//    @Column(name = "role")
//    private String role;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;


    @CreationTimestamp
    @Column(name = "creation_timestamp", updatable = false)
    private Instant creationTimestamp;

    @UpdateTimestamp
    @Column(name = "update_timestamp")
    private Instant updateTimestamp;

    //teste email
    @Column(name = "email_validated")
    private Instant emailValidated;

}

