package com.deniel.ms.web.security;

import com.deniel.ms.domain.user.IRole;
import com.deniel.ms.domain.user.IUserRoles;
import com.deniel.ms.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final IUserRoles user = userService.findUserByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        final List<GrantedAuthority> col = new ArrayList<>();
        for (IRole role : user.getRoles()) {
            col.add(new SimpleGrantedAuthority(String.format("ROLE_%s", role.getName())));
        }

        return new User(
                user.getName(),
                user.getPass(),
                true, // enabled
                true, // account not expired
                true, // credentials not expired
                true, // account not locked
                col);
    }
}
