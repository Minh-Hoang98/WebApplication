use ManagerHospital
go
alter proc usp_TinhTong2
--tinh tong 2 so nguyen
@a int,
@b int
as
begin
  declare @result int
  set @result=@a+@b
  --tong so va chuoi nen k hieu-->phai cast de convert
  print N'Tong 2 so '+CAST(@a as varchar(10))+ 'va'+casT(@b as varchar(10)) +'la'+casT(@result as varchar(10))
end
exec usp_TinhTong2 6,9



create proc usp_TinhTongOut
@a int ,
@b int,
@result int out
as
begin
set @result=@a+@b
end
go
declare @result int
exec usp_TinhTongOut 6,9,@result out
print @result