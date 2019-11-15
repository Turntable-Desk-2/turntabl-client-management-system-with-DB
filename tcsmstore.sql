drop table clients if exists;

create table clients(client_id integer primary key not null, client_name varchar(100) not null, client_level varchar(20) not null, client_address varchar(100) not null, client_email varchar(100) not null, phone varchar(50) not null);

insert into clients values(3456, 'Isaac Agyen', 'Gold', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
insert into clients values(346, 'Sam Bartels', 'Premium', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
insert into clients values(3656, 'Shadrack Ankomahene', 'Platinum', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
insert into clients values(34356, 'Yaa Nuamah', 'Gold', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
insert into clients values(34561, 'Sam Moorhouse', 'premium', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
insert into clients values(34546, 'Isaac Isaacs', 'Platinum', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
insert into clients values(34566, 'Akwasi Manu', 'Premium', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
insert into clients values(456, 'Alex Agyapong', 'Premium', 'Malam Junction 2345', 'alex@io.com', '033-456-321');
