CREATE USER estore_dev PASSWORD 'estore_dev';
ALTER ROLE estore_dev SET SEARCH_PATH=estore_dev,public;
CREATE SCHEMA estore_dev AUTHORIZATION estore_dev;
