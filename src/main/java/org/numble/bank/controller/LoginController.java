package org.numble.bank.controller;

import lombok.RequiredArgsConstructor;
import org.numble.bank.controller.form.LoginForm;
import org.numble.bank.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginForm form) {
        loginService.login(form);
        return "로그인 성공";
    }
}
