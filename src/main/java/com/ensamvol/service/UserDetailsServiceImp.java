package com.ensamvol.service;


import com.ensamvol.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private final AccountService accountService;

    public UserDetailsServiceImp(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user =accountService.loadUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getAppRoles().forEach(appRole -> {
            authorities.add(new SimpleGrantedAuthority(appRole.getRoleName()));
        });
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
