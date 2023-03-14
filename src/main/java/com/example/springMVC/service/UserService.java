package com.example.springhello.service;

import com.example.springhello.dao.UserDao;
import com.example.springhello.dto.UpdateAgeRequest;
import com.example.springhello.dto.UpdateAgeResponse;
import com.example.springhello.dto.UpdatePhoneNumberRequest;
import com.example.springhello.dto.UserResponse;
import com.example.springhello.entity.User;
import com.example.springhello.exception.UserException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User updatePhoneNumberByNameAndAge(UpdatePhoneNumberRequest request) {
        final User requestUser = request.toUser();
        final User realUser = userDao.getUser(request.getId());

        requestUser.validateEqualByNameAndAge(realUser);

        if (requestUser.getPhoneNumber().equals(realUser.getPhoneNumber())) {
            throw new UserException("휴대폰 번호가 중복되었습니다.");
        }
        userDao.updatePhoneNumberById(request);
        return requestUser;
    }

    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    public Long insertUser(User user) {
        return userDao.insertUser(user);
    }

    public List<UserResponse> getAllUsers() {
        return UserResponse.listOf(userDao.getAllUsers());
    }

    public UserResponse updateUserById(User user) {
        return UserResponse.of(userDao.updateUserById(user));
    }

    public UpdateAgeResponse updateAgeById(UpdateAgeRequest request) {
        return userDao.updateAgeById(request);
    }

    public Long deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
