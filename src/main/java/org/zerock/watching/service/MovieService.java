package org.zerock.watching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.watching.model.Movie;
import org.zerock.watching.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // 영화 전체 목록 조회
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // 영화 개별 상세 조회
    // 영화 정보 등록
    // 영화 정보 삭제

}
