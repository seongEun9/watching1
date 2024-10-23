package org.zerock.watching.controller;

import org.springframework.ui.Model;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.watching.model.Movie;
import org.zerock.watching.service.MovieService;

import java.util.List;

@Controller
@RequestMapping("/movie")
@Log4j2
public class MovieController {

    @Autowired
    private MovieService movieService;

    // 영화 전체 목록 조회
    @GetMapping("/list")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies); // 모델에 영화 추가
        return "movie/list";
    }

    // 영화 개별 조회


    // 영화 등록 페이지 표시
    // 영화 정보 등록


    // 영화 수정 페이지 표시
    // 영화 정보 수정


    // 영화 정보 삭제

}
