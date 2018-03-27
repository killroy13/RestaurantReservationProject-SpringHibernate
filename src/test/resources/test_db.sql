/*Test Project*/
# test_restaurant_reservation_db

create database IF NOT EXISTS test_restaurant_reservation_db;
USE test_restaurant_reservation_db;

# DROP TABLE advertisements;
# DROP TABLE orders;
# DROP TABLE reviews;
# DROP TABLE restaurants;
# DROP TABLE users;

CREATE TABLE IF NOT EXISTS users
(
  users_id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_name  VARCHAR(45)     NOT NULL,
  last_name  VARCHAR(45)     NOT NULL,
  user_birth DATE            NOT NULL,
  login      VARCHAR(45)     NOT NULL,
  password   VARCHAR(45)     NOT NULL,
  user_email VARCHAR(45)     NOT NULL,
  user_phone VARCHAR(45)     NOT NULL
);
CREATE TABLE IF NOT EXISTS restaurants
(
  restaurant_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  rest_name     VARCHAR(45)     NOT NULL,
  rest_city     VARCHAR(45)     NOT NULL,
  rest_district VARCHAR(45)     NOT NULL,
  rest_street   VARCHAR(45)     NOT NULL,
  houseNumber   VARCHAR(45)     NOT NULL,
  rest_phone    VARCHAR(16)     NOT NULL,
  rest_describe VARCHAR(300)    NOT NULL,
  rest_photo    LONGBLOB
);
CREATE TABLE IF NOT EXISTS advertisements
(
  advertisement_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  adv_text         VARCHAR(45)     NOT NULL,
  restaurant_id    INT             NOT NULL,
  INDEX restaurantId_idx (restaurant_id ASC),
  CONSTRAINT restaurantId
  FOREIGN KEY (restaurant_id)
  REFERENCES restaurants (restaurant_id)
);
CREATE TABLE IF NOT EXISTS reviews
(
  reviews_id     INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  rev_date       DATE            NOT NULL,
  rev_text       VARCHAR(45)     NOT NULL,
  user_id        INT             NOT NULL,
  restaurants_id INT             NOT NULL,
  INDEX usersId_idx (user_id ASC),
  CONSTRAINT usersId
  FOREIGN KEY (user_id)
  REFERENCES users (users_id),
  INDEX restId_idx (restaurants_id ASC),
  CONSTRAINT restId
  FOREIGN KEY (restaurants_id)
  REFERENCES restaurants (restaurant_id)
);
CREATE TABLE IF NOT EXISTS orders
(
  orders_id  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_id    INT             NOT NULL,
  rest_id    INT             NOT NULL,
  order_date DATE            NOT NULL,
  INDEX userId_idx (user_id ASC),
  CONSTRAINT userId
  FOREIGN KEY (user_id)
  REFERENCES users (users_id),
  INDEX restId_idx (rest_id ASC),
  CONSTRAINT restaurantsId
  FOREIGN KEY (rest_id)
  REFERENCES restaurants (restaurant_id)
);


# ALTER TABLE advertisements ADD FOREIGN KEY (restaurant_id) REFERENCES restaurants (restaurant_id);
# CREATE INDEX restaurantId_idx ON advertisements (restaurant_id);
#
# ALTER TABLE reviews ADD FOREIGN KEY (user_id) REFERENCES users (users_id);
# CREATE INDEX usersId_idx ON reviews (user_id);
# ALTER TABLE reviews ADD FOREIGN KEY (restaurants_id) REFERENCES restaurants (restaurant_id);
# CREATE INDEX restId_idx ON reviews (restaurants_id);
#
# ALTER TABLE orders ADD FOREIGN KEY (user_id) REFERENCES users (users_id);
# CREATE INDEX FK_usersId_idx ON orders (user_id);
# ALTER TABLE orders ADD FOREIGN KEY (rest_id) REFERENCES restaurants (restaurant_id);
# CREATE INDEX FK_restId_idx ON orders (rest_id);
