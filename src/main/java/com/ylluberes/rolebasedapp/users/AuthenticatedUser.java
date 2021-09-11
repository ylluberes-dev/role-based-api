package com.ylluberes.rolebasedapp.users;

import com.ylluberes.rolebasedapp.roles.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private Users user;

    public AuthenticatedUser (Users users){
        super(users.getEmail(),users.getPassword(),getAuthorities(users));
    }

    public Users getUser()
    {
        return user;
    }
    private static Collection<? extends GrantedAuthority> getAuthorities(Users user)
    {
        Set<String> roleAndPermissions = new HashSet<>();
        List<Roles> roles = user.getRoles();

        for (Roles role : roles)
        {
            roleAndPermissions.add(role.getName());
        }
        String[] roleNames = new String[roleAndPermissions.size()];
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
        return authorities;
    }
}
