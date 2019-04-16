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

DROP TABLE IF EXISTS `customerlevel`;

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
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

/*Table structure for table `goodsprice` */

DROP TABLE IF EXISTS `goodsprice`;

CREATE TABLE `goodsprice` (
  `id` varchar(4) NOT NULL,
  `ctid` varchar(20) DEFAULT NULL,
  `sufname` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `gvid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `preferential` double DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsprice` */

/*Table structure for table `goodsstandardvalue` */

DROP TABLE IF EXISTS `goodsstandardvalue`;

CREATE TABLE `goodsstandardvalue` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `svids` varchar(20) DEFAULT NULL,
  `vid` varchar(20) DEFAULT NULL,
  `svid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `enname` varchar(50) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsstandardvalue` */

/*Table structure for table `goodstype` */

DROP TABLE IF EXISTS `goodstype`;

CREATE TABLE `goodstype` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodstype` */

/*Table structure for table `goodsvalue` */

DROP TABLE IF EXISTS `goodsvalue`;

CREATE TABLE `goodsvalue` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gid` varchar(20) DEFAULT NULL,
  `jprice` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `defaultvalue` int(4) DEFAULT NULL,
  `enname` varchar(50) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsvalue` */

/*Table structure for table `img` */

DROP TABLE IF EXISTS `img`;

CREATE TABLE `img` (
  `id` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `oldname` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `gid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `img` */

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `enname` varchar(20) DEFAULT NULL,
  `catalog` int(4) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `parentid` int(4) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `module` */

/*Table structure for table `paytype` */

DROP TABLE IF EXISTS `paytype`;

CREATE TABLE `paytype` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `paytype` */

/*Table structure for table `quotedprice` */

DROP TABLE IF EXISTS `quotedprice`;

CREATE TABLE `quotedprice` (
  `id` varchar(20) NOT NULL,
  `svid` varchar(20) DEFAULT NULL,
  `cid` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `quotedprice` */

/*Table structure for table `remittance` */

DROP TABLE IF EXISTS `remittance`;

CREATE TABLE `remittance` (
  `id` varchar(20) NOT NULL,
  `money` double DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `remittance` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*Table structure for table `rolemodule` */

DROP TABLE IF EXISTS `rolemodule`;

CREATE TABLE `rolemodule` (
  `id` varchar(20) NOT NULL,
  `mid` varchar(20) DEFAULT NULL,
  `rid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rolemodule` */

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` varchar(20) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `soid` varchar(20) DEFAULT NULL,
  `cid` varchar(20) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `paytype` varchar(20) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `count` int(4) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `paymoney` double DEFAULT NULL,
  `tainmoney` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sales` */

/*Table structure for table `salesback` */

DROP TABLE IF EXISTS `salesback`;

CREATE TABLE `salesback` (
  `id` varchar(20) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ssid` varchar(20) DEFAULT NULL,
  `cid` varchar(20) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `paytype` varchar(20) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL,
  `count` int(4) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `paymoney` double DEFAULT NULL,
  `tainmoney` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesback` */

/*Table structure for table `salesbackdetails` */

DROP TABLE IF EXISTS `salesbackdetails`;

CREATE TABLE `salesbackdetails` (
  `id` varchar(20) NOT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `gvid` varchar(20) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `oldprice` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `count` int(4) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `updatime` datetime DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesbackdetails` */

/*Table structure for table `salesdetails` */

DROP TABLE IF EXISTS `salesdetails`;

CREATE TABLE `salesdetails` (
  `id` varchar(20) NOT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `gvid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `oldprice` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `count` int(4) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `storeid` varchar(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesdetails` */

/*Table structure for table `salesorder` */

DROP TABLE IF EXISTS `salesorder`;

CREATE TABLE `salesorder` (
  `id` varchar(20) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `cid` varchar(20) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `paytype` varchar(20) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL,
  `count` int(4) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `Preprice` double DEFAULT NULL,
  `paymoney` double DEFAULT NULL,
  `tainmoney` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `progress` int(4) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesorder` */

/*Table structure for table `salesorderdetails` */

DROP TABLE IF EXISTS `salesorderdetails`;

CREATE TABLE `salesorderdetails` (
  `id` varchar(20) NOT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `gvid` varchar(20) DEFAULT NULL,
  `oldprice` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `count` int(4) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesorderdetails` */

/*Table structure for table `salesstockrecord` */

DROP TABLE IF EXISTS `salesstockrecord`;

CREATE TABLE `salesstockrecord` (
  `Id` varchar(20) NOT NULL,
  `gvid` varchar(20) DEFAULT NULL,
  `salesdetailid` varchar(20) DEFAULT NULL,
  `stockdetailid` varchar(20) DEFAULT NULL,
  `count` int(4) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesstockrecord` */

/*Table structure for table `standard` */

DROP TABLE IF EXISTS `standard`;

CREATE TABLE `standard` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `tid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `standard` */

/*Table structure for table `standardvalue` */

DROP TABLE IF EXISTS `standardvalue`;

CREATE TABLE `standardvalue` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `standardvalue` */

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` varchar(20) NOT NULL,
  `cid` varchar(20) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

/*Table structure for table `stockdetails` */

DROP TABLE IF EXISTS `stockdetails`;

CREATE TABLE `stockdetails` (
  `id` varchar(20) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `storeid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stockdetails` */

/*Table structure for table `stockrecord` */

DROP TABLE IF EXISTS `stockrecord`;

CREATE TABLE `stockrecord` (
  `id` varchar(20) NOT NULL,
  `aftersdid` varchar(20) DEFAULT NULL,
  `beforesdid` varchar(20) DEFAULT NULL,
  `aftersid` varchar(50) DEFAULT NULL,
  `beforesid` varchar(50) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stockrecord` */

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sufname` varchar(30) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `district` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `parented` int(4) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `store` */

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `district` varchar(20) DEFAULT NULL,
  `addres` varchar(50) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

/*Table structure for table `ulrgoods` */

DROP TABLE IF EXISTS `ulrgoods`;

CREATE TABLE `ulrgoods` (
  `id` varchar(20) NOT NULL,
  `gid` varchar(20) DEFAULT NULL,
  `utid` varchar(20) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `defaulttype` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ulrgoods` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `storeid` int(4) DEFAULT NULL,
  `rid` int(4) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*Table structure for table `usercorrelation` */

DROP TABLE IF EXISTS `usercorrelation`;

CREATE TABLE `usercorrelation` (
  `id` varchar(20) NOT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `utid` varchar(20) DEFAULT NULL,
  `uids` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usercorrelation` */

/*Table structure for table `usertags` */

DROP TABLE IF EXISTS `usertags`;

CREATE TABLE `usertags` (
  `id` varchar(20) NOT NULL,
  `gid` varchar(20) DEFAULT NULL,
  `gtid` varchar(20) DEFAULT NULL,
  `season` int(4) DEFAULT NULL,
  `uid` varchar(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `column1` varchar(50) DEFAULT NULL,
  `column2` varchar(50) DEFAULT NULL,
  `column3` varchar(50) DEFAULT NULL,
  `column4` varchar(50) DEFAULT NULL,
  `column5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usertags` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
