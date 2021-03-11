show table();
select database();
use webprj;
-- ------------------------------------

select * from t_user;
-- 유저 테이블 ----    
create table t_user(
	u_pk int unsigned auto_increment primary key,
	u_logType varchar(30) default ('user'),
	u_nm varchar(20) not null,
	u_id varchar(20) unique key not null,
	u_pass varchar(300), 
	u_salt varchar(200),
	u_gender varchar(10),
	u_phone varchar(30) unique key,
	u_mail varchar(30) unique key,
	u_regDate datetime DEFAULT CURRENT_TIMESTAMP,
	u_profile varchar(400)
);

-- 댓글 테이블   --------------------------------------------
create table t_comment(
	c_pk int unsigned auto_increment primary key,
	u_pk int unsigned,
	m_pk int unsigned,
	c_seq int unsigned,
	c_content varchar(200) not null,
	c_regDate datetime DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY(u_pk) REFERENCES t_user(u_pk) ON delete cascade,
	FOREIGN KEY(m_pk) REFERENCES matzip(m_pk) ON delete cascade
);
select * from t_comment;

-- 맛집 테이블 ----------------------------
create table matzip(
	m_pk int unsigned auto_increment primary key,
	m_title varchar(20) not null,
	m_viewDetail varchar(50) not null,
	m_starPoint float,
	m_category int default 0,
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
	m_parking varchar(300),
	m_commentCount int default 0,
	m_viewCount int default 0
);

select * from matzip;

update matzip 
set m_category =  6
where m_pk between 190 and 200;

drop table matzip;


-- 좋아요 테이블 --
drop table t_like;
create table t_like(
	l_pk int unsigned auto_increment unique,
	m_pk int unsigned not null,
	u_pk int unsigned not null,
	m_title varchar(50),
	m_img1 varchar(500) not null,
	m_viewDetail varchar(50) not null,
	m_starPoint float,
	m_viewCount int unsigned,
	m_commentCount int unsigned,
	primary key(m_pk, u_pk),
	FOREIGN KEY(u_pk) REFERENCES t_user(u_pk) ON delete cascade,
	FOREIGN KEY(m_pk) REFERENCES matzip(m_pk) ON delete cascade
);
select * from t_like;




