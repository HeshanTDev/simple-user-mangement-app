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

//        for (User user : users) {
//            usersResponse.add(new UserResponseDTO(
//
//            ));
//        }

        return new ArrayList<UserResponseDTO>();
    }

    public UserResponseDTO findById(int id) {
        return null;
    }

    public UserResponseDTO addUser(UserCreateRequestDTO userRequest){
        return null;
    }
}
