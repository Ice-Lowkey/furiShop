package vn.t3h.class2109.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.UserDto;
import vn.t3h.class2109.entities.UserEntity;
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.repositories.UserRepository;

import java.util.Optional;


@Service
public class UserService implements TableService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = userDto.mapperEntity();
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public void findAll(PagingAndSortOject page) {
        page.findAll(userRepository);
    }

    public Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getId();
        }
        return null;
    }

    public String getCurrentUserName() {
        Object princial = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (princial instanceof  CustomUserDetails) {
            return ((CustomUserDetails) princial).getUsername();
        }
        return null;
    }
}
