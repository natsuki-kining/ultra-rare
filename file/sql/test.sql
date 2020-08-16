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

-- ----------------------------
-- Table structure for test_rose_chart
-- ----------------------------
DROP TABLE IF EXISTS `test_rose_chart`;
CREATE TABLE `test_ranking_board` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for test_water_level_chart
-- ----------------------------
DROP TABLE IF EXISTS `test_water_level_chart`;
CREATE TABLE `test_water_level_chart` (
  `id` varchar(32) NOT NULL,
  `wave_height` int(11) DEFAULT NULL,
  `wave_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for test_scroll_board
-- ----------------------------
DROP TABLE IF EXISTS `test_scroll_board`;
CREATE TABLE `test_scroll_board` (
  `id` varchar(32) NOT NULL,
  `date` datetime DEFAULT NULL,
  `info` varchar(500) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `jieduan` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 测试数据
INSERT INTO `ur_dynamic_sql` VALUES ('1', 'test-ranking-board', 'test-ranking-board', 'test', 'select * from test_ranking_board', NULL, '', 'var queryData=ssrParams.queryData;queryData.rowNum = queryData.count;queryData.data = queryData.list;delete (queryData.count);delete (queryData.list);ssrResult=queryData;', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ur_dynamic_sql` VALUES ('2', 'test-digital-flop', 'test-digital-flop', 'test', 'SELECT\r\n	f.id,\r\n	f.title,\r\n	f.unit,\r\n	a.number\r\nFROM\r\n	test_digital_flop f,\r\n	(\r\n		SELECT\r\n			n.test_digital_flop_id,\r\n			sum(n.number) number\r\n		FROM\r\n			test_digital_flop_number n\r\n		GROUP BY\r\n			n.test_digital_flop_id\r\n	) a\r\nWHERE\r\n	f.id = a.test_digital_flop_id', NULL, NULL, 'var testDigitalFlopData = ssrParams.queryData;var colors = [\'#4d99fc\',\'#f46827\',\'#40faee\',\'#4d99fc\',\'#f46827\',\'#40faee\',\'#4d99fc\',\'#f46827\',\'#40faee\'];\nfor (var i in testDigitalFlopData.list) {\n    testDigitalFlopData.list[i].number = {\"number\": [testDigitalFlopData.list[i].number]};\n    testDigitalFlopData.list[i].number.content = \'{nt}\';\n    testDigitalFlopData.list[i].number.textAlign = \'right\';\n    testDigitalFlopData.list[i].number.style = {\"fill\": colors[i], \"fontWeight\": \'bold\'};\n} ssrResult=testDigitalFlopData.list;\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ur_dynamic_sql` VALUES ('3', 'test-rose-chart', 'test-rose-chart', 'test', 'select * from test_rose_chart', NULL, '', "var queryData=ssrParams.queryData;queryData.data = queryData.list;delete (queryData.count);delete (queryData.list);ssrResult=series: [{ type: 'pie', radius: '50%', roseSort: false, data: queryData, insideLabel: { show: false }, outsideLabel: { formatter: '{name} {percent}%', labelLineEndLength: 20, style: { fill: '#fff' }, labelLineStyle: { stroke: '#fff' } }, roseType: true }], color: ['#da2f00', '#fa3600', '#ff4411', '#ff724c', '#541200', '#801b00', '#a02200', '#5d1400', '#b72700'];", NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ur_dynamic_sql` VALUES ('4', 'test-water-level-chart', 'test-water-level-chart', 'test', 'select waveHeight wave_height,wave_num waveNum from test_water_level_chart', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ur_dynamic_sql` VALUES ('4', 'test-water-level-chart', 'test-water-level-chart', 'test', 'select waveHeight wave_height,wave_num waveNum from test_water_level_chart', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);




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



-- ----------------------------
-- Records of test_rose_chart
-- ----------------------------
INSERT INTO `test_rose_chart` VALUES ('1', '日常养护', '55');
INSERT INTO `test_rose_chart` VALUES ('2', '交通事故', '25');
INSERT INTO `test_rose_chart` VALUES ('3', '路面', '46');
INSERT INTO `test_rose_chart` VALUES ('4', '桥通', '16');
INSERT INTO `test_rose_chart` VALUES ('5', '计日工', '40');
INSERT INTO `test_rose_chart` VALUES ('6', '路基', '25');
INSERT INTO `test_rose_chart` VALUES ('7', '交安设施', '29');
INSERT INTO `test_rose_chart` VALUES ('8', '除雪', '39');
INSERT INTO `test_rose_chart` VALUES ('9', '绿化', '49');


-- ----------------------------
-- Records of test_water_level_chart
-- ----------------------------
INSERT INTO `test_water_level_chart` VALUES ('1', 25, 5);

-- ----------------------------
-- Records of test_scroll_board
-- ----------------------------
INSERT INTO `test_scroll_board` VALUE('1','2019-07-01 19:25:00', '路面危害-松散', '5', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('2','2019-07-02 17:25:00', '路面危害-路面油污清理', '13', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('3','2019-07-03 16:25:00', '交安设施-交通标志牌结构', '6', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('4','2019-07-04 15:25:00', '路基危害-防尘网', '2', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('5','2019-07-05 14:25:00', '交安设施-交通标志牌结构', '1', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('6','2019-07-06 13:25:00', '路面危害-松散', '3', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('7','2019-07-07 12:25:00', '路基危害-防尘网', '4', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('8','2019-07-08 11:25:00', '路面危害-路面油污清理', '2', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('9','2019-07-09 10:25:00', '交安设施-交通标志牌结构', '5', 'xxxxxxx');
INSERT INTO `test_scroll_board` VALUE('10','2019-07-10 09:25:00', '路基危害-防尘网', '3', 'xxxxxxx']