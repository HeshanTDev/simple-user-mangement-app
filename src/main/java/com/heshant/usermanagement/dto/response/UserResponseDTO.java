package com.heshant.usermanagement.dto.response;

import com.heshant.usermanagement.model.Department;
import com.heshant.usermanagement.model.UserStatus;
import com.heshant.usermanagement.model.UserType;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String mobile,
        UserType userType,
        UserStatus userStatus,
        Department department,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
