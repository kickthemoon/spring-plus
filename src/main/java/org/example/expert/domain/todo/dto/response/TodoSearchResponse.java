package org.example.expert.domain.todo.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class TodoSearchResponse {

    private final String title;
    private final Long cntManager;
    private final Long cntComment;
    private final LocalDateTime createdAt;


    public TodoSearchResponse(String title, Long cntManager, Long cntComment,
        LocalDateTime createdAt) {
        this.title = title;
        this.cntManager = cntManager;
        this.cntComment = cntComment;
        this.createdAt = createdAt;
    }
}
