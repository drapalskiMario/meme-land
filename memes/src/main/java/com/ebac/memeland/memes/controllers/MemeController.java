package com.ebac.memeland.memes.controllers;

import com.ebac.memeland.memes.clients.UserClient;
import com.ebac.memeland.memes.dto.input.MemeInputDto;
import com.ebac.memeland.memes.dto.output.MemeCategoryOutputDto;
import com.ebac.memeland.memes.dto.output.MemeOutputDto;
import com.ebac.memeland.memes.entities.Category;
import com.ebac.memeland.memes.entities.Meme;
import com.ebac.memeland.memes.repositories.CategoryRepository;
import com.ebac.memeland.memes.repositories.MemeRepository;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/memes")
public class MemeController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private UserClient userClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@Valid @RequestBody MemeInputDto inputDto) {
        try {
            final var category = categoryRepository.findById(inputDto.getMemeCategoryId());
            if (category.isEmpty()) {
                return ResponseEntity.badRequest().body("Invalid category id");
            }

            final var user = userClient.findById(inputDto.getUserId());
            final var meme = new Meme(inputDto.getName(), inputDto.getDescription(), user.getId(), category.get());
            memeRepository.save(meme);

            return ResponseEntity.status(HttpStatus.CREATED).body(toOutputDto(meme));
        } catch (FeignException e) {
            return ResponseEntity.badRequest().body("Invalid user id");
        }
    }

    @GetMapping
    public List<MemeOutputDto> find() {
        final var memeList = memeRepository.findAll();
        final var outputDtoList = new ArrayList<MemeOutputDto>();

        for (Meme meme : memeList) {
            final var outputDto = toOutputDto(meme);
            outputDtoList.add(outputDto);
        }

        return outputDtoList;
    }

    private MemeOutputDto toOutputDto(Meme meme) {
        final var memeCategoryDto = toCategoryOutputDto(meme.getMemeCategory());
        return new MemeOutputDto(meme.getId(), meme.getName(), meme.getDescription(), memeCategoryDto, meme.getUserId());
    }

    private MemeCategoryOutputDto toCategoryOutputDto(Category category) {
        return new MemeCategoryOutputDto(category.getId(), category.getName(), category.getDescription());
    }
}
