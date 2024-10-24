package org.zerock.watching.service;

import org.zerock.watching.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    // 영화 전체 목록 조회
    List<MovieDTO> getAllMovies();
    // 영화 개별 상세 조회
    MovieDTO getMovieById(Long id);
    // 영화 정보 등록
    void registerMovie(MovieDTO movieDTO);
    // 영화 정보 수정
    void modifyMovie(Long id, MovieDTO movieDTO);
    // 영화 정보 삭제
    void deleteMovie(Long id);
}
