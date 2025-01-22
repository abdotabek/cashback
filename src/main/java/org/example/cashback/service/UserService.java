package org.example.cashback.service;

import lombok.RequiredArgsConstructor;
import org.example.cashback.dto.UserDTO;
import org.example.cashback.entity.User;
import org.example.cashback.exception.ExceptionUtil;
import org.example.cashback.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        return toDTO(userRepository.save(user));
    }

    public UserDTO get(Long id) {
        return toDTO(userRepository.findById(id).orElseThrow(
                () -> ExceptionUtil.throwNotFoundException("user with id does not exist!")));
    }

    public List<UserDTO> getList() {
        return userRepository.findAll().stream().map(this::toDTO).toList();
    }

    public UserDTO update(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(
                () -> ExceptionUtil.throwNotFoundException("product with id does not exist!"));
        user.setName(userDTO.getName());
        return toDTO(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

}
