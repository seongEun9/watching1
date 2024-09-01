package org.zerock.watching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.watching.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // 추가적으로 필요한 쿼리 메서드를 정의할 수 있습니다.
}