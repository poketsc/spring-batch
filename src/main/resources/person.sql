create table person (
    id bigint primary key auto_increment,
    name varchar(255),
    age varchar(255),
    address varchar(255)
)

insert into person(name, age, address)
values('abc', '32', '서울')
insert into person(name, age, address)
values('abc2', '31', '인천')
insert into person(name, age, address)
values('abc3', '30', '부산')