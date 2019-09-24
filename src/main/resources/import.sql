insert into user (id, login, password) values (1, 'admin', 'admin');

insert into my_day_of_week (id, description) values (1, 'MONDAY');
insert into my_day_of_week (id, description) values (2, 'TUESDAY');
insert into my_day_of_week (id, description) values (3, 'WEDNESDAY');
insert into my_day_of_week (id, description) values (4, 'THURSDAY');
insert into my_day_of_week (id, description) values (5, 'FRIDAY');
insert into my_day_of_week (id, description) values (6, 'SATURDAY');
insert into my_day_of_week (id, description) values (7, 'SUNDAY');

insert into wheather_forecast(id, id_my_day_of_week, min_temperature, max_temperature, moisture, latitude, longitude, time, description) values (1, 1, 10.2, 15.6, 5.32, 10, 15, '12:50:35', 'This a cold day');

insert into wheather_forecast (id, id_my_day_of_week, min_temperature, max_temperature, moisture, latitude, longitude, time, description) values (2, 2, 10.6, 15.1, 5.37, 10, 15, '16:30:20', 'This almost the same day');

