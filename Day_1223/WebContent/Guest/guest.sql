-- 방명록 테이블(답변글 없음)
-- 테이블 구조 `tbl_guest`

create table tbl_guest (
	idx number not null ,			-- 고유번호/자동증가
	name varchar2(50) not null,		-- 작성자
	subject varchar2(100) not null,		-- 제목
	contents varchar2(2000) not null,	-- 내용
	regdate date default sysdate,		-- 작성일자
	readcnt number default 0,		-- 조회수
	primary key(idx)			-- 기본키
);
create sequence tbl_guest_seq_idx;
