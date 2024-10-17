insert into CITIES (name) values ('DELHI');
insert into CITIES (name) values ('NOIDA');
insert into CITIES (name) values ('GURGAON');


insert into movies(name,language,genre) values ('BORDER', 'HINDI', 'ACTION');
insert into movies(name,language,genre) values ('GOLMAL', 'HINDI', 'COMEDY');
insert into movies(name,language,genre) values ('X-Man', 'ENGLISH', 'ACTION');
insert into movies(name,language,genre) values ('3-Idiot', 'HINDI', 'COMEDY');
insert into movies(name,language,genre) values ('HARRY POTTER', 'HINDI', 'FANTASY');

insert into theatres(name,address, city_id) values ('PVR','Sector1',1);
insert into theatres(name,address, city_id) values ('ALPHA','Sector2',1);
insert into theatres(name,address, city_id) values ('BETA','Sector3',1);
insert into theatres(name,address, city_id) values ('PVR','Sector1',2);
insert into theatres(name,address, city_id) values ('ALPHA','Sector2',2);
insert into theatres(name,address, city_id) values ('BETA','Sector3',2);
insert into theatres(name,address, city_id) values ('PVR','Sector1',3);
insert into theatres(name,address, city_id) values ('ALPHA','Sector2',3);
insert into theatres(name,address, city_id) values ('BETA','Sector3',3);

insert into screens(name, theatre_id) values( 'A1',1);
insert into screens(name, theatre_id) values( 'A1',1);
insert into screens(name, theatre_id) values( 'A1',1);
insert into screens(name, theatre_id) values( 'A1',2);
insert into screens(name, theatre_id) values( 'A1',2);
insert into screens(name, theatre_id) values( 'A1',2);
insert into screens(name, theatre_id) values( 'A1',3);
insert into screens(name, theatre_id) values( 'A1',3);
insert into screens(name, theatre_id) values( 'A1',3);

insert into seats(seat_number, seat_status, screen_id,price) values (1,'EMPTY',1,100);
insert into seats(seat_number, seat_status, screen_id,price) values (2,'EMPTY',1,100);
insert into seats(seat_number, seat_status, screen_id,price) values (3,'EMPTY',1,200);
insert into seats(seat_number, seat_status, screen_id,price) values (4,'EMPTY',1,200);
insert into seats(seat_number, seat_status, screen_id,price) values (5,'EMPTY',1,300);
insert into seats(seat_number, seat_status, screen_id,price) values (6,'EMPTY',1,300);
insert into seats(seat_number, seat_status, screen_id,price) values (7,'EMPTY',1,400);
insert into seats(seat_number, seat_status, screen_id,price) values (8,'EMPTY',1,400);
insert into seats(seat_number, seat_status, screen_id,price) values (9,'EMPTY',1,400);
insert into seats(seat_number, seat_status, screen_id,price) values (1,'EMPTY',2,100);
insert into seats(seat_number, seat_status, screen_id,price) values (2,'EMPTY',2,100);
insert into seats(seat_number, seat_status, screen_id,price) values (3,'EMPTY',2,200);
insert into seats(seat_number, seat_status, screen_id,price) values (4,'EMPTY',2,200);
insert into seats(seat_number, seat_status, screen_id,price) values (5,'EMPTY',2,300);
insert into seats(seat_number, seat_status, screen_id,price) values (6,'EMPTY',2,300);
insert into seats(seat_number, seat_status, screen_id,price) values (7,'EMPTY',2,400);
insert into seats(seat_number, seat_status, screen_id,price) values (8,'EMPTY',2,400);
insert into seats(seat_number, seat_status, screen_id,price) values (9,'EMPTY',2,400);
insert into seats(seat_number, seat_status, screen_id,price) values (1,'EMPTY',3,100);
insert into seats(seat_number, seat_status, screen_id,price) values (2,'EMPTY',3,100);
insert into seats(seat_number, seat_status, screen_id,price) values (3,'EMPTY',3,200);
insert into seats(seat_number, seat_status, screen_id,price) values (4,'EMPTY',3,200);
insert into seats(seat_number, seat_status, screen_id,price) values (5,'EMPTY',3,300);
insert into seats(seat_number, seat_status, screen_id,price) values (6,'EMPTY',3,300);
insert into seats(seat_number, seat_status, screen_id,price) values (7,'EMPTY',3,400);
insert into seats(seat_number, seat_status, screen_id,price) values (8,'EMPTY',3,400);
insert into seats(seat_number, seat_status, screen_id,price) values (9,'EMPTY',3,400);

insert into users (name,email,password,contact) values ('user1', 'user1@gmail','##$$','232323');
insert into users (name,email,password,contact) values ('user2', 'user2@gmail','##$$','232323');
insert into users (name,email,password,contact) values ('user3', 'user3@gmail','##$$','232323');

insert into shows(city_id,screen_id,movie_id,start_date,end_date,show_time,show_status,theatre_id) values(1,1,1,CURRENT_DATE,CURRENT_DATE+7,CURRENT_TIME,'ONGOING',1);
insert into shows(city_id,screen_id,movie_id,start_date,end_date,show_time,show_status,theatre_id) values(2,2,1,CURRENT_DATE,CURRENT_DATE+7,CURRENT_TIME,'ONGOING',1);
insert into shows(city_id,screen_id,movie_id,start_date,end_date,show_time,show_status,theatre_id) values(1,2,3,CURRENT_DATE,CURRENT_DATE+7,CURRENT_TIME,'ONGOING',1);


insert into offers (show_id,parameter,discount,operator1,condition1,condition_Joiner,operator2,condition2) values(1,'SEATCOUNT',50,'EQUALS','3','OR','GREATERTHAN','3');
insert into offers (show_id,parameter,discount,operator1,condition1,condition_Joiner,operator2,condition2) values(1,'SHOWTIME',20,'FROM','12:00:00','AND','TO','23:59:59');
insert into offers (show_id,parameter,discount,operator1,condition1,condition_Joiner,operator2,condition2) values(2,'SHOWTIME',20,'FROM','12:00:00','AND','TO','23:59:59');
insert into offers (show_id,parameter,discount,operator1,condition1,condition_Joiner,operator2,condition2) values(3,'SHOWTIME',20,'FROM','12:00:00','AND','TO','23:59:59');
