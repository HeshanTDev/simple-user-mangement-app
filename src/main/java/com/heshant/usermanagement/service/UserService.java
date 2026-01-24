package com.heshant.usermanagement.service;

import com.heshant.usermanagement.dto.request.UserCreateRequestDTO;
import com.heshant.usermanagement.dto.response.UserResponseDTO;
import com.heshant.usermanagement.model.Department;
import com.heshant.usermanagement.model.User;
import com.heshant.usermanagement.model.UserStatus;
import com.heshant.usermanagement.model.UserRole;
import com.heshant.usermanagement.repo.DepartmentRepository;
import com.heshant.usermanagement.repo.UserRepository;
import com.heshant.usermanagement.repo.UserStatusRepository;
import com.heshant.usermanagement.repo.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserStatusRepository userStatusRepository;
    private final DepartmentRepository departmentRepository;

    public UserService(
            UserRepository userRepository,
            UserRoleRepository userRoleRepository,
            UserStatusRepository userStatusRepository,
            DepartmentRepository departmentRepository
    ) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
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
                    user.getUserRole(),
                    user.getUserStatus(),
                    user.getDepartment(),
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
                user.getUserRole(),
                user.getUserStatus(),
                user.getDepartment(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public UserResponseDTO addUser(UserCreateRequestDTO userRequest) {


        UserRole userRole = userRoleRepository.findById(userRequest.getUserRoleId()).orElseThrow(() -> new RuntimeException("User Type not found!"));
        UserStatus userStatus = userStatusRepository.findById(userRequest.getUserStatusId()).orElseThrow(() -> new RuntimeException("User Status not found!"));
        Department department = departmentRepository.findById(userRequest.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found!"));

        User user = User.create(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getPassword(),
                userRole,
                userStatus,
                department
        );

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getMobile(),
                savedUser.getUserRole(),
                savedUser.getUserStatus(),
                savedUser.getDepartment(),
                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt()
        );
    }

    public UserResponseDTO updateUser(long id, UserCreateRequestDTO userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));

        UserRole userRole = userRoleRepository.findById(userRequest.getUserRoleId()).orElseThrow(() -> new RuntimeException("User Type not found!"));
        if (userRole != null) {
            user.setUserRole(userRole);
        }

        UserStatus userStatus = userStatusRepository.findById(userRequest.getUserStatusId()).orElseThrow(() -> new RuntimeException("User Status not found!"));
        if (userStatus != null) {
            user.setUserStatus(userStatus);
        }

        Department department = departmentRepository.findById(userRequest.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found!"));
        if (department != null) {
            user.setDepartment(department);
        }


        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setMobile(userRequest.getMobile());

        User updateUser = userRepository.save(user);

        return new UserResponseDTO(
                updateUser.getId(),
                updateUser.getName(),
                updateUser.getEmail(),
                updateUser.getMobile(),
                updateUser.getUserRole(),
                updateUser.getUserStatus(),
                updateUser.getDepartment(),
                updateUser.getCreatedAt(),
                updateUser.getUpdatedAt()
        );
    }

    public void deleteUser(long id) {
        User found = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));

        if (found != null) {
            userRepository.deleteById(id);
        }
    }

}
