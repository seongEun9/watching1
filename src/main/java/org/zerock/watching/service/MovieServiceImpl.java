package org.zerock.watching.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.watching.dto.MovieDTO;
import org.zerock.watching.model.Movie;
import org.zerock.watching.repository.MovieRepository;
import org.zerock.watching.service.MovieService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper; // ModelMapper 사용

    private static final String UPLOAD_DIR = "src/main/resources/static/img/";

    // 영화 전체 목록 조회
    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class)) // 엔티티 -> DTO 변환
                .collect(Collectors.toList());
    }

    // 영화 개별 조회
    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
        return modelMapper.map(movie, MovieDTO.class); // 엔티티 -> DTO 변환
    }

    // 영화 등록
    @Override
    public void registerMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class); // DTO -> 엔티티 변환
        processFile(movieDTO.getPosterFile(), movie); // 파일 업로드 처리
        movieRepository.save(movie); // 영화 저장
    }

    // 영화 수정
    @Override
    public void modifyMovie(Long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
        modelMapper.map(movieDTO, movie); // DTO -> 기존 엔티티에 덮어씀
        if (movieDTO.getPosterFile() != null && !movieDTO.getPosterFile().isEmpty()) {
            processFile(movieDTO.getPosterFile(), movie); // 새로운 파일이 있으면 파일 처리
        }
        movieRepository.save(movie); // 수정된 영화 저장
    }

    // 영화 삭제
    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // 파일 업로드 처리
    private void processFile(MultipartFile file, Movie movie) {
        if (file != null && !file.isEmpty()) {
            try {
                String originalFileName = file.getOriginalFilename();
                String fileName = System.currentTimeMillis() + "_" + originalFileName;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);
                Files.write(filePath, file.getBytes());
                movie.setPoster("img/" + fileName); // 저장 경로 설정
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
