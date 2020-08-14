/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : ur

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-08-09 10:46:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ur_dynamic_sql
-- ----------------------------
DROP TABLE IF EXISTS `ur_dynamic_sql`;
CREATE TABLE `ur_dynamic_sql` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `QUERY_CODE` varchar(100) NOT NULL COMMENT '查询的code',
  `QUERY_NAME` varchar(100) DEFAULT NULL COMMENT '查询的名称',
  `QUERY_TYPE` varchar(50) DEFAULT NULL COMMENT '查询的类型',
  `SQL_TEMPLATE` text NOT NULL COMMENT 'sql模板',
  `PRE_SCRIPT` text COMMENT '预处理脚本',
  `BEFORE_SCRIPT` text COMMENT '查询之前脚本',
  `AFTER_SCRIPT` text COMMENT '查询之后脚本',
  `VERSION` varchar(20) DEFAULT NULL COMMENT '版本号',
  `DEL_FLAG` bit(1) DEFAULT NULL COMMENT '是否删除。1：是，0：否。',
  `ORDER_NUM` int(11) DEFAULT NULL COMMENT '排序编号。正序。',
  `CREATE_NAME` varchar(60) DEFAULT NULL COMMENT '创建人名称',
  `CREATE_Id` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_NAME` varchar(60) DEFAULT NULL COMMENT '修改人名称',
  `UPDATE_Id` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNIQUE` (`QUERY_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for ur_template
-- ----------------------------
DROP TABLE IF EXISTS `ur_template`;
CREATE TABLE `ur_template` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `TEMPLATE_CODE` varchar(255) NOT NULL COMMENT 'template code',
  `TEMPLATE` text COMMENT 'template',
  `VERSION` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '版本号',
  `DEL_FLAG` bit(1) DEFAULT NULL COMMENT '是否删除。1：是，0：否。',
  `ORDER_NUM` int(11) DEFAULT NULL COMMENT '排序编号。正序。',
  `CREATE_NAME` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人名称',
  `CREATE_Id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_NAME` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改人名称',
  `UPDATE_Id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改人id',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `REMARK` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ur_template_unique` (`TEMPLATE_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
