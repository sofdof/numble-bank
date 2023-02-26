package org.numble.bank.controller;

import lombok.RequiredArgsConstructor;
import org.numble.bank.controller.form.UserCreateForm;
import org.numble.bank.controller.form.UserPasswordUpdateForm;
import org.numble.bank.controller.form.UserUpdateForm;
import org.numble.bank.repository.User;
import org.numble.bank.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @PostMapping("/user/create")
    public User createUser(@RequestBody @Valid UserCreateForm form){
        form.validate();
        return userService.create(form);
    }

    @PostMapping("/user/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateForm form){
        return userService.update(id, form);
    }

    @PostMapping("/user/update/password/{id}")
    public User updatePassword(@PathVariable Long id, @RequestBody @Valid UserPasswordUpdateForm form){
        return userService.changePassword(id, form.getPassword1());
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "삭제 성공";
    }
}
