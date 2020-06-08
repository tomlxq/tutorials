package com.tom.springpagination;

import com.alibaba.fastjson.JSON;
import com.tom.springpagination.dto.PostDto;
import com.tom.springpagination.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

@Slf4j
public class PostDtoUnitTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertPostEntityToPostDto_thenCorrect() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle(randomAlphabetic(6));
        post.setUrl("www.test.com");
        post.setDate("2020-06-07 22:45");

        PostDto postDto = modelMapper.map(post, PostDto.class);
        assertEquals(post.getId(), postDto.getId());
        assertEquals(post.getTitle(), postDto.getTitle());
        assertEquals(post.getUrl(), postDto.getUrl());
        log.info("{}", JSON.toJSONString(postDto, true));
    }

    @Test
    public void whenConvertPostDtoToPostEntity_thenCorrect() {
        PostDto postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle(randomAlphabetic(6));
        postDto.setUrl("www.test.com");
        postDto.setDate("2020-06-07 22:45");
        Post post = modelMapper.map(postDto, Post.class);
        assertEquals(postDto.getId(), post.getId());
        assertEquals(postDto.getTitle(), post.getTitle());
        assertEquals(postDto.getUrl(), post.getUrl());
        log.info("{}", JSON.toJSONString(post, true));
    }
}