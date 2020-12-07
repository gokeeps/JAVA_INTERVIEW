drop table user;

create table user(
    id bigint auto_increment primary key,
    name varchar(64),
    age tinyint unsigned
);

alter table user rename to user1;
alter table user1 rename user;
alter table user change name name varchar(64) null default '未知' comment '姓名';
alter table user modify column name varchar(32) comment '哈哈';
alter table user add column sex tinyint unsigned default 18 comment '年龄' after age;
alter table user change name name varchar(64) not null default '么么哒' comment '嘿嘿';
alter table user drop column sex;


select dense_rank() over(age) from user;
