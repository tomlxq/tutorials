package com.tom.validation.listvalidation.controller;

import com.tom.validation.listvalidation.constraint.MaxSizeConstraint;
import com.tom.validation.listvalidation.model.Movie;
import com.tom.validation.listvalidation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public void addAll(@RequestBody @NotEmpty(message = "Input movie list cannot be empty.") @MaxSizeConstraint List<@Valid Movie> movies) {
        movieService.addAll(movies);
    }
}
