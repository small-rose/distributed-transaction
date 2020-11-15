/*
Navicat MySQL Data Transfer

Source Server         : LocalHost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : hmily_account

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-15 15:25:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ams_account
-- ----------------------------
DROP TABLE IF EXISTS `ams_account`;
CREATE TABLE `ams_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `balance` decimal(15,2) DEFAULT NULL,
  `freeze_amount` decimal(15,2) DEFAULT '0.00',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ams_account
-- ----------------------------
INSERT INTO `ams_account` VALUES ('1', '202001', 'xiaocai', '2020011020201112', '10000.00', '0.00', '2020-11-15 12:19:30');
