use ManagerHospital
create table [Admin]
(
[Email]  varchar(10) primary key,
[Password] varchar(10) not null,
)
go 
insert into [Admin] values('admin','admin')