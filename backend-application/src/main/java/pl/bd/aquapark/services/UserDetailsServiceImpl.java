package pl.bd.aquapark.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.endpoint.user.data.UserPrincipal;
import pl.bd.aquapark.endpoint.user.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.getUserByUserName(username);

        if(user == null)
            throw new UsernameNotFoundException(username);

        log.info("loadUserByUsername() : {}", username);

        return new UserPrincipal(user);
    }
}
