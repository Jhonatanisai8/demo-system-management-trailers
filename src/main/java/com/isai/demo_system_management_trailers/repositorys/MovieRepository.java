package com.isai.demo_system_management_trailers.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isai.demo_system_management_trailers.models.Movie;

public interface MovieRepository
        extends JpaRepository<Movie, Integer> {

    Movie findByIdMovie(Integer idMovie);
}
