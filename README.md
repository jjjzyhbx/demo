# demo
一个课设
**基础入门配置**
**1.**
#配置mysql，网络上找mysql入门，配置相应路径，创建数据库名：meal_card_management
# sql语句如下
cerate database meal_card_management;
use  meal_card_management
# 创建表
CREATE TABLE `user` (
                        `id` int PRIMARY KEY AUTO_INCREMENT,
                        `username` varchar(50) NOT NULL,
                        `password` varchar(50) NOT NULL,
                        `real_name` varchar(50) NOT NULL,
                        `type` tinyint NOT NULL DEFAULT 0 COMMENT '用户类型:0-学生,1-员工',
                        `student_id` varchar(20) UNIQUE,
                        `employee_id` varchar(20) UNIQUE,
                        `department_id` int,
                        `grade` int,
                        `balance` decimal(8,2) NOT NULL DEFAULT 0.00,
                        `register_time` datetime NOT NULL,
                        `last_login_time` datetime
);

CREATE TABLE `department` (
                              `id` int PRIMARY KEY AUTO_INCREMENT,
                              `name` varchar(50) NOT NULL
);

CREATE TABLE `dish` (
                        `id` int PRIMARY KEY AUTO_INCREMENT,
                        `name` varchar(50) NOT NULL,
                        `price` decimal(6,2) NOT NULL,
                        `category_id` int NOT NULL,
#                         月销量
                        `monthly_sales` int NOT NULL DEFAULT 0,
#                         库存
                        `inventory` int NOT NULL DEFAULT 0,
                        `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态:0-下架,1-上架',
                        `create_time` datetime NOT NULL,
                        `update_time` datetime NOT NULL
);
# 订单表
CREATE TABLE `order` (
                         `id` int PRIMARY KEY AUTO_INCREMENT,
                         `user_id` int NOT NULL,
                         `dish_id` int NOT NULL,
                         `count` smallint NOT NULL,
                         `amount` decimal(6,2) NOT NULL,
                         `paid_amount` decimal(6,2) NOT NULL,
                         `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态:0-未付款,1-已付款',
                         `pay_type` tinyint NOT NULL DEFAULT 1 COMMENT '支付类型:1-余额;2-现金',
                         `complete_time` datetime,
                         `create_time` datetime NOT NULL
);

-- 生成部门数据
INSERT INTO `department` VALUES
(1, '开发部'),
(2, '测试部');

-- 生成用户数据
INSERT INTO `user` VALUES
(1, 'zhangsan', '123456', '张三', 0, '1001', NULL, 1, 3, 120, '2023-02-01 10:00:00', NULL),
(2, 'lisi', '123456', '李四', 1, NULL, '1002', 2, NULL, 80, '2023-02-02 12:00:00', '2023-02-03 15:00:00');


-- 生成菜品数据
INSERT INTO `dish` VALUES
(1, '香锅鱼', 12.5, 1, 500, 100, 1, '2023-01-01 12:00:00', NULL),
(2, '烤鸡腿', 15, 2, 300, 80, 1, '2023-01-05 16:00:00', NULL);


-- 生成订单数据
INSERT INTO `order` VALUES
(1, 1, 1, 2, 25, 25, 1, 1, '2023-02-04 18:00:00', '2023-02-04 17:30:00'),
(2, 2, 2, 1, 15, 15, 1, 2, NULL, '2023-02-04 18:00:00');

ALTER TABLE user ADD signatures varchar(256);

ALTER TABLE user CHANGE employee_id email varchar(20);

# **meaven**
配置meaven，然后加载依赖
# **配置自己本地环境**
application.yaml 中，只需要将
spring.datasource.username: root（自己数据库用户名）
spring.datasource.password: 2605274496（自己数据库密码）
