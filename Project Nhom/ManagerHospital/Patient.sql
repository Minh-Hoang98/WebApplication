	
use ManagerHospital
create table Patient
(
PatientID nvarchar(6) primary key,
PatientName nvarchar(50) not null,
PEmail nvarchar(50) not null,
[PPassword] nvarchar(50) not null,
PGender nvarchar(7) default('Male') check(PGender in ('Male','Female','Other')) not null,
DDOB date not null,
Disease nvarchar(150) not null,
[Status] nvarchar(150) ,
Contact nvarchar(50) not null,
[PAddress] nvarchar(50) not null,
[filename] nvarchar(255) ,
[savepath] nvarchar(255)
)
go
Create function func_nextPatientID(@lastPatientID varchar(6),@prefix varchar(3),@size int)
returns varchar(6)
as
    BEGIN
         IF(@lastPatientID='')
             set @lastPatientID=@prefix + REPLICATE(0,@size - LEN(@prefix))
         declare @num_nextPatientID int, @nextPatientID varchar(6)
		 set @lastPatientID=LTRIM(RTRIM(@lastPatientID))
		 set @num_nextPatientID=REPLACE(@lastPatientID,@prefix,'')+1
		 set @size=@size -LEN(@prefix)
		 set @nextPatientID = @prefix +REPLICATE(0,@size - LEN(@prefix))
		 set @nextPatientID=@prefix +RIGHT(REPLICATE(0,@size)+CONVERT(varchar(MAX),@num_nextPatientID),@size)
		 return @nextPatientID
	END
Go
Create trigger re_NextPatientID on [Patient]
for insert
as 
    begin
           declare @lastPatientID varchar(6)
           set @lastPatientID=(SELECT TOP 1 PatientID from [Patient] order by PatientID desc)
           update [Patient] set PatientID =dbo.func_nextPatientID(@lastPatientID,'PT_',6) where PatientID=''
end
go 
