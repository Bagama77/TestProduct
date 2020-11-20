DROP TABLE IF EXISTS product;

CREATE TABLE PRODUCT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price double NOT NULL,
  date DATE not null
);

INSERT INTO PRODUCT (name, price, date) VALUES
('Product 1 ', 12.34, '1997-06-10'),
('Product 2', 30.40, '1998-01-01'),
('Product 3', 0.56, '1999-01-01');

DROP TABLE IF EXISTS myrole;

CREATE TABLE myrole (
    id   serial      not null constraint myrole_pk primary key,
    name varchar(20) not null
);

DROP TABLE IF EXISTS myuser;

-- auto-generated definition
create table myuser
(
    id       serial not null
        constraint myuser_pk
        primary key,
    login    varchar(50),
    password varchar(500),
    role_id  integer
        constraint myuser_myrole_id_fk
        references myrole
);

create unique index myuser_login_uindex
    on myuser (login);

insert into myrole(name) values ('ROLE_ADMIN');
insert into myrole(name) values ('ROLE_USER');