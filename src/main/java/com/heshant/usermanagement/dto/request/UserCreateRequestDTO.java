package com.heshant.usermanagement.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 10, message = "Name must be less than 100 characters")
    @Pattern(regexp = "^[A-Za-z ]{2,50}$",message = "Name can contain only letters and spaces")
    private String name;

    @NotBlank(message = "Email is required")
    @Size(max = 10, message = "Email must be less than 100 characters")
    @Email(message = "Enter a valid email")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 8,max = 20, message = "Password must be between 8 to 20 characters")
    @Pattern(regexp = "^.{8,}$", message = "Password must be at least 8 characters long")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter")
    @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one digit")
    @Pattern(regexp = ".*[@#$%^&+=!].*", message = "Password must contain at least one special character (@#$%^&+=!)")
    private String password;

    @NotNull(message = "Password is required")
    @Pattern(regexp = "^0\\\\d{9}$",message = "Mobile number must start with 0 and be exactly 10 digits long")
    private int mobile;

    private Long userTypeId;

    private Long userStatusId;
}
