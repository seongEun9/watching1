package org.zerock.watching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.watching.model.User;
import org.zerock.watching.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 모든 사용자 정보를 가져오는 메서드
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ID로 사용자 정보를 가져오는 메서드
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // 새로운 사용자를 생성하는 메서드
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // ID로 사용자를 삭제하는 메서드
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}