package com.ensamvol;
import com.ensamvol.service.AccountService;
import com.ensamvol.service.UserDetailsServiceImp;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AccountService accountService;
    private final UserDetailsServiceImp userDetailsServiceImp;
    public SecurityConfig(AccountService accountService, UserDetailsServiceImp userDetailsServiceImp) {
        this.accountService = accountService;
        this.userDetailsServiceImp = userDetailsServiceImp;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsServiceImp);
//        auth.userDetailsService()
        auth.userDetailsService(userDetailsServiceImp);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**","/js/**","/","/images/**","/signup").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
//        http.formLogin();

        http.csrf();
        http.exceptionHandling().accessDeniedPage("/notAuthorized");


    }
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}