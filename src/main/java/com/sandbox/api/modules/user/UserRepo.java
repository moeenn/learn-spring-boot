package com.sandbox.api.modules.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
    @Query(value = """
                select u.*
                from users u
                limit :limit
                offset :offset
            """, nativeQuery = true)
    List<UserEntity> listPaginated(@Param("limit") int limit, @Param("offset") int offset);
}
