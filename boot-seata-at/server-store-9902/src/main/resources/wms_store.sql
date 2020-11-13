/*
Navicat MySQL Data Transfer

Source Server         : LocalHost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : server_store

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-09 21:59:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wms_store
-- ----------------------------
DROP TABLE IF EXISTS `wms_store`;
CREATE TABLE `wms_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` int(11) DEFAULT NULL,
  `prod_name` varchar(15) DEFAULT NULL,
  `store` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of wms_store
-- ----------------------------
INSERT INTO `wms_store` VALUES ('1', '1001', '小米手机', '1000');
INSERT INTO `wms_store` VALUES ('2', '1002', 'ThinkPad笔记本', '2000');
