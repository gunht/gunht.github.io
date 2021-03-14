package com.example.bug_report.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RedirectUrlRole extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private String determineTargetUrl() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) auth.getAuthorities();
            List<String> name = authorities.stream().map(item -> item.getAuthority()).collect(Collectors.toList());
            if (name.contains("ROLE_ADMIN")) {
                return "/admin";
            }
        }
        return "/";
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String url = determineTargetUrl();
        if (response.isCommitted()) return;
        redirectStrategy.sendRedirect(request, response, url);
    }
}
