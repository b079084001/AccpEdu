create table TIMECHECKINFO(
	stuid CHAR(11),		/**  学员学号  */
	checkedstate ENUM("出勤","迟到","请假","旷课","早退") not null default '出勤',	/**  出勤状态  */
	checkedtime VARCHAR(10)   			/**  考勤时间  */
);