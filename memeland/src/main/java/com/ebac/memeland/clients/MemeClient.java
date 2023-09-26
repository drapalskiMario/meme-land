package com.ebac.memeland.clients;

import com.ebac.memeland.dto.input.MemeCategoryInputDto;
import com.ebac.memeland.dto.input.MemeInputDto;
import com.ebac.memeland.dto.output.MemeCategoryOutputDto;
import com.ebac.memeland.dto.output.MemeOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "memeService", url = "${meme-service.url}")
public interface MemeClient {

    @PostMapping("/categories")
    MemeCategoryOutputDto createCategory(@RequestBody MemeCategoryInputDto dto);

    @GetMapping("/categories")
    List<MemeCategoryOutputDto> findCategories();

    @PostMapping("/memes")
    MemeOutputDto createMeme(@RequestBody MemeInputDto dto);

    @GetMapping("/memes")
    List<MemeOutputDto> findMemes();
}
