/*
Navicat MySQL Data Transfer

Source Server         : LocalHost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : hmily_order

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-15 15:25:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `numbers` int(11) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4;
