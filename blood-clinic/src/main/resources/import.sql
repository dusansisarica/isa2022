insert into center (address, avg_grade, description, name) VALUES ('Zeleznicka 3', 3.4, 'Jako dobar', 'Novi Centar');
insert into center (address, avg_grade, description, name) VALUES ('Janka Veselinovica 5', 3.7, 'sadads', 'Centar Dobra Krv');
insert into center (address, avg_grade, description, name) VALUES ('Novaka Pejcica 24', 4.4, 'ads', 'A centar');
insert into center (address, avg_grade, description, name) VALUES ('Sarajevska 4', 1.4, 'sadads', 'Daj Krv');
insert into center (address, avg_grade, description, name) VALUES ('Augusta Cesarca 35', 2.9, 'ss', 'Kula centar');

insert into address (address, city, country) VALUES ('Zeleznicka 3', 'Novi Sad', 'Serbia');
insert into address (address, city, country) VALUES ('Novaka Pejcica 20', 'Kula', 'Serbia');
insert into address (address, city, country) VALUES ('Zeleznicka 5', 'Beograd', 'Serbia');
insert into address (address, city, country) VALUES ('Augusta Cesarca', 'Valjevo', 'Serbia');
insert into address (address, city, country) VALUES ('Novaka Pejcica 26', 'Novi Sad', 'Serbia');

