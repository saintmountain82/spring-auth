package com.sshs.auth2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 유저 등록
     *
*    * @param email email
     * @param password password
     * @return 유저 권한을 가지고 있는 유저
     */
    public User signup(String email, String password) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = userRepository.findByEmail(email);
        if (user != null) {
            throw new AlreadyRegisteredUserException();
        }

        return userRepository.save(
                User.builder()
                        .username(email)
                        .email(email)
                        .password(passwordEncoder.encode(password))
                        .authority("ROLE_USER")
                        .build()
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return user;
    }
}
