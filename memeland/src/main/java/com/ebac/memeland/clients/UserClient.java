package com.ebac.memeland.clients;


import com.ebac.memeland.dto.input.UserInputDto;
import com.ebac.memeland.dto.output.UserOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "userService", url = "${user-service.url}")
public interface UserClient {

    @PostMapping
    UserOutputDto create(@RequestBody UserInputDto dto);

    @GetMapping
    List<UserOutputDto> find();
}
