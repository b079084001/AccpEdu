create table TIMECHECKINFO(
	stuid CHAR(11),		/**  ѧԱѧ��  */
	checkedstate ENUM("����","�ٵ�","���","����","����") not null default '����',	/**  ����״̬  */
	checkedtime VARCHAR(10)   			/**  ����ʱ��  */
);