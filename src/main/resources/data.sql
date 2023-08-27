-- executed if there is a data.sql
DROP TABLE IF EXISTS virtual_pet CASCADE;
CREATE TABLE virtual_pet(id INT, name VARCHAR(255), description VARCHAR(255), hunger INT, thirst INT, boredom INT);

