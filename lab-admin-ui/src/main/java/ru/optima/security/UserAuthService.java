package ru.optima.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.optima.persist.model.Role;
import ru.optima.persist.repo.KitRepository;
import ru.optima.persist.repo.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserAuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByLastName(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getLastName(),
                        user.getPassword(),
                        mapRolesToAuthorities(user.getRoles())
                ))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
