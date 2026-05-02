package com.codeWithProjects.ecom.filters;

import com.codeWithProjects.ecom.utils.jwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class jwtRequestFilter extends OncePerRequestFilter {

    private final UserDetailsserviceImpl userDetailsservice;
    private final jwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader=request.getHeader("Authorization");
        String token=null;
        String username=null;

        if (authHeader!=null && authHeader.startsWith("Bearer")){
            token=authHeader.substring(7);
            username= jwtUtil.extractUsername(token);
        }

        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=userDetailsservice.loadUserByUsername(username);
        }
    }
}
