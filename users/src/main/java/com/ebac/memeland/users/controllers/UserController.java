package com.ebac.memeland.users.controllers;

import com.ebac.memeland.users.dto.UserInputDto;
import com.ebac.memeland.users.dto.UserOutputDto;
import com.ebac.memeland.users.entities.User;
import com.ebac.memeland.users.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserOutputDto create(@Valid @RequestBody UserInputDto inputDto) {
        final var user = new User(inputDto.getName(), inputDto.getEmail());
        repository.save(user);
        return toUserOutputDto(user);
    }

    @GetMapping
    public List<UserOutputDto> find() {
        final var userList = repository.findAll();
        final var outputDtoList = new ArrayList<UserOutputDto>();

        for (User user : userList) {
            final var outputDto = toUserOutputDto(user);
            outputDtoList.add(outputDto);
        }

        return outputDtoList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutputDto> findById(@PathVariable Long id) {
        final var user = repository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(toUserOutputDto(user.get()));
    }

    private UserOutputDto toUserOutputDto(User user) {
        return new UserOutputDto(user.getId(), user.getName(), user.getEmail());
    }
}
