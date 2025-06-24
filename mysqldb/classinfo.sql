CREATE TABLE CLASSINFO
(
	CLASSID CHAR(15) not null primary key,		/** 班级编号  */
	CLASSBID CHAR(10) not null,			/**  总部班级编号  */
	CLASSTEACHER VARCHAR(10),				/**  授课教员  */
	CLASSMANAGER VARCHAR(10),				/**  班主任  */
	CLASSBEGINDATE VARCHAR(10),   		/**  开课日期  */
	CLASSFINISHDATE VARCHAR(10),			/**  预计结课日期  */
	CLASSTESTDATE VARCHAR(10),			/**  预计参加考试时间  */
	CLASSTYPE VARCHAR(10),				/**  班级种类  */
	CLASSPERWEEK SMALLINT default 12,		/**  周课时数  */
	CLASSBEGINNUMBER SMALLINT default 0,		/**  开课人数  */
	CLASSSTUIN SMALLINT default 0,			/**  转入  */
	CLASSSTUOUT SMALLINT default 0,			/**  转出  */
	CLASSSTUPAUSE SMALLINT default 0,		/**  休学  */
	CLASSSTUNUMBER SMALLINT default 0,		/**  班级人数  */
	CLASSENDDATE VARCHAR(10),			/**  结课日期  */
	CLASSENDNUMBER SMALLINT default 0,		/**  结课时人数  */
	CLASSPRERATE FLOAT default 0.0,			/**  预计升学率  */
	CLASSPASSNUMBER SMALLINT default 0,		/**  获证人数  */
	CLASSREALNUMBER SMALLINT default 0,		/**  实际开学人数  */
	CLASSREALRATE FLOAT default 0.0,		/**  实际升学率  */
	CLASSSEME CHAR(2) default 'S1'			/**  学期  */
);
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S10617A', '6071041T01', '陈丽娜', '朱梅松', 'T135AM','S1');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S10722A', '6072841T01', '史晓伦', '张慧慧', 'T135PM','S1');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S20628A', '6062842Y01', '党国涛', '张淑红', 'T246AM','S2');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006S20814A', '6081082T01', '王海龙', '朱梅松', 'T246PM','S2');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006Y20310A', '6031043T01', '姬晓峰', '孙燕', 'T135AM','Y2');
insert into classinfo(classid,classbid,classteacher,classmanager,classtype,classseme)
	 values ('ACCP2006Y20322A', '6032243W01', '周磊', '杨俊英', 'T135PM','Y2');