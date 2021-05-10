create database if not exists `test`;

use test;

drop table if exists `userthread`;

create table `userthread`(
    `id` int not null auto_increment,
    `username` varchar(100),
    `thread_id` bigint,
    `thread_status` varchar(100),
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;