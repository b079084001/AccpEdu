/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50744
Source Host           : localhost:3306
Source Database       : accp

Target Server Type    : MYSQL
Target Server Version : 50744
File Encoding         : 65001

Date: 2025-06-21 20:27:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `classinfo`
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `CLASSID` char(15) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号',
  `CLASSBID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '总部班级编号',
  `CLASSTEACHER` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '授课教员',
  `CLASSMANAGER` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班主任',
  `CLASSBEGINDATE` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '开课日期',
  `CLASSFINISHDATE` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预计结课日期',
  `CLASSTESTDATE` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预计参加考试时间',
  `CLASSTYPE` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级种类',
  `CLASSPERWEEK` smallint(6) DEFAULT '12' COMMENT '周课时数',
  `CLASSBEGINNUMBER` smallint(6) DEFAULT '0' COMMENT '开课人数',
  `CLASSSTUIN` smallint(6) DEFAULT '0' COMMENT '转入',
  `CLASSSTUOUT` smallint(6) DEFAULT '0' COMMENT '转出',
  `CLASSSTUPAUSE` smallint(6) DEFAULT '0' COMMENT '休学',
  `CLASSSTUNUMBER` smallint(6) DEFAULT '0' COMMENT '班级人数',
  `CLASSENDDATE` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '结课日期',
  `CLASSENDNUMBER` smallint(6) DEFAULT '0' COMMENT '结课时人数',
  `CLASSPRERATE` float DEFAULT '0' COMMENT ' 预计升学率',
  `CLASSPASSNUMBER` smallint(6) DEFAULT '0' COMMENT '获证人数',
  `CLASSREALNUMBER` smallint(6) DEFAULT '0' COMMENT '实际开学人数',
  `CLASSREALRATE` float DEFAULT '0' COMMENT '实际升学率',
  `CLASSSEME` char(2) COLLATE utf8mb4_unicode_ci DEFAULT 'S1' COMMENT '学期',
  PRIMARY KEY (`CLASSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES ('ACCP2006S10617A', '6071041T01', '陈丽娜', '朱梅松', null, null, null, 'T135AM', '12', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', 'S1');
INSERT INTO `classinfo` VALUES ('ACCP2006S10722A', '6072841T01', '史晓伦', '张慧慧', null, null, null, 'T135PM', '12', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', 'S1');
INSERT INTO `classinfo` VALUES ('ACCP2006S20628A', '6062842Y01', '党国涛', '张淑红', null, null, null, 'T246AM', '12', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', 'S2');
INSERT INTO `classinfo` VALUES ('ACCP2006S20814A', '6081082T01', '王海龙', '朱梅松', null, null, null, 'T246PM', '12', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', 'S2');
INSERT INTO `classinfo` VALUES ('ACCP2006Y20310A', '6031043T01', '姬晓峰', '孙燕', null, null, null, 'T135AM', '12', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', 'Y2');
INSERT INTO `classinfo` VALUES ('ACCP2006Y20322A', '6032243W01', '周磊', '杨俊英', null, null, null, 'T135PM', '12', '0', '0', '0', '0', '0', null, '0', '0', '0', '0', '0', 'Y2');

-- ----------------------------
-- Table structure for `departmentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `departmentinfo`;
CREATE TABLE `departmentinfo` (
  `DEPARTMENTID` char(4) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门编号',
  `DEPARTMENTNAME` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`DEPARTMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of departmentinfo
-- ----------------------------
INSERT INTO `departmentinfo` VALUES ('hw01', '行政部');
INSERT INTO `departmentinfo` VALUES ('hw02', '市场部');
INSERT INTO `departmentinfo` VALUES ('hw03', '教质部');
INSERT INTO `departmentinfo` VALUES ('hw04', '学术部');
INSERT INTO `departmentinfo` VALUES ('hw05', '就业部');
INSERT INTO `departmentinfo` VALUES ('hw06', '财务部');
INSERT INTO `departmentinfo` VALUES ('hw07', '后勤部');
INSERT INTO `departmentinfo` VALUES ('hw08', '人事部');

-- ----------------------------
-- Table structure for `roleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `roleid` char(1) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色编号',
  `rolename` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES ('A', '中心校长');
INSERT INTO `roleinfo` VALUES ('B', '部门经理');
INSERT INTO `roleinfo` VALUES ('C', '人事专员');
INSERT INTO `roleinfo` VALUES ('D', '班主任');
INSERT INTO `roleinfo` VALUES ('E', '教务');
INSERT INTO `roleinfo` VALUES ('F', '就业专员');

-- ----------------------------
-- Table structure for `scoreinfo`
-- ----------------------------
DROP TABLE IF EXISTS `scoreinfo`;
CREATE TABLE `scoreinfo` (
  `stuid` char(11) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生学号',
  `subjectno` char(4) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '科目编号',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '成绩',
  PRIMARY KEY (`stuid`,`subjectno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of scoreinfo
-- ----------------------------
INSERT INTO `scoreinfo` VALUES ('30112345674', 'S1_1', '0');
INSERT INTO `scoreinfo` VALUES ('30112345675', 'S1_1', '0');
INSERT INTO `scoreinfo` VALUES ('30112345676', 'S1_1', '0');
INSERT INTO `scoreinfo` VALUES ('30112345677', 'S1_1', '0');
INSERT INTO `scoreinfo` VALUES ('30112345678', 'S1_1', '0');

-- ----------------------------
-- Table structure for `studentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `schoolid` char(3) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '301' COMMENT '中心编号',
  `stuid` char(11) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学员学号',
  `stuname` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学员姓名',
  `stunamespell` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名拼音',
  `stusex` enum('男','女') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `stuidentity` char(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `stuclassid` char(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在班级编号',
  `stuteacherid` char(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班主任编号',
  `stustate` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT '在读' COMMENT '学员状态',
  `stucertified` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '已持有证书',
  `stuedulevel` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '高中' COMMENT '学历',
  `stuspec` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '专业',
  `stuhomeschool` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '毕业学校',
  `stuworkstate` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '待业' COMMENT '工作状态',
  `stucompany` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工作单位',
  `stuworktype` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工作种类',
  `stutelphone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `stuaddress` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '通讯地址',
  `stucode` char(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮编',
  `stujobcity` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '就业意向城市',
  `stujobcompany` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '就业意向单位',
  `remark` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES ('301', '30112345673', '刘小八', 'liuxiaoba', '男', null, 'ACCP2006Y20322A', '301A003', '在读', null, '高中', null, null, '待业', null, null, null, null, null, null, null, null);
INSERT INTO `studentinfo` VALUES ('301', '30112345674', '朱小七', 'zhuxiaoqi', '男', null, 'ACCP2006Y20310A', '301A002', '在读', null, '高中', null, null, '待业', null, null, null, null, null, null, null, null);
INSERT INTO `studentinfo` VALUES ('301', '30112345675', '赵小六', 'zhaoxiaoliu', '男', null, 'ACCP2006S20814A', '301A001', '在读', null, '高中', null, null, '待业', null, null, null, null, null, null, null, null);
INSERT INTO `studentinfo` VALUES ('301', '30112345676', '王小五', 'wangxiaowu', '男', null, 'ACCP2006S20628A', '301A003', '在读', null, '高中', null, null, '待业', null, null, null, null, null, null, null, null);
INSERT INTO `studentinfo` VALUES ('301', '30112345677', '李小四', 'lixiaosi', '男', null, 'ACCP2006S10722A', '301A002', '在读', null, '高中', null, null, '待业', null, null, null, null, null, null, null, null);
INSERT INTO `studentinfo` VALUES ('301', '30112345678', '张小三', 'zhangxiaosan', '男', null, 'ACCP2006S10617A', '301A001', '在读', null, '高中', null, null, '待业', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `subjectinfo`
-- ----------------------------
DROP TABLE IF EXISTS `subjectinfo`;
CREATE TABLE `subjectinfo` (
  `subjectno` char(4) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '科目编号',
  `subjectname` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '科目名称',
  `subjectseme` char(2) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'S1' COMMENT '所属学期',
  PRIMARY KEY (`subjectno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of subjectinfo
-- ----------------------------
INSERT INTO `subjectinfo` VALUES ('S1_1', 'SQL SERVER应用开发', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_2', '程序逻辑和C语言实现', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_3', '网页编程', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_4', 'Java面向对象程序设计', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_5', '项目案例', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_6', '出勤率', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_7', '课堂表现', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_8', 'COT课程', 'S1');
INSERT INTO `subjectinfo` VALUES ('S1_9', '阶段项目', 'S1');
INSERT INTO `subjectinfo` VALUES ('S2_1', 'SQL SERVER数据库设计和实现', 'S2');
INSERT INTO `subjectinfo` VALUES ('S2_2', 'Java Web应用开发', 'S2');
INSERT INTO `subjectinfo` VALUES ('S2_3', 'C#和WinForm开发', 'S2');
INSERT INTO `subjectinfo` VALUES ('S2_4', '项目案例', 'S2');
INSERT INTO `subjectinfo` VALUES ('S2_5', '出勤率', 'S2');
INSERT INTO `subjectinfo` VALUES ('S2_6', '课堂表现', 'S2');
INSERT INTO `subjectinfo` VALUES ('S2_7', 'COT课程', 'S2');
INSERT INTO `subjectinfo` VALUES ('S2_8', '阶段项目', 'S2');
INSERT INTO `subjectinfo` VALUES ('Y2_1', 'OOAD+XML+Oracle', 'Y2');
INSERT INTO `subjectinfo` VALUES ('Y2_2', '.NET企业级应用开发', 'Y2');
INSERT INTO `subjectinfo` VALUES ('Y2_3', 'J2EE企业级开发及框架技术', 'Y2');
INSERT INTO `subjectinfo` VALUES ('Y2_4', '项目案例', 'Y2');
INSERT INTO `subjectinfo` VALUES ('Y2_5', '出勤率', 'Y2');
INSERT INTO `subjectinfo` VALUES ('Y2_6', '课堂表现', 'Y2');
INSERT INTO `subjectinfo` VALUES ('Y2_7', 'COT课程', 'Y2');
INSERT INTO `subjectinfo` VALUES ('Y2_8', '阶段项目', 'Y2');

-- ----------------------------
-- Table structure for `teacherinfo`
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo` (
  `teacherid` char(15) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '员工编号',
  `teachername` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '员工姓名',
  `teacherbirthday` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出生日期 ',
  `teachersex` enum('男','女') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `teacherschool` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '毕业院校',
  `teachertech` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '专业',
  `teacheraddress` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '籍贯',
  `teacherindate` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '入职时间',
  `teacherdepartment` char(4) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在部门:外键表：departmentinfo',
  `teacherduty` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职务',
  PRIMARY KEY (`teacherid`),
  KEY `teacherdepartment` (`teacherdepartment`),
  CONSTRAINT `teacherinfo_ibfk_1` FOREIGN KEY (`teacherdepartment`) REFERENCES `departmentinfo` (`DEPARTMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of teacherinfo
-- ----------------------------
INSERT INTO `teacherinfo` VALUES ('301A001', '陈丽娜', '1978-05-06', '女', '清华大学', '计算机科学与技术', '河南郑州', '2004-07-08', 'hw04', '学术经理');
INSERT INTO `teacherinfo` VALUES ('301A002', '党国涛', '1979-06-07', '男', '北京大学', '计算机科学与技术', '河南郑州', '2004-09-08', 'hw04', '教员');
INSERT INTO `teacherinfo` VALUES ('301A003', '崔朝霞', '1976-08-16', '女', '清华大学', '计算机科学与技术', '河南郑州', '2003-06-18', 'hw05', '教质经理');
INSERT INTO `teacherinfo` VALUES ('301A004', '杨俊英', '1975-05-26', '女', '河南大学', '体育运动学', '河南郑州', '2006-07-08', 'hw05', '班主任');
INSERT INTO `teacherinfo` VALUES ('301A005', '杨泉', '1980-05-23', '男', '郑州大学', '计算机科学与技术', '河南郑州', '2006-12-08', 'hw05', '就业经理');
INSERT INTO `teacherinfo` VALUES ('301A006', '李娜', '1982-11-06', '女', '河南师范大学', '经济管理', '河南郑州', '2007-01-08', 'hw05', '就业专员');
INSERT INTO `teacherinfo` VALUES ('301A007', '王金柱', '1972-03-05', '男', '哈佛大学', '人力资源管理', '河南郑州', '2003-08-08', 'hw01', '校长');
INSERT INTO `teacherinfo` VALUES ('301A008', '朱丽娜', '1982-11-15', '女', '山东大学', '行政管理', '河南   郑州', '2006-12-08', 'hw03', '教务');
INSERT INTO `teacherinfo` VALUES ('301A009', '张莉', '1983-10-25', '女', '复旦大学', '人事管理', '河南郑州', '2007-02-08', 'hw08', '人事专员');

-- ----------------------------
-- Table structure for `timecheckinfo`
-- ----------------------------
DROP TABLE IF EXISTS `timecheckinfo`;
CREATE TABLE `timecheckinfo` (
  `stuid` char(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学员学号',
  `checkedstate` enum('出勤','迟到','请假','旷课','早退') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '出勤' COMMENT '出勤状态',
  `checkedtime` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '考勤时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of timecheckinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userno` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `userid` char(15) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '员工编号，同时作为用户登录账号  ',
  `userpwd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '111111' COMMENT '账户密码',
  `userrole` varchar(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户所分配的角色',
  PRIMARY KEY (`userno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '301A007', '111111', 'A');
INSERT INTO `userinfo` VALUES ('2', '301A003', '111111', 'B');
INSERT INTO `userinfo` VALUES ('3', '301A009', '111111', 'C');
INSERT INTO `userinfo` VALUES ('4', '301A004', '111111', 'D');
INSERT INTO `userinfo` VALUES ('5', '301A008', '111111', 'E');
INSERT INTO `userinfo` VALUES ('6', '301A006', '111111', 'F');
