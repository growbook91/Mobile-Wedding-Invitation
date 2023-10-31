	drop table if exists comment CASCADE;

	create table comment
    (
        id   bigint not null AUTO_INCREMENT,
        name varchar(255),
        content varchar(2048),
        date varchar(255),
        password varchar(255),
        primary key (id)
    );

	drop table if exists attendance CASCADE;

	create table attendance
    (
        id   bigint not null AUTO_INCREMENT,
        side varchar(16),
        name varchar(16),
        companionName varchar(16),
        food varchar(16),
        totalNum int,
        primary key (id)
    );