create table STUDENTS
(
    ID   bigserial primary key,
    NAME varchar(50) unique not null,
    MARK int
);