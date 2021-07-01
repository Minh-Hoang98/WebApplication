use ManagerHospital
create table AppointmentOfficial
(
PatientID nvarchar(6) not null,
PatientName nvarchar(50) not null,
DoctorID  nvarchar(6) not null,
DoctorName nvarchar(50) not null,
Department nvarchar(50) not null,
RoomType varchar(20) default('VIP') check(Roomtype in ('VIP','NORMAL1','NORMAL2','NORMAL3'))not null, 
AppointmentDate Date not null,
AppointmentTime nvarchar(10) not null,
[Message] nvarchar(1000) not null,
CONSTRAINT fk_pt5
   FOREIGN KEY (PatientID)
   REFERENCES Patient(PatientID),
CONSTRAINT fk_dt5
   FOREIGN KEY (DoctorID)
   REFERENCES Doctor(DoctorID),
)

