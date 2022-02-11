CREATE TABLE students
(
    id   bigserial    NOT NULL primary key,
    name varchar(255) NOT NULL UNIQUE,
    age  int          NOT NULL
)