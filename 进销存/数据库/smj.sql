/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.60 : Database - laimiqi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

#数据库2
CREATE DATABASE /*!32312 IF NOT EXISTS*/`laimiqi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `laimiqi`;

/*Table structure for table `bit` */

DROP TABLE IF EXISTS `bit`;

CREATE TABLE `bit` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `bit` */

/*Table structure for table `commodity` */

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `commodity` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `img` BLOB,
  `telephonename` VARCHAR(20) DEFAULT NULL,
  `telephone` VARCHAR(20) DEFAULT NULL,
  `pname` VARCHAR(20) DEFAULT NULL,
  `cname` VARCHAR(20) DEFAULT NULL,
  `aname` VARCHAR(20) DEFAULT NULL,
  `address` VARCHAR(50) DEFAULT NULL,
  `balance` DOUBLE DEFAULT NULL,
  `initbalance` DOUBLE DEFAULT NULL,
  `score` INT(4) DEFAULT NULL,
  `cid` VARCHAR(20) DEFAULT NULL,
  `lid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

/*Table structure for table `customerlevel` */

SELECT * FROM customer

SELECT * FROM store WHERE state=0

DROP TABLE IF EXISTS `customerlevel`;
#客户级别
CREATE TABLE `customerlevel` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `agio` DOUBLE DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `customerlevel` */

/*Table structure for table `customerrecharge` */

SELECT * FROM customerlevel WHERE state=0

UPDATE customerlevel SET `name`='',`agio`=,`updatetime`= WHERE id=


UPDATE `customerlevel` SET state = 0 WHERE id = '2'

DROP TABLE IF EXISTS `customerrecharge`;

CREATE TABLE `customerrecharge` (
  `id` VARCHAR(20) NOT NULL,
  `rechargetime` DATETIME DEFAULT NULL,
  `money` DOUBLE DEFAULT NULL,
  `cid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `customerrecharge` */

/*Table structure for table `customertype` */

DROP TABLE IF EXISTS `customertype`;

CREATE TABLE `customertype` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `viewname` VARCHAR(20) DEFAULT NULL,
  `agio` DOUBLE DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `defaulttype` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `customertype` */

/*Table structure for table `goods` */

SELECT * FROM customertype

SELECT * FROM customertype c,`user` u
WHERE c.state=0 AND c.uid=u.id
AND (c.`name` LIKE '%霖%' OR c.viewname LIKE '%霖%' OR c.agio LIKE '%0%' OR u.name LIKE '%霖%')

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `img` BLOB,
  `tid` VARCHAR(20) DEFAULT NULL,
  `code` VARCHAR(20) DEFAULT NULL,
  `prevbit` VARCHAR(20) DEFAULT NULL,
  `sufbit` VARCHAR(20) DEFAULT NULL,
  `bitval` VARCHAR(20) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `jprice` DOUBLE DEFAULT NULL,
  `remark` VARCHAR(50) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  `minsecurity` int(4) DEFAULT NULL,
  `maxsecurity` int(4) DEFAULT NULL,
  `historygid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `detail` varchar(50) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `enname` varchar(50) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
=======
=======
>>>>>>> refs/heads/lxy
  `minsecurity` INT(4) DEFAULT NULL,
  `maxsecurity` INT(4) DEFAULT NULL,
  `historygid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `detail` VARCHAR(50) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `enname` VARCHAR(50) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
<<<<<<< HEAD
>>>>>>> refs/heads/master
=======
  `minsecurity` INT(4) DEFAULT NULL,
  `maxsecurity` INT(4) DEFAULT NULL,
  `historygid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `detail` VARCHAR(5000) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `enname` VARCHAR(50) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
>>>>>>> refs/remotes/origin/dws
=======
  `minsecurity` INT(4) DEFAULT NULL,
  `maxsecurity` INT(4) DEFAULT NULL,
  `historygid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `detail` VARCHAR(5000) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `enname` VARCHAR(50) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
>>>>>>> refs/heads/dws
=======
>>>>>>> refs/heads/lxy
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

/*Table structure for table `goodsprice` */

DROP TABLE IF EXISTS `goodsprice`;

CREATE TABLE `goodsprice` (
  `id` VARCHAR(4) NOT NULL,
  `ctid` VARCHAR(20) DEFAULT NULL,
  `sufname` VARCHAR(20) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `gvid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `preferential` DOUBLE DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `goodsprice` */

/*Table structure for table `goodsstandardvalue` */

DROP TABLE IF EXISTS `goodsstandardvalue`;

CREATE TABLE `goodsstandardvalue` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `svids` VARCHAR(20) DEFAULT NULL,
  `vid` VARCHAR(20) DEFAULT NULL,
  `svid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `enname` VARCHAR(50) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `goodsstandardvalue` */

/*Table structure for table `goodstype` */

DROP TABLE IF EXISTS `goodstype`;

CREATE TABLE `goodstype` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `pid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `goodstype` */

/*Table structure for table `goodsvalue` */

DROP TABLE IF EXISTS `goodsvalue`;

CREATE TABLE `goodsvalue` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `gid` VARCHAR(20) DEFAULT NULL,
  `jprice` DOUBLE DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `defaultvalue` INT(4) DEFAULT NULL,
  `enname` VARCHAR(50) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `goodsvalue` */

/*Table structure for table `img` */

DROP TABLE IF EXISTS `img`;

CREATE TABLE `img` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) DEFAULT NULL,
  `oldname` VARCHAR(50) DEFAULT NULL,
  `url` VARCHAR(100) DEFAULT NULL,
  `gid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `img` */

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `enname` VARCHAR(20) DEFAULT NULL,
  `catalog` INT(4) DEFAULT NULL,
  `url` VARCHAR(50) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `parentid` INT(4) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `module` */

/*Table structure for table `paytype` */

DROP TABLE IF EXISTS `paytype`;

CREATE TABLE `paytype` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `paytype` */

/*Table structure for table `quotedprice` */

DROP TABLE IF EXISTS `quotedprice`;

CREATE TABLE `quotedprice` (
  `id` VARCHAR(20) NOT NULL,
  `svid` VARCHAR(20) DEFAULT NULL,
  `cid` VARCHAR(20) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `quotedprice` */

/*Table structure for table `remittance` */

DROP TABLE IF EXISTS `remittance`;

CREATE TABLE `remittance` (
  `id` VARCHAR(20) NOT NULL,
  `money` DOUBLE DEFAULT NULL,
  `sid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `remittance` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*Table structure for table `rolemodule` */

