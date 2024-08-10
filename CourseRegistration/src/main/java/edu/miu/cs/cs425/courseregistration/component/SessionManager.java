package edu.miu.cs.cs425.courseregistration.component;

import edu.miu.cs.cs425.courseregistration.domain.CustomUser;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    public CustomUser getUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return (CustomUser) securityContext.getAuthentication().getPrincipal();
    }
}
