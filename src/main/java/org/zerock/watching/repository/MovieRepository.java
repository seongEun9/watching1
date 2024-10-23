package org.zerock.watching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.watching.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}