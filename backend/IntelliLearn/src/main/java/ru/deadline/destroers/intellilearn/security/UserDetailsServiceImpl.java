<<<<<<< HEAD
package ru.deadline.destroers.intellilearn.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
        //TODO: this method
    }
=======
package ru.deadline.destroers.intellilearn.security;public class UserDetailsServiceImpl {
>>>>>>> d784bcb403447ad4b1b20a800460330762eac89a
}
