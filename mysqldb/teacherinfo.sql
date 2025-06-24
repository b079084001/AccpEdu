create table TEACHERINFO(
	teacherid CHAR(15) not null primary key,		/** Ա�����  */
	teachername VARCHAR(10) not null,			/**  Ա������  */
	teacherbirthday VARCHAR(20),				/**  ��������  */
	teachersex ENUM("��","Ů") not null default '��',	/**  �Ա�  */
	teacherschool VARCHAR(20),   			/**  ��ҵԺУ  */
	teachertech VARCHAR(20),			/**  רҵ  */
	teacheraddress VARCHAR(20),			/**  ����  */
	teacherindate VARCHAR(20),					/**  ��ְʱ��  */
	teacherdepartment CHAR(4),		/**  ���ڲ���:�����departmentinfo  */
	teacherduty VARCHAR(16),		/**  ְ��  */
	FOREIGN KEY(teacherdepartment) REFERENCES departmentinfo(DEPARTMENTID)
);
insert into TEACHERINFO values 
	('301A001', '������', '1978-05-06', 'Ů', '�廪��ѧ','�������ѧ�뼼��','����֣��','2004-07-08','hw04','ѧ������');
insert into TEACHERINFO values 
	('301A002', '������', '1979-06-07', '��', '������ѧ','�������ѧ�뼼��','����֣��','2004-09-08','hw04','��Ա');
insert into TEACHERINFO values 
	('301A003', '�޳�ϼ', '1976-08-16', 'Ů', '�廪��ѧ','�������ѧ�뼼��','����֣��','2003-06-18','hw05','���ʾ���');
insert into TEACHERINFO values 
	('301A004', '�Ӣ', '1975-05-26', 'Ů', '���ϴ�ѧ','�����˶�ѧ','����֣��','2006-07-08','hw05','������');
insert into TEACHERINFO values 
	('301A005', '��Ȫ', '1980-05-23', '��', '֣�ݴ�ѧ','�������ѧ�뼼��','����֣��','2006-12-08','hw05','��ҵ����');
insert into TEACHERINFO values 
	('301A006', '����', '1982-11-06', 'Ů', '����ʦ����ѧ','���ù���','����֣��','2007-01-08','hw05','��ҵרԱ');
insert into TEACHERINFO values 
	('301A007', '������', '1972-03-05', '��', '�����ѧ','������Դ����','����֣��','2003-08-08','hw01','У��');
insert into TEACHERINFO values 
	('301A008', '������', '1982-11-15', 'Ů', 'ɽ����ѧ','��������','����   ֣��','2006-12-08','hw03','����');
insert into TEACHERINFO values 
	('301A009', '����', '1983-10-25', 'Ů', '������ѧ','���¹���','����֣��','2007-02-08','hw08','����רԱ');