package com.stackroute.MovieApplicationService.controller;

import com.stackroute.MovieApplicationService.domain.Movie;
import com.stackroute.MovieApplicationService.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApplicationService.exceptions.MovieNotFoundException;
import com.stackroute.MovieApplicationService.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private MovieService movieService;

@Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> saveUser(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);

            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }

        return responseEntity;
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie,@PathVariable int id) {
        movie.setId(id);
        Movie updateMovie  = movieService.updateMovie(movie);
        return new ResponseEntity<Movie>(updateMovie,HttpStatus.OK);
    }

    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> getAllUsers() {
        List<Movie> allmovie = movieService.getAllMovie();
        return new ResponseEntity<>(allmovie, HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie movieById = movieService.getMovieById(id);
        return new ResponseEntity<Movie>(movieById, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<?> getMovieByName(@PathVariable String name){
    ResponseEntity responseEntity;
    try
    {
        List<Movie> movieByName = movieService.getMovieByName(name);
        responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
    }
    catch (MovieNotFoundException ex)
    {
        responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        ex.printStackTrace();

    }
    return responseEntity;
    }


}
