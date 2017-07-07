/*
Navicat MySQL Data Transfer

Source Server         : jiajingong
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_tour

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-07-07 10:55:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tourinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tourinfo`;
CREATE TABLE `tourinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `musicName` varchar(45) DEFAULT NULL,
  `musicUrl` varchar(255) DEFAULT NULL,
  `photoName` varchar(45) DEFAULT NULL,
  `photoUrl` varchar(255) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `sign` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tourinfo
-- ----------------------------
INSERT INTO `tourinfo` VALUES ('1', '贾金公', '44444444444444', 'Sugar.mp3', 'http://127.0.0.1:8080/Tour/upload/Sugar.mp3', '5.jpg', 'http://127.0.0.1:8080/Tour/upload/5.jpg', '2017-6', '1499324669437');
INSERT INTO `tourinfo` VALUES ('2', '贾金公', '1111111111111111111', 'HeartbeatSong.mp3', 'http://127.0.0.1:8080/Tour/upload/HeartbeatSong.mp3', '6.jpg', 'http://127.0.0.1:8080/Tour/upload/6.jpg', '2017-6', '1499325434008');
INSERT INTO `tourinfo` VALUES ('3', '贾金公', '凄凄切切群群', 'HeartbeatSong.mp3', 'http://127.0.0.1:8080/Tour/upload/HeartbeatSong.mp3', '7.jpg', 'http://127.0.0.1:8080/Tour/upload/7.jpg', '2017-6', '1499326435380');
INSERT INTO `tourinfo` VALUES ('4', '贾金公', 'ddddddddddddddddd', null, null, '7.jpg', 'http://127.0.0.1:8080/Tour/upload/7.jpg', '2017-6', '1499331928810');
INSERT INTO `tourinfo` VALUES ('5', '贾金公', 'ddddddddddddddddd', null, null, '7.jpg', 'http://127.0.0.1:8080/Tour/upload/7.jpg', '2017-6', '1499331937140');
INSERT INTO `tourinfo` VALUES ('6', '贾金公', 'eeeeeeeeeeeeeeeeeee ', null, null, '7.jpg', 'http://127.0.0.1:8080/Tour/upload/7.jpg', '2017-6', '1499332002000');
INSERT INTO `tourinfo` VALUES ('7', '贾金公', 'www', null, null, '7.jpg', 'http://127.0.0.1:8080/Tour/upload/7.jpg', '2017-6', '1499332152849');
INSERT INTO `tourinfo` VALUES ('8', '贾金公', 'ffffffffff', null, null, '7.jpg', 'http://127.0.0.1:8080/Tour/upload/7.jpg', '2017-6', '1499332191102');
INSERT INTO `tourinfo` VALUES ('9', '贾金公', '呃呃呃', 'Sugar.mp3', 'http://127.0.0.1:8080/Tour/upload/Sugar.mp3', '7.jpg', 'http://127.0.0.1:8080/Tour/upload/7.jpg', '2017-7', '1499387462715');
INSERT INTO `tourinfo` VALUES ('10', '贾金公', '22222', 'WhatDoYouMean.mp3', 'http://127.0.0.1:8080/Tour/upload/WhatDoYouMean.mp3', null, null, '2017-7', '1499387779064');
INSERT INTO `tourinfo` VALUES ('12', '贾金公', '水水水水', null, null, '6.jpg', 'http://127.0.0.1:8080/Tour/upload/6.jpg', '2017-7', '1499389917380');
