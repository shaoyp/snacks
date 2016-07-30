/*
 Navicat Premium Data Transfer

 Source Server         : memberbag
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost
 Source Database       : snack

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : utf-8

 Date: 07/30/2016 08:11:49 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `baiduwaimai`
-- ----------------------------
DROP TABLE IF EXISTS `baiduwaimai`;
CREATE TABLE `baiduwaimai` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '店名',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '网址',
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `evaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '评分',
  `sales` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '成交量',
  `get_time` datetime DEFAULT NULL COMMENT '获取时间',
  `caipin` longtext COLLATE utf8_bin COMMENT '菜品',
  `areaid` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '行政区划码',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='百度外卖';

-- ----------------------------
--  Table structure for `caipin`
-- ----------------------------
DROP TABLE IF EXISTS `caipin`;
CREATE TABLE `caipin` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `caipinming` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `fandianid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `sales` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `prince` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `code_area`
-- ----------------------------
DROP TABLE IF EXISTS `code_area`;
CREATE TABLE `code_area` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编码',
  `area_name` varchar(90) COLLATE utf8_bin DEFAULT NULL COMMENT '地区名称',
  `order_id` varchar(3) COLLATE utf8_bin DEFAULT NULL COMMENT '排序',
  `is_enable` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '启用标志',
  `area_abba` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '名称缩写',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地区代码表';

-- ----------------------------
--  Table structure for `code_caipin`
-- ----------------------------
DROP TABLE IF EXISTS `code_caipin`;
CREATE TABLE `code_caipin` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `type_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `order_id` varchar(4) COLLATE utf8_bin DEFAULT NULL,
  `is_enable` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `pinyin` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `companys`
-- ----------------------------
DROP TABLE IF EXISTS `companys`;
CREATE TABLE `companys` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `business_scope` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `province` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='公司表';

-- ----------------------------
--  Table structure for `elemewaimai`
-- ----------------------------
DROP TABLE IF EXISTS `elemewaimai`;
CREATE TABLE `elemewaimai` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '店名',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '网址',
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `evaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '评分',
  `sales` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '成交量',
  `get_time` datetime DEFAULT NULL COMMENT '获取时间',
  `caipin` longtext COLLATE utf8_bin COMMENT '菜品',
  `areaid` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '行政区划码',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饿了么外卖';

-- ----------------------------
--  Table structure for `fandian`
-- ----------------------------
DROP TABLE IF EXISTS `fandian`;
CREATE TABLE `fandian` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '店名',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '网址',
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `meituanvaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  `elemevaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  `baiduevaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '评分',
  `lastmonthsales` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `totlesales` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '成交量',
  `province` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '省',
  `city` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '市',
  `lng` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '经度',
  `lat` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '纬度',
  `state` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `baidu` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `eleme` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `meituan` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `newre` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `eachmonthsales` varchar(3000) COLLATE utf8_bin DEFAULT NULL,
  `diqu` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `areaid` char(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饭店';

-- ----------------------------
--  Table structure for `fandian_user`
-- ----------------------------
DROP TABLE IF EXISTS `fandian_user`;
CREATE TABLE `fandian_user` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `fandian_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `recall_date` date DEFAULT NULL,
  `beizhu` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `last_date` date DEFAULT NULL,
  `wechat` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `fandiandata`
-- ----------------------------
DROP TABLE IF EXISTS `fandiandata`;
CREATE TABLE `fandiandata` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '店名',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '网址',
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `meituanvaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '美团评分',
  `elemevaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '饿了么评分',
  `baiduevaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '百度评分',
  `sales` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '成交量',
  `get_time` datetime DEFAULT NULL COMMENT '获取时间',
  `province` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '省',
  `city` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '市',
  `lng` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '经度',
  `lat` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '纬度',
  `baidu` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `meituan` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `eleme` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `baidusales` int(11) DEFAULT NULL,
  `meituansales` int(11) DEFAULT NULL,
  `elemesales` int(11) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饭店';

-- ----------------------------
--  Table structure for `meituanwaimai`
-- ----------------------------
DROP TABLE IF EXISTS `meituanwaimai`;
CREATE TABLE `meituanwaimai` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '店名',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '网址',
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `evaluate` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '评分',
  `sales` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '成交量',
  `get_time` datetime DEFAULT NULL COMMENT '获取时间',
  `caipin` longtext COLLATE utf8_bin COMMENT '菜品',
  `areaid` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '行政区划码',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='美团外卖';

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `resource_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `level` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
--  Table structure for `user_area`
-- ----------------------------
DROP TABLE IF EXISTS `user_area`;
CREATE TABLE `user_area` (
  `resource_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `area_id` varchar(32) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
