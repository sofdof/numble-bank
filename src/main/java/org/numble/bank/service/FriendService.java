package org.numble.bank.service;

import lombok.RequiredArgsConstructor;
import org.numble.bank.controller.form.FriendCreateForm;
import org.numble.bank.repository.Friend;
import org.numble.bank.repository.FriendRepository;
import org.numble.bank.repository.User;
import org.numble.bank.repository.UserRepository;
import org.numble.bank.service.dto.FriendDto;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    public Friend create(FriendCreateForm form) {
        Map<Long, User> userMap = userRepository.findAllByIdAndDeleted(Arrays.asList(form.getUserId(), form.getFriendId()), false).stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        if (userMap.size() < 2) {
            throw new ValidationException("사용자 정보가 없습니다.");
        }

        Friend friend = new Friend();
        friend.setUser(userMap.get(form.getUserId()));
        friend.setFriend(userMap.get(form.getFriendId()));

        return friendRepository.save(friend);
    }

    public void softDelete(Long id) {
        Friend friend = friendRepository.getReferenceById(id);
        if (friend == null) {
            return;
        }
        friend.setDeleted(true);
        friendRepository.save(friend);
    }

    public List<FriendDto> getList(Long id) {
        User user = userRepository.getReferenceById(id);
        if (user == null) {
            return Collections.emptyList();
        }
        return friendRepository.findAllByUser(user).stream()
                .map(entity -> FriendDto.of(entity.getFriend()))
                .collect(Collectors.toList());
    }
}
