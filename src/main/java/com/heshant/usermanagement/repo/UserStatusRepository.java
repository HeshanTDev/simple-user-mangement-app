package com.heshant.usermanagement.repo;

import com.heshant.usermanagement.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "user-management/user_statuses")
public interface UserStatusRepository extends JpaRepository<UserStatus,Long> {
}
