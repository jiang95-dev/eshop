DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `sub_title` varchar(100) DEFAULT NULL,
  `title_desc` varchar(500) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `pic` varchar(300) DEFAULT NULL COMMENT 'abosulte path',
  `pic2` varchar(300) DEFAULT NULL,
  `content` text,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `updated` (`updated`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;


INSERT INTO `content` VALUES ('28', '89', '标题1', '标题1', '标题1', 'http://www.jd.com', 'http://localhost:9089/images/2019/07/27/1437979301511057.jpg', null, '标题1', '2019-07-27 14:41:57', '2019-07-27 14:41:57');
INSERT INTO `content` VALUES ('29', '89', 'ad2', 'ad2', 'ad2', 'http://www.baidu.com', 'http://localhost:9089/images/2019/07/27/1437979349040954.jpg', null, 'ad2', '2019-07-27 14:42:36', '2019-07-27 14:42:36');
INSERT INTO `content` VALUES ('30', '89', 'ad3', 'ad3', 'ad3', 'http://www.sina.com.cn', 'http://localhost:9089/images/2019/07/27/1437979377450366.jpg', null, '', '2019-07-27 14:42:58', '2019-07-27 14:42:58');
INSERT INTO `content` VALUES ('31', '89', 'ad4', 'ad4', 'ad4', 'ad4', 'http://localhost:9089/images/2019/07/27/1437979392186756.jpg', null, 'ad4', '2019-07-27 14:43:15', '2019-07-27 14:43:15');
