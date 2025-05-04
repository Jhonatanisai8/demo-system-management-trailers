package com.isai.demo_system_management_trailers.controllers;

import com.isai.demo_system_management_trailers.models.Movie;
import com.isai.demo_system_management_trailers.repositorys.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {
    private final MovieRepository movieRepository;


    @GetMapping
    public ModelAndView ver() {
        List<Movie> latestMovies = movieRepository.findAll(
                        PageRequest.of(0, 4,
                                Sort.by("datePremiere")
                                        .descending()))
                .toList();

        return new ModelAndView("index")
                .addObject("latestMovies", latestMovies);

    }

    @GetMapping(path = "/movies")
    public ModelAndView listMoviesHome(
            @PageableDefault(sort = "datePremiere", direction = Sort.Direction.DESC)
            Pageable pageable) {
        Page<Movie> latestMovies = movieRepository.findAll(pageable);
        return new ModelAndView("movies")
                .addObject("latestMovies", latestMovies);
    }

    @GetMapping(path = "/movies/{idMovie}")
    public ModelAndView showMovieDetails(
            @PathVariable Integer idMovie) {
        Movie movie = movieRepository.findByIdMovie(idMovie);
        return new ModelAndView("movie")
                .addObject("movie", movie);
    }

}
