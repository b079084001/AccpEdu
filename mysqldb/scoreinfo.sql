create table SCOREINFO(
	stuid CHAR(11),		/**  ѧ��ѧ��  */
	subjectno CHAR(4),	/**  ��Ŀ���  */
	score INTEGER not null default 0,	/**  �ɼ�  */
	PRIMARY KEY  (stuid,subjectno)
);
insert into SCOREINFO values ("30112345674","S1_1",0);
insert into SCOREINFO values ("30112345675","S1_1",0);
insert into SCOREINFO values ("30112345676","S1_1",0);
insert into SCOREINFO values ("30112345677","S1_1",0);
insert into SCOREINFO values ("30112345678","S1_1",0);


