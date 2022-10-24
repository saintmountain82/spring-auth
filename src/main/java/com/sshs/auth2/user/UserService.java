package com.sshs.auth2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User createUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new AlreadyRegisteredUserException();
        }
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authority(user.getAuthority())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }

}
