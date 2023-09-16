/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100125 (10.1.25-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : api1

 Target Server Type    : MySQL
 Target Server Version : 100125 (10.1.25-MariaDB)
 File Encoding         : 65001

 Date: 15/09/2023 08:43:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Luo Zhennan');
INSERT INTO `user` VALUES (2, 'Judy Silva');
INSERT INTO `user` VALUES (3, 'Tan Yuning');
INSERT INTO `user` VALUES (4, 'Wong Wing Sze');
INSERT INTO `user` VALUES (5, 'Ethel Butler');
INSERT INTO `user` VALUES (6, 'Daniel Rodriguez');
INSERT INTO `user` VALUES (7, 'Imai Yota');
INSERT INTO `user` VALUES (8, 'Saito Yuna');
INSERT INTO `user` VALUES (9, 'Tanaka Ayato');
INSERT INTO `user` VALUES (10, 'Fan Xiuying');

SET FOREIGN_KEY_CHECKS = 1;
