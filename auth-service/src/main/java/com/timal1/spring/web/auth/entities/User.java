package com.timal1.spring.web.auth.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "users")
@Schema(description = "Модель пользователя")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "ID пользователя", required = true, example = "1")
    private Long id;

    @Column(name = "username")
    @Schema(description = "Имя пользователя", required = true, example = "Иван")
    private String username;

    @Column(name = "password")
    @Schema(description = "пароль", required = true, example = "jnbidcbivbiswb")
    private String password;

    @Column(name = "email")
    @Schema(description = "Email", required = true, example = "Ivan@mail.ru")
    private String email;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Schema(description = "Роль", required = true, example = "USER")
    private Collection<Role> roles;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Order> orders;


    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
