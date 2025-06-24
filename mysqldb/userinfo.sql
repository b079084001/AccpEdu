create table USERINFO(
	userno INTEGER not null auto_increment,		/**  序号  */
	userid CHAR(15) not null,			/**  员工编号，同时作为用户登录账号  */
	userpwd VARCHAR(20) not null default '111111',	/**  账户密码  */
	userrole VARCHAR(6),   /**  用户所分配的角色  */
	PRIMARY KEY  (userno)
);
insert into USERINFO values (1, '301A007', '111111', 'A');  /**  校长  */
insert into USERINFO values (2, '301A003', '111111', 'B');  /**  部门经理  */
insert into USERINFO values (3, '301A009', '111111', 'C');  /**  人事专员  */
insert into USERINFO values (4, '301A004', '111111', 'D');  /**  班主任  */
insert into USERINFO values (5, '301A008', '111111', 'E');  /**  教务  */
insert into USERINFO values (6, '301A006', '111111', 'F');  /**  就业专员  */
