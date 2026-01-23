package com.heshant.usermanagement.dto.response;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String mobile,
        String userType,
        String userStatus,
        String Department,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
