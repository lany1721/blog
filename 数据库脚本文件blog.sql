/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-10-10 13:25:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博文主键',
  `blog_title` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '博文标题',
  `blog_content` longtext CHARACTER SET utf8mb4 NOT NULL COMMENT '博文内容',
  `blog_view` int(11) NOT NULL DEFAULT '0' COMMENT '博文浏览量',
  `blog_type` varchar(4) NOT NULL DEFAULT '原创' COMMENT '原创 、转载',
  `blog_brief` text CHARACTER SET utf8mb4,
  `published` bit(1) NOT NULL DEFAULT b'1' COMMENT '0-草稿 1-发布',
  `appreciation` bit(1) NOT NULL DEFAULT b'0' COMMENT '0-不开启赞赏 1-开启赞赏',
  `copyright` bit(1) NOT NULL DEFAULT b'1' COMMENT '0-不开启版权声明 1-代表开启',
  `comment` bit(1) NOT NULL DEFAULT b'0' COMMENT '0-代表不允许评论 1-代表允许',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `category_id` int(11) DEFAULT NULL COMMENT '关联的分类',
  `user_id` int(11) DEFAULT NULL COMMENT '关联的用户',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tag`;
CREATE TABLE `t_blog_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '分类名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '分类创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '分类修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_link
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `link_url` varchar(50) COLLATE utf8_bin NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签主键',
  `tag_name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '标签名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `nickname` varchar(20) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `email` varchar(50) NOT NULL COMMENT '用户邮箱',
  `role` varchar(20) NOT NULL DEFAULT 'user' COMMENT '用户所在的用户组',
  `avatar` varchar(100) NOT NULL COMMENT '用户头像',
  `introduce` text CHARACTER SET utf8mb4,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
