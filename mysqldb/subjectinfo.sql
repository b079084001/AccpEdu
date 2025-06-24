create table SUBJECTINFO(
	subjectno CHAR(4) not null primary key,		/**  科目编号  */
	subjectname VARCHAR(30),			/**  科目名称  */
	subjectseme CHAR(2) not null default "S1"	/**  所属学期  */
);
insert into SUBJECTINFO values ("S1_1","SQL SERVER应用开发","S1"); 
insert into SUBJECTINFO values ("S1_2","程序逻辑和C语言实现","S1");
insert into SUBJECTINFO values ("S1_3","网页编程","S1");
insert into SUBJECTINFO values ("S1_4","Java面向对象程序设计","S1");
insert into SUBJECTINFO values ("S1_5","项目案例","S1");
insert into SUBJECTINFO values ("S1_6","出勤率","S1");
insert into SUBJECTINFO values ("S1_7","课堂表现","S1");
insert into SUBJECTINFO values ("S1_8","COT课程","S1");
insert into SUBJECTINFO values ("S1_9","阶段项目","S1");

insert into SUBJECTINFO values ("S2_1","SQL SERVER数据库设计和实现","S2"); 
insert into SUBJECTINFO values ("S2_2","Java Web应用开发","S2");
insert into SUBJECTINFO values ("S2_3","C#和WinForm开发","S2");
insert into SUBJECTINFO values ("S2_4","项目案例","S2");
insert into SUBJECTINFO values ("S2_5","出勤率","S2");
insert into SUBJECTINFO values ("S2_6","课堂表现","S2");
insert into SUBJECTINFO values ("S2_7","COT课程","S2");
insert into SUBJECTINFO values ("S2_8","阶段项目","S2");

insert into SUBJECTINFO values ("Y2_1","OOAD+XML+Oracle","Y2"); 
insert into SUBJECTINFO values ("Y2_2",".NET企业级应用开发","Y2");
insert into SUBJECTINFO values ("Y2_3","J2EE企业级开发及框架技术","Y2");
insert into SUBJECTINFO values ("Y2_4","项目案例","Y2");
insert into SUBJECTINFO values ("Y2_5","出勤率","Y2");
insert into SUBJECTINFO values ("Y2_6","课堂表现","Y2");
insert into SUBJECTINFO values ("Y2_7","COT课程","Y2");
insert into SUBJECTINFO values ("Y2_8","阶段项目","Y2");




