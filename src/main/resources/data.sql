-- create database online_library_management;
drop schema public cascade;
create schema public;

--Creating genre table in database
create table if not exists genre
(
    id   serial primary key,
    name varchar not null unique
);

-- Inserting genre info
insert into genre(name)
values ('Fantasy'),
       ('Novel (Historical novel)'),
       ('Fiction');

-- Creating author table in database
create table author
(
    id         serial primary key,
    firstname  varchar not null,
    lastname   varchar not null,
    birth_date timestamp
);

-- Inserting author info
insert into author(firstname, lastname, birth_date)
VALUES ('Joanne ', 'Rowling ', '1965-07-31'),
       ('Lev', 'Tolstoy', '1828-09-09');

-- Creating users table in database
create table users
(
    id           serial primary key,
    firstname    varchar not null,
    lastName     varchar not null,
    username     varchar not null,
    phone_number varchar not null,
    password     varchar not null,
    role         varchar not null
);

-- Inserting user info
insert into users(firstname, lastName, username, phone_number, password, role)
VALUES ('Javohir', 'Uralov', 'admin', '+998950801467', '123', 'ADMIN'),
       ('Izzatbek', 'Mavlonov', 'user', '+998901234567', '123', 'USER');


-- Creating book table in database
create table book
(
    id                    serial primary key,
    name                  varchar not null,
    cost                  decimal not null,
    genre_id              integer not null,
    page_count            integer not null,
    total_number_of_books integer not null,
    left_number_of_books  integer not null,
    author_id             integer not null
);
-- Constrains
alter table book
    add constraint fk_book_author_id foreign key (author_id) REFERENCES author (id);

alter table book
    add constraint fk_book_genre_id foreign key (genre_id) references genre(id);

-- Inserting info
insert into book(name, cost, genre_id, page_count, total_number_of_books, left_number_of_books, author_id)
VALUES ('Harry Potter and the Philosopher''s Stone', 23, 1, 223, 5, 5, 1),
       ('Harry Potter and the Chamber of Secrets''s Stone', 27, 1, 251, 5, 5, 1),
       ('Harry Potter and the Prisoner of Azkaban''s Stone', 32, 1, 317, 5, 5, 1),
       ('Harry Potter and the Goblet of Fire', 43, 1, 636, 5, 5, 1),
       ('War and Peace', 21.00, 2, 1225, 5, 5, 2);


-- Creating book_user table in database
create table book_user
(
    id                 serial primary key,
    takenDate          timestamp        default now(),
    returnedDate       timestamp,
    bookId             integer not null ,
    takenNumberOfBooks integer not null ,
    userId             integer not null ,
    isReturned         boolean default false
);

alter table book_user
    add constraint book_user_book_id FOREIGN KEY (bookId) references book (id);

alter table book_user
    add constraint book_user_user_id foreign key (userId) references users (id);

-- Inserting info
insert into book_user(takenDate, returnedDate, bookId, takenNumberOfBooks, userId, isReturned)
values (now(), null, 1, 3, 1, false),
       (now(), null, 2, 1, 1, false),
       (now(), null, 3, 1, 2, false),
       (now(), null, 5, 1, 2, false);