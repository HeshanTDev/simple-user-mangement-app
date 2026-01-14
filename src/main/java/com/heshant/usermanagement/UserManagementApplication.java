package com.heshant.usermanagement;

import com.heshant.usermanagement.model.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserManagementApplication.class, args);
        Type heshan = new Type(1L, "Heshan");
        System.out.println(heshan);

    }

}
