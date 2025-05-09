package org.example.expert.domain.todo.repository;

import java.time.LocalDateTime;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.queryDsl.TodoRepositoryQueryDsl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryQueryDsl {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u "
        + "WHERE (:weather IS NULL OR t.weather LIKE %:weather%) "
        + "AND (:startDate IS NULL OR t.createdAt >= :startDate) "
        + "AND (:endDate IS NULL OR t.createdAt <= :endDate)"
        + "ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable,
                                              @Param("weather") String weather,
                                              @Param("startDate") LocalDateTime startDate,
                                              @Param("endDate") LocalDateTime endDate);

/*    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);*/
}


// findByStoreNameContainingOrElseThrow