/*sifra je Dusan123 za oba*/
insert into users (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, survey) VALUES (1, 'dsisarica40@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 0, true);
insert into users (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, survey) VALUES (2, 'dukisuzuki@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, true);
insert into users (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, survey) VALUES (3, 'dusansisarica@gmail.com', 'MALE', true, false, '124124124', 'student', 'Dusan', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 0, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (4, 'sisarica.u@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 1, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (5, 'centar1@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 2, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (6, 'centar2@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 1, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (7, 'centar3@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 1, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (8, 'centar4@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 3, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (9, 'centar5@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 3, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (10, 'centar6@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 4, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (11, 'centar7@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 5, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (12, 'centar8@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 2, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (13, 'centar9@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 4, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (14, 'centar10@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 3, true);
insert into center_administrator (id, email, gender, activated, deleted, jmbg, job, name, password, phone_number, surname, address_id, penalty, center_id, survey) VALUES (15, 'centar11@gmail.com', 'MALE', true, false, '124124124', 'student', 'Uros', '$2a$10$nU6EsmjOywLNk0wXyJNkq.q0Wjp8A1iUZy9AVLG6tjUdHpNMzWOEe', '062131241', 'Sisarica', 1, 2, 5, true);

insert into role (name) VALUES ('ROLE_ADMIN');
insert into role (name) VALUES ('ROLE_USER');
insert into role (name) VALUES ('ROLE_CENTER_ADMIN');


insert into user_role (user_id, role_id) VALUES (1,1);
insert into user_role (user_id, role_id) VALUES (2,2);
insert into user_role (user_id, role_id) VALUES (3,2);
insert into user_role (user_id, role_id) VALUES (4,3);
insert into user_role (user_id, role_id) VALUES (5,3);
insert into user_role (user_id, role_id) VALUES (6,3);
insert into user_role (user_id, role_id) VALUES (7,3);
insert into user_role (user_id, role_id) VALUES (8,3);
insert into user_role (user_id, role_id) VALUES (9,3);
insert into user_role (user_id, role_id) VALUES (10,3);
insert into user_role (user_id, role_id) VALUES (11,3);
insert into user_role (user_id, role_id) VALUES (12,3);
insert into user_role (user_id, role_id) VALUES (13,3);
insert into user_role (user_id, role_id) VALUES (14,3);
insert into user_role (user_id, role_id) VALUES (15,3);

insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('24/01/2023 19:00', 30, 3, true, 1, 4);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('26/01/2023 19:00', 40, 1, false, 3, 8);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('25/01/2023 21:00', 20, 1, false, 2, 5);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('24/01/2023 21:00', 220, 3, true, 5, 15);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('26/01/2023 14:30', 40, 3, false, 4, 13);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('26/01/2023 15:00', 60, 2, false, 4, 13);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('23/01/2023 15:30', 70, 2, true, 2, 5);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('23/01/2023 16:00', 80, 2, true, 4, 13);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('23/01/2023 16:30', 30, 2, true, 5, 15);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('25/01/2023 10:30', 30, 2, false, 1, 4);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('22/01/2023 13:30', 30, 3, true, 1, 6);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('28/01/2023 10:30', 20, null, false, 2, 5);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('29/01/2023 11:30', 10, null, false, 2, 5);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('27/01/2023 12:30', 5, null, false, 3, 9);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('13/08/2023 12:30', 5, null, false, 3, 9);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('21/08/2023 12:30', 5, null, false, 3, 9);
insert into appointment (start_date, duration, user_id, done, center_id, center_administrator_id) VALUES ('21/08/2024 12:30', 5, null, false, 3, 9);

insert into center_appointments (center_id, appointments_id) VALUES (1,1);
insert into center_appointments (center_id, appointments_id) VALUES (1,10);
insert into center_appointments (center_id, appointments_id) VALUES (1,11);
insert into center_appointments (center_id, appointments_id) VALUES (2,3);
insert into center_appointments (center_id, appointments_id) VALUES (2,7);
insert into center_appointments (center_id, appointments_id) VALUES (2,12);
insert into center_appointments (center_id, appointments_id) VALUES (2,13);
insert into center_appointments (center_id, appointments_id) VALUES (3,2);
insert into center_appointments (center_id, appointments_id) VALUES (3,14);
insert into center_appointments (center_id, appointments_id) VALUES (3,15);
insert into center_appointments (center_id, appointments_id) VALUES (3,16);
insert into center_appointments (center_id, appointments_id) VALUES (3,16);
insert into center_appointments (center_id, appointments_id) VALUES (4,5);
insert into center_appointments (center_id, appointments_id) VALUES (4,6);
insert into center_appointments (center_id, appointments_id) VALUES (4,8);
insert into center_appointments (center_id, appointments_id) VALUES (5,4);
insert into center_appointments (center_id, appointments_id) VALUES (5,9);


insert into users_appointments (users_id, appointments_id) VALUES (1,2);
insert into users_appointments (users_id, appointments_id) VALUES (1,3);
insert into users_appointments (users_id, appointments_id) VALUES (3,4);
insert into users_appointments (users_id, appointments_id) VALUES (2,6);
insert into users_appointments (users_id, appointments_id) VALUES (2,7);
insert into users_appointments (users_id, appointments_id) VALUES (2,8);
insert into users_appointments (users_id, appointments_id) VALUES (2,9);
insert into users_appointments (users_id, appointments_id) VALUES (2,10);
insert into users_appointments (users_id, appointments_id) VALUES (3,1);
insert into users_appointments (users_id, appointments_id) VALUES (3,5);
insert into users_appointments (users_id, appointments_id) VALUES (3,11);

insert into user_appointment (user_id, appointment_id) VALUES (1,2);
insert into user_appointment (user_id, appointment_id) VALUES (1,3);
insert into user_appointment (user_id, appointment_id) VALUES (2,5);
insert into user_appointment (user_id, appointment_id) VALUES (2,6);
insert into user_appointment (user_id, appointment_id) VALUES (2,7);
insert into user_appointment (user_id, appointment_id) VALUES (2,8);
insert into user_appointment (user_id, appointment_id) VALUES (2,9);
insert into user_appointment (user_id, appointment_id) VALUES (2,10);
insert into user_appointment (user_id, appointment_id) VALUES (3,1);
insert into user_appointment (user_id, appointment_id) VALUES (3,5);
insert into user_appointment (user_id, appointment_id) VALUES (3,11);


