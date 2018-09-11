/*
  在你的数据库环境中创建示例表
  用于测试从apollo获取配置初始化连接池获取数据
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_basic
-- ----------------------------
DROP TABLE IF EXISTS `user_basic`;
CREATE TABLE `user_basic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `sex` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `idcard` varchar(18) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_basic
-- ----------------------------
INSERT INTO `user_basic` VALUES ('1', 'lisi', '21', '男', '中国深圳', '21', '12');
