create database driver_management;

use driver_management;

-- bus driver
create table driver (
	id int primary key,
	name nvarchar(100) not null, -- họ tên
	address nvarchar(100) not null, -- địa chỉ
	phoneNumber varchar(20)  not null, -- số điện thoại
	level varchar(2) not null -- trình độ
);

-- bus line
create table line (
	id int primary key,
	distance double not null, -- khoảng cách điểm đầu - cuối
	bus_stop int not null -- số bến dừng
);

-- bus assignment
create table assignment (
    id int primary key auto_increment,
	driver_id int not null,
	line_id int not null,
    turns int not null -- số lượt lái trong ngày
);

alter table assignment
add constraint fk_driver
foreign key (driver_id) references driver(id);

alter table assignment
add constraint fk_line
foreign key (line_id) references line(id);

-- ALTER TABLE line MODIFY bus_stop int;

insert into driver values (10000, 'Nguyễn Thị Hải', 'Hà Nội', 12345678, 'A');
insert into driver values (10001, 'Trần Văn Chính', 'Bình Định', 11012015, 'B');
insert into driver values (10002, 'Lê Thu Yến', 'TP HCM', 021456334, 'C');
insert into driver values (10003, 'Lê Hải Yến', 'TP HCM', 050502435, 'D');
insert into driver values (10004, 'Trần Anh Tuấn', 'Hà Nội', 08865554, 'E');
insert into driver values (10005, 'Trần Thanh Mai', 'Hải Phòng', 02456872, 'F');

insert into line values (100, 10.23, 5);
insert into line values (101, 20, 8);
insert into line values (102, 3.5, 2);

insert into assignment values (1, 10000, 101, 5);
insert into assignment values (2, 10002, 100, 6);
insert into assignment values (3, 10000, 102, 4);
insert into assignment values (4, 10005, 102, 12);
insert into assignment values (5, 10003, 102, 2);
insert into assignment values (6, 10004, 100, 2);
