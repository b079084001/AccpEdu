CREATE TABLE CLASSINFO
(
	CLASSID CHAR(15) not null primary key,		/** �༶���  */
	CLASSBID CHAR(10) not null,			/**  �ܲ��༶���  */
	CLASSTEACHER VARCHAR(10),				/**  �ڿν�Ա  */
	CLASSMANAGER VARCHAR(10),				/**  ������  */
	CLASSBEGINDATE VARCHAR(10),   		/**  ��������  */
	CLASSFINISHDATE VARCHAR(10),			/**  Ԥ�ƽ������  */
	CLASSTESTDATE VARCHAR(10),			/**  Ԥ�Ʋμӿ���ʱ��  */
	CLASSTYPE VARCHAR(10),				/**  �༶����  */
	CLASSPERWEEK SMALLINT default 12,		/**  �ܿ�ʱ��  */
	CLASSBEGINNUMBER SMALLINT default 0,		/**  ��������  */
	CLASSSTUIN SMALLINT default 0,			/**  ת��  */
	CLASSSTUOUT SMALLINT default 0,			/**  ת��  */
	CLASSSTUPAUSE SMALLINT default 0,		/**  ��ѧ  */
	CLASSSTUNUMBER SMALLINT default 0,		/**  �༶����  */
	CLASSENDDATE VARCHAR(10),			/**  �������  */
	CLASSENDNUMBER SMALLINT default 0,		/**  ���ʱ����  */
	CLASSPRERATE FLOAT default 0.0,			/**  Ԥ����ѧ��  */
	CLASSPASSNUMBER SMALLINT default 0,		/**  ��֤����  */
	CLASSREALNUMBER SMALLINT default 0,		/**  ʵ�ʿ�ѧ����  */
	CLASSREALRATE FLOAT default 0.0,		/**  ʵ����ѧ��  */
	CLASSSEME CHAR(2) default 'S1'			/**  ѧ��  */
);
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S10617A', '6071041T01', '������', '��÷��', 'T135AM','S1');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S10722A', '6072841T01', 'ʷ����', '�Żۻ�', 'T135PM','S1');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S20628A', '6062842Y01', '������', '�����', 'T246AM','S2');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S20814A', '6081082T01', '������', '��÷��', 'T246PM','S2');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006Y20310A', '6031043T01', '������', '����', 'T135AM','Y2');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006Y20322A', '6032243W01', '����', '�Ӣ', 'T135PM','Y2');