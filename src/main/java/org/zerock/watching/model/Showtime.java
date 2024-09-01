package org.zerock.watching.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 상영 시간 ID (Primary Key)
    private LocalDateTime startTime; // 상영 시작 시간

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie; // 상영 영화 (Foreign Key)

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater; // 상영 극장 (Foreign Key)

}
