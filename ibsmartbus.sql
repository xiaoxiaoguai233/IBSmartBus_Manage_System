/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : ibsmartbus

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2020-06-18 23:54:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `busCode` int(11) NOT NULL,
  `busLicense` varchar(20) NOT NULL,
  `busType` varchar(20) NOT NULL,
  `status` varchar(25) NOT NULL,
  `startTime` datetime NOT NULL,
  PRIMARY KEY (`busCode`),
  KEY `AK_Identifier_2` (`busLicense`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES ('1', '鄂E88888', '大巴', '启运', '2020-02-25 22:59:04');
INSERT INTO `bus` VALUES ('2', '鄂N12345', '大巴', '启运', '2020-06-15 22:59:39');
INSERT INTO `bus` VALUES ('3', '桂E77889', '中巴', '启运', '2020-06-02 23:00:06');
INSERT INTO `bus` VALUES ('4', '桂N45678', '中巴', '停运', '2020-06-07 08:00:41');
INSERT INTO `bus` VALUES ('5', '桂E46B54', '小巴', '启运', '2020-06-23 23:01:12');
INSERT INTO `bus` VALUES ('6', '桂7456A4', '小巴', '启运', '2020-03-01 23:01:43');
INSERT INTO `bus` VALUES ('7', '桂B11223', '中巴', '启运', '2020-06-04 00:00:00');
INSERT INTO `bus` VALUES ('8', '鄂A12312', '中小巴', '启运', '2020-06-02 00:00:00');
INSERT INTO `bus` VALUES ('9', '桂E15965', '中巴', '启运', '2020-01-14 00:00:00');

-- ----------------------------
-- Table structure for line
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `lineCode` int(11) NOT NULL,
  `lineName` varchar(20) NOT NULL,
  `status` varchar(25) NOT NULL,
  `startLineTime` datetime NOT NULL,
  `direction` varchar(2) NOT NULL,
  PRIMARY KEY (`lineCode`),
  KEY `AK_Identifier_2` (`lineName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '线路一', '启运', '1989-07-13 23:42:21', '上行');
INSERT INTO `line` VALUES ('2', '线路二', '启运', '2000-06-21 23:43:22', '上行');
INSERT INTO `line` VALUES ('3', '线路三', '停运', '2019-06-02 23:43:48', '上行');
INSERT INTO `line` VALUES ('4', '线路四', '启运', '2019-01-15 23:44:16', '下行');

-- ----------------------------
-- Table structure for line_station_ref
-- ----------------------------
DROP TABLE IF EXISTS `line_station_ref`;
CREATE TABLE `line_station_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lineCode` int(11) DEFAULT NULL,
  `stationCode` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_4` (`lineCode`),
  KEY `FK_Relationship_5` (`stationCode`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`lineCode`) REFERENCES `line` (`lineCode`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`stationCode`) REFERENCES `station` (`stationCode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line_station_ref
-- ----------------------------
INSERT INTO `line_station_ref` VALUES ('1', '1', '3');
INSERT INTO `line_station_ref` VALUES ('2', '1', '2');
INSERT INTO `line_station_ref` VALUES ('3', '1', '4');
INSERT INTO `line_station_ref` VALUES ('4', '2', '3');
INSERT INTO `line_station_ref` VALUES ('5', '2', '4');
INSERT INTO `line_station_ref` VALUES ('6', '2', '5');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionCode` int(11) NOT NULL,
  `permissionName` varchar(50) NOT NULL,
  `permissionDescribe` varchar(100) NOT NULL,
  PRIMARY KEY (`permissionCode`),
  KEY `AK_Identifier_2` (`permissionName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'JiaShi', '	驾驶员权限，只能查看信息');
INSERT INTO `permission` VALUES ('2', 'DiaoDu', '调度员权限，可以进行排班管理，查看信息');
INSERT INTO `permission` VALUES ('3', 'All', '可以增加，修改，删除，查看所有表操作');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rolecode` int(11) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `roleDescribe` varchar(100) NOT NULL,
  PRIMARY KEY (`rolecode`),
  KEY `AK_Identifier_2` (`roleName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '驾驶员', '驾驶员角色');
INSERT INTO `role` VALUES ('2', '调度员', '调度员角色');
INSERT INTO `role` VALUES ('3', '管理员', '管理员角色');

-- ----------------------------
-- Table structure for role_permission_ref
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_ref`;
CREATE TABLE `role_permission_ref` (
  `relationCode` int(11) NOT NULL,
  `rolecode` int(11) DEFAULT NULL,
  `permissionCode` int(11) DEFAULT NULL,
  PRIMARY KEY (`relationCode`),
  KEY `FK_Relationship_2` (`rolecode`),
  KEY `FK_Relationship_3` (`permissionCode`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`rolecode`) REFERENCES `role` (`rolecode`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`permissionCode`) REFERENCES `permission` (`permissionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_ref
-- ----------------------------
INSERT INTO `role_permission_ref` VALUES ('1', '1', '1');
INSERT INTO `role_permission_ref` VALUES ('2', '2', '2');
INSERT INTO `role_permission_ref` VALUES ('3', '3', '3');

-- ----------------------------
-- Table structure for scheduling
-- ----------------------------
DROP TABLE IF EXISTS `scheduling`;
CREATE TABLE `scheduling` (
  `schedulingCode` int(11) NOT NULL AUTO_INCREMENT,
  `lineCode` int(11) DEFAULT NULL,
  `busLicense` int(11) DEFAULT NULL,
  `tcNumber` varchar(25) NOT NULL,
  `tcTime` varchar(20) NOT NULL,
  `userCode` int(11) DEFAULT NULL,
  `startStation` int(11) DEFAULT NULL,
  `endStation` int(11) DEFAULT NULL,
  PRIMARY KEY (`schedulingCode`),
  KEY `FK_Relationship_10` (`endStation`),
  KEY `FK_Relationship_6` (`lineCode`),
  KEY `FK_Relationship_7` (`busLicense`),
  KEY `FK_Relationship_9` (`startStation`),
  KEY `FK_Relationship_8` (`userCode`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`endStation`) REFERENCES `station` (`stationCode`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`lineCode`) REFERENCES `line` (`lineCode`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`busLicense`) REFERENCES `bus` (`busCode`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`userCode`) REFERENCES `sysuser` (`id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`startStation`) REFERENCES `station` (`stationCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scheduling
-- ----------------------------
INSERT INTO `scheduling` VALUES ('1', '1', '1', '12', '00：56', '3', '1', '4');
INSERT INTO `scheduling` VALUES ('2', '2', '5', '205', '01:10', '6', '2', '3');
INSERT INTO `scheduling` VALUES ('3', '3', '5', '456', '01:30', '5', '1', '3');

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `stationCode` int(11) NOT NULL,
  `stationName` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `reqion` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  PRIMARY KEY (`stationCode`),
  KEY `AK_Identifier_2` (`stationName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('1', '黄石港政府湖北师范大学', '115.072238', '30.228596', '湖北省黄石市黄石港区磁湖路180号', '磁湖路');
INSERT INTO `station` VALUES ('2', '黄石市人民政府', '115.045476', '30.20683', '湖北省黄石市下陆区团城山杭州东路1号', '杭州东路');
INSERT INTO `station` VALUES ('3', '黄石市西塞山区人民政府', '115.116816', '30.211206', '黄石市西塞山区人民政府', '飞云街8');
INSERT INTO `station` VALUES ('4', '万达广场(黄石店)', '115.066561', '30.249652', '黄石市黄石港区花湖大道30号', '花湖大道');
INSERT INTO `station` VALUES ('5', '湖北师范大学文理学院(新校区)', '115.122389', '30.159424', '湖北省黄石市经济技术开发区金山大道东666号', '金山大道东');

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `idcard` varchar(25) NOT NULL,
  `role` varchar(5) DEFAULT NULL,
  `driving` decimal(10,0) NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_Identifier_4` (`idcard`),
  KEY `AK_Identifier_3` (`phone`),
  KEY `AK_Identifier_2` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('1', '13977954313', '123456', '吴泽胜', '13977954313', '450702199908015153', '管理员', '0', '启用');
INSERT INTO `sysuser` VALUES ('2', '123456', '123456', '谢青', '12345678910', '450702199908015153', '管理员', '0', '启用');
INSERT INTO `sysuser` VALUES ('3', '12345678', '123456', '游安', '11111111111', '454545451010105455', '驾驶员', '555', '启用');
INSERT INTO `sysuser` VALUES ('4', '13123592227', '123456', '秦起聪', '12345678910', '450702199908901515', '调度员', '0', '启用');
INSERT INTO `sysuser` VALUES ('5', 'qq2571312654', '123456', '丁世杰', '12345678910', '1231231231321233331', '驾驶员', '6000', '禁用');
INSERT INTO `sysuser` VALUES ('6', 'qq123456', '123456', '林晨', '12345645612', '123456465456465454', '驾驶员', '56606', '启用');
INSERT INTO `sysuser` VALUES ('7', '15978', '4654', '熊伟仲', '12313213212', '21321321321321321321', '驾驶员', '21231', '启用');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 NOT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('5', '谢青123', '男', '778877887788', '湖北武汉');
INSERT INTO `t_customer` VALUES ('6', '徐燕', '女', '12312312311', '湖北黄石');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL,
  `PassWord` varchar(20) NOT NULL,
  `Name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `Phone` varchar(11) NOT NULL,
  `IdCard` varchar(20) NOT NULL,
  `Role` varchar(20) NOT NULL,
  `Driving` varchar(10) NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '13977954313', '123456', '吴泽胜', '13977954313', '450702199908015153', '3', '0', '0');
