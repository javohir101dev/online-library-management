-- Creating users entity in database
create table users(id serial,
                   firstname varchar,
                   lastName varchar,
                   username varchar,
                   password varchar,
                   account decimal,
                   role varchar);

insert into users(firstname, lastName, username, password, account, role) VALUES
    ('Javohir', 'Uralov', 'java', '123', 250, 'USER');
insert into users(firstname, lastName, username, password, account, role) VALUES
    ('Izzatbek', 'Mavlonov', 'izz', '123', 350, 'USER');