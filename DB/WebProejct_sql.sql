show table();
select database();
use webprj;
-- ------------------------------------
-- 테이블 생성
create table t_user(
	u_Pk int unsigned auto_increment primary key,
	u_LogType varchar(30) default ('user'),
	u_Nm varchar(20) not null,
	u_Id varchar(20) unique key not null,
	u_Pass varchar(300), 
	u_Salt varchar(200),
	u_Gender varchar(10),
	u_Phone varchar(30) unique key,
	u_Addr varchar(50),
	u_Mail varchar(30) unique key,
	u_regDate datetime DEFAULT CURRENT_TIMESTAMP
);
select * from t_user;
<<<<<<< HEAD

commit;


drop table matzip;
create table matzip(
	m_pk int unsigned auto_increment primary key,
	m_title varchar(20) not null,
	m_viewDetail varchar(50) not null,
	m_starPoint float,
	m_category varchar(10) not null,
	m_location varchar(10) not null,
	m_img1 varchar(500) not null,
	m_img2 varchar(500) not null,
	m_img3 varchar(500) not null,
	m_img4 varchar(500) not null,
	m_addrRoad varchar(100) ,
	m_addrJibun varchar(100) ,
	m_phone varchar(300) ,
	m_foodType varchar(300),
	m_price varchar(300) ,
	m_workingTime varchar(100) ,
	m_parking varchar(300)
=======

commit;

-- 댓글 시작  --------------------------------------------

drop table t_comment;

create table t_comment(
	c_pk int unsigned auto_increment primary key,
	u_pk int unsigned,
	m_pk int unsigned,
	c_seq int unsigned,
	c_content varchar(200) not null,
	c_regDate datetime DEFAULT CURRENT_TIMESTAMP
);
select * from t_comment;

insert into t_comment
(u_pk,m_pk,c_seq,c_content)
values
(6,1,1,'안녕하세요 댓글이에요');

insert into t_comment
(u_pk,m_pk,c_seq,c_content)
values
(16,1,1,'하이하이하이여');


drop table t_reviewimg;
create table t_reviewImg(
	r_Pk int unsigned,
	r_Img varchar(500)
>>>>>>> jaejin
)

select * from matzip
order by m_starPoint desc
limit 0,20;

insert into matzip
(m_title,m_viewDetail,m_starPoint,m_category,m_location,m_img1,m_img2,m_img3,m_img4,m_addrRoad,m_addrJibun,m_phone,m_foodType,
m_price,m_workingTime,m_parking)
values
('이재진','이재진','이재진','이재진','이재진','이재진','이재진','이재진','이재진','이재진',
'이재진','이재진','이재진','이재진','이재진','이재진');

<<<<<<< HEAD
commit;
delete from matzip;



create table test_table(
	name varchar(20)
);
select * from test_table;
insert into test_table
(name)
values
('이재진');



=======



-- 맛집 시작 ----------------------------
create table matzip(
	m_pk int unsigned auto_increment primary key,
	m_title varchar(20) not null,
	m_viewDetail varchar(50) not null,
	m_starPoint float,
	m_category varchar(10) not null,
	m_location varchar(10) not null,
	m_img1 varchar(500) not null,
	m_img2 varchar(500) not null,
	m_img3 varchar(500) not null,
	m_img4 varchar(500) not null,
	m_addrRoad varchar(100) ,
	m_addrJibun varchar(100) ,
	m_phone varchar(300) ,
	m_foodType varchar(300),
	m_price varchar(300) ,
	m_workingTime varchar(100) ,
	m_parking varchar(300)
);
select * from matzip;
commit;
insert into matzip
(m_title,m_viewDetail,m_starPoint,m_category,m_location,m_img1,m_img2,m_img3,m_img4,m_addrRoad,m_addrJibun,m_phone,m_foodType,
m_price,m_workingTime,m_parking)
values
('이재진','이재진','이재진','이재진','이재진','이재진','이재진','이재진','이재진','이재진',
'이재진','이재진','이재진','이재진','이재진','이재진');

commit;
delete from matzip;

create table test_table(
	name varchar(20)
);
select * from test_table;
insert into test_table
(name)
values
('이재진');


-- 페이징 구현 쿼리 
select count(m_pk) from matzip;

select * from matzip
order by m_starPoint desc
limit 0, 20;









>>>>>>> jaejin



