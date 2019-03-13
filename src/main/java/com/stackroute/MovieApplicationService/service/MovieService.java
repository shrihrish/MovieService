package com.stackroute.MovieApplicationService.service;

import com.stackroute.MovieApplicationService.domain.Movie;
import com.stackroute.MovieApplicationService.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApplicationService.exceptions.MovieNotFoundException;
import com.stackroute.MovieApplicationService.repository.MovieRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;



@Service

public class  MovieService  implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    private MovieRepsitory movieRepsitory;

    @Autowired

    public MovieService(MovieRepsitory movieRepsitory) {
        this.movieRepsitory = movieRepsitory;
    }

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepsitory.existsById(movie.getId())){
            throw new MovieAlreadyExistsException("Movie Already Exist");
        }
        Movie savedMovie =movieRepsitory.save(movie);
        if (savedMovie ==null){
            throw new MovieAlreadyExistsException(" Movie Already Exist");
        }
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
        return movieRepsitory.findById(id).get();
    }

    public Movie searchMovie(Movie movie){
        Movie searchMovie = movieRepsitory.save(movie);
        return searchMovie;
    }
@Value("${name}")
String name;
    @Value("${length}")
    int length;
    @Value("${type}")
    String type;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
movieRepsitory.save(new Movie(1,name,length,type));
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepsitory.save(new Movie(1,name,length,type));

    }

    public List<Movie> getMovieByName(String name)throws MovieNotFoundException {
        if(movieRepsitory.searchMovieByName(name)==0)
        {
            throw new MovieNotFoundException("Movie not Found");
        }
        List<Movie> movieList= movieRepsitory.movieByName(name);
        return movieList;

    }
}

