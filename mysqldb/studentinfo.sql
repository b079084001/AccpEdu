create table STUDENTINFO(
	schoolid CHAR(3) not null default '301',  /**  中心编号  */
	stuid CHAR(11) not null primary key,		/**  学员学号  */
	stuname VARCHAR(10) not null,			/**  学员姓名  */
	stunamespell VARCHAR(20) not null,		/**  姓名拼音  */
	stusex ENUM("男","女") not null default '男',	/**  性别  */
	stuidentity CHAR(18),   			/**  身份证号  */
	stuclassid CHAR(15),			/**  所在班级编号  */
	stuteacherid  CHAR(15),			/**  班主任编号  */
	stustate VARCHAR(10) null default '在读',	/**  学员状态  */
	stucertified VARCHAR(20),			/**  已持有证书  */
	stuedulevel VARCHAR(10) not null default '高中',		/**  学历  */
	stuspec VARCHAR(20),					/**  专业  */
	stuhomeschool VARCHAR(20),					/**  毕业学校  */
	stuworkstate VARCHAR(20) not null default '待业',		/**  工作状态  */
	stucompany VARCHAR(10),			/**  工作单位  */
	stuworktype VARCHAR(20),			/**  工作种类  */
	stutelphone VARCHAR(20),			/**  联系电话  */
	stuaddress VARCHAR(20) ,			/**  通讯地址  */
	stucode CHAR(6),				/**  邮编  */
	stujobcity VARCHAR(15) ,			/**  就业意向城市  */
	stujobcompany VARCHAR(20),			/**  就业意向单位  */
	remark VARCHAR(250) 			/**  备注  */
);
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345678', '张小三', 'zhangxiaosan', 'ACCP2006S10617A','301A001');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345677', '李小四', 'lixiaosi', 'ACCP2006S10722A','301A002');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345676', '王小五', 'wangxiaowu', 'ACCP2006S20628A','301A003');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345675', '赵小六', 'zhaoxiaoliu', 'ACCP2006S20814A','301A001');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345674', '朱小七', 'zhuxiaoqi', 'ACCP2006Y20310A','301A002');
insert into STUDENTINFO(stuid,stuname,stunamespell,stuclassid,stuteacherid)
	 values ('30112345673', '刘小八', 'liuxiaoba', 'ACCP2006Y20322A','301A003');