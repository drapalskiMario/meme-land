package com.ebac.memeland.memes.clients;


import com.ebac.memeland.memes.dto.output.UserOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userService", url = "${user-service.url}")
public interface UserClient {

    @GetMapping("/{id}")
    UserOutputDto findById(@PathVariable Long id);
}
