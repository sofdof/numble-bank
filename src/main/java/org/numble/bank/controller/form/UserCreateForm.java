package org.numble.bank.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank
    private String email;
    @NotBlank
    private String password1;
    @NotBlank
    private String password2;
    @NotBlank
    private String name;

    public void validate(){
        if (!password1.equals(password2)) {
            throw new ValidationException("비밀번호가 다릅니다.");
        }
    }
}
