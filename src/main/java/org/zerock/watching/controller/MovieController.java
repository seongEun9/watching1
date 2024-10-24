package org.zerock.watching.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.watching.dto.MovieDTO;
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
        List<MovieDTO> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies); // 모델에 영화 목록 추가
        return "movie/list";
    }

    // 영화 등록 페이지 표시
    @GetMapping("/register")
    public String showRegisterPage() {
        return "movie/register";
    }

    // 영화 정보 등록
    @PostMapping("/register")
    public String registerMovie(@ModelAttribute MovieDTO movieDTO,
                                @RequestParam("poster") MultipartFile file) {
        movieDTO.setPosterFile(file); // 파일을 DTO에 설정
        movieService.registerMovie(movieDTO); // DTO를 사용하여 등록 처리
        return "redirect:/movie/list";
    }

    // 영화 수정 페이지 표시
    @GetMapping("/modify/{id}")
    public String showModifyPage(@PathVariable("id") Long id, Model model) {
        MovieDTO movieDTO = movieService.getMovieById(id); // 영화 DTO 조회
        model.addAttribute("movie", movieDTO); // 모델에 영화 추가
        return "movie/modify"; // 영화 수정 페이지로 이동
    }

    // 영화 정보 수정
    @PostMapping("/modify/{id}")
    public String modifyMovie(@PathVariable("id") Long id,
                              @ModelAttribute MovieDTO movieDTO,
                              @RequestParam("poster") MultipartFile file) {
        movieDTO.setPosterFile(file); // 파일을 DTO에 설정
        movieService.modifyMovie(id, movieDTO); // 수정 처리
        return "redirect:/movie/list";
    }

    // 영화 정보 삭제
    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movie/list";
    }
}
