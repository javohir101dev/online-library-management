-- Creating author table in database
create table author
(
    id         serial primary key,
    firstname  varchar not null,
    lastname   varchar not null,
    birth_date timestamp
);

-- Inserting author infos
insert into author(firstname, lastname, birth_date)
VALUES ('Joanne ', 'Rowling ', '1965-07-31'),
       ('Lev', 'Tolstoi', '1828-09-09');


-- Creating users table in database
create table users
(
    id           serial,
    firstname    varchar,
    lastName     varchar,
    username     varchar,
    phone_number varchar,
    password     varchar,
    account      decimal,
    role         varchar
);

-- Inserting user infos
insert into users(firstname, lastName, username, phone_number, password, account, role)
VALUES ('Javohir', 'Uralov', 'java', '+998950801467', '123', 250, 'USER'),
       ('Izzatbek', 'Mavlonov', 'izz', '+998901234567', '123', 350, 'USER');