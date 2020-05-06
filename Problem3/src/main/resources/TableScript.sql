drop table customer;

create table customer(
	cust_id number,
	first_name varchar2(20),
	last_namevarchar2(20)
);

insert into customer values(1,'Kuldeep','Kodi');
insert into customer values(2,'Adam','Gilchrist');
insert into customer values(3,'Brad','Pitt');
insert into customer values(4,'Chris','Evans');
insert into customer values(5,'David','bautista');

drop table movie;

create table movie(
	movie_id number,
	name varchar2(20)
);

insert into movie values(1,'Titanic');
insert into movie values(2,'Shawshank Redemption');
insert into movie values(3,'Extraction');
insert into movie values(4,'Avengers- Endgame');
insert into movie values(5,'Toy Story');

drop table rating;

create table rating(
	id number,
	cust_id number,
	movie_id number,
	rating number
);

insert into rating values(1, 1, 1, 4);
insert into rating values(2, 2, 5, 5);
insert into rating values(3, 3, 4, 5);
insert into rating values(4, 4, 4, 5);
insert into rating values(5, 1, 3, 4);
insert into rating values(6, 4, 5, 5);
insert into rating values(7, 1, 4, 5);