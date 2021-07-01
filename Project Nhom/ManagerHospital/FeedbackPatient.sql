use ManagerHospital
create table FeedbackPatient
(
PatientID nvarchar(6),
PatientName nvarchar(50) not null,
[Services] nvarchar(10) default('Good') check([Services] in ('Good','Excellent','Average','Poor','Very Poor')),
Point int default(5) check(Point in (1,2,3,4,5)) not null,
Quality nvarchar(15) default('Handsome') check(Quality in ('Handsome','Delicious','Intelligent','Generous')) ,
[Status] nvarchar(1000) ,
FRegisterDate date not null,
CONSTRAINT fk_fb
   FOREIGN KEY (PatientID)
   REFERENCES Patient(PatientID),
)

