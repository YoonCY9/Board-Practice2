# 보드

## 게시판 필드
String title; 제목

게시판생성
Post ("/boards")

게시판목록조회
Get ("/boards")

게시판목록 수정
Put("/boards/{id}")

게시판목록 삭제
Delete("/boards/{id}")

# 포스트
## 게시글 필드
String title; 제목
String content; 내용
String name; 작성자

게시글생성
Post ("/posts")

게시글목록조회
Get ("/posts")

게시글목록 수정
Put ("/posts/{id}")

게시글목록 삭제 
Delete ("/posts/{id}")

z
