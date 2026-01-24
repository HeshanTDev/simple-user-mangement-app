//package com.heshan.crud_app_2.config;
package com.heshant.usermanagement.config;

import com.heshant.usermanagement.model.Department;
import com.heshant.usermanagement.model.UserRole;
import com.heshant.usermanagement.model.UserStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        config.exposeIdsFor(UserRole.class);
        config.exposeIdsFor(UserStatus.class);
        config.exposeIdsFor(Department.class);
    }
}