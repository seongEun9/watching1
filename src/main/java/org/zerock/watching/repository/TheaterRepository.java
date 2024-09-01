package org.zerock.watching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.watching.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    // 추가적으로 필요한 쿼리 메서드를 정의할 수 있습니다.
}