package org.example.expert.domain.todo.queryDsl;


import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;


@RequiredArgsConstructor
public class TodoRepositoryQueryDslImpl implements TodoRepositoryQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {
        QTodo qTodo = QTodo.todo;

        return Optional.ofNullable(jpaQueryFactory
            .select(qTodo)
            .from(qTodo)
            .join(qTodo.user)
            .fetchJoin()
            .where(qTodo.id.eq(todoId))
            .fetchOne());
    }
}
