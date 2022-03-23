# Spring Boot를 이용한 RESTful Web Service 개발

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
