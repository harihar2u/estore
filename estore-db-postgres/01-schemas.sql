-- Create schemas
CREATE USER estore_dev PASSWORD 'estore_dev';
ALTER ROLE estore_dev SET SEARCH_PATH="$user",public;
CREATE SCHEMA AUTHORIZATION estore_dev;
