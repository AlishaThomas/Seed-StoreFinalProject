drop table if exists order_products;
drop table if exists products;
drop table if exists orders;
drop table if exists customers;

create table customers(
	customer_id int(10) not null auto_increment,
	first_name varchar(40) not null,
	last_name varchar(40)not null, 
	street varchar (30),
	city varchar (30),
	state varchar(2), 
	zip varchar(30),
	email varchar(60),
	phone varchar(12),
	primary key(customer_id)
);
create table orders(
	order_id int(11) not null auto_increment,
	customer_id int(10) not null,
	order_date datetime default current_timestamp,
	order_total decimal(5,2),
	primary key (order_id),
	foreign key (customer_id) references customers(customer_id)
);
create table products(
	product_id int(10) not null auto_increment, 
	seed_type varchar(50) not null,
	name varchar(50) not null,
	description varchar(255),
	price decimal(5,2) not null,
	primary key (product_id)
);
	
create table order_products(
	order_products_id int(50) not null auto_increment, 
	order_id int(11) not null,
	product_id int(10) not null,
	primary key (order_products_id),
	foreign key (order_id) references orders (order_id),
	foreign key (product_id) references products (product_id)
);





