package com.live.movies.controller;

import com.live.movies.model.Movie;
import com.live.movies.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins ="*")
    public class MovieController {


        @Autowired
        private MovieService movieService;

        @GetMapping
        public ResponseEntity<List<Movie>>getAllMovies() {
            return  new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
        }

        @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>>getSpecificMovie(@PathVariable String imdbId) {
            return new ResponseEntity<Optional<Movie>>(movieService.specificMovie(imdbId), HttpStatus.OK);
        }

    @Document(collection="reviews")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Review {
        private ObjectId id;
        private String body;


    }
}


