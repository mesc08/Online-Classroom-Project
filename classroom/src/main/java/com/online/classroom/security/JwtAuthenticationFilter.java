package com.online.classroom.security;

import com.online.classroom.service.implementation.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.jwt.example.sercurity.JwtHelper;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestHeader = request.getHeader("Authorization");
        logger.info(" Header :  {}", requestHeader);
        String username = null;
        String token = null;

        if(requestHeader != null && requestHeader.startsWith("Bearer")){
            token = requestHeader.substring(7);
            try{
                username = this.helper.getUsernameFromToken(token);
            }
            catch (IllegalArgumentException exp){
                logger.info("Illegal Argument while fetching the username !!");
                exp.printStackTrace();
            }
            catch (ExpiredJwtException exp){
                logger.info("Given jwt token is expired !!");
                exp.printStackTrace();
            }
            catch (MalformedJwtException exp){
                logger.info("Some changed has done in token !! Invalid Token");
                exp.printStackTrace();
            }
            catch (Exception exp){
                exp.printStackTrace();
            }
        } else{
            logger.info("Invalid Header Value !! ");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validToken = this.helper.validateToken(token, userDetails);
            if(validToken){
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            else{
                logger.info("Validation fails !!");
            }
        }
        filterChain.doFilter(request, response);
    }
}
