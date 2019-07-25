create sequence hibernate_sequence start 1 increment 1;

create table part (
id serial,
amount int4,
name varchar(255),
necessary boolean,
primary key (id));

INSERT INTO part(name, necessary, amount) VALUES
('материнская плата',true, 3),
('звуковая карта',false ,2),
('процессор ',true , 2),
('подсветка корпуса',false ,0),
('HDD диск',true , 1),
('корпус',true ,10),
('память',true ,10),
('SSD диск',true , 15),
('видеокарта',false ,7),
('монитор', true , 8);
