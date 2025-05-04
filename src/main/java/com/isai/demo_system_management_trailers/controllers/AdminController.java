package com.isai.demo_system_management_trailers.controllers;

import com.isai.demo_system_management_trailers.models.Gender;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isai.demo_system_management_trailers.models.Movie;
import com.isai.demo_system_management_trailers.repositorys.GenderRepository;
import com.isai.demo_system_management_trailers.repositorys.MovieRepository;
import com.isai.demo_system_management_trailers.services.imp.WarehouseServiceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
        return new ModelAndView("admin/index")
                .addObject("movies", movies);
    }

    @GetMapping("/movies/new")
    public ModelAndView showFormNewMovie() {
        List<Gender> genders = genderRepository.findAll(Sort.by("title"));
        return new ModelAndView("admin/new-movie")
                .addObject("movie", new Movie())
                .addObject("genders", genders);
    }

    @PostMapping(path = "/movies/new")
    public ModelAndView movieregistrar(
            @Valid Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || movie.getFileCover().isEmpty()) {
            if (movie.getFileCover().isEmpty()) {
                bindingResult.reject("fileCover", "MultiplartNotEmpty");
            }
            List<Gender> genders = genderRepository.findAll(Sort.by("title"));
            return new ModelAndView("admin/new-movie")
                    .addObject("movie", movie)
                    .addObject("genders", genders);
        }
        String routeCover = warehouseServiceImp.storeFile(movie.getFileCover());
        movie.setRouteCover(routeCover);
        movieRepository.save(movie);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping(path = "/movies/{movieId}/edit")
    public ModelAndView showFormEditMovie(@PathVariable Integer movieId) {
        List<Gender> genders = genderRepository.findAll(Sort.by("title"));
        Movie movie = movieRepository.findByIdMovie(movieId);
        return new ModelAndView("admin/edit-movie")
                .addObject("movie", movie)
                .addObject("genders", genders);
    }


}