DROP TABLE IF EXISTS `rolemodule`;

CREATE TABLE `rolemodule` (
  `id` VARCHAR(20) NOT NULL,
  `mid` VARCHAR(20) DEFAULT NULL,
  `rid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `rolemodule` */

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` VARCHAR(20) NOT NULL,
  `code` VARCHAR(50) DEFAULT NULL,
  `soid` VARCHAR(20) DEFAULT NULL,
  `cid` VARCHAR(20) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `paytype` VARCHAR(20) DEFAULT NULL,
  `remark` VARCHAR(50) DEFAULT NULL,
  `count` INT(4) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `paymoney` DOUBLE DEFAULT NULL,
  `tainmoney` DOUBLE DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sales` */

/*Table structure for table `salesback` */

DROP TABLE IF EXISTS `salesback`;

CREATE TABLE `salesback` (
  `id` VARCHAR(20) NOT NULL,
  `code` VARCHAR(50) DEFAULT NULL,
  `ssid` VARCHAR(20) DEFAULT NULL,
  `cid` VARCHAR(20) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `paytype` VARCHAR(20) DEFAULT NULL,
  `remark` VARCHAR(20) DEFAULT NULL,
  `count` INT(4) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `paymoney` DOUBLE DEFAULT NULL,
  `tainmoney` DOUBLE DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `salesback` */

/*Table structure for table `salesbackdetails` */

DROP TABLE IF EXISTS `salesbackdetails`;

CREATE TABLE `salesbackdetails` (
  `id` VARCHAR(20) NOT NULL,
  `sid` VARCHAR(20) DEFAULT NULL,
  `gvid` VARCHAR(20) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `oldprice` DOUBLE DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `count` INT(4) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `updatime` DATETIME DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `salesbackdetails` */

/*Table structure for table `salesdetails` */

DROP TABLE IF EXISTS `salesdetails`;

CREATE TABLE `salesdetails` (
  `id` VARCHAR(20) NOT NULL,
  `sid` VARCHAR(20) DEFAULT NULL,
  `gvid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `oldprice` DOUBLE DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `count` INT(4) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `salesdetails` */

/*Table structure for table `salesorder` */

DROP TABLE IF EXISTS `salesorder`;

CREATE TABLE `salesorder` (
  `id` VARCHAR(20) NOT NULL,
  `code` VARCHAR(50) DEFAULT NULL,
  `cid` VARCHAR(20) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `paytype` VARCHAR(20) DEFAULT NULL,
  `remark` VARCHAR(20) DEFAULT NULL,
  `count` INT(4) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `Preprice` DOUBLE DEFAULT NULL,
  `paymoney` DOUBLE DEFAULT NULL,
  `tainmoney` DOUBLE DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `progress` INT(4) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `salesorder` */

/*Table structure for table `salesorderdetails` */

DROP TABLE IF EXISTS `salesorderdetails`;

CREATE TABLE `salesorderdetails` (
  `id` VARCHAR(20) NOT NULL,
  `sid` VARCHAR(20) DEFAULT NULL,
  `gvid` VARCHAR(20) DEFAULT NULL,
  `oldprice` DOUBLE DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `count` INT(4) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `salesorderdetails` */

/*Table structure for table `salesstockrecord` */

DROP TABLE IF EXISTS `salesstockrecord`;

CREATE TABLE `salesstockrecord` (
  `Id` VARCHAR(20) NOT NULL,
  `gvid` VARCHAR(20) DEFAULT NULL,
  `salesdetailid` VARCHAR(20) DEFAULT NULL,
  `stockdetailid` VARCHAR(20) DEFAULT NULL,
  `count` INT(4) DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `salesstockrecord` */

/*Table structure for table `standard` */

DROP TABLE IF EXISTS `standard`;

CREATE TABLE `standard` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `tid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `standard` */

/*Table structure for table `standardvalue` */

DROP TABLE IF EXISTS `standardvalue`;

CREATE TABLE `standardvalue` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `sid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `standardvalue` */

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` VARCHAR(20) NOT NULL,
  `cid` VARCHAR(20) DEFAULT NULL,
  `code` VARCHAR(50) DEFAULT NULL,
  `sid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

/*Table structure for table `stockdetails` */

DROP TABLE IF EXISTS `stockdetails`;

CREATE TABLE `stockdetails` (
  `id` VARCHAR(20) NOT NULL,
  `code` VARCHAR(50) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `storeid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `stockdetails` */

/*Table structure for table `stockrecord` */

DROP TABLE IF EXISTS `stockrecord`;

CREATE TABLE `stockrecord` (
  `id` VARCHAR(20) NOT NULL,
  `aftersdid` VARCHAR(20) DEFAULT NULL,
  `beforesdid` VARCHAR(20) DEFAULT NULL,
  `aftersid` VARCHAR(50) DEFAULT NULL,
  `beforesid` VARCHAR(50) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `stockrecord` */

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `sufname` VARCHAR(30) DEFAULT NULL,
  `province` VARCHAR(20) DEFAULT NULL,
  `city` VARCHAR(20) DEFAULT NULL,
  `district` VARCHAR(20) DEFAULT NULL,
  `address` VARCHAR(50) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `parented` INT(4) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `store` */

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `sid` VARCHAR(20) DEFAULT NULL,
  `phone` VARCHAR(20) DEFAULT NULL,
  `province` VARCHAR(20) DEFAULT NULL,
  `city` VARCHAR(20) DEFAULT NULL,
  `district` VARCHAR(20) DEFAULT NULL,
  `addres` VARCHAR(50) DEFAULT NULL,
  `balance` DOUBLE DEFAULT NULL,
  `remark` VARCHAR(50) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

SELECT * FROM supplier

SELECT s.* FROM supplier s,`user` u WHERE u.id=s.uid AND s.balance>=0 AND CONCAT(s.name,u.name) LIKE '%%'


/*Table structure for table `ulrgoods` */

DROP TABLE IF EXISTS `ulrgoods`;

CREATE TABLE `ulrgoods` (
  `id` VARCHAR(20) NOT NULL,
  `gid` VARCHAR(20) DEFAULT NULL,
  `utid` VARCHAR(20) DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `defaulttype` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `ulrgoods` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) DEFAULT NULL,
  `pwd` VARCHAR(20) DEFAULT NULL,
  `storeid` INT(4) DEFAULT NULL,
  `rid` INT(4) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `updatetime` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

SELECT * FROM `user`

/*Table structure for table `usercorrelation` */

DROP TABLE IF EXISTS `usercorrelation`;

CREATE TABLE `usercorrelation` (
  `id` VARCHAR(20) NOT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `utid` VARCHAR(20) DEFAULT NULL,
  `uids` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `usercorrelation` */

/*Table structure for table `usertags` */

DROP TABLE IF EXISTS `usertags`;

CREATE TABLE `usertags` (
  `id` VARCHAR(20) NOT NULL,
  `gid` VARCHAR(20) DEFAULT NULL,
  `gtid` VARCHAR(20) DEFAULT NULL,
  `season` INT(4) DEFAULT NULL,
  `uid` VARCHAR(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL,
  `state` INT(4) DEFAULT NULL,
  `column1` VARCHAR(50) DEFAULT NULL,
  `column2` VARCHAR(50) DEFAULT NULL,
  `column3` VARCHAR(50) DEFAULT NULL,
  `column4` VARCHAR(50) DEFAULT NULL,
  `column5` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `usertags` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
