create table TEACHERINFO(
	teacherid CHAR(15) not null primary key,		/** 员工编号  */
	teachername VARCHAR(10) not null,			/**  员工姓名  */
	teacherbirthday VARCHAR(20),				/**  出生日期  */
	teachersex ENUM("男","女") not null default '男',	/**  性别  */
	teacherschool VARCHAR(20),   			/**  毕业院校  */
	teachertech VARCHAR(20),			/**  专业  */
	teacheraddress VARCHAR(20),			/**  籍贯  */
	teacherindate VARCHAR(20),					/**  入职时间  */
	teacherdepartment CHAR(4),		/**  所在部门:外键表：departmentinfo  */
	teacherduty VARCHAR(16),		/**  职务  */
	FOREIGN KEY(teacherdepartment) REFERENCES departmentinfo(DEPARTMENTID)
);
insert into TEACHERINFO values 
	('301A001', '陈丽娜', '1978-05-06', '女', '清华大学','计算机科学与技术','河南郑州','2004-07-08','hw04','学术经理');
insert into TEACHERINFO values 
	('301A002', '党国涛', '1979-06-07', '男', '北京大学','计算机科学与技术','河南郑州','2004-09-08','hw04','教员');
insert into TEACHERINFO values 
	('301A003', '崔朝霞', '1976-08-16', '女', '清华大学','计算机科学与技术','河南郑州','2003-06-18','hw05','教质经理');
insert into TEACHERINFO values 
	('301A004', '杨俊英', '1975-05-26', '女', '河南大学','体育运动学','河南郑州','2006-07-08','hw05','班主任');
insert into TEACHERINFO values 
	('301A005', '杨泉', '1980-05-23', '男', '郑州大学','计算机科学与技术','河南郑州','2006-12-08','hw05','就业经理');
insert into TEACHERINFO values 
	('301A006', '李娜', '1982-11-06', '女', '河南师范大学','经济管理','河南郑州','2007-01-08','hw05','就业专员');
insert into TEACHERINFO values 
	('301A007', '王金柱', '1972-03-05', '男', '哈佛大学','人力资源管理','河南郑州','2003-08-08','hw01','校长');
insert into TEACHERINFO values 
	('301A008', '朱丽娜', '1982-11-15', '女', '山东大学','行政管理','河南   郑州','2006-12-08','hw03','教务');
insert into TEACHERINFO values 
	('301A009', '张莉', '1983-10-25', '女', '复旦大学','人事管理','河南郑州','2007-02-08','hw08','人事专员');