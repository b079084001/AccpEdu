create table SUBJECTINFO(
	subjectno CHAR(4) not null primary key,		/**  ��Ŀ���  */
	subjectname VARCHAR(30),			/**  ��Ŀ����  */
	subjectseme CHAR(2) not null default "S1"	/**  ����ѧ��  */
);
insert into SUBJECTINFO values ("S1_1","SQL SERVERӦ�ÿ���","S1"); 
insert into SUBJECTINFO values ("S1_2","�����߼���C����ʵ��","S1");
insert into SUBJECTINFO values ("S1_3","��ҳ���","S1");
insert into SUBJECTINFO values ("S1_4","Java�������������","S1");
insert into SUBJECTINFO values ("S1_5","��Ŀ����","S1");
insert into SUBJECTINFO values ("S1_6","������","S1");
insert into SUBJECTINFO values ("S1_7","���ñ���","S1");
insert into SUBJECTINFO values ("S1_8","COT�γ�","S1");
insert into SUBJECTINFO values ("S1_9","�׶���Ŀ","S1");

insert into SUBJECTINFO values ("S2_1","SQL SERVER���ݿ���ƺ�ʵ��","S2"); 
insert into SUBJECTINFO values ("S2_2","Java WebӦ�ÿ���","S2");
insert into SUBJECTINFO values ("S2_3","C#��WinForm����","S2");
insert into SUBJECTINFO values ("S2_4","��Ŀ����","S2");
insert into SUBJECTINFO values ("S2_5","������","S2");
insert into SUBJECTINFO values ("S2_6","���ñ���","S2");
insert into SUBJECTINFO values ("S2_7","COT�γ�","S2");
insert into SUBJECTINFO values ("S2_8","�׶���Ŀ","S2");

insert into SUBJECTINFO values ("Y2_1","OOAD+XML+Oracle","Y2"); 
insert into SUBJECTINFO values ("Y2_2",".NET��ҵ��Ӧ�ÿ���","Y2");
insert into SUBJECTINFO values ("Y2_3","J2EE��ҵ����������ܼ���","Y2");
insert into SUBJECTINFO values ("Y2_4","��Ŀ����","Y2");
insert into SUBJECTINFO values ("Y2_5","������","Y2");
insert into SUBJECTINFO values ("Y2_6","���ñ���","Y2");
insert into SUBJECTINFO values ("Y2_7","COT�γ�","Y2");
insert into SUBJECTINFO values ("Y2_8","�׶���Ŀ","Y2");




