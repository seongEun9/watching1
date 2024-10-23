package org.zerock.watching.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 영화 ID (Primary Key)
    private String title; // 영화 제목
    private String description; // 영화 설명
    private String genre; // 영화 장르
    private LocalDate releaseDate; // 개봉일
    private String poster; // 영화 포스터 경로

    private String director; // 영화 감독
    private String actors; // 영화 배우 (콤마로 구분 저장)
    private String rating; // 관람가
    private int runtime; // 영화 러닝타임 (분 단위)

    @Enumerated(EnumType.STRING)
    private MovieStatus status; // 영화 상태 (Enum 타입:3가지)
}
