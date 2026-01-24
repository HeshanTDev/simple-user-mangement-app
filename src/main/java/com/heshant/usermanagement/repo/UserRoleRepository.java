package com.heshant.usermanagement.repo;

import com.heshant.usermanagement.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "user-management/user-roles")
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
