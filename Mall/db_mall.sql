/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : db_mall

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-03-15 18:21:29
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('5', '23', '1');
INSERT INTO `car` VALUES ('6', '21', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot
-- ----------------------------
INSERT INTO `hot` VALUES ('3', 'mall/hot', '', '3');
INSERT INTO `hot` VALUES ('4', 'mall/hot', '', '5');
INSERT INTO `hot` VALUES ('5', 'mall/hot', '', '7');
INSERT INTO `hot` VALUES ('6', 'mall/hot', '', '9');
INSERT INTO `hot` VALUES ('7', 'mall/hot', '', '11');
INSERT INTO `hot` VALUES ('8', 'mall/hot', '', '13');
INSERT INTO `hot` VALUES ('9', 'mall/hot', '', '15');
INSERT INTO `hot` VALUES ('10', 'mall/hot', '', '21');
INSERT INTO `hot` VALUES ('11', 'mall/hot', '', '23');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('2', '1', '23', '苏州市', '18205253796', '1552629953097', '1');
INSERT INTO `orders` VALUES ('3', '1', '22', '北京市', '18205253796', '1552630063620', '0');
INSERT INTO `orders` VALUES ('4', '1', '21', '上海市', '18205253796', '1552630080336', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recom
-- ----------------------------
INSERT INTO `recom` VALUES ('3', 'mall/recomxmad_15476455699512_MQwfF.jpg', '好礼送不断', '17');
INSERT INTO `recom` VALUES ('4', 'mall/recomxmad_15471129430061_HgNMC.jpg', '小米电视4A', '18');
INSERT INTO `recom` VALUES ('5', 'mall/recomxmad_15476374946177_ZTGJq.jpg', '电脑大减价', '19');

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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('3', 'mall/shopO1CN01ZyIzqC2EXNfF8vLur_!!2113798754.jpg', '海盗船 复仇者 单条8G 16G DDR4 2400 3000 3200台式机电脑游戏 RGB内存条8*2套装超频马甲散热内存灯条兼容 ', '\r\n产品名称：美商海盗船 CM4X8GE2400C1...\r\n品牌: 美商海盗船\r\n型号: CM4X8GE2400C16K4\r\n内存容量: 8GB\r\n成色: 全新\r\n售后服务: 全国联保\r\n传输类型: DDR4\r\n颜色分类: DDR4-2400-8G（单条） DDR4-3000-8GB单条 DDR4-3200-8G RGB PRO DDR4 3000 8G 单条 DDR4-2400-16GB套8G*2 DDR4-3000-16GB套装（8Gx2条） DDR4-3200-16GB套装（8Gx2条） RGB PRO 16G 3000（8Gx2条） RGB PRO 16G 3200（8Gx2条） RGB PRO 16G 3600（8Gx2条）\r\n组合形式: 单条\r\n生产企业: 美商海盗船\r\n内存频率: 2400MHz\r\n适用对象: 台式机\r\n是否支持灯光: RGB', null, '289.00', '3350', '1552570673482', null);
INSERT INTO `shop` VALUES ('4', 'mall/shopTB2zeu3gSXlpuFjy0FeXXcJbFXa_!!1746864514.jpg', '威刚游戏威龙 万紫千红DDR4 8G 16G 2400 2666 3000 3200台式机电脑Apex 英雄 游戏吃鸡D4内存条 RGB灯条 ', '产品名称：AData/威刚 8G DDR4 2400...\r\n品牌: AData/威刚\r\n威刚型号: 8G DDR4 2400 (XPG 单条）\r\n内存容量: 8GB\r\n成色: 全新\r\n售后服务: 全国联保\r\n传输类型: DDR4\r\n颜色分类: 8G DDR4 2400万紫千红 8GB DDR4 2666 万紫千红 游戏威龙 8G 2400 8GB DDR4 2666游戏威龙 8GB DDR4 3000 游戏威龙 DDR4 3200 8G游戏威龙 8G DDR4 2666 D41灯条 游戏威龙红色马甲16G套装(8GB*2条)2400频率 游戏威龙金色马甲16G套装(8GB*2条)3000频率 游戏威龙红色马甲16G套装(8GB*2条)2666频率\r\n毛重: 1.0kg\r\n组合形式: 单条\r\n生产企业: 威刚科技股份有限公司\r\n内存频率: 2400MHz\r\n适用对象: 台式机\r\n包装体积: 1\r\n是否支持灯光: RGB', null, '319.00', '2135', '1552570825369', null);
INSERT INTO `shop` VALUES ('5', 'mall/shop5bc056a7N02e342e6.jpg', '三星(SAMSUNG) 860 EVO 500G SATA3 固态硬盘（MZ-76E500B） ', '\r\n    商品名称：三星MZ-76E500B\r\n    商品编号：6212482\r\n    商品毛重：85.00g\r\n    商品产地：中国大陆\r\n    接口：SATA接口\r\n    容量：(480-512)GB\r\n    游戏性能：入门级\r\n', null, '539.00', '2645', '1552571032410', null);
INSERT INTO `shop` VALUES ('6', 'mall/shop57ed10fa37aa7a71.jpg', '东芝(TOSHIBA) TR200系列 240GB SATA3 SSD固态硬盘 ', '\r\n    商品名称：东芝TR200\r\n    商品编号：5724596\r\n    商品毛重：100.00g\r\n    商品产地：中国大陆\r\n    接口：SATA接口\r\n    游戏性能：入门级，发烧级\r\n    容量：(240-256)GB\r\n    类别：家用娱乐，升级换代\r\n', null, '249.00', '10256', '1552614530466', null);
INSERT INTO `shop` VALUES ('7', 'mall/shop82ba312372446250.jpg', '联想（Lenovo）8倍速 铝合金Type-C USB2.0外置光驱 外置DVD刻录机 移动光驱 (Windows/MAC系统/DB85) ', '商品名称：联想DB85\r\n商品编号：100000945519\r\n商品毛重：390.00g\r\n商品产地：中国大陆\r\n接口：USB接口\r\n类型：DVD光驱，DVD刻录机', null, '269.00', '3654', '1552614641226', null);
INSERT INTO `shop` VALUES ('8', 'mall/shop5bed499bN5faab1ed.jpg', '华硕(ASUS) 8倍速 USB2.0 外置移动DVD光驱 黑色(兼容Win7、Win10和苹果 操作系统/SDR-08B1-U)', '\r\n    商品名称：华硕SDR-08B1-U\r\n    商品编号：251210\r\n    商品毛重：420.00g\r\n    商品产地：中国大陆\r\n    接口：USB接口\r\n    类型：DVD光驱，外置DVD光驱\r\n', null, '179.00', '6788', '1552614848134', null);
INSERT INTO `shop` VALUES ('9', 'mall/shop337a5b30e04328d9.jpg', '华硕（ASUS ）EX-RX580 2048SP-4G 1284-1294MHz 4G/256bit GDDR5 DX12 Apex英雄 4G独立游戏显卡 ', '\r\n    商品名称：华硕EX-RX580 2048SP-4G\r\n    商品编号：100001895376\r\n    商品毛重：1.005kg\r\n    商品产地：中国大陆\r\n    接口：其他\r\n    显存位宽：256bit\r\n    游戏特色：其他\r\n    AMD芯片：RX 580\r\n    显存类型：GDDR5\r\n    显存容量：4G\r\n    游戏性能：发烧级\r\n    性能：游戏\r\n', null, '989.00', '8544', '1552615326780', null);
INSERT INTO `shop` VALUES ('10', 'mall/shop5b485f42N3b4298c7.jpg', '索泰（ZOTAC）GTX1060 X-GAMING OC M3吃鸡显卡/游戏电竞台式机独立显卡 6GD5/1569-1784/8008MHz ', '\r\n    商品名称：索泰GTX1060-6GD5 X-GAMING OC M3\r\n    商品编号：8173834\r\n    商品毛重：1.295kg\r\n    商品产地：中国大陆\r\n    接口：HDMI，DP，DVI\r\n    显存位宽：192bit\r\n    游戏特色：索泰至尊PLUS\r\n    显存类型：GDDR5\r\n    游戏性能：发烧级\r\n    显存容量：6G\r\n    NVIDIA芯片：GTX1060\r\n    性能：发烧\r\n', null, '1699.00', '4516', '1552615425704', null);
INSERT INTO `shop` VALUES ('11', 'mall/shop8f6f70c50771e5a1.jpg', '英特尔（Intel）i5 9400F 酷睿六核 盒装CPU处理器 ', '\r\n    商品名称：英特尔i5 9400F\r\n    商品编号：100002657042\r\n    商品毛重：270.00g\r\n    商品产地：哥斯达黎加/越南/中国/美国/菲律宾/马来西亚\r\n    类别：游戏/影音\r\n    接口：INTEL1151（九代）\r\n    产品系列(Intel)：其他\r\n    处理器(Intel)：酷睿i5\r\n', null, '1349.00', '8485', '1552615596158', null);
INSERT INTO `shop` VALUES ('12', 'mall/shop5acb20d3N67918726.jpg', 'AMD 锐龙 7 2700 处理器 (r7) 8核16线程 AM4 接口 3.2GHz 盒装CPU ', '\r\n    商品名称：AMD锐龙 7 2700 处理器\r\n    商品编号：7115899\r\n    商品毛重：0.62kg\r\n    商品产地：中国\r\n    接口：AMD AM4\r\n    产品系列(AMD)：锐龙\r\n    搭配主板(AMD)：X470，X370，B450，B350，A320\r\n    类别：发烧/超频\r\n    处理器(AMD)：锐龙 R7\r\n', null, '1999.00', '5155', '1552615660960', null);
INSERT INTO `shop` VALUES ('13', 'mall/shop6358b1d4a87710f9.jpg', 'tenlamp 十盏灯G1 声卡套装手机直播台式机电脑通用调音台快手全民k歌专用喊麦主播设备全套 声卡套装【手持麦】绅士黑 ', '\r\n    商品名称：tenlampG1\r\n    商品编号：37156604581\r\n    店铺： tenlamp旗舰店\r\n    商品毛重：500.00g\r\n    商品产地：中国大陆\r\n    货号：G1\r\n    用途：直播show，手机K歌，电脑K歌，专业录音，游戏语音，声卡套装\r\n    类型：电容麦\r\n    传输方式：有线\r\n    连接主体：智能手机，台式电脑，笔记本\r\n    指向特征：心型指向\r\n    扬声方式：耳机\r\n    伴奏输入：蓝牙，3.5mm有线\r\n    读取方式：OTG\r\n    供电方式：外接供电\r\n    使用方式：手持\r\n', null, '298.00', '3305', '1552615795671', null);
INSERT INTO `shop` VALUES ('14', 'mall/shop5b87674dN124ac474.jpg', 'E之音 V12+E1700 手机声卡套装 快手抖音直播喊麦录音k歌主播设备电脑外置声卡套装 ', '商品名称：E之音V12+E1700\r\n商品编号：8127376\r\n商品毛重：1.5kg\r\n商品产地：中国大陆\r\n连接主体：智能手机，台式电脑，笔记本\r\n扬声方式：耳机\r\n类型：电容麦\r\n伴奏输入：3.5mm有线\r\n传输方式：有线\r\n供电方式：内置电池\r\n用途：直播show，手机K歌，电脑', null, '279.00', '1102', '1552615909952', null);
INSERT INTO `shop` VALUES ('15', 'mall/shopb73f0b4d6c32a824.jpg', '华硕（ASUS）TUF B360M-PLUS GAMING S 游戏主板（Intel B360/LGA 1151） ', '\r\n    商品名称：华硕TUF B360M-PLUS GAMING S\r\n    商品编号：8074512\r\n    商品毛重：0.94kg\r\n    商品产地：中国大陆\r\n    应用场景：游戏优选\r\n    AMD芯片：其他\r\n    INTEL芯片：B360\r\n    板型：M-ATX（紧凑型）\r\n    适用CPU接口：INTEL1151\r\n    游戏特色：华硕TUF\r\n', null, '688.00', '8454', '1552616154447', null);
INSERT INTO `shop` VALUES ('16', 'mall/shopfb1e265673801ffd.jpg', '微星（MSI）B360M MORTAR迫击炮主板+英特尔（Intel）i5 9400F 酷睿六核 盒装CPU处理器 板U套装', '\r\n    商品名称：微星板U套装\r\n    商品编号：100003048790\r\n    商品毛重：1.8kg\r\n    商品产地：中国大陆\r\n    接口：INTEL1151（八代）\r\n    板型：M-ATX（紧凑型）\r\n    搭配主板：B360\r\n    处理器：酷睿i5\r\n', null, '1779.00', '5145', '1552616411135', null);
INSERT INTO `shop` VALUES ('17', 'mall/shop5b063343N1d84d0cf.jpg', '小米（MI）小米电视4C 32英寸 L32M5-AD 1GB+4GB 高清人工智能网络液晶平板电视 ', '\r\n    商品名称：小米L32M5-AD\r\n    商品编号：7680253\r\n    商品毛重：5.0kg\r\n    商品产地：中国大陆\r\n    观看距离：2m以下（≤32英寸）\r\n    分辨率：高清（1366×768）\r\n    电视类型：人工智能\r\n    能效等级：3级\r\n    屏幕尺寸：32英寸及以下\r\n    选购指数：6.9-6.0\r\n', null, '799.00', '54354', '1552616573348', null);
INSERT INTO `shop` VALUES ('18', 'mall/shop194d9e0ac892941f.jpg', '戴尔DELL游匣G315.6英寸英特尔酷睿i5游戏笔记本电脑(i5-8300H 8G 128G 1T GTX1050Ti 4G独显 IPS) ', '\r\n    商品名称：戴尔G3\r\n    商品编号：7341442\r\n    商品毛重：3.63kg\r\n    商品产地：中国大陆\r\n    系统：Windows 10\r\n    分辨率：全高清屏（1920×1080）\r\n    厚度：20.0mm—25.0mm\r\n    硬盘容量：128GB SSD+1TB HDD\r\n    显卡型号：GTX1050Ti\r\n    游戏性能：骨灰级\r\n    待机时长：9小时以上\r\n    处理器：Intel i5标准电压版\r\n    特性：其他\r\n    系列：戴尔-G系列\r\n    裸机重量：2-2.5kg\r\n    优选服务：两年质保\r\n    显存容量：4G\r\n    内存容量：8G\r\n    屏幕尺寸：15.6英寸\r\n', null, '8599.00', '5184', '1552616862545', null);
INSERT INTO `shop` VALUES ('19', 'mall/shop5b76bab9N13246041.jpg', '小米 8SE 全面屏智能游戏拍照手机 6GB+128GB 灰色 骁龙710处理器 全网通4G 双卡双待 ', '    商品名称：小米8SE\r\n    商品编号：8656283\r\n    商品毛重：415.00g\r\n    商品产地：中国大陆\r\n    系统：安卓（Android）\r\n    机身厚度：薄（7mm-8.5mm）\r\n    拍照特点：后置双摄像头\r\n      机身颜色：灰色系\r\n    热点：快速充电，人工智能\r\n    运行内存：6GB\r\n    前置摄像头像素：2000万及以上\r\n    多卡支持：双卡双待双4G\r\n    电池容量：3000mAh-3999mAh\r\n    后置摄像头像素：1200万-1999万\r\n    机身内存：128GB', null, '1699.00', '84854', '1552616939765', null);
INSERT INTO `shop` VALUES ('20', 'mall/shop5b7bc500N108a0d29.jpg', '飞利浦（PHILIPS）258B6QJEB 25英寸2K分辨率三边微边框AH-IPS屏 99.5%sRGB广色域护眼不闪屏显示器(送鼠标）', '商品名称：飞利浦258B6QJEB\r\n商品编号：8246639\r\n商品毛重：9.63kg\r\n商品产地：中国大陆\r\n面板：IPS（LGD面板）\r\n权威认证：节能认证，十环认证（环保）\r\n屏幕比例：16:9\r\n售后服务：3年上门，3年质保\r\n刷新率：60HZ\r\n特征：旋转升降底座，内置音箱，可壁挂\r\n尺寸：25英寸\r\n分辨率：2560×1440\r\n接口：DP，HDMI，DVI，VGA，US', null, '1699.00', '8541', '1552617030711', null);
INSERT INTO `shop` VALUES ('21', 'mall/shop5ad54394N4376947b.jpg', '戴尔（DELL） U2717D 27英寸四边微边框2K高分 旋转升降IPS屏 出厂色彩校准 99%sRGB 个人商务 电脑显示器 ', '商品名称：戴尔U2717D\r\n商品编号：2557168\r\n商品毛重：10.2kg\r\n商品产地：中国大陆\r\n面板：IPS技术\r\n权威认证：节能认证，十环认证（环保）\r\n屏幕比例：16:9\r\n售后服务：3年上门\r\n刷新率：60HZ\r\n特征：四边微边框，可壁挂\r\n尺寸：27英寸\r\n分辨率：2560×1440\r\n接口：DP，HDMI，USB扩展/充电', null, '2899.00', '8485', '1552617107623', null);
INSERT INTO `shop` VALUES ('22', 'mall/shop57ddfdd0N664c6861.jpg', '九州风神（DEEPCOOL） 玄冰400 CPU散热器（多平台/支持AM4/4热管/智能温控/发蓝光/12CM风扇/附带硅脂）', '商品名称：九州风神玄冰400\r\n商品编号：598827\r\n商品毛重：0.74kg\r\n商品产地：中国大陆\r\n热管数量：4热管\r\n背板类型：塑料背板\r\n产品类型：风冷散热器\r\n发光类型：单色光\r\n风冷底座：热管直触\r\n建议机箱：宽度大于180mm\r\n风冷鳍片：穿片工艺\r\n兼容接口：Intel LGA 1151，AMD', null, '99.99', '5415', '1552617929627', null);
INSERT INTO `shop` VALUES ('23', 'mall/shop346931546b5f83d8.jpg', '越来越酷（COOLCOLD）冰魔2S笔记本散热器 底座式电脑排风扇游戏本降温散热支架 黑红USB5V供电 ', '\r\n    商品名称：越来越酷冰魔2S\r\n    商品编号：100001781720\r\n    商品毛重：1.03kg\r\n    商品产地：中国大陆\r\n    产品类型：笔记本散热器\r\n    发光类型：单色光\r\n', null, '199.00', '7868', '1552618010212', null);

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
