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