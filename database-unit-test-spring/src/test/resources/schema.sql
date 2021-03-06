DROP TABLE IF EXISTS USER RESTRICT;
DROP TABLE IF EXISTS BLOG RESTRICT;
DROP TABLE IF EXISTS POST RESTRICT;

-- 사용자
CREATE TABLE USER (
	USER_ID VARCHAR(20)  PRIMARY KEY, -- 사용자ID
	USER_NM VARCHAR(50)  NOT NULL, -- 이름
	EMAIL   VARCHAR(100) NULL      -- 이메일
);

-- 블로그
CREATE TABLE BLOG (
	BLOG_ID INTEGER     PRIMARY KEY AUTO_INCREMENT, -- 블로그ID
	BLOG_NM VARCHAR(50) NOT NULL, -- 블로그명
	USER_ID VARCHAR(20) NOT NULL -- 관리자ID
);

-- 포스트
CREATE TABLE POST (
	POST_ID  INTEGER       PRIMARY KEY AUTO_INCREMENT, -- 포스트ID
	SUBJECT  VARCHAR(100)  NOT NULL, -- 제목
	CONTENTS VARCHAR(1000) NOT NULL, -- 내용
	REG_DT   DATETIME      NOT NULL DEFAULT SYSDATE(), -- 등록일시
	BLOG_ID  INTEGER       NOT NULL  -- 블로그ID
);
