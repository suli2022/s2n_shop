
create database shop
character set utf8
collate utf8_hungarian_ci;

use shop;

grant all privileges 
on shop.*
to shop@localhost
identified by 'titok';

create table products (
    id int not null primary key auto_increment,
    name varchar(50),
    itemNumber varchar(10),
    count int,
    price double
);

