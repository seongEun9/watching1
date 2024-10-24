package org.zerock.watching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String title;
    private String description;
    private String genre;
    private LocalDate releaseDate;
    private String poster; // 파일 경로
    private MultipartFile posterFile; // 파일
    private String director;
    private String actors;
    private String rating;
    private int runtime;
    private String  status; // 영화 상태 (타입:3가지)
}
