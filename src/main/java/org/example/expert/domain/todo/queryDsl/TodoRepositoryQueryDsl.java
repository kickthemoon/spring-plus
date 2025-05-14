package org.example.expert.domain.todo.queryDsl;


import java.util.Optional;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoRepositoryQueryDsl {

    Optional<Todo> findByIdWithUser(Long todoId);

    Page<Todo> findBySearchTitle(String title,Pageable pageable);

    Page<Todo> findBySearchMenager(String manager,Pageable pageable);
}
