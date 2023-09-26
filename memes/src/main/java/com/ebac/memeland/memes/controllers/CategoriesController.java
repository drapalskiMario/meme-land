package com.ebac.memeland.memes.controllers;

import com.ebac.memeland.memes.dto.input.MemeCategoryInputDto;
import com.ebac.memeland.memes.dto.output.MemeCategoryOutputDto;
import com.ebac.memeland.memes.entities.Category;
import com.ebac.memeland.memes.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoryRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemeCategoryOutputDto create(@Valid @RequestBody MemeCategoryInputDto inputDto) {
        final var category = new Category(inputDto.getName(), inputDto.getDescription());
        repository.save(category);
        return toOutputDto(category);
    }

    @GetMapping
    public List<MemeCategoryOutputDto> find() {
        final var categoryList = repository.findAll();
        final var outputDtoList = new ArrayList<MemeCategoryOutputDto>();

        for (Category category: categoryList) {
            final var outputDto = toOutputDto(category);
            outputDtoList.add(outputDto);
        }

        return outputDtoList;
    }

    private MemeCategoryOutputDto toOutputDto(Category category) {
        return new MemeCategoryOutputDto(category.getId(), category.getName(), category.getDescription());
    }
}
