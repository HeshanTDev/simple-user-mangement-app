package com.heshant.usermanagement.service;

import com.heshant.usermanagement.dto.request.UserCreateRequestDTO;
import com.heshant.usermanagement.dto.response.UserResponseDTO;
import com.heshant.usermanagement.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findAll();

    UserResponseDTO findById(long id) throws UserNotFoundException;

    UserResponseDTO addUser(UserCreateRequestDTO userRequest);

    UserResponseDTO updateUser(long id, UserCreateRequestDTO userRequest);

    void deleteUser(long id);
}