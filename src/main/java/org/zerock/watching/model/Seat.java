package org.zerock.watching.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 좌석 ID (Primary Key)
    private String seatNumber; // 좌석 번호
    private boolean isAvailable; // 좌석 이용 가능 여부

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime; // 해당 좌석의 상영 시간 (Foreign Key)

}
