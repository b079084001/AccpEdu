create table ROLEINFO(
	roleid CHAR(1) not null primary key,			/**  角色编号  */
	rolename VARCHAR(20)				/**  角色名称  */
);

insert into ROLEINFO values ('A','中心校长');  /**  中心校长  */
insert into ROLEINFO values ('B','部门经理');  /**  部门经理  */
insert into ROLEINFO values ('C','人事专员');  /**  人事专员  */
insert into ROLEINFO values ('D','班主任');  	/**  班主任  */
insert into ROLEINFO values ('E','教务');  	/**  教务  */
insert into ROLEINFO values ('F','就业专员');  /**  就业专员  */