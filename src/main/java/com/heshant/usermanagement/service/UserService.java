package com.heshant.usermanagement.service;

import com.heshant.usermanagement.dto.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<UserResponseDTO> findAll() {
        return new ArrayList<UserResponseDTO>();
    }

    public UserResponseDTO findById(int id) {
        return new UserResponseDTO();
    }
}
