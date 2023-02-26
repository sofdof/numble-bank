package org.numble.bank.service;

import lombok.RequiredArgsConstructor;
import org.numble.bank.controller.form.LoginForm;
import org.numble.bank.repository.User;
import org.numble.bank.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    public void login(LoginForm form) {
        User user = userRepository.findByEmail(form.getEmail());
        if (user == null) {
            throw new ValidationException("사용자 정보가 없습니다.");
        }

        if (!user.getPassword().equals(form.getPassword())) {
            throw new ValidationException("잘못된 비밀번호입니다.");
        }
    }
}
