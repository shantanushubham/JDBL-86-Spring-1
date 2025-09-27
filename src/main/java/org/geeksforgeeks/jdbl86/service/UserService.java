package org.geeksforgeeks.jdbl86.service;

import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.geeksforgeeks.jdbl86.execptions.NotFoundException;
import org.geeksforgeeks.jdbl86.repository.impl.UserRepository;
import org.geeksforgeeks.jdbl86.utils.BCryptUtil;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserEntity userEntity) {
        userEntity.setPassword(BCryptUtil.encryptPassword(userEntity.getPassword()));
        return this.userRepository.addUser(userEntity);
    }

    //public UserEntity authenticateUser(String email, String password) {
    //  if (EmailValidator.isValidEmail(email) ) {
           // UserEntity foundUser = this.userRepository.getUserByEmail(email);
            // Generate an OTP and send to their email/no using Twilio, Mailchimp etc
            // Set a redis key as OTP for the user when OTP sending is successful
            // (with a TTL of 5 min)
    // }
    //}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            // Regex implementation
            UserEntity userEntity = this.userRepository.getUserByEmail(username);
            return User.withUsername(userEntity.getEmail())
                    .password(userEntity.getPassword()) // fetch the OTP from redis and send here
                    .build();
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
    }
}
