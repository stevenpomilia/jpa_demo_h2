-- executed if there is a data.sql
DROP TABLE IF EXISTS customer CASCADE;
-- CREATE TABLE customer(id INT, first_name VARCHAR(255), last_name VARCHAR(255), date_joined VARCHAR(255));
DROP TABLE IF EXISTS orders CASCADE;
-- CREATE TABLE orders(id INT, shipped_location VARCHAR(255), purchase_total VARCHAR(255));

-- executed only if seeding is enabled in application.properties 
-- INSERT INTO customer VALUES(1, 'firstName1', 'lastName1', '12 August 2023');
-- INSERT INTO customer VALUES(2, 'firstName2', 'lastName2', '12 August 2023');