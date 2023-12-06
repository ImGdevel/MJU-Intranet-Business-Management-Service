DROP TABLE 근태;
DROP TABLE 일정;
DROP TABLE 급여;
DROP TABLE 교육훈련;
DROP TABLE 경력;
DROP TABLE 기술;
DROP TABLE 기술분류;
DROP TABLE 상세평가;
DROP TABLE 고객평가;
DROP TABLE PM평가;
DROP TABLE 동료평가;
DROP TABLE 평가;
DROP TABLE 프로젝트_참여정보;
DROP TABLE 직무;
DROP TABLE 프로젝트;
DROP TABLE 발주처;
DROP TABLE 회원정보;
DROP TABLE 직원;
DROP TABLE 부서;
DROP VIEW 프로젝트참여자수;

CREATE TABLE 부서 (
    부서번호 NUMBER(3) NOT NULL,
    부서명 VARCHAR(50),
    부서위치 VARCHAR(6),
    담당업무 VARCHAR(50),
    부서전화번호 VARCHAR(20),
    PRIMARY KEY (부서번호)
);

CREATE TABLE 직원 (
    직원번호 NUMBER(5) NOT NULL,
    직원명 VARCHAR(50) NOT NULL,
    주민등록번호 VARCHAR(14) NOT NULL,
    최종학력 VARCHAR(50),
    직위 VARCHAR(50),
    소속부서 NUMBER(3) NOT NULL,
    정보권한등급 NUMBER(1),
    PRIMARY KEY (직원번호),
    FOREIGN KEY (소속부서) REFERENCES 부서(부서번호)
);

CREATE TABLE 회원정보 (
    ID VARCHAR(20) NOT NULL,
    직원사번 NUMBER(5) NOT NULL,
    비밀번호 VARCHAR(20) NOT NULL,
    전화번호 VARCHAR(20),
    생년월일 DATE,
    이메일 VARCHAR(50),
    PRIMARY KEY (ID),
    FOREIGN KEY (직원사번) REFERENCES 직원(직원번호)
);


CREATE TABLE 발주처 (
    발주처번호 NUMBER(5) NOT NULL,
    발주처이름 VARCHAR(50) NOT NULL,
    발주처전화번호 VARCHAR(20),
    발주처이메일 VARCHAR(50),
    PRIMARY KEY (발주처번호)
);

CREATE TABLE 프로젝트 (
    프로젝트번호 NUMBER(5) NOT NULL,
    프로젝트명 VARCHAR(50),
    프로젝트착수일자 DATE NOT NULL,
    프로젝트종료일자 DATE,
    발주처 NUMBER(5) NOT NULL,
    PRIMARY KEY (프로젝트번호),
    FOREIGN KEY (발주처) REFERENCES 발주처(발주처번호)
);

CREATE TABLE 직무 (
    직무번호 NUMBER(5) NOT NULL,
    직무이름 VARCHAR(50),
    PRIMARY KEY (직무번호)
);


CREATE TABLE 프로젝트_참여정보 (
    프로젝트번호 NUMBER(5),
    직원번호 NUMBER(5),
    프로젝트투입일자 DATE,
    프로젝트이탈일자 DATE,
    수행직무 NUMBER(5) REFERENCES 직무(직무번호),
    PRIMARY KEY (프로젝트번호, 직원번호),
    FOREIGN KEY (프로젝트번호) REFERENCES 프로젝트(프로젝트번호),
    FOREIGN KEY (직원번호) REFERENCES 직원(직원번호)
);



CREATE TABLE 평가 (
    평가번호 NUMBER(10) NOT NULL,
    피평가자 NUMBER(5) NOT NULL,
    프로젝트번호 NUMBER(5) NOT NULL,
    PRIMARY KEY (평가번호),
    FOREIGN KEY (피평가자) REFERENCES 직원(직원번호),
    FOREIGN KEY (프로젝트번호) REFERENCES 프로젝트(프로젝트번호)
);

CREATE TABLE 동료평가 (
    평가번호 NUMBER(10) NOT NULL,
    평가자_동료 NUMBER(5) NOT NULL,
    PRIMARY KEY (평가번호),
    FOREIGN KEY (평가번호) REFERENCES 평가(평가번호),
    FOREIGN KEY (평가자_동료) REFERENCES 직원(직원번호)
);



