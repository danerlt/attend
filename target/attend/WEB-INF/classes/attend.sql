/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : attendce

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-04-02 03:39:15
*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
SET FOREIGN_KEY_CHECKS=0;
DROP DATABASE IF EXISTS attend;
CREATE DATABASE attend DEFAULT CHARACTER SET utf8;
USE attend;
-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id,主键',
  `uid` int(6) DEFAULT NULL COMMENT '用户id',
  `workdate` datetime DEFAULT NULL COMMENT '工作日期',
  `describe` varchar(1000) DEFAULT NULL COMMENT '工作内容描述',
  `worktime` tinyint(4) DEFAULT NULL COMMENT '工作时长,单位小时',
  `difficulty` varchar(10) DEFAULT NULL COMMENT '工作难度,有初,中,高',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_user` (`uid`),
  CONSTRAINT `fk_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('100001', '1001', '2017-04-01 00:00:00', '测试数据', '8', '中', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名,不能为空',
  `password` varchar(32) NOT NULL COMMENT '密码,加密存储',
  `level` int(11) DEFAULT '0' COMMENT '用户权限等级,一共分为5级,最高5级,最低0级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1001', 'root', '123456', '5');
INSERT INTO `user` VALUES ('1002', 'test', '123456', '4');
INSERT INTO `user` VALUES ('1003', 'litao', '123456', '3');
INSERT INTO `user` VALUES ('1004', 'wll', '123456', '2');
