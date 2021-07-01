Create database NguyenCanhViet_com_test
use NguyenCanhViet_com_test
create table [User]
(
UserID varchar(6) primary key,
UserName nvarchar(20) not null unique
)
Go
--@lastid la ma so cuoi cung (fixwidth)
--@prefix la tien to ma:vd NV001  -->NV
--@size la so luon ki tu trong ma NV001 -->6
Create function func_nextID(@lastUserID varchar(6),@prefix varchar(3),@size int)
returns varchar(6)
as
    BEGIN
         IF(@lastUserID='')
             set @lastUserID=@prefix + REPLICATE(0,@size - LEN(@prefix))
         declare @num_nextUserID int, @nextUserID varchar(6)
		 set @lastUserID=LTRIM(RTRIM(@lastUserID))
		 set @num_nextUserID=REPLACE(@lastUserID,@prefix,'')+1
		 set @size=@size -LEN(@prefix)
		 set @nextUserID = @prefix +REPLICATE(0,@size - LEN(@prefix))
		 set @nextUserID=@prefix +RIGHT(REPLICATE(0,@size)+CONVERT(varchar(MAX),@num_nextUserID),@size)
		 return @nextUserID
	END
Go
Create trigger re_NextUserID on [User]
for insert
as 
    begin
           declare @lastUserID varchar(6)
           set @lastUserID=(SELECT TOP 1 UserID from [User] order by UserID desc)
           update [User] set UserID =dbo.func_nextID (@lastUserID,'ID_',6) where UserID=''
end
Go
Insert into [User] Values('',N'Gin')
Insert into [User] Values('',N'CanhViet')
Insert into [User] Values('',N'NguyenCanhViet')
Insert into [User] Values('',N'Alibaba	')
Insert into [User] Values('',N'AlibabaSida2')

