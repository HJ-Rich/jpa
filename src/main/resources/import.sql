insert into student values(student_seq.nextval, 'richard')
insert into student values(student_seq.nextval, 'jane')
insert into student values(student_seq.nextval, 'jake')
insert into student values(student_seq.nextval, 'kay')
insert into student values(student_seq.nextval, 'start')

insert into club values(club_seq.nextval, 'baseball')
insert into club values(club_seq.nextval, 'soccer')
insert into club values(club_seq.nextval, 'tennis')

insert into student_has_club values(student_has_club_seq.nextval, 1, 1)
insert into student_has_club values(student_has_club_seq.nextval, 2, 1)
insert into student_has_club values(student_has_club_seq.nextval, 3, 1)
insert into student_has_club values(student_has_club_seq.nextval, 1, 2)
insert into student_has_club values(student_has_club_seq.nextval, 3, 2)
insert into student_has_club values(student_has_club_seq.nextval, 3, 3)
insert into student_has_club values(student_has_club_seq.nextval, 1, 4)
insert into student_has_club values(student_has_club_seq.nextval, 3, 4)
insert into student_has_club values(student_has_club_seq.nextval, 2, 5)