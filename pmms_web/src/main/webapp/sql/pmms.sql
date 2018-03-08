/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pmms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-18 13:55:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1', '2017-10-11 10:48:41', '2017-10-12 10:48:45', '信息工程学院');

-- ----------------------------
-- Table structure for academy_profession
-- ----------------------------
DROP TABLE IF EXISTS `academy_profession`;
CREATE TABLE `academy_profession` (
  `academy_id` varchar(32) NOT NULL,
  `profession_id` varchar(32) NOT NULL,
  PRIMARY KEY (`academy_id`,`profession_id`),
  UNIQUE KEY `UK_bc0g9gc6x5jtptktbpurdxyxx` (`profession_id`),
  CONSTRAINT `FK_2ylxiqh110j1e30nbwgf2ycnp` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`),
  CONSTRAINT `FK_bc0g9gc6x5jtptktbpurdxyxx` FOREIGN KEY (`profession_id`) REFERENCES `profession` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy_profession
-- ----------------------------
INSERT INTO `academy_profession` VALUES ('1', '1');

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `is_top` int(11) DEFAULT '0',
  `title` varchar(255) DEFAULT NULL,
  `publisher` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5r5271rr0olmtmbjdoavpsa4s` (`publisher`),
  CONSTRAINT `FK_5r5271rr0olmtmbjdoavpsa4s` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('2', '2017-10-26 19:32:25', '2017-10-26 19:32:29', '22', '0', '2', '6');

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `audit_date` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `score` double DEFAULT '0',
  `teacher_id` tinyblob,
  `publisher_id` varchar(32) DEFAULT NULL,
  `desccription` text,
  `type` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_nkcc53myjubufalujk1uc7cfi` (`publisher_id`),
  CONSTRAINT `FK_nkcc53myjubufalujk1uc7cfi` FOREIGN KEY (`publisher_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('8a84935f5f2df164015f2df449cf0000', '2017-10-18 13:28:24', null, null, '指导书_实验一.pdf', null, 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\pmms\\uploads\\attach\\指导书_实验一.pdf', null, null, '7', null, null);
INSERT INTO `document` VALUES ('8a86d0575f2037d7015f2037f4fd0000', '2017-10-15 21:27:38', null, null, '20170920195800_88725.doc', null, 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\pmms\\uploads\\attach\\20170920195800_88725.doc', null, null, '6', null, '0');
INSERT INTO `document` VALUES ('8a86d0575f205069015f2050bdd10000', '2017-10-15 21:54:43', null, null, '20170920195800_88725.doc', null, 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\pmms\\uploads\\attach\\20170920195800_88725.doc', null, null, '7', null, '0');
INSERT INTO `document` VALUES ('8a86d0575f205069015f2050ef620001', '2017-10-15 21:54:55', null, null, '20170920195800_88725.doc', null, 'C:\\Users\\Administrator\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\pmms\\uploads\\attach\\20170920195800_88725.doc', null, null, '7', null, '0');

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `p_name` varchar(255) DEFAULT NULL,
  `academy_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2uhb59vjq4idey8bg5iys08jd` (`academy_id`),
  CONSTRAINT `FK_2uhb59vjq4idey8bg5iys08jd` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('1', '2017-09-27 14:00:21', '2017-10-14 14:00:25', '计算机科学与技术', '1');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `url` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '2017-10-04 17:52:48', '2017-10-03 17:52:55', 'delete', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '2017-10-04 10:49:45', '2017-11-30 10:49:48', 'admin');
INSERT INTO `role` VALUES ('2', '2017-10-12 22:07:26', '2017-10-18 22:07:29', 'PartMember');
INSERT INTO `role` VALUES ('3', '2017-10-12 22:07:26', '2017-10-18 22:07:29', 'ProPartyMember');
INSERT INTO `role` VALUES ('5', '2017-10-12 22:07:26', '2017-10-18 22:07:29', 'Member');

-- ----------------------------
-- Table structure for role_resources
-- ----------------------------
DROP TABLE IF EXISTS `role_resources`;
CREATE TABLE `role_resources` (
  `role_id` varchar(32) NOT NULL,
  `resource_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`),
  KEY `FK_euxmvqfhmkgak0ytevriks43t` (`resource_id`),
  CONSTRAINT `FK_euxmvqfhmkgak0ytevriks43t` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`),
  CONSTRAINT `FK_khf0hg2sihl30h463aaeusqdo` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resources
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `clazz` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `is_admin` int(11) DEFAULT '0',
  `password` varchar(16) NOT NULL DEFAULT '1234560',
  `phone` varchar(11) DEFAULT NULL,
  `sno` varchar(255) NOT NULL,
  `status` int(11) DEFAULT '0',
  `username` varchar(20) NOT NULL,
  `academy_id` varchar(32) NOT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5957djqkfmdpg47t1pf23r1u6` (`academy_id`),
  CONSTRAINT `FK_5957djqkfmdpg47t1pf23r1u6` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', '2017-10-05 16:39:53', '2017-10-11 16:39:57', '2017-10-10 16:40:00', '计算机201506', '1324', '女', '778', '0', '1234560', '123456', '20158866', '1', '蒋慧', '1', null);
INSERT INTO `user` VALUES ('6', '2017-10-05 16:39:53', '2017-10-11 16:39:57', '2017-10-10 16:40:00', '计算机201506', '1324', '女', '778', '0', '1234560', '123456', '20158866', '1', '蒋慧', '1', null);
INSERT INTO `user` VALUES ('7', '2017-10-05 16:39:53', '2017-10-11 16:39:57', '2017-10-10 16:40:00', '计算机201506', '1324', '女', '778', '0', '1234560', '123456', '20158866', '1', '蒋慧', '1', null);
INSERT INTO `user` VALUES ('8', '2017-10-05 16:39:53', '2017-10-11 16:39:57', '2017-10-10 16:40:00', '计算机201506', '1324', '女', '778', '0', '1234560', '123456', '20158866', '1', '蒋慧', '1', null);
INSERT INTO `user` VALUES ('9', '2017-10-05 16:39:53', '2017-10-11 16:39:57', '2017-10-10 16:40:00', '计算机201506', '1324', '女', '778', '0', '1234560', '123456', '20158866', '1', '蒋慧', '1', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('6', '5');
