package org.numble.bank.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserPasswordUpdateForm {
    @NotBlank
    private String password1;
    @NotBlank
    private String password2;

    public void validate(){
        if (!password1.equals(password2)) {
            throw new ValidationException("비밀번호가 다릅니다.");
        }
    }
}
