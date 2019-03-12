package com.stackroute.MovieApplicationService.service;

import com.stackroute.MovieApplicationService.domain.Movie;
import com.stackroute.MovieApplicationService.repository.MovieRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepsitory movieRepsitory;

    @Autowired
    public MovieService(MovieRepsitory movieRepsitory) {
        this.movieRepsitory = movieRepsitory;
    }

    public Movie saveMovie(Movie movie){
        Movie savedMovie =movieRepsitory.save(movie);
        return  savedMovie;
    }

    public Movie updateMovie(Movie movie){
        Movie updateMovie = movieRepsitory.save(movie);
        return updateMovie;
    }

    public List<Movie> getAllMovie(){
        return (List<Movie>) movieRepsitory.findAll();
    }

    public  Movie getMovieById(int id){
        return movieRepsitory.getOne(id);
    }
}
