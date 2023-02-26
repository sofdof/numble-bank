package org.numble.bank.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.numble.bank.controller.form.UserCreateForm;
import org.numble.bank.controller.form.UserUpdateForm;
import org.numble.bank.repository.User;
import org.numble.bank.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User create(@NonNull UserCreateForm form) {
        User user = userRepository.findByEmail(form.getEmail());
        if (user != null) {
            throw new ValidationException("이미 가입된 이메일입니다.");
        }

        user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword1());
        user.setName(form.getName());

        return userRepository.save(user);
    }

    public User update(@NonNull Long userId, @NonNull UserUpdateForm form) {
        User user = userRepository.getReferenceById(userId);
        if (user == null) {
            throw new ValidationException("사용자 정보가 없습니다.");
        }
        user.setName(form.getName());
        return user;
    }

    public User changePassword(@NonNull Long userId, @NonNull String password) {
        User user = userRepository.getReferenceById(userId);
        if (user == null) {
            throw new ValidationException("사용자 정보가 없습니다.");
        }
        user.setPassword(password);
        return user;
    }

    public void delete(@NonNull Long userId) {
        User user = userRepository.getReferenceById(userId);
        if (user == null) {
            return;
        }
        userRepository.delete(user);
    }
}
