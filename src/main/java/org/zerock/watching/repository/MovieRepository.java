package org.zerock.watching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.watching.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}