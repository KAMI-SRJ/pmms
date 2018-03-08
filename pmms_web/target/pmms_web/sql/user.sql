/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pmms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-15 14:06:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `password` varchar(32) NOT NULL DEFAULT 'D8E423A9D5EB97DA9E2D58CD57B92808',
  `sno` varchar(9) NOT NULL,
  `status` int(1) DEFAULT '0',
  `username` varchar(20) NOT NULL,
  `academy_id` varchar(32) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `icon` varchar(255) DEFAULT '',
  `is_admin` int(1) DEFAULT '0',
  `phone` varchar(11) DEFAULT NULL,
  `clazz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5957djqkfmdpg47t1pf23r1u6` (`academy_id`),
  CONSTRAINT `FK_5957djqkfmdpg47t1pf23r1u6` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158866', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('10', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158898', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('11', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158876', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('12', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158877', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('2', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158867', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('3', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '201588668', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('4', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '201588669', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('5', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158861', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('6', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158862', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('7', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158899', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('8', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158874', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
INSERT INTO `user` VALUES ('9', '2017-10-25 10:48:03', '2017-10-26 10:48:07', '2017-10-03 10:48:12', '女', 'D8E423A9D5EB97DA9E2D58CD57B92808', '20158875', '1', '蒋慧', '1', '1', '1', '0', '15520253763', '计算机201506');
