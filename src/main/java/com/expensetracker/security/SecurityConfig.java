package com.expensetracker.security;

import com.expensetracker.filter.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.springframework.http.HttpMethod.GET;

//@CrossOrigin("http://localhost:3000")
@EnableWebSecurity @Configuration @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //Spring Security has by default user and pass. Now we need to tell spring that we will use
    //our own username and password from the database. Authentication manager builder is for that
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                CustomAuthenticationFilter authenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
                authenticationFilter.setFilterProcessesUrl("/api/login");
                //http.cors();
                http.csrf().disable();
                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                http.authorizeRequests().antMatchers("/api/login/**").permitAll();
                http.authorizeRequests().antMatchers("/save/user/**").permitAll();
                http.authorizeRequests().antMatchers("/**").permitAll();
                http.authorizeRequests().anyRequest().hasAnyAuthority();//if the app has restrictions include the role
                                                                    // for the user
                http.addFilter(authenticationFilter);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
