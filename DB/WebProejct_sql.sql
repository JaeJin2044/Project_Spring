show table();
select database();
use webprj;
-- ------------------------------------
-- user Table 
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
alter table t_user add u_profile varchar(400) default 'https://mblogthumb-phinf.pstatic.net/20150403_86/e2voo_14280514283502gas9_JPEG/kakako-00.jpg?type=w800';
select * from t_user;
commit;


-- 댓글 시작  --------------------------------------------

drop table t_comment;

select * from matzip
order by m_starPoint desc
limit 0 ,20;

select * from t_user;

--  - --------------
SELECT M.*, ifnull(R.c_content, '') AS c_content, R.u_Nm , R.u_profile, DATE_FORMAT(R.c_regDate, '%Y-%m-%d') as c_regDate
FROM matzip M
LEFT JOIN (
   SELECT A.m_pk, A.c_content, C.u_Nm , C.u_profile ,A.c_regDate 
   FROM t_comment A
   INNER JOIN
   (
      SELECT m_pk, MAX(c_seq) AS c_seq
      FROM t_comment
      GROUP BY m_pk
   ) B
   ON A.m_pk = B.m_pk
   AND A.c_seq = B.c_seq
   LEFT JOIN t_user C
   ON A.u_pk = C.u_pk
) R
ON M.m_pk = R.m_pk
ORDER BY M.m_starpoint DESC 
LIMIT 0, 20;
--  ---------------

select MAX(c_seq) from t_comment ;


create table t_comment(
	c_pk int unsigned auto_increment primary key,
	u_pk int unsigned,
	m_pk int unsigned,
	c_seq int unsigned,
	c_content varchar(200) not null,
	c_regDate datetime DEFAULT CURRENT_TIMESTAMP
);

select * from t_comment;

order by c_seq desc
limit 1;


select * from t_comment
where m_pk = 1
order by c_seq desc
limit 1,10;

drop table t_comment;

select count(*) from t_comment
where m_pk =1;

SELECT 3, IFNULL(MAX(c_seq), 0) + 1, 10, '안녕'
FROM t_comment
WHERE m_pk = ;


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
)






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

select * from matzip;
alter table matzip add m_commentCount int default 0 ;
alter table matzip change c_viewCount m_viewCount int default 0;

update matzip 
set m_viewCount = m_viewCount+1
where m_pk = 1;

select m_viewCount from matzip
where m_pk = 1 ;
;

select * from matzip
where m_title ='대장부{송현점}';



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


SELECT 
A.c_pk,A.u_pk,A.m_pk,A.c_seq,A.c_content,
DATE_FORMAT(c_regDate, '%Y-%m-%d') as c_regDate, B.u_Nm AS writerNm
FROM t_comment A
LEFT JOIN t_user B
ON A.u_pk = B.u_Pk
WHERE A.m_pk = 1
ORDER BY A.c_seq desc
limit 0,10;

select A.*,B.c_content 
from matzip A 
left join t_comment B
on A.m_pk = B.m_pk
order by m_starPoint desc
limit 0, 20;


select * from matzip
order by m_starPoint desc
limit 0,20;







SELECT 
A.c_pk,A.u_pk,A.m_pk,A.c_seq,A.c_content,
DATE_FORMAT(c_regDate, '%Y-%m-%d') as c_regDate, B.u_Nm AS writerNm
FROM t_comment A
LEFT JOIN t_user B
ON A.u_pk = B.u_Pk
WHERE A.m_pk = 1
ORDER BY A.c_seq desc
limit 0,10;




