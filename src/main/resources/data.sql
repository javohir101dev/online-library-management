create database online_library_management;
drop schema public cascade;
create schema public;

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
       ('Lev', 'Tolstoi', '1828-09-09');

-- Creating users table in database
create table users
(
    id           serial primary key,
    firstname    varchar,
    lastName     varchar,
    username     varchar,
    phone_number varchar,
    password     varchar,
    role         varchar
);

-- Inserting user info
insert into users(firstname, lastName, username, phone_number, password, role)
VALUES ('Javohir', 'Uralov', 'admin', '+998950801467', '123', 'ADMIN'),
       ('Izzatbek', 'Mavlonov', 'user', '+998901234567', '123', 'USER');


-- Creating book table in database
create table book
(
    id                    serial primary key,
    name                  varchar,
    cost                  decimal,
    genre                 varchar,
    page_count            integer,
    total_number_of_books integer,
    left_number_of_books  integer,
    author_id             integer
);
-- Constrains
alter table book
    add constraint fk_book_author_id foreign key (author_id) REFERENCES author (id);

-- Inserting info
insert into book(name, cost, genre, page_count, total_number_of_books, left_number_of_books, author_id)
VALUES ('Harry Potter and the Philosopher''s Stone', 23, 'Fantasy', 223, 5, 5, 1),
       ('Harry Potter and the Chamber of Secrets''s Stone', 27, 'Fantasy', 251, 5, 5, 1),
       ('Harry Potter and the Prisoner of Azkaban''s Stone', 32, 'Fantasy', 317, 5, 5, 1),
       ('Harry Potter and the Goblet of Fire', 43, 'fantasy', 636, 5, 5, 1),
       ('War and Peace', 21.00, 'Novel (Historical novel)', 1225, 5, 5, 2);


-- Creating book_user table in database
create table book_user
(
    id                 serial primary key,
    takenDate          timestamp        default now(),
    returnedDate       timestamp,
    bookId             integer,
    takenNumberOfBooks integer,
    userId             integer,
    isReturned         boolean not null default false
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