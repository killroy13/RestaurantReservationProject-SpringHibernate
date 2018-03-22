use restaurant_reservation_db;

CREATE TABLE IF NOT EXISTS advertisements
(
  advertisement_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  adv_text VARCHAR(45) NOT NULL,
  restaurant_id INT NOT NULL
);
CREATE TABLE IF NOT EXISTS orders
(
  orders_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL
);
CREATE TABLE IF NOT EXISTS restaurants
(
  restaurant_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  rest_name VARCHAR(45) NOT NULL,
  rest_city VARCHAR(45) NOT NULL,
  rest_district VARCHAR(45) NOT NULL,
  rest_street VARCHAR(45) NOT NULL,
  houseNumber VARCHAR(45) NOT NULL,
  rest_phone VARCHAR(45),
  rest_describe VARCHAR(45) NOT NULL,
  rest_photo VARCHAR(45)
);
CREATE TABLE IF NOT EXISTS reviews
(
  reviews_id INT PRIMARY KEY NOT NULL,
  rev_date DATE NOT NULL,
  rev_text VARCHAR(45) NOT NULL,
  user_id INT NOT NULL,
  restaurants_id INT NOT NULL
);
CREATE TABLE IF NOT EXISTS users
(
  users_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  user_birth DATE NOT NULL,
  login VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  user_email VARCHAR(45) NOT NULL,
  user_phone VARCHAR(45) NOT NULL
);
ALTER TABLE advertisements ADD FOREIGN KEY (restaurant_id) REFERENCES restaurants (restaurant_id);
CREATE INDEX restaurantId_idx ON advertisements (restaurant_id);
ALTER TABLE reviews ADD FOREIGN KEY (restaurants_id) REFERENCES restaurants (restaurant_id);
ALTER TABLE reviews ADD FOREIGN KEY (user_id) REFERENCES users (users_id);
CREATE INDEX restId_idx ON reviews (restaurants_id);
CREATE INDEX usersId_idx ON reviews (user_id);


#
#
#
# CREATE TABLE IF NOT EXISTS users
#   (
#   users_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#   user_name VARCHAR(45) NOT NULL,
#   last_name VARCHAR(45) NOT NULL,
#   user_birth DATE NOT NULL,
#   login VARCHAR(45) NOT NULL,
#   password VARCHAR(45) NOT NULL,
#   user_email VARCHAR(45) NOT NULL,
#   user_phone VARCHAR(45) NOT NULL
#   );
#
# CREATE TABLE IF NOT EXISTS reviews
# (
#   reviews_id INT PRIMARY KEY NOT NULL,
#   rev_date DATE NOT NULL,
#   rev_text VARCHAR(45) NOT NULL,
#   user_id INT NOT NULL,
#   restaurants_id INT NOT NULL,
#   FOREIGN KEY (restaurants_id) REFERENCES restaurant (restaurant_id),
#   FOREIGN KEY (user_id) REFERENCES users (users_id)
# );
# CREATE INDEX restId_idx ON reviews (restaurants_id);
# CREATE INDEX usersId_idx ON reviews (user_id);
#
# CREATE TABLE IF NOT EXISTS restaurants
# (
#   restaurant_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#   rest_name VARCHAR(45) NOT NULL,
#   rest_city VARCHAR(45) NOT NULL,
#   rest_district VARCHAR(45) NOT NULL,
#   rest_street VARCHAR(45) NOT NULL,
#   houseNumber VARCHAR(45) NOT NULL,
#   rest_phone VARCHAR(45),
#   rest_describe VARCHAR(45) NOT NULL,
#   rest_photo VARCHAR(45)
# );
#
# CREATE TABLE IF NOT EXISTS orders
# (
#   orders_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#   user_id INT NOT NULL
# );
#
# CREATE TABLE IF NOT EXISTS advertisements
# (
#   advertisement_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#   adv_text VARCHAR(45) NOT NULL,
#   restaurant_id INT NOT NULL,
#   FOREIGN KEY (restaurant_id) REFERENCES restaurants (restaurant_id)
# );
# CREATE INDEX restaurantId_idx ON advertisements (restaurant_id);




#
# /*Project*/
# restaurant_reservation_db
#
# create database restaurant_reservation_db;
#
# CREATE TABLE users (
#   users_id INT NOT NULL AUTO_INCREMENT,
#   user_name VARCHAR(45) NOT NULL,
#   last_name VARCHAR(45) NOT NULL,
#   user_birth DATE NOT NULL,
#   login VARCHAR(45) NOT NULL,
#   password VARCHAR(45) NOT NULL,
#   user_email VARCHAR(45) NOT NULL,
#   user_phone VARCHAR(45) NOT NULL,
#   PRIMARY KEY (users_id));
#
# CREATE TABLE restaurant (
#   restaurant_id INT NOT NULL AUTO_INCREMENT,
#   rest_name VARCHAR(45) NOT NULL,
#   rest_city VARCHAR(45) NOT NULL,
#   rest_district VARCHAR(45) NOT NULL,
#   rest_street VARCHAR(45) NOT NULL,
#   houseNumber VARCHAR(45) NOT NULL,
#   rest_phone VARCHAR(45) NULL,
#   rest_describe VARCHAR(45) NOT NULL,
#   rest_photo VARCHAR(45) NULL,
#   PRIMARY KEY (restaurant_id));
#
# CREATE TABLE advertisement (
#   advertisement_id INT NOT NULL AUTO_INCREMENT,
#   adv_text VARCHAR(45) NOT NULL,
#   restaurant_id INT NOT NULL,
#   PRIMARY KEY (advertisement_id),
#   INDEX restaurantId_idx (restaurant_id ASC),
#   CONSTRAINT restaurantId
#   FOREIGN KEY (restaurant_id)
#   REFERENCES restaurant (restaurant_id);
#
# CREATE TABLE reviews (
#   reviews_id INT NOT NULL,
#   rev_date DATE NOT NULL,
#   rev_text VARCHAR(45) NOT NULL,
#   user_id INT NOT NULL,
#   restaurants_id INT NOT NULL,
#   PRIMARY KEY (reviews_id),
#   INDEX usersId_idx (user_id ASC),
#   INDEX restId_idx (restaurants_id ASC),
#   CONSTRAINT usersId
#   FOREIGN KEY (user_id)
#   REFERENCES users (users_id),
#   CONSTRAINT restId
#   FOREIGN KEY (restaurants_id)
#   REFERENCES restaurant (restaurant_id);











