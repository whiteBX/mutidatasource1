create database `front`;
use `front`;
create table `user` (
  `id` bigint(20) not null  auto_increment comment '主键id',
  `userId` varchar(32) not null comment '用户id',
  `userName` varchar(32) comment '用户名字',
  primary key (`id`)
) engine=InnoDB default charset=utf8mb4 comment '用户表';

create database `back`;
use `back`;
create table `admin` (
  `id` bigint(20) not null  auto_increment comment '主键id',
  `adminId` varchar(32) not null comment '管理员id',
  `adminName` varchar(32) comment '管理员名字',
  primary key (`id`)
) engine=InnoDB default charset=utf8mb4 comment '管理员表';