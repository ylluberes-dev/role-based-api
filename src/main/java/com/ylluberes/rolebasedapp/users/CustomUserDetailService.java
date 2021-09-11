package com.ylluberes.rolebasedapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("This email does not exists"));
        return new org.springframework.security.core.userdetails
                   .User(user.getEmail(),
                    user.getPassword(),
                    getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities (Users user){

        String [] userRoles = user
                .getRoles()
                .stream()
                .map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
