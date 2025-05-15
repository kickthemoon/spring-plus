# SPRING PLUS

3-10 api : https://lush-pelican-577.notion.site/lv3-10-QueryDSL-API-1f327317404480fba3beffd3553b17ee

도전 레벨 3-11번 까지 해결 했습니다

=====================================================================

Level 1 - 1. 코드 개선 퀴즈 - @Transactional의 이해
TodoService 수정

Level 1 - 2. 코드 추가 퀴즈 - JWT의 이해
User, AuthService.signup(), SignupRequest 수정

Level 1 - 3. 코드 개선 퀴즈 -  JPA의 이해
TodoService.getTodos(), TodoRepository, TodoController.getTodos() 수정

Level 1 - 4. 테스트 코드 퀴즈 - 컨트롤러 테스트의 이해
TodoControllerTest.todo_단건_조회_시_todo가_존재하지_않아_예외가_발생한다() 수정

Level 1 - 5. 코드 개선 퀴즈 - AOP의 이해
AdminAccessLoggingAspect 수정

Level 2 - 6. JPA Cascade
Todo 수정

Level 2 - 7. N+1
CommentRepository 수정

Level 2 - 8. QueryDSL
TodoRepository.findByIdWithUser 제거, QueryDslConfig,TodoRepositoryQueryDsl,TodoRepositoryQueryDslImpl 추가

Level 2 - 9. Spring Security
WebConfig, FilterConfig 제거, SecurityConfig 추가, JwtFilter 메서드 수정

Level 3 - 10. QueryDSL 을 사용하여 검색 기능 만들기
TodoSearchResponse, TodoController.getTodoSearchs(), TodoService.getTodoSearchs(), 
TodoRepositoryQueryDsl 및 TodoRepositoryQueryDslImpl 의 findBySearchTitle(),findBySearchMenager()를 추가

Level 3 - 11. Transaction 심화
AdminAccessLoggingAspect.logBeforeManagerPostController(),
LogEntity, LoggingService, LogRepository 추가

