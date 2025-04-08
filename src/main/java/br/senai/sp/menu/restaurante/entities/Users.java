
/**
 * Criado por: Caroline Portela
 * Data: 04/04/2025
 *
 * Entidade responsável por mapear a tabela 'tbl_users' no banco de dados.
 *
 * Esta classe representa os dados do usuário no sistema, incluindo:
 * - username: nome de login do usuário.
 * - password: senha do usuário (deve ser armazenada de forma segura).
 * - role: papel ou perfil do usuário (ex: ADMIN, GUEST), usado no controle de permissões.
 * - creationTimestamp: data/hora em que o usuário foi criado.
 * - updateTimestamp: data/hora da última atualização dos dados.
 *
 * A anotação @CreationTimestamp define o momento em que o registro foi inserido,
 * enquanto @UpdateTimestamp atualiza automaticamente a data sempre que o registro for modificado.
 *
 * Essa entidade é usada pelo JPA/Hibernate para operações de persistência no banco de dados.
 */

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
    private String username;

    @Column(name = "password")
    private String password;

//    @Column(name = "role")
//    private String role;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;


    @CreationTimestamp
    @Column(name = "creation_timestamp", updatable = false)
    private Instant creationTimestamp;

    @UpdateTimestamp
    @Column(name = "update_timestamp")
    private Instant updateTimestamp;
}

