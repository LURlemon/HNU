/*
 Navicat Premium Data Transfer

 Source Server         : mail
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 127.0.0.1:3306
 Source Schema         : mail

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 29/05/2020 02:18:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `Con_id` int(11) NOT NULL AUTO_INCREMENT,
  `Host_Account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Friend_Account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Con_id`) USING BTREE,
  UNIQUE INDEX `UUnique`(`Host_Account`, `Friend_Account`) USING BTREE,
  INDEX `FK_Relationship_4`(`Friend_Account`) USING BTREE,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`Host_Account`) REFERENCES `user` (`account`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`Friend_Account`) REFERENCES `user` (`account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (2, '1234@zzl.com', '2333@zzl.com');
INSERT INTO `contact` VALUES (3, '1234@zzl.com', '666@zzl.com');
INSERT INTO `contact` VALUES (7, '666@zzl.com', '1111@zzl.com');
INSERT INTO `contact` VALUES (6, '666@zzl.com', '1222@zzl.com');
INSERT INTO `contact` VALUES (4, '666@zzl.com', '1234@zzl.com');
INSERT INTO `contact` VALUES (5, '666@zzl.com', '2333@zzl.com');
INSERT INTO `contact` VALUES (9, '666@zzl.com', '3456@zzl.com');
INSERT INTO `contact` VALUES (8, '666@zzl.com', '4444@zzl.com');

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail`  (
  `Mail_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reciver_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mail_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Subject` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Mail_State` int(11) NOT NULL DEFAULT 1,
  `size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0',
  PRIMARY KEY (`Mail_id`) USING BTREE,
  INDEX `FK_Relationship_1`(`sender_address`) USING BTREE,
  INDEX `FK_Relationship_2`(`reciver_address`) USING BTREE,
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`sender_address`) REFERENCES `user` (`account`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`reciver_address`) REFERENCES `user` (`account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES (3, '1234@zzl.com', '2333@zzl.com', '2020-05-26 17:48:13', 'sdcsdcds', 'sdcsdcdscds', 1, '11');
INSERT INTO `mail` VALUES (4, '1234@zzl.com', '666@zzl.com', '2020-05-26 18:12:09', 'sdfsdfsdf', 'dcsdfsdf', 1, '8');
INSERT INTO `mail` VALUES (5, '1234@zzl.com', '666@zzl.com', '2020-05-26 18:13:55', 'ggggsfsdfsdf', 'gggggggg', 1, '8');
INSERT INTO `mail` VALUES (6, '1234@zzl.com', '2333@zzl.com', '2020-05-26 18:15:00', 'ggggsfsdfsdf', 'gggggggg', 1, '8');
INSERT INTO `mail` VALUES (7, '666@zzl.com', '1234@zzl.com', '2020-05-27 05:33:43', 'efwefefewf', 'wefewfef', 1, '8');
INSERT INTO `mail` VALUES (8, '666@zzl.com', '2333@zzl.com', '2020-05-27 05:33:43', 'efwefefewf', 'wefewfef', 1, '8');
INSERT INTO `mail` VALUES (9, '666@zzl.com', '1234@zzl.com', '2020-05-27 11:53:21', 'ni hao', 'wo Shi guanliyuan', 1, '18');
INSERT INTO `mail` VALUES (10, '666@zzl.com', '1222@zzl.com', '2020-05-27 16:29:35', 'hello', 'hellohellohello', 1, '15');
INSERT INTO `mail` VALUES (11, '666@zzl.com', '1222@zzl.com', '2020-05-27 16:31:18', 'sdfsdfdshdf', 'ksdfjksdjfkljsdkfjkdlsf', 1, '23');
INSERT INTO `mail` VALUES (12, '666@zzl.com', '1111@zzl.com', '2020-05-27 16:31:19', 'sdfsdfdshdf', 'ksdfjksdjfkljsdkfjkdlsf', 1, '23');
INSERT INTO `mail` VALUES (13, '666@zzl.com', '1111@zzl.com', '2020-05-27 16:44:49', 'werwer', 'werwerew', 1, '8');
INSERT INTO `mail` VALUES (14, '666@zzl.com', '1111@zzl.com', '2020-05-27 16:46:58', 'werwer', 'werwerew', 1, '8');
INSERT INTO `mail` VALUES (15, '666@zzl.com', '4444@zzl.com', '2020-05-28 20:56:33', 'hello', 'hello', 1, '5');
INSERT INTO `mail` VALUES (16, '666@zzl.com', '3456@zzl.com', '2020-05-28 20:57:09', 'hello', 'hello', 1, '5');
INSERT INTO `mail` VALUES (17, '666@zzl.com', '4444@zzl.com', '2020-05-28 20:57:09', 'hello', 'hello', 1, '5');
INSERT INTO `mail` VALUES (18, '666@zzl.com', '4444@zzl.com', '2020-05-29 02:00:22', 'fsdsdsdff', 'fsdfdsf', 1, '7');
INSERT INTO `mail` VALUES (19, '666@zzl.com', '4444@zzl.com', '2020-05-29 02:00:22', 'fsdsdsdff', 'fsdfdsf', 1, '7');
INSERT INTO `mail` VALUES (20, '666@zzl.com', '4444@zzl.com', '2020-05-29 02:00:51', 'fsdsdsdff', 'fsdfdsf', 1, '7');
INSERT INTO `mail` VALUES (21, '666@zzl.com', '3456@zzl.com', '2020-05-29 02:00:51', 'fsdsdsdff', 'fsdfdsf', 1, '7');

-- ----------------------------
-- Table structure for server
-- ----------------------------
DROP TABLE IF EXISTS `server`;
CREATE TABLE `server`  (
  `smtp_state` int(1) NOT NULL,
  `smtp_port` int(4) NOT NULL,
  `pop3_state` int(1) NOT NULL,
  `pop3_port` int(4) NOT NULL,
  `smtp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of server
-- ----------------------------
INSERT INTO `server` VALUES (1, 25, 1, 1233, 'smtp');
INSERT INTO `server` VALUES (1, 25, 1, 1233, 'pops');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `nickName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserState` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`Account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1111', 'ld201516', '1111@zzl.com', 0);
INSERT INTO `user` VALUES ('1222', 'ld123456', '1222@zzl.com', 1);
INSERT INTO `user` VALUES ('1234', 'ld201516', '1234@zzl.com', 1);
INSERT INTO `user` VALUES ('2333', 'ld201516', '2333@zzl.com', 1);
INSERT INTO `user` VALUES ('3456', 'ld123456', '3456@zzl.com', 0);
INSERT INTO `user` VALUES ('4444', 'ld123456', '4321@zzl.com', 0);
INSERT INTO `user` VALUES ('4444', 'ld123456', '4444@zzl.com', 0);
INSERT INTO `user` VALUES ('666', 'ld201516', '666@zzl.com', 2);

-- ----------------------------
-- View structure for v_mail
-- ----------------------------
DROP VIEW IF EXISTS `v_mail`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `v_mail` AS select `mail`.`Mail_id` AS `Mail_id`,`mail`.`sender_address` AS `sender_address`,`mail`.`reciver_address` AS `reciver_address`,`mail`.`mail_date` AS `mail_date`,`mail`.`Subject` AS `Subject`,`mail`.`Content` AS `Content`,`mail`.`Mail_State` AS `Mail_State`,`reciver`.`nickName` AS `reciver_name`,`sender`.`nickName` AS `sender_name`,`mail`.`size` AS `size` from ((`mail` join `user` `reciver` on((`mail`.`reciver_address` = `reciver`.`Account`))) join `user` `sender` on((`mail`.`sender_address` = `sender`.`Account`)));

SET FOREIGN_KEY_CHECKS = 1;
