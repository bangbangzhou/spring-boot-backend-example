create database backend_db;
use backend_db;





create table tb_tutorial
(
    id      bigint auto_increment comment '主键ID'
        primary key,
    title   varchar(40)    comment '标题',
    description    varchar(30)    comment '描述',
    published     tinyint        comment '1 表示发布 0 表示未发布'
);

