-- create schemas
CREATE USER estore PASSWORD 'estore';
ALTER ROLE estore SET SEARCH_PATH = "$user",public;
CREATE SCHEMA IF NOT EXISTS AUTHORIZATION estore;
