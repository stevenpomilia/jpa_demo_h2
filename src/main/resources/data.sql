-- executed if there is a data.sql
DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer(id INT, first_name VARCHAR(255), last_name VARCHAR(255), date_joined VARCHAR(255));

