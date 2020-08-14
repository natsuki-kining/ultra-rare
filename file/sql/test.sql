-- ----------------------------
-- Table structure for test_digital_flop
-- ----------------------------
DROP TABLE IF EXISTS `test_digital_flop`;
CREATE TABLE `test_digital_flop` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for test_digital_flop_number
-- ----------------------------
DROP TABLE IF EXISTS `test_digital_flop_number`;
CREATE TABLE `test_digital_flop_number` (
  `id` varchar(32) NOT NULL,
  `test_digital_flop_id` varchar(32) NOT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for test_ranking_board
-- ----------------------------
DROP TABLE IF EXISTS `test_ranking_board`;
CREATE TABLE `test_ranking_board` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




-- 测试数据
INSERT INTO `ur_dynamic_sql` VALUES ('1', 'test-ranking-board', 'test-ranking-board', 'test', 'select * from test_ranking_board', NULL, '', 'var queryData=ssrParams.queryData;queryData.rowNum = queryData.count;queryData.data = queryData.list;delete (queryData.count);delete (queryData.list);ssrResult=queryData;', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ur_dynamic_sql` VALUES ('2', 'test-digital-flop', 'test-digital-flop', 'test', 'SELECT\r\n	f.id,\r\n	f.title,\r\n	f.unit,\r\n	a.number\r\nFROM\r\n	test_digital_flop f,\r\n	(\r\n		SELECT\r\n			n.test_digital_flop_id,\r\n			sum(n.number) number\r\n		FROM\r\n			test_digital_flop_number n\r\n		GROUP BY\r\n			n.test_digital_flop_id\r\n	) a\r\nWHERE\r\n	f.id = a.test_digital_flop_id', NULL, NULL, 'var testDigitalFlopData = ssrParams.queryData;var colors = [\'#4d99fc\',\'#f46827\',\'#40faee\',\'#4d99fc\',\'#f46827\',\'#40faee\',\'#4d99fc\',\'#f46827\',\'#40faee\'];\nfor (var i in testDigitalFlopData.list) {\n    testDigitalFlopData.list[i].number = {\"number\": [testDigitalFlopData.list[i].number]};\n    testDigitalFlopData.list[i].number.content = \'{nt}\';\n    testDigitalFlopData.list[i].number.textAlign = \'right\';\n    testDigitalFlopData.list[i].number.style = {\"fill\": colors[i], \"fontWeight\": \'bold\'};\n} ssrResult=testDigitalFlopData.list;\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Records of test_digital_flop
-- ----------------------------
INSERT INTO `test_digital_flop` VALUES ('1', '管养里程', '公里');
INSERT INTO `test_digital_flop` VALUES ('2', '桥梁', '座');
INSERT INTO `test_digital_flop` VALUES ('3', '涵洞隧道', '个');
INSERT INTO `test_digital_flop` VALUES ('4', '匝道', '个');
INSERT INTO `test_digital_flop` VALUES ('5', '隧道', '个');
INSERT INTO `test_digital_flop` VALUES ('6', '服务区', '个');
INSERT INTO `test_digital_flop` VALUES ('7', '收费站', '个');
INSERT INTO `test_digital_flop` VALUES ('8', '超限站', '个');
INSERT INTO `test_digital_flop` VALUES ('9', '停车区', '个');

-- ----------------------------
-- Records of test_digital_flop_number
-- ----------------------------
INSERT INTO `test_digital_flop_number` VALUES ('1', '1', '1111');
INSERT INTO `test_digital_flop_number` VALUES ('10', '8', '7');
INSERT INTO `test_digital_flop_number` VALUES ('11', '9', '6');
INSERT INTO `test_digital_flop_number` VALUES ('2', '1', '455');
INSERT INTO `test_digital_flop_number` VALUES ('3', '1', '60');
INSERT INTO `test_digital_flop_number` VALUES ('4', '2', '35');
INSERT INTO `test_digital_flop_number` VALUES ('5', '3', '30');
INSERT INTO `test_digital_flop_number` VALUES ('6', '4', '20');
INSERT INTO `test_digital_flop_number` VALUES ('7', '5', '10');
INSERT INTO `test_digital_flop_number` VALUES ('8', '6', '5');
INSERT INTO `test_digital_flop_number` VALUES ('9', '7', '8');

-- ----------------------------
-- Records of test_ranking_board
-- ----------------------------
INSERT INTO `test_ranking_board` VALUES ('1', '日常养护', '55');
INSERT INTO `test_ranking_board` VALUES ('2', '交通事故', '120');
INSERT INTO `test_ranking_board` VALUES ('3', '路面', '78');
INSERT INTO `test_ranking_board` VALUES ('4', '桥通', '66');
INSERT INTO `test_ranking_board` VALUES ('5', '计日工', '80');
INSERT INTO `test_ranking_board` VALUES ('6', '路基', '45');
INSERT INTO `test_ranking_board` VALUES ('7', '交安设施', '29');
INSERT INTO `test_ranking_board` VALUES ('8', '除雪', '29');
INSERT INTO `test_ranking_board` VALUES ('9', '绿化', '29');