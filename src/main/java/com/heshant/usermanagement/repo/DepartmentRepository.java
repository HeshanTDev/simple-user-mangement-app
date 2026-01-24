package com.heshant.usermanagement.repo;

import com.heshant.usermanagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "departments")
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
