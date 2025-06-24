create table DEPARTMENTINFO(
	DEPARTMENTID CHAR(4) not null primary key,		/** 部门编号  */
	DEPARTMENTNAME VARCHAR(15) not null			/** 部门名称  */
);
insert into DEPARTMENTINFO values ('hw01', '行政部');
insert into DEPARTMENTINFO values ('hw02', '市场部');
insert into DEPARTMENTINFO values ('hw03', '教质部');
insert into DEPARTMENTINFO values ('hw04', '学术部');
insert into DEPARTMENTINFO values ('hw05', '就业部');
insert into DEPARTMENTINFO values ('hw06', '财务部');
insert into DEPARTMENTINFO values ('hw07', '后勤部');
insert into DEPARTMENTINFO values ('hw08', '人事部');