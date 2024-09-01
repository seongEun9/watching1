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
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 예약 ID (Primary Key)

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 예약한 사용자 (Foreign Key)

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime; // 예약한 상영 시간 (Foreign Key)

    private LocalDateTime bookingTime; // 예약 시간

}
