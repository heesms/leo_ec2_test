package com.ec2.springboot.web;


import com.ec2.springboot.service.PostsService;
import com.ec2.springboot.web.dto.PostsListResponseDto;
import com.ec2.springboot.web.dto.PostsResponseDto;
import com.ec2.springboot.web.dto.PostsSaveRequestDto;
import com.ec2.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        log.debug("test1234");
        return postsService.save(requestDto); }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        log.debug("test1234");
        return postsService.findAllDesc();
    }
}