CREATE TABLE PM평가 (
    평가번호 NUMBER(10) NOT NULL,
    평가자_PM NUMBER NOT NULL,
    PRIMARY KEY (평가번호),
    FOREIGN KEY (평가번호) REFERENCES 평가(평가번호),
    FOREIGN KEY (평가자_PM) REFERENCES 직원(직원번호)
);


CREATE TABLE 고객평가 (
    평가번호 NUMBER(10) NOT NULL,
    평가자_고객 NUMBER NOT NULL,
    PRIMARY KEY (평가번호),
    FOREIGN KEY (평가번호) REFERENCES 평가(평가번호),
    FOREIGN KEY (평가자_고객) REFERENCES 발주처(발주처번호)
);


CREATE TABLE 상세평가 (
    평가항목 NUMBER(2) NOT NULL,
    평가번호 NUMBER(10) NOT NULL,
    평가내용 VARCHAR(500),
    평점 NUMBER(2,1),
    PRIMARY KEY (평가항목, 평가번호),
    FOREIGN KEY (평가번호) REFERENCES 평가(평가번호)
);


CREATE TABLE 기술분류 (
    기술번호 NUMBER(2) NOT NULL,
    기술이름 VARCHAR(50) NOT NULL,
    PRIMARY KEY (기술번호)
);



CREATE TABLE 기술 (
    직원번호 NUMBER(5) NOT NULL,
    기술번호 NUMBER(2) NOT NULL,
    기술등급 NUMBER(1) NOT NULL,
    PRIMARY KEY (직원번호, 기술번호),
    FOREIGN KEY (직원번호) REFERENCES 직원(직원번호),
    FOREIGN KEY (기술번호) REFERENCES 기술분류(기술번호)
);


CREATE TABLE 경력 (
    직원번호 NUMBER(5) NOT NULL,
    경력번호 NUMBER(5) NOT NULL,
    경력내용 VARCHAR(100),
    경력시작일자 DATE,
    기간 NUMBER(4),
    PRIMARY KEY (직원번호, 경력번호),
    FOREIGN KEY (직원번호) REFERENCES 직원(직원번호)
);


CREATE TABLE 교육훈련 (
    교육훈련번호 NUMBER(5) NOT NULL,
    직원번호 NUMBER(5),
    교육훈련유형 VARCHAR(50),
    교육훈련일자 DATE,
    교육훈련내용 VARCHAR(100),
    PRIMARY KEY (교육훈련번호, 직원번호),
    FOREIGN KEY (직원번호) REFERENCES 직원(직원번호)
);


CREATE TABLE 급여 (
    사원번호 NUMBER(5),
    급여일자 DATE,
    기본급여 NUMBER(10),
    인센티브 NUMBER(10),
    세금 NUMBER(10),
    PRIMARY KEY (사원번호, 급여일자),
    FOREIGN KEY (사원번호) REFERENCES 직원(직원번호)
);


CREATE TABLE 일정 (
    일정번호 NUMBER(10) NOT NULL,
    직원번호 NUMBER(5),
    시작일자 DATE,
    종료일자 DATE,
    일정내용 VARCHAR(50),
    PRIMARY KEY (일정번호, 직원번호),
    FOREIGN KEY (직원번호) REFERENCES 직원(직원번호)
);

CREATE TABLE 근태 (
    날짜 DATE NOT NULL,
    직원번호 NUMBER(5),
    출근시각 DATE,
    퇴근시각 DATE,
    PRIMARY KEY (날짜, 직원번호),
    FOREIGN KEY (직원번호) REFERENCES 직원(직원번호)
);

create view 프로젝트참여자수(프로젝트번호, 참여자수) as
select 프로젝트.프로젝트번호 as 프로젝트번호, count(직원번호)
from 프로젝트, 프로젝트_참여정보
where 프로젝트.프로젝트번호 = 프로젝트_참여정보.프로젝트번호
group by 프로젝트.프로젝트번호;



COMMIT;

