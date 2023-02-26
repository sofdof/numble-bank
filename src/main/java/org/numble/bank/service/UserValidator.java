package org.numble.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
@RequiredArgsConstructor
public class UserValidator {
    public void validate(String password1, String password2){
        if (!password1.equals(password2)) {
            throw new ValidationException("비밀번호가 다릅니다.");
        }
    }
}
