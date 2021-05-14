insert into acs_user(id, username, password, role, is_active) values(1, 'admin', 'password', 'ROLE_ADMIN', true);
insert into acs_user(id, username, password, role, is_active) values(2, 'user', 'password', 'ROLE_USER', true);

-- Product type
insert into product_type(id , name, active) values(1, 'Kitchen', true);

-- Product sub type
insert into product_sub_type(id ,name, product_type_id,  active) values(1, 'PRODUCT 1', 1, true);
insert into product_sub_type(id ,name, product_type_id,  active) values(2, 'PRODUCT 2', 1, true);
insert into product_sub_type(id ,name, product_type_id,  active) values(3, 'PRODUCT 3', 1, true);
insert into product_sub_type(id ,name, product_type_id,  active) values(4, 'PRODUCT 4', 1, true);
insert into product_sub_type(id ,name, product_type_id,  active) values(5, 'PRODUCT 5', 1, true);

-- Products
insert into product(id ,name, description, product_type_id, product_sub_type_id,  active) values(1, 'Product 1', 'This is test product used for testing purpose ', 1, 1, true);
insert into product(id ,name, description, product_type_id, product_sub_type_id,  active) values(2, 'Product 2', 'This is test product used for testing purpose ', 1, 2, true);
insert into product(id ,name, description, product_type_id,  product_sub_type_id,  active) values(3, 'Product 3', 'This is test product used for testing purpose ', 1, 3, true);
insert into product(id ,name, description, product_type_id,  product_sub_type_id,  active) values(4, 'Product 4', 'This is test product used for testing purpose ', 1, 4, true);
insert into product(id ,name, description, product_type_id, product_sub_type_id,  active) values(5, 'Product 5', 'This is test product used for testing purpose ', 1, 5, true);

-- Product details
insert into product_detail(id, product_id, price, weight) values (1, 1, 2, 200);
insert into product_detail(id, product_id, price, weight) values ( 2, 1, 1, 100);
insert into product_detail(id, product_id, price, weight) values ( 3, 2, 5, 100);
insert into product_detail(id, product_id, price, weight) values ( 4, 2, 10, 200);
insert into product_detail(id, product_id, price, weight) values (5, 3, 10, 300);





