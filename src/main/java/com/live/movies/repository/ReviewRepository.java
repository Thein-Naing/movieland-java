package com.live.movies.repository;

import com.live.movies.Review;
import com.live.movies.controller.MovieController;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<MovieController.Review, ObjectId> {
    Review insert(Review review);
}
