insert into center (address, avg_grade, description, name) VALUES ('Adresa 4', 3.4, 'Jako dobar', 'Centar 1');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 1', 3.4, 'sadads', 'Centar 2');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 1a', 3.4, 'ads', 'Centar 3');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 2', 3.4, 'sadads', 'Centar 4');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 3', 3.4, 'ss', 'Centar 5');

insert into address (address, city, country) VALUES ('Zeleznicka 3', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 4', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 5', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 6', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 7', 'Novi Sad', 'Serbia');

/*sifra je Dusan123 za oba*/
insert into users (email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id) VALUES ('dsisarica40@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1);
insert into users (email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id) VALUES ('dukisuzuki@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1);

insert into role (name) VALUES ('ROLE_ADMIN');
insert into role (name) VALUES ('ROLE_USER');

insert into user_role (user_id, role_id) VALUES (1,1);
insert into user_role (user_id, role_id) VALUES (2,2);

