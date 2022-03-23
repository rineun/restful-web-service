# Spring Boot를 이용한 RESTful Web Service 개발

## 👩🏻‍💻 목차
- Spring Boot로 개발하는 RESTful Service
  - HelloWord controller, Bean 추가
  - DispatcherServelt과 프로젝트 동작의 이해
  - Path variable 사용
- User Service API 구현
  - User 도메인 클래스 생성
  - 사용자 목록조회- GET HTTP Method
  - 사용자 등록조회 -POST HTTP Method
  - HTTP status code 제어
  - Spring AOP를 이용한 Exeption Handling
  - 사용자 삭제 - DELETE HTTP Method
- RESTful Service 기능 확장
  - 유효성체크를 위한 Validation Api 사용
  - 다국어처리를 위한 internationaliztion 구현방법
  - Response 데이터 형식 변환 (XML포맷)
  - Response 데이터 제어를 위한 Filtering
  - 프로그램으로 제어하는 Filtering방법 : 개별 사용자 조회
  - 프로그램으로 제어하는 Filtering방법 : 전체 사용자 조회
  - API 버젼관리 (URL, Request parameter & Header
- Spring Boot API 사용
  - HaTeoas 적용
  - Swagger
  - REST API Monitering위한 actuator 설정
  - Spring Security 인증처리
  - Configuration 클래스를 이용한 사용자 인증처리
- Java Persistence API 사용
  - JPA Service 구현을 위한 Controller, Repository 생성
  - JPA 사용자목록조회 - GET HTTP Method
  - PA 사용자추가, 삭제조회 - POST/DELETE HTTP Method
  - 게시물 관리를 위한 Post Entity추가와 초기 데이터 설정
  - 게시물 조회를 위한 Post Entity와 User Entity 와의 관계설정
  - JPA 새게시물 추가 -POST HTTP Method

## 👩🏻‍💻 사용자 관리 API
-  전체 사용자 목록 조회: GET HTTP Method, http://localhost:8088/users
-  개별 사용자 조회: GET HTTP Method, http://localhost:8088/users/{id}
-  사용자 삭제: DELETE HTTP Method, http://localhost:8088/users/{id}
-  사용자 정보 수정: PUT HTTP Method, http://localhost:8088/users/{id}


- user 추가
```
POST http://localhost:8088/users
{
"name": "New USer",
"joinDate": "2021-03-31T01:43:45.812+00:00"
}
```


## 👩🏻‍💻 게시물 관리 API
-  전체 게시물 목록 조회: GET HTTP Method, http://localhost:8088/users/{id}/posts
-  게시물 삭제: DELETE HTTP Method, http://localhost:8088/users/{id}/posts/{post_id}

## 👩🏻‍💻
- http://localhost:8088/actuator
- http://localhost:8088/browser/index.html#/
- http://localhost:8088/actuator/metrics/jvm.memory.max
- localhost:8088/h2-console  JDBC URL : jdbc:h2:mem:testdb
