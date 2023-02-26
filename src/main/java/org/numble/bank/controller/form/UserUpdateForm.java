package org.numble.bank.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserUpdateForm {
    @NotBlank
    private String name;
}
