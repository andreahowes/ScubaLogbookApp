package com.andreahowes.dive_db.logic.SecurityModule;

import com.andreahowes.dive_db.data.SecurityData.RoleRepository;
import com.andreahowes.dive_db.data.SecurityData.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public Boolean checkCredentials(String email, String password){
        User user = userRepository.findByEmail(email);
        boolean passwordMatches = bCryptPasswordEncoder.matches(password, user.getPassword());
        if(passwordMatches){
            return true;
        }else{
            return false;
        }
    }



}
