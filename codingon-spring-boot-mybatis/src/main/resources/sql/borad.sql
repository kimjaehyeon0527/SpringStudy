create table board (
	id int primary key auto_increment,
    title varchar(20) not null,
    content varchar(100) not null,
    writer varchar(10) not null,
    registered datetime default current_timestamp
);
