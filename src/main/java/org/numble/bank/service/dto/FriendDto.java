package org.numble.bank.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.numble.bank.repository.User;

@Getter
@RequiredArgsConstructor
public class FriendDto {
    private final Long id;
    private final String name;

    public static FriendDto of(User friend) {
        return new FriendDto(friend.getId(), friend.getName());
    }
}
