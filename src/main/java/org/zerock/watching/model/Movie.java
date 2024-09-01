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

}
