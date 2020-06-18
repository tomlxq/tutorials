package com.tom.hibernate.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(e -> e.getAuthentication())
                .map(Authentication::getName)
                .orElse(null);
    }

}
