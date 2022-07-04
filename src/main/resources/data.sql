-- Creating author table
create table author
(
    id         serial primary key,
    firstname  varchar not null,
    lastname   varchar not null,
    birth_date timestamp
);


-- Inserting author infos for
insert into author(firstname, lastname, birth_date)
VALUES ('Joanne ', 'Rowling ', '1965-07-31'),
       ('Lev', 'Tolstoi', '1828-09-09');


-- Creating users entity in database
create table users
(
    id        serial,
    firstname varchar,
    lastName  varchar,
    username  varchar,
    password  varchar,
    account   decimal,
    role      varchar
);

insert into users(firstname, lastName, username, password, account, role)
VALUES ('Javohir', 'Uralov', 'java', '123', 250, 'USER'),
       ('Izzatbek', 'Mavlonov', 'izz', '123', 350, 'USER');