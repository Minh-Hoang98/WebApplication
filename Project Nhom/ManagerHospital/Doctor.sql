create database ManagerHospital
use ManagerHospital
create table Doctor
(
DoctorID nvarchar(6) primary key,
DoctorName nvarchar(50) not null ,
DEmail nvarchar(50) not null,
[DPassword] nvarchar(50) not null,
DGender nvarchar(7) default('Male') check(DGender in ('Male','Female','Other')),
DDOB date not null,
Degree nvarchar(50) default('MBA') check(Degree in ('MBA','HAO','CBA','ODA',
'PHD','DHA','WHO','Other')) not null,
Department nvarchar(50) default('General surgery') check(Department in ('Breast screening','Cardiology'
,'Chaplaincy','Critical care','Gastroenterology','General surgery','Gynaecology','Haematology','Microbiology')),
DContact nvarchar(50) not null,  
[DAddress] nvarchar(50) not null,
DRegisterDate date not null,
[filename] nvarchar(255) ,
savepath nvarchar(255)
)
go
Create function func_nextDoctorID(@lastDoctorID varchar(6),@prefix varchar(3),@size int)
returns varchar(6)
as
    BEGIN
         IF(@lastDoctorID='')
             set @lastDoctorID=@prefix + REPLICATE(0,@size - LEN(@prefix))
         declare @num_nextDoctorID int, @nextDoctorID varchar(6)
		 set @lastDoctorID=LTRIM(RTRIM(@lastDoctorID))
		 set @num_nextDoctorID=REPLACE(@lastDoctorID,@prefix,'')+1
		 set @size=@size -LEN(@prefix)
		 set @nextDoctorID = @prefix +REPLICATE(0,@size - LEN(@prefix))
		 set @nextDoctorID=@prefix +RIGHT(REPLICATE(0,@size)+CONVERT(varchar(MAX),@num_nextDoctorID),@size)
		 return @nextDoctorID
	END
Go
Create trigger re_NextDoctorID on [Doctor]
for insert
as 
    begin
           declare @lastDoctorID varchar(6)
           set @lastDoctorID=(SELECT TOP 1 DoctorID from [Doctor] order by DoctorID desc)
           update [Doctor] set DoctorID =dbo.func_nextDoctorID(@lastDoctorID,'DT_',6) where DoctorID=''
end
go 
