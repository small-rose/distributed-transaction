/*
Navicat MySQL Data Transfer

Source Server         : LocalHost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : hmily_store

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-15 15:26:29
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
  `prod_price` double DEFAULT NULL,
  `total_stock` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `lock_stock` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
