DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);


INSERT INTO topjava.public.meals (user_id, date_time, description, calories) VALUES
  (100000, '2017-11-19 07:00', 'Завтрак', DEFAULT),
  (100000, '2017-11-19 12:00', 'Обед', 1000),
  (100000, '2017-11-19 19:00', 'Ужин', 700),
  (100000, '2017-11-19 17:00', 'Перекус', 100),
  (100001, '2017-11-19 08:00', 'Завтрак', DEFAULT),
  (100001, '2017-11-19 13:00', 'Обед', 1100),
  (100001, '2017-11-19 19:00', 'Ужин', 500),
  (100001, '2017-11-19 17:00', 'Перекус', 100);