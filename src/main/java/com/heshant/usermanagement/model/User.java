package com.heshant.usermanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 10)
    private String mobile;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "user_status_id", nullable = false)
    private UserStatus userStatus;

    @ManyToOne
    @JoinColumn(name = "user_department_id", nullable = false)
    private Department department;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpate() {
        updatedAt = LocalDateTime.now();
    }

//Factory method to create user object
    public static User create(
            String name,
            String email,
            String mobile,
            String password,
            UserType userType,
            UserStatus userStatus,
            Department department
    ) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setPassword(password);
        user.setUserType(userType);
        user.setUserStatus(userStatus);
        user.setDepartment(department);

        return user;
    }
}
