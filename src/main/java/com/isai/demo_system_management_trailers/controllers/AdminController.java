package com.isai.demo_system_management_trailers.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isai.demo_system_management_trailers.models.Movie;
import com.isai.demo_system_management_trailers.repositorys.GenderRepository;
import com.isai.demo_system_management_trailers.repositorys.MovieRepository;
import com.isai.demo_system_management_trailers.services.imp.WarehouseServiceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final MovieRepository movieRepository;
    private final GenderRepository genderRepository;
    private final WarehouseServiceImp warehouseServiceImp;

    @GetMapping("")
    public ModelAndView seePageHome(@PageableDefault(sort = "title", size = 5) Pageable pageable) {
        Page<Movie> movies = movieRepository.findAll(pageable);
        return new ModelAndView("index")
                .addObject("movies", movies);
    }

}