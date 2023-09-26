package com.ebac.memeland.controllers;


import com.ebac.memeland.clients.UserClient;
import com.ebac.memeland.dto.input.UserInputDto;
import com.ebac.memeland.dto.output.UserOutputDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia/users")
public class UsersController {
    @Autowired
    private UserClient client;

    @GetMapping
    public List<UserOutputDto> find(HttpServletRequest request) {
        return client.find();
    }

    @PostMapping
    public UserOutputDto create(@Valid @RequestBody UserInputDto dto) {
        return client.create(dto);
    }
}
