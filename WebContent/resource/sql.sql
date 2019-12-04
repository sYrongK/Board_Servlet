create table users(
	id varchar2(8) primary key,
	password number(8) not null,
	name varchar2(8) not null,
	age number(3) not null,
	gender varchar2(5) check(gender in('³²', '¿©')),
	email varchar2(20) not null
)

drop table users;

select * from users;