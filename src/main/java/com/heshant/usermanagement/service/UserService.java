package com.heshant.usermanagement.service;

import com.heshant.usermanagement.dto.request.UserCreateRequestDTO;
import com.heshant.usermanagement.dto.response.UserResponseDTO;
import com.heshant.usermanagement.model.User;
import com.heshant.usermanagement.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserResponseDTO> findAll() {

        List<User> users = userRepository.findAll();

        List<UserResponseDTO> usersResponse = new ArrayList<>();

        for (User user : users) {
            UserResponseDTO responseUser = new UserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getUserType().getName(),
                    user.getUserStatus().getName(),
                    user.getDepartment().getName(),
                    user.getCreatedAt()
            );
            usersResponse.add(responseUser);
        }

        return usersResponse;
    }

    public UserResponseDTO findById(int id) {
        return null;
    }

    public UserResponseDTO addUser(UserCreateRequestDTO userRequest) {
        return null;
    }
}
