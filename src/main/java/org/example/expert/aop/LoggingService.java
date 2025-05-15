package org.example.expert.aop;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoggingService {

    private final LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(String userId, String requestUrl, LocalDateTime requestTime, String methodName) {
       LogEntity log = LogEntity.builder()
           .logUserId(userId)
           .logRequestUrl(requestUrl)
           .logRequestTime(requestTime)
           .logMethodName(methodName)
           .build();

       logRepository.save(log);
    }
}
