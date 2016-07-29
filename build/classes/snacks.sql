-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.40 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 snacks 的数据库结构
CREATE DATABASE IF NOT EXISTS `snacks` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `snacks`;


-- 导出  表 snacks.demo 结构
CREATE TABLE IF NOT EXISTS `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` int(11) NOT NULL DEFAULT '0',
  `content` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  snacks.demo 的数据：0 rows
/*!40000 ALTER TABLE `demo` DISABLE KEYS */;
/*!40000 ALTER TABLE `demo` ENABLE KEYS */;


-- 导出  表 snacks.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `createime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `level` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  snacks.user 的数据：0 rows
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
