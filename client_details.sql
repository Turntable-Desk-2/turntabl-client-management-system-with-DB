DROP TABLE levels IF EXISTS;
DROP TABLE clients IF EXISTS;

CREATE TABLE levels(
level_id serial PRIMARY KEY,
level_name varchar(50) NOT NULL
);

CREATE TABLE clients(
client_id serial PRIMARY KEY,
client_name varchar(60) NOT NULL,
level_id integer references levels(level_id),
client_address varchar(100) NOT NULL,
client_email varchar(100) NOT NULL,
Phone varchar(20) NOT NULL
);

