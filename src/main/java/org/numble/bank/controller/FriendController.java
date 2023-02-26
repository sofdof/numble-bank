package org.numble.bank.controller;

import lombok.RequiredArgsConstructor;
import org.numble.bank.controller.form.FriendCreateForm;
import org.numble.bank.repository.Friend;
import org.numble.bank.repository.User;
import org.numble.bank.service.FriendService;
import org.numble.bank.service.dto.FriendDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;
    @PostMapping("/friend/create")
    public Friend createFriend(@RequestBody @Valid FriendCreateForm form){
        form.validate();
        return friendService.create(form);
    }

    @PostMapping("/friend/delete/{id}")
    public String deleteFriend(@PathVariable Long id){
        friendService.softDelete(id);
        return "삭제 완료";
    }

    @GetMapping("/friends")
    public List<FriendDto> getList(@PathVariable Long id) {
        return friendService.getList(id);
    }
}
