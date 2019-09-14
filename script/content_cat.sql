DROP TABLE IF EXISTS `content_cat`;
CREATE TABLE `content_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '1 : normal, 2 : deleted',
  `sort_order` int(4) DEFAULT NULL COMMENT 'non-negative',
  `is_parent` tinyint(1) DEFAULT '1' COMMENT '1 : true, 0 : false',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`,`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;


INSERT INTO `content_cat` VALUES ('30', '0', '淘淘商城', '1', '1', '1', '2019-04-03 16:51:38', '2019-04-03 16:51:40');
INSERT INTO `content_cat` VALUES ('86', '30', '首页', '1', '1', '1', '2019-06-07 15:36:07', '2019-06-07 15:36:07');
INSERT INTO `content_cat` VALUES ('87', '30', '列表页面', '1', '1', '1', '2019-06-07 15:36:16', '2019-06-07 15:36:16');
INSERT INTO `content_cat` VALUES ('88', '30', '详细页面', '1', '1', '1', '2019-06-07 15:36:27', '2019-06-07 15:36:27');
INSERT INTO `content_cat` VALUES ('89', '86', '大广告', '1', '1', '0', '2019-06-07 15:36:38', '2019-06-07 15:36:38');
INSERT INTO `content_cat` VALUES ('90', '86', '小广告', '1', '1', '0', '2019-06-07 15:36:45', '2019-06-07 15:36:45');
INSERT INTO `content_cat` VALUES ('91', '86', '淘淘快报', '1', '1', '0', '2019-06-07 15:36:55', '2019-06-07 15:36:55');
INSERT INTO `content_cat` VALUES ('92', '87', '边栏广告', '1', '1', '0', '2019-06-07 15:37:07', '2019-06-07 15:37:07');
INSERT INTO `content_cat` VALUES ('93', '87', '页头广告', '1', '1', '0', '2019-06-07 15:37:17', '2019-06-07 15:37:17');
INSERT INTO `content_cat` VALUES ('94', '87', '页脚广告', '1', '1', '0', '2019-06-07 15:37:31', '2019-06-07 15:37:31');
INSERT INTO `content_cat` VALUES ('95', '88', '边栏广告', '1', '1', '0', '2019-06-07 15:37:56', '2019-06-07 15:37:56');
INSERT INTO `content_cat` VALUES ('96', '86', '中广告', '1', '1', '1', '2019-07-25 18:58:52', '2019-07-25 18:58:52');
INSERT INTO `content_cat` VALUES ('97', '96', '中广告1', '1', '1', '0', '2019-07-25 18:59:43', '2019-07-25 18:59:43');
