/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : db_mall

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-03-14 20:48:32
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
  `img` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `sid` int(5) DEFAULT NULL,
  PRIMARY KEY (`hid`),
  KEY `hsid` (`sid`),
  CONSTRAINT `hsid` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot
-- ----------------------------
INSERT INTO `hot` VALUES ('1', 'mall/hotO1CN01ruMtwN1J48GLcHM7n_!!0-item_pic.jpg_60x60q90.jpg', '老铁，来杯茶', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) DEFAULT NULL,
  `sid` int(5) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `ouid` (`uid`) USING BTREE,
  KEY `osid` (`sid`) USING BTREE,
  CONSTRAINT `osid` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`),
  CONSTRAINT `ouid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for recom
-- ----------------------------
DROP TABLE IF EXISTS `recom`;
CREATE TABLE `recom` (
  `rid` int(5) NOT NULL AUTO_INCREMENT,
  `img` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `sid` int(5) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `rsid` (`sid`),
  CONSTRAINT `rsid` FOREIGN KEY (`sid`) REFERENCES `shop` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recom
-- ----------------------------
INSERT INTO `recom` VALUES ('1', 'mall/recomO1CN01ruMtwN1J48GLcHM7n_!!0-item_pic.jpg_60x60q90.jpg', '女神节快乐', '1');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `sid` int(5) NOT NULL AUTO_INCREMENT,
  `head` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `intro` varchar(2000) DEFAULT NULL,
  `imgs` varchar(500) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `num` int(6) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', 'mall/shop', '九州风神玄冰400 CPU散热器铜管台式静音I5电脑I3CPU风扇1155AMD ', '产品名称：Deepcool/九州风神 玄冰4...\r\n品牌: Deepcool/九州风神\r\n九州风神型号: 玄冰400\r\n成色: 全新\r\n售后服务: 全国联保\r\n散热器类型: 风扇\r\n颜色分类: 标配单风扇★赠针管硅胶+理线带 玄冰400蓝光双风扇版本+针管硅胶+理线带 玄冰400双风扇温控版☆加送一分二4PIN线 玄冰400+XFAN120双扇 玄冰400标准单风扇版+硅脂导热膏 玄冰400皓月蓝光双风扇版本 玄冰400极光蓝色双风扇版本 红光版单风扇★赠针管硅胶+理线带 玄冰400红光+极光红色双风扇版本 玄冰400幻彩版 玄冰400+魔环三联包 玄冰400+500W电源+伯爵机箱 玄冰400+伯爵机箱 玄冰400+魔环三联包+600W电源+伯爵机箱 玄冰400+魔环三联包+500W电源+伯爵机箱 玄冰400+600W电源+伯爵机箱 玄冰400RGB高级版（神光同步） 玄冰400RGB高级版双风扇（神光同步）\r\n毛重: 638g\r\n生产企业: 北京市九州风神科技有限公司\r\n适用对象: 多平台\r\n包装体积: 135*76*159mm\r\n保修期: 12个月', null, '99.00', '5635', '1552469492840', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaoshitou', '18205253792', '123');
