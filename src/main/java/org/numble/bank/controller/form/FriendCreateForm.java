package org.numble.bank.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FriendCreateForm {
    @NotNull
    private Long userId;
    @NotNull
    private Long friendId;

    public void validate() {
        if (userId.equals(friendId)) {
            throw new ValidationException();
        }
    }
}
