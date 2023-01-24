insert into center (address, avg_grade, description, name) VALUES ('Adresa 4', 3.4, 'Jako dobar', 'Centar 1');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 1', 3.7, 'sadads', 'Centar 2');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 1a', 4.4, 'ads', 'Centar 3');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 2', 1.4, 'sadads', 'Centar 4');
insert into center (address, avg_grade, description, name) VALUES ('Adresa 3', 2.9, 'ss', 'Centar 5');

insert into address (address, city, country) VALUES ('Zeleznicka 3', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 4', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 5', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 6', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 7', 'Novi Sad', 'Serbia');

/*sifra je Dusan123 za oba*/
insert into users (email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty) VALUES ('dsisarica40@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 0);
insert into users (email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty) VALUES ('dukisuzuki@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2);
insert into users (email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty) VALUES ('dusansisarica@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2);
insert into users (email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty) VALUES ('sisarica.u@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2);

insert into role (name) VALUES ('ROLE_ADMIN');
insert into role (name) VALUES ('ROLE_USER');

insert into user_role (user_id, role_id) VALUES (1,1);
insert into user_role (user_id, role_id) VALUES (2,2);
insert into user_role (user_id, role_id) VALUES (3,2);
insert into user_role (user_id, role_id) VALUES (4,2);

insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('25/01/2023 19:00', 30, null, false, 1);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('26/01/2023 19:00', 30, 1, false, 3);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('25/01/2023 21:00', 30, 1, false, 2);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('28/01/2023 21:00', 30, null, false, 5);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('26/01/2023 14:30', 30, 2, false, 4);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('26/01/2023 15:00', 30, 2, false, 4);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('23/01/2023 15:30', 30, 2, true, 2);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('23/01/2023 16:00', 30, 2, true, 4);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('23/01/2023 16:30', 30, 2, true, 5);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('25/01/2023 10:30', 30, 2, false, 1);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('28/01/2023 13:30', 30, null, false, 1);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('28/01/2023 10:30', 30, null, false, 2);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('29/01/2023 11:30', 30, null, false, 2);
insert into appointment (start_date, duration, user_id, done, center_id) VALUES ('27/01/2023 12:30', 30, null, false, 3);

insert into center_appointments (center_id, appointments_id) VALUES (1,1);
insert into center_appointments (center_id, appointments_id) VALUES (1,10);
insert into center_appointments (center_id, appointments_id) VALUES (1,11);
insert into center_appointments (center_id, appointments_id) VALUES (2,3);
insert into center_appointments (center_id, appointments_id) VALUES (2,7);
insert into center_appointments (center_id, appointments_id) VALUES (2,12);
insert into center_appointments (center_id, appointments_id) VALUES (2,13);
insert into center_appointments (center_id, appointments_id) VALUES (3,2);
insert into center_appointments (center_id, appointments_id) VALUES (3,14);
insert into center_appointments (center_id, appointments_id) VALUES (4,5);
insert into center_appointments (center_id, appointments_id) VALUES (4,6);
insert into center_appointments (center_id, appointments_id) VALUES (4,8);
insert into center_appointments (center_id, appointments_id) VALUES (5,4);
insert into center_appointments (center_id, appointments_id) VALUES (5,9);


insert into users_appointments (users_id, appointments_id) VALUES (1,2);
insert into users_appointments (users_id, appointments_id) VALUES (1,3);
insert into users_appointments (users_id, appointments_id) VALUES (2,5);
insert into users_appointments (users_id, appointments_id) VALUES (2,6);
insert into users_appointments (users_id, appointments_id) VALUES (2,7);
insert into users_appointments (users_id, appointments_id) VALUES (2,8);
insert into users_appointments (users_id, appointments_id) VALUES (2,9);
insert into users_appointments (users_id, appointments_id) VALUES (2,10);

insert into user_appointment (user_id, appointment_id) VALUES (1,2);
insert into user_appointment (user_id, appointment_id) VALUES (1,3);
insert into user_appointment (user_id, appointment_id) VALUES (2,5);
insert into user_appointment (user_id, appointment_id) VALUES (2,6);
insert into user_appointment (user_id, appointment_id) VALUES (2,7);
insert into user_appointment (user_id, appointment_id) VALUES (2,8);
insert into user_appointment (user_id, appointment_id) VALUES (2,9);
insert into user_appointment (user_id, appointment_id) VALUES (2,10);


