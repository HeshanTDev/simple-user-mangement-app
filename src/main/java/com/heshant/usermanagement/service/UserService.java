package com.heshant.usermanagement.service;

import com.heshant.usermanagement.dto.request.UserCreateRequestDTO;
import com.heshant.usermanagement.dto.response.UserResponseDTO;
import com.heshant.usermanagement.model.Department;
import com.heshant.usermanagement.model.User;
import com.heshant.usermanagement.model.UserStatus;
import com.heshant.usermanagement.model.UserType;
import com.heshant.usermanagement.repo.DepartmentRepository;
import com.heshant.usermanagement.repo.UserRepository;
import com.heshant.usermanagement.repo.UserStatusRepository;
import com.heshant.usermanagement.repo.UserTypeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    private final UserStatusRepository userStatusRepository;
    private final DepartmentRepository departmentRepository;

    public UserService(
            UserRepository userRepository,
            UserTypeRepository userTypeRepository,
            UserStatusRepository userStatusRepository,
            DepartmentRepository departmentRepository
    ) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
        this.userStatusRepository = userStatusRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<UserResponseDTO> findAll() {

        List<User> users = userRepository.findAll();

        List<UserResponseDTO> usersResponse = new ArrayList<>();

        for (User user : users) {
            UserResponseDTO responseUser = new UserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getMobile(),
                    user.getUserType().getName(),
                    user.getUserStatus().getName(),
                    user.getDepartment().getName(),
                    user.getCreatedAt(),
                    user.getUpdatedAt()
            );

            usersResponse.add(responseUser);
        }

        return usersResponse;
    }

    public UserResponseDTO findById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getMobile(),
                user.getUserType().getName(),
                user.getUserStatus().getName(),
                user.getDepartment().getName(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public UserResponseDTO addUser(UserCreateRequestDTO userRequest) {


        Department department = departmentRepository.findById(userRequest.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found!"));
        UserStatus userStatus = userStatusRepository.findById(userRequest.getUserStatusId()).orElseThrow(() -> new RuntimeException("User Status not found!"));
        UserType userType = userTypeRepository.findById(userRequest.getUserTypeId()).orElseThrow(() -> new RuntimeException("User Type not found!"));

        User user = User.create(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getPassword(),
                userType,
                userStatus,
                department
        );

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getMobile(),
                savedUser.getUserType().getName(),
                savedUser.getUserStatus().getName(),
                savedUser.getDepartment().getName(),
                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt()
        );
    }

    public void deleteUser(long id) {
        User found = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (found != null) {
            userRepository.deleteById(id);
        }
    }
}
