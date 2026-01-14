package com.heshant.usermanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_status")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 50)
    private String name;
}
