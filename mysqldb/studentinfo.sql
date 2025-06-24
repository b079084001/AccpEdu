create table STUDENTINFO(
	schoolid CHAR(3) not null default '301',  /**  ���ı��  */
	stuid CHAR(11) not null primary key,		/**  ѧԱѧ��  */
	stuname VARCHAR(10) not null,			/**  ѧԱ����  */
	stunamespell VARCHAR(20) not null,		/**  ����ƴ��  */
	stusex ENUM("��","Ů") not null default '��',	/**  �Ա�  */
	stuidentity CHAR(18),   			/**  ���֤��  */
	stuclassid CHAR(15),			/**  ���ڰ༶���  */
	stuteacherid  CHAR(15),			/**  �����α��  */
	stustate VARCHAR(10) null default '�ڶ�',	/**  ѧԱ״̬  */
	stucertified VARCHAR(20),			/**  �ѳ���֤��  */
	stuedulevel VARCHAR(10) not null default '����',		/**  ѧ��  */
	stuspec VARCHAR(20),					/**  רҵ  */
	stuhomeschool VARCHAR(20),					/**  ��ҵѧУ  */
	stuworkstate VARCHAR(20) not null default '��ҵ',		/**  ����״̬  */
	stucompany VARCHAR(10),			/**  ������λ  */
	stuworktype VARCHAR(20),			/**  ��������  */
	stutelphone VARCHAR(20),			/**  ��ϵ�绰  */
	stuaddress VARCHAR(20) ,			/**  ͨѶ��ַ  */
	stucode CHAR(6),				/**  �ʱ�  */
	stujobcity VARCHAR(15) ,			/**  ��ҵ�������  */
	stujobcompany VARCHAR(20),			/**  ��ҵ����λ  */
	remark VARCHAR(250) 			/**  ��ע  */
);
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345678', '��С��', 'zhangxiaosan', 'ACCP2006S10617A','301A001');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345677', '��С��', 'lixiaosi', 'ACCP2006S10722A','301A002');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345676', '��С��', 'wangxiaowu', 'ACCP2006S20628A','301A003');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345675', '��С��', 'zhaoxiaoliu', 'ACCP2006S20814A','301A001');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345674', '��С��', 'zhuxiaoqi', 'ACCP2006Y20310A','301A002');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345673', '��С��', 'liuxiaoba', 'ACCP2006Y20322A','301A003');