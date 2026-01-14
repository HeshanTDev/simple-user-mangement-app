package com.heshant.usermanagement.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long userTypeId;
    private Long userStatusId;
}
