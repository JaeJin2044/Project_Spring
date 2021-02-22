show table();
select database();
use webprj;

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

drop table t_user;

insert into t_user
(u_Id,u_Nm,u_Mail,u_Gender,u_Phone,u_LogType)
values
('dlwowls1','이재진','abab2044@daum.net','M','01011112222','user');

insert into t_user
		(u_Id,u_Nm,u_LogType)
		values
		('이재진','안녕하세요','kakao');



select * from t_user;
commit;


update t_user
set u_Pass = '123456'
where u_Id = 'shzhem764';

commit;

delete from t_user;

select * from t_user;

		
select * from t_user
where u_Phone = '01087782044'
or u_Mail = 'abab2044';