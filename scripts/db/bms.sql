/*
 Navicat Premium Data Transfer

 Source Server         : project
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : bms

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 14/07/2020 18:50:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员工号',
  `admin_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员姓名',
  `admin_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员性别',
  `admin_contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员联系方式',
  `admin_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员照片',
  `admin_ban` int(0) NOT NULL DEFAULT 0 COMMENT '管理员账户是否被禁，有记录则不删除，默认为0',
  `admin_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账户密码',
  `admin_root` int(0) NOT NULL DEFAULT 0 COMMENT '是否是超管，默认0，1为超管',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('root', '李四', '女', 'noply@fpbms.com', '/WEB-INF/statics/images/default.png', 0, '987654321', 1);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_No` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名字',
  `book_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书作者',
  `book_publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书出版社',
  `book_bio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书简介',
  `book_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书类别',
  `book_price` float(10, 2) NOT NULL DEFAULT 0.00 COMMENT '图书价格',
  `book_number` int(0) NOT NULL DEFAULT 0 COMMENT '图书数量',
  `book_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书图片',
  `book_ban` int(0) NOT NULL DEFAULT 0 COMMENT '图书是否下架，有记录则不删除记录，默认为0',
  `book_limit` int(0) NOT NULL COMMENT '借阅时间，单位是天',
  `book_per_day` float(10, 2) NOT NULL COMMENT '超过每天的罚款',
  PRIMARY KEY (`book_No`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('BookTest', '软件工程', '张海藩', '清华大学出版社', NULL, '教科书', 39.50, 28, '/WEB-INF/statics/images/default.png', 1, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest1', '网络安全', '吴永祥', '清华大学出版社', 'null', '教科书', 29.53, 15, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest10', 'Java程序语言设计', '梁勇', '机械工业出版社', '想要学习Java吗', '文化、科学', 54.30, 3, '/images/default-book.png', 0, 15, 0.20);
INSERT INTO `book` VALUES ('BookTest15', '论语', '孔子', '上海大学出版社', '中华传统文化', '文学', 10.00, 5, '/images/default-book.png', 0, 7, 0.05);
INSERT INTO `book` VALUES ('BookTest2', '网络安全', '李泽平', '铁道出版社', NULL, '娱乐书', 45.00, 0, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest3', '计算机网络', '罗志祥', '铁道出版社', 'null', '教科书', 28.32, 1, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest4', '数字逻辑', '欧阳星明', '华中科技大学出版社', 'null', '教科书', 27.10, 6, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest5', '学术英语', '范祥', '外研社', NULL, '教科书', 32.00, 6, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest6', 'Header First', 'Freeman', '中国电力出版社', NULL, '教科书', 23.50, 8, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest7', 'C++ Primer', 'fafda', '电子工业出版社', NULL, '教科书', 9.99, 6, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest8', 'Web程序设计', '王鹏', '清华大学出版社', NULL, '教科书', 112.00, 3, '/images/default-book.png', 0, 30, 1.00);
INSERT INTO `book` VALUES ('BookTest9', '疯狂安卓讲义', '李阳', '电子工业出版社', NULL, '教科书', 53.20, 2, '/images/default-book.png', 0, 30, 1.00);

-- ----------------------------
-- Table structure for flow
-- ----------------------------
DROP TABLE IF EXISTS `flow`;
CREATE TABLE `flow`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flow_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水号',
  `order_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `paid_amount` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付金额',
  `paid_method` int(0) NULL DEFAULT NULL COMMENT '支付方式',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of flow
-- ----------------------------
INSERT INTO `flow` VALUES ('2007087XA15HZTR4', '2020070822001412020500673663', '2007087X3BSAPF14', '90.53', 1, '2020-07-08 03:04:38');
INSERT INTO `flow` VALUES ('2007088BYG02F9KP', '2020070822001412020500673538', '2007088BNDHBYXYW', '10.23', 1, '2020-07-08 03:48:26');
INSERT INTO `flow` VALUES ('2007088FAZAABPDP', '2020070822001412020500673431', '2007088F6BZH9THH', '1000.01', 1, '2020-07-08 03:55:46');
INSERT INTO `flow` VALUES ('2007088TCC2FP280', '2020070822001412020500673436', '2007088T7NHSDA5P', '20.00', 1, '2020-07-08 04:22:57');
INSERT INTO `flow` VALUES ('200708FZ24BY223C', '2020070822001412020500673784', '200708FYWWTDXGC0', '27.10', 1, '2020-07-08 12:58:17');
INSERT INTO `flow` VALUES ('200710FW5CHN7K68', '2020071022001412020500674816', '200710FW15WF8ZC0', '25.21', 1, '2020-07-10 12:49:37');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `order_amount` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单金额',
  `paid_amount` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际支付金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `paid_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('2007087X3BSAPF14', '2007087X3BSAPF14', '20', '90.53', '90.53', '2020-07-08 03:03:55', '2020-07-08 03:04:38');
INSERT INTO `orders` VALUES ('2007088BNDHBYXYW', '2007088BNDHBYXYW', '20', '10.23', '10.23', '2020-07-08 03:47:41', '2020-07-08 03:48:26');
INSERT INTO `orders` VALUES ('2007088F6BZH9THH', '2007088F6BZH9THH', '20', '1000.01', '1000.01', '2020-07-08 03:55:17', '2020-07-08 03:55:46');
INSERT INTO `orders` VALUES ('2007088T7NHSDA5P', '2007088T7NHSDA5P', '20', '20.0', '20.00', '2020-07-08 04:22:27', '2020-07-08 04:22:57');
INSERT INTO `orders` VALUES ('200708FYWWTDXGC0', '200708FYWWTDXGC0', '20', '27.1', '27.10', '2020-07-08 12:57:43', '2020-07-08 12:58:17');
INSERT INTO `orders` VALUES ('200710FW15WF8ZC0', '200710FW15WF8ZC0', '20', '25.21', '25.21', '2020-07-10 12:49:10', '2020-07-10 12:49:37');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `reader_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者号',
  `reader_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者姓名',
  `reader_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者性别',
  `reader_contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者联系方式',
  `reader_fine` float(10, 2) NULL DEFAULT NULL COMMENT '读者所欠罚款',
  `reader_ban` int(0) NOT NULL DEFAULT 0 COMMENT '读者账户是否被禁，如有记录则不删除，默认为0',
  `reader_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者照片',
  `reader_register_time` datetime(0) NOT NULL COMMENT '读者注册时间',
  `reader_last_sign_time` datetime(0) NOT NULL COMMENT '读者最后一次登录时间',
  `reader_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者账户密码',
  PRIMARY KEY (`reader_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('ReaderTest', '王五', '男', '820-820-8828', 12.58, 1, '/WEB-INF/statics/images/default.png', '2020-06-23 02:44:10', '2020-06-23 03:27:10', '987654321');
INSERT INTO `reader` VALUES ('ReaderTest1', '王五', '女', '820-820-8820', 12.50, 0, '/WEB-INF/statics/images/default.png', '2020-06-23 08:57:36', '2020-06-23 08:57:36', '123456789');
INSERT INTO `reader` VALUES ('ReaderTest2', '王五', '男', '820-820-8820', 52.60, 0, '/WEB-INF/statics/images/default.png', '2020-06-23 08:58:04', '2020-06-23 08:58:04', '123456789');
INSERT INTO `reader` VALUES ('ReaderTest3', '王五', '男', '820-820-8820', 42.00, 0, '/WEB-INF/statics/images/default.png', '2020-06-23 08:58:21', '2020-06-23 08:58:21', '123456789');
INSERT INTO `reader` VALUES ('ReaderTest4', '王五', '女', '820-820-8820', 78.65, 0, '/WEB-INF/statics/images/default.png', '2020-06-23 08:58:35', '2020-06-23 08:58:35', '123456789');
INSERT INTO `reader` VALUES ('ReaderTest5', '王五', '男', '820-820-8820', NULL, 0, '/WEB-INF/statics/images/default.png', '2020-06-23 08:58:59', '2020-06-23 08:58:59', '123456789');
INSERT INTO `reader` VALUES ('ReaderTest6', '王五', '男', '820-820-8820', NULL, 0, '/WEB-INF/statics/images/default.png', '2020-06-23 08:59:16', '2020-06-23 08:59:16', '123456789');
INSERT INTO `reader` VALUES ('ReaderTest72', '罗志祥', '男', '123456789', NULL, 0, '/WEB-INF/statics/images/default.png', '2020-07-08 10:21:13', '2020-07-08 10:21:13', '123456789');
INSERT INTO `reader` VALUES ('ReaderYang', '羊羊羊', '男', '7758258', NULL, 0, '/WEB-INF/statics/images/default.png', '2020-06-26 14:45:08', '2020-06-26 14:45:08', 'h5SabF8rr2U7VFC');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `record_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '记录号',
  `record_book` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借的书',
  `record_reader` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借的人',
  `record_admin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经手人',
  `record_borrow` datetime(0) NOT NULL COMMENT '借的时间',
  `record_return` datetime(0) NULL DEFAULT NULL COMMENT '还的时间',
  `record_is_return` int(0) NOT NULL DEFAULT 0 COMMENT '是否归还，默认为0，未归还，1为归还',
  `record_is_overtime` int(0) NOT NULL DEFAULT 0 COMMENT '是否超时，默认为0，未超时，1为超时',
  `record_is_lost` int(0) NOT NULL DEFAULT 0 COMMENT '是否丢失，默认为0，未丢失，1为丢失',
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `record_reader`(`record_reader`) USING BTREE,
  INDEX `record_admin`(`record_admin`) USING BTREE,
  INDEX `record_ibfk_1`(`record_book`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`record_book`) REFERENCES `book` (`book_No`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`record_reader`) REFERENCES `reader` (`reader_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `record_ibfk_3` FOREIGN KEY (`record_admin`) REFERENCES `admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 'BookTest', 'ReaderTest', 'root', '2020-06-23 13:51:34', '2020-07-25 07:54:50', 1, 0, 0);
INSERT INTO `record` VALUES (2, 'BookTest1', 'ReaderTest', 'root', '2020-06-30 08:02:49', '2020-07-08 12:41:47', 1, 0, 0);
INSERT INTO `record` VALUES (4, 'BookTest4', 'ReaderTest', 'root', '2020-06-30 08:17:17', NULL, 0, 0, 0);
INSERT INTO `record` VALUES (5, 'BookTest4', 'ReaderTest', 'root', '2020-06-30 12:32:55', NULL, 0, 0, 1);
INSERT INTO `record` VALUES (6, 'BookTest1', 'ReaderTest', 'root', '2020-06-30 12:33:20', NULL, 0, 0, 0);
INSERT INTO `record` VALUES (7, 'BookTest9', 'ReaderTest', 'root', '2020-06-30 12:42:00', NULL, 0, 0, 0);
INSERT INTO `record` VALUES (8, 'BookTest7', 'ReaderTest', 'root', '2020-06-30 12:42:33', NULL, 0, 0, 0);
INSERT INTO `record` VALUES (9, 'BookTest6', 'ReaderTest', 'root', '2020-06-30 12:43:42', '2020-07-05 09:34:21', 1, 0, 0);
INSERT INTO `record` VALUES (10, 'BookTest1', 'ReaderTest', 'root', '2020-06-30 12:44:06', NULL, 0, 0, 0);
INSERT INTO `record` VALUES (11, 'BookTest5', 'ReaderTest', 'root', '2020-06-30 12:45:20', NULL, 0, 0, 0);
INSERT INTO `record` VALUES (12, 'BookTest8', 'ReaderTest', 'root', '2020-06-30 12:46:22', NULL, 0, 0, 0);
INSERT INTO `record` VALUES (13, 'BookTest1', 'ReaderTest', 'root', '2020-06-30 12:46:52', NULL, 0, 0, 1);
INSERT INTO `record` VALUES (16, 'BookTest1', 'ReaderTest', 'root', '2020-07-10 12:42:03', NULL, 0, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
