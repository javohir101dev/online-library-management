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
    id           serial,
    firstname    varchar,
    lastName     varchar,
    username     varchar,
    phone_number varchar,
    password     varchar,
    account      decimal,
    role         varchar
);

-- Inserting user info
insert into users(firstname, lastName, username, phone_number, password, account, role)
VALUES ('Javohir', 'Uralov', 'java', '+998950801467', '123', 250, 'USER'),
       ('Izzatbek', 'Mavlonov', 'izz', '+998901234567', '123', 350, 'USER');


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
       ('War and Peace', 21.00, 'Novel (Historical novel)', 1225, 5, 5, 1);
