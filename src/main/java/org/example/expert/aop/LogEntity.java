package org.example.expert.aop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.entity.Timestamped;


@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "log")
public class LogEntity extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logUserId;
    private String logRequestUrl;
    private LocalDateTime logRequestTime;
    private String logMethodName;
}
