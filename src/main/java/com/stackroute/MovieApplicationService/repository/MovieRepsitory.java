package com.stackroute.MovieApplicationService.repository;


import com.stackroute.MovieApplicationService.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface MovieRepsitory extends JpaRepository<Movie,Integer> {
}
