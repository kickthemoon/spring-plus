package org.example.expert.domain.todo.queryDsl;


import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.manager.entity.QManager;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


@RequiredArgsConstructor
public class TodoRepositoryQueryDslImpl implements TodoRepositoryQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    QUser qUser = QUser.user;
    QTodo qTodo = QTodo.todo;
    QManager qManager = QManager.manager;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {

        return Optional.ofNullable(jpaQueryFactory
            .select(qTodo)
            .from(qTodo)
            .join(qTodo.user)
            .fetchJoin()
            .where(qTodo.id.eq(todoId))
            .fetchOne());
    }

    @Override
    public Page<Todo> findBySearchTitle(String title, Pageable pageable) {
        List<Todo> content = jpaQueryFactory
            .select(qTodo)
            .from(qTodo)
            .where(qTodo.title.eq(title))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        Long total = jpaQueryFactory
            .select(qTodo.count())
            .from(qTodo)
            .where(qTodo.title.eq(title))
            .fetchOne();

        long totals = total != null ? total : 0;

        return new PageImpl<>(content, pageable, totals);
    }

    @Override
    public Page<Todo> findBySearchMenager(String manager, Pageable pageable) {

        List<Todo> content = jpaQueryFactory
            .select(qTodo)
            .from(qTodo)
            .join(qTodo.managers, qManager)
            .join(qManager.user, qUser)
            .where(qUser.nickname.eq(manager))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        Long total = jpaQueryFactory
            .select(qTodo.count())
            .from(qTodo)
            .join(qTodo.managers, qManager)
            .join(qManager.user, qUser)
            .where(qUser.nickname.eq(manager))
            .fetchOne();

        long totals = total != null ? total : 0;

        return new PageImpl<>(content, pageable, totals);
    }
}
