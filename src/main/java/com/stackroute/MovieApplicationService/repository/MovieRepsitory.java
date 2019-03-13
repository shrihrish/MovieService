package com.stackroute.MovieApplicationService.repository;


import com.stackroute.MovieApplicationService.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface MovieRepsitory extends JpaRepository<Movie,Integer> {
    @Query(value="Select * from movie where name=?1",nativeQuery = true)
    List<Movie> movieByName(String movieName);

    @Query(value ="Select * from movie where type = ?2", nativeQuery = true)
    Movie movieByType(String movieType);

    @Query(value = "Select * from movie where length = ?3",nativeQuery = true)
    Movie movieByLength(String movieLength);

    @Query(value = "Select count(*) from movie where name=?1",nativeQuery = true)
    int searchMovieByName(String movieNAME);
}
