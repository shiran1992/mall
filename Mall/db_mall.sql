/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : db_mall

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-03-12 21:36:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `sid` int(5) DEFAULT NULL,
  `uid` int(5) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `csid` (`sid`),
  KEY `cuid` (`uid`),
  CONSTRAINT `csid` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`),
  CONSTRAINT `cuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for hot
-- ----------------------------
DROP TABLE IF EXISTS `hot`;
CREATE TABLE `hot` (
  `hid` int(5) NOT NULL AUTO_INCREMENT,
  `img` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `sid` int(5) DEFAULT NULL,
  PRIMARY KEY (`hid`),
  KEY `hsid` (`sid`),
  CONSTRAINT `hsid` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) DEFAULT NULL,
  `sid` int(5) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `ouid` (`uid`),
  KEY `osid` (`sid`),
  CONSTRAINT `osid` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`),
  CONSTRAINT `ouid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for recom
-- ----------------------------
DROP TABLE IF EXISTS `recom`;
CREATE TABLE `recom` (
  `rid` int(5) NOT NULL AUTO_INCREMENT,
  `img` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `sid` int(5) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `rsid` (`sid`),
  CONSTRAINT `rsid` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recom
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `sid` int(5) NOT NULL AUTO_INCREMENT,
  `head` varchar(30) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `imgs` varchar(500) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `num` int(6) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaoshitou', '18205253792', '123');
