create table USERINFO(
	userno INTEGER not null auto_increment,		/**  ���  */
	userid CHAR(15) not null,			/**  Ա����ţ�ͬʱ��Ϊ�û���¼�˺�  */
	userpwd VARCHAR(20) not null default '111111',	/**  �˻�����  */
	userrole VARCHAR(6),   /**  �û�������Ľ�ɫ  */
	PRIMARY KEY  (userno)
);
insert into USERINFO values (1, '301A007', '111111', 'A');  /**  У��  */
insert into USERINFO values (2, '301A003', '111111', 'B');  /**  ���ž���  */
insert into USERINFO values (3, '301A009', '111111', 'C');  /**  ����רԱ  */
insert into USERINFO values (4, '301A004', '111111', 'D');  /**  ������  */
insert into USERINFO values (5, '301A008', '111111', 'E');  /**  ����  */
insert into USERINFO values (6, '301A006', '111111', 'F');  /**  ��ҵרԱ  */
