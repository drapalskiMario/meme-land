package com.ebac.memeland.controllers;

import com.ebac.memeland.clients.MemeClient;
import com.ebac.memeland.dto.input.MemeCategoryInputDto;
import com.ebac.memeland.dto.input.MemeInputDto;
import com.ebac.memeland.dto.output.MemeCategoryOutputDto;
import com.ebac.memeland.dto.output.MemeOutputDto;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class MemesController {

    @Autowired
    private MemeClient client;

    @GetMapping("/categories")
    public List<MemeCategoryOutputDto> findCategories() {
        return client.findCategories();
    }

    @PostMapping("/categories")
    public MemeCategoryOutputDto createCategory(@Valid @RequestBody MemeCategoryInputDto dto) {
        return client.createCategory(dto);
    }

    @GetMapping("/memes")
    public List<MemeOutputDto> findMeme() {
        return client.findMemes();
    }

    @PostMapping("/memes")
    public MemeOutputDto createMeme(@Valid @RequestBody MemeInputDto dto) {
        try {
            return client.createMeme(dto);
        } catch (FeignException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid userId: " + dto.getUserId() + " or memeCategoryId: " + dto.getMemeCategoryId(), exception.getCause());
        }
    }
}
