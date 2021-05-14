-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	5.7.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `card`
--
use bank;
DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `balance` double(20,4) DEFAULT '0.0000',
  `customer_code` varchar(40) DEFAULT NULL COMMENT '客户号',
  `account_num` varchar(20) DEFAULT NULL unique COMMENT '银行卡账号',
  `password` varchar(40) NOT NULL COMMENT '加密后的银行卡密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (27,6432530.4231,'demo001202104079','6161779470821245928','dsaddadaewradada'),(28,24703.8355,'南小食有限公司','716177967387571','dadadafddagfdfgdd'),(30,-1.0000,'demo001202104079','6161779470821216793','wrrewrsdfsfsfgdfgd');

/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `code` varchar(40) NOT NULL COMMENT '客户号',
  `name` varchar(40) NOT NULL COMMENT '用户名',
  `id_number` varchar(20) NOT NULL COMMENT '证件号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_code_uindex` (`code`),
  UNIQUE KEY `customer_id_number_uindex` (`id_number`),
  UNIQUE KEY `customer_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (13,'demo001202104078','张三','432561200009087821'),(14,'demo001202104079','南小食客户一','465432134566789097');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_fund_buy`
--

DROP TABLE IF EXISTS `customer_fund_buy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_fund_buy` (
  `customer_id` int(20) NOT NULL,
  `fund_code` char(4) NOT NULL,
  `time_buy` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `principal` double NOT NULL,
  `total` double NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `customer_product_product_id_fk` (`fund_code`),
  KEY `customer_fund_buy_customer_id_fk` (`customer_id`),
  CONSTRAINT `customer_fund_buy_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_fund_fund_code_fk` FOREIGN KEY (`fund_code`) REFERENCES `fund` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_fund_buy`
--

LOCK TABLES `customer_fund_buy` WRITE;
/*!40000 ALTER TABLE `customer_fund_buy` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_fund_buy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_fund_sell`
--

DROP TABLE IF EXISTS `customer_fund_sell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_fund_sell` (
  `customer_id` int(11) NOT NULL,
  `fund_code` char(4) NOT NULL,
  `sell_amount` double NOT NULL,
  `sell_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `customer_fund_sell_fund_code_fk` (`fund_code`),
  KEY `customer_fund_sell_customer_id_fk` (`customer_id`),
  CONSTRAINT `customer_fund_sell_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_fund_sell_fund_code_fk` FOREIGN KEY (`fund_code`) REFERENCES `fund` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_fund_sell`
--

LOCK TABLES `customer_fund_sell` WRITE;
/*!40000 ALTER TABLE `customer_fund_sell` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_fund_sell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_stock_buy`
--

DROP TABLE IF EXISTS `customer_stock_buy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_stock_buy` (
  `customer_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '0',
  `stock_code` char(4) NOT NULL,
  `buy_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `customer_stock_stock_id_fk` (`stock_code`),
  KEY `customer_stock_buy_customer_id_fk` (`customer_id`),
  CONSTRAINT `customer_stock_buy_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_stock_stock_code_fk` FOREIGN KEY (`stock_code`) REFERENCES `stock` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_stock_buy`
--

LOCK TABLES `customer_stock_buy` WRITE;
/*!40000 ALTER TABLE `customer_stock_buy` DISABLE KEYS */;
INSERT INTO `customer_stock_buy` VALUES (14,100,'GP01','2021-04-22 10:48:30',1),(14,100,'GP01','2021-04-22 11:13:34',2),(14,100,'GP01','2021-04-22 11:23:01',3),(14,100,'GP01','2021-04-22 11:28:53',4);
/*!40000 ALTER TABLE `customer_stock_buy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_stock_sell`
--

DROP TABLE IF EXISTS `customer_stock_sell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_stock_sell` (
  `customer_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '0',
  `stock_code` char(4) NOT NULL,
  `sell_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `customer_stock_sell_stock_code_fk` (`stock_code`),
  KEY `customer_stock_sell_customer_id_fk` (`customer_id`),
  CONSTRAINT `customer_stock_sell_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_stock_sell_stock_code_fk` FOREIGN KEY (`stock_code`) REFERENCES `stock` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_stock_sell`
--

LOCK TABLES `customer_stock_sell` WRITE;
/*!40000 ALTER TABLE `customer_stock_sell` DISABLE KEYS */;
INSERT INTO `customer_stock_sell` VALUES (14,1,'GP01','2021-04-22 10:50:45',1),(14,1,'GP01','2021-04-22 11:14:48',2),(14,1,'GP01','2021-04-22 11:23:01',3),(14,1,'GP01','2021-04-22 11:28:52',4);
/*!40000 ALTER TABLE `customer_stock_sell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_term`
--

DROP TABLE IF EXISTS `customer_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(40) NOT NULL,
  `term_code` char(4) NOT NULL,
  `principle` double NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'months',
  PRIMARY KEY (`id`),
  KEY `customer_term_term_code_fk` (`term_code`),
  KEY `customer_term_customer_id_fk` (`customer_id`),
  CONSTRAINT `customer_term_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_term_term_code_fk` FOREIGN KEY (`term_code`) REFERENCES `term` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_term`
--

LOCK TABLES `customer_term` WRITE;
/*!40000 ALTER TABLE `customer_term` DISABLE KEYS */;
INSERT INTO `customer_term` VALUES (1,13,'TM01',20000,'2021-04-12 04:05:56'),(2,14,'TM01',1000,'2021-04-22 09:47:32'),(3,14,'TM01',1000,'2021-04-22 11:11:56'),(4,14,'TM01',1000,'2021-04-22 11:23:02'),(5,14,'TM01',1000,'2021-04-22 11:28:53');
/*!40000 ALTER TABLE `customer_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fund`
--

DROP TABLE IF EXISTS `fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fund` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(4) NOT NULL,
  `rate` double NOT NULL DEFAULT '0',
  `name` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fund_code_uindex` (`code`),
  UNIQUE KEY `fund_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fund`
--

LOCK TABLES `fund` WRITE;
/*!40000 ALTER TABLE `fund` DISABLE KEYS */;
INSERT INTO `fund` VALUES (1,'FD01',0,'fund1'),(2,'FD02',0,'fund2');
/*!40000 ALTER TABLE `fund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fund_rate_time`
--

DROP TABLE IF EXISTS `fund_rate_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fund_rate_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fund_code` char(4) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `rate` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fund_price_time_fund_code_fk` (`fund_code`),
  CONSTRAINT `fund_price_time_fund_code_fk` FOREIGN KEY (`fund_code`) REFERENCES `fund` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fund_rate_time`
--

LOCK TABLES `fund_rate_time` WRITE;
/*!40000 ALTER TABLE `fund_rate_time` DISABLE KEYS */;
INSERT INTO `fund_rate_time` VALUES (1,'FD01','2021-04-12 03:48:06',3.1),(2,'FD01','2021-04-12 03:48:21',3.8);
/*!40000 ALTER TABLE `fund_rate_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institution`
--

DROP TABLE IF EXISTS `institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institution` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(40) NOT NULL COMMENT '机构名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institution`
--

LOCK TABLES `institution` WRITE;
/*!40000 ALTER TABLE `institution` DISABLE KEYS */;
INSERT INTO `institution` VALUES (8,'野村证券公司'),(9,'南食'),(10,'南小食有限公司');
/*!40000 ALTER TABLE `institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
    `iou_num` varchar(40) NOT NULL unique COMMENT '借据号',
  `customer_code` varchar(40) DEFAULT NULL COMMENT '客户号',
  `account_num` varchar(20) DEFAULT NULL COMMENT '银行卡账号',
  `yearly_rate` double(20,4) DEFAULT '0.0000' COMMENT '年利率',
  `repayment_count` int(10) NOT NULL,
  `due_date` date NOT NULL COMMENT '应还日期',
  `loan_date` date NOT NULL COMMENT '贷款日期',
  `loan_cost` double(20,4) NOT NULL COMMENT '贷款相关费用',
  `loan_amount` double(20,4) NOT NULL COMMENT '贷款费用',
  `product_code` varchar(20) NOT NULL COMMENT '产品编号',
  `institution_account_num` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `loan_customer_fk` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`code`),
  CONSTRAINT `loan_card_fk` FOREIGN KEY (`account_num`) REFERENCES `card` (`account_num`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES 
(8,'L2104081553341','demo001202104079','6161779470821245928',4.0000,2,'2021-06-07','2021-04-07',10.0000,9990.0000,'40001','716177967387571','loan1'),
(9,'L2104081553342','demo001202104079','6161779470821245928',4.0000,3,'2021-04-07','2021-01-07',10.0000,19990.0000,'40001','716177967387571','loan2'),
(10,'L2104081553343','demo001202104079','6161779470821245928',4.0000,3,'2021-04-08','2021-01-08',10.0000,19990.0000,'40001','716177967387571','loan3');
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repay_plan`
--

DROP TABLE IF EXISTS `repay_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repay_plan` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `iou_num` varchar(40) NOT NULL,
  `create_time` datetime NOT NULL,
  `plan_num` double(20,4) NOT NULL COMMENT '本次贷款的第几期',
  `plan_amount` double(20,4) NOT NULL,
  `plan_principal` double(20,4) DEFAULT '0.0000',
  `plan_interest` double(20,4) DEFAULT '0.0000',
  `plan_date` date NOT NULL,
  `remain_amount` double(20,4) NOT NULL,
  `remain_principal` double(20,4) NOT NULL,
  `remain_interest` double(20,4) DEFAULT '0.0000',
  `fine` double(20,4) DEFAULT '0.0000' COMMENT '罚金',
  `status` int(11) DEFAULT '0' COMMENT '0：默认，1：逾期，有罚金且未还罚金，2，逾期，已还罚金，3：正常还款',
  PRIMARY KEY (`id`),
    CONSTRAINT `repay_plan_loan_fk` FOREIGN KEY (`iou_num`) REFERENCES `loan` (`iou_num`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repay_plan`
--

LOCK TABLES `repay_plan` WRITE;
/*!40000 ALTER TABLE `repay_plan` DISABLE KEYS */;

INSERT INTO `repay_plan` VALUES (11,'L2104081553341','2021-04-07 20:53:27',1.0000,5025.0114,4991.6814,33.3300,'2021-05-07',5025.0114,4991.6814,33.3300,0.0000,0),(12,'L2104081553341','2021-04-07 20:53:27',1.0000,5025.0114,5008.3187,16.6927,'2021-06-07',5025.0114,5008.3187,16.6927,0.0000,0),

(13,'L2104081553342','2021-01-07 20:53:27',1.0000,6712.2785,6643.9385,68.3400,'2021-02-07',6712.2785,6643.9385,68.3400,0.0000,0),(14,'L2104081553342','2021-01-07 20:53:27',1.0000,6712.2785,6666.6408,45.6377,'2021-03-07',6712.2785,6666.6408,45.6377,0.0000,0),(15,'L2104081553342','2021-01-07 20:53:27',1.0000,6712.2785,6689.4207,22.8578,'2021-04-07',6712.2785,6689.4207,22.8578,0.0000,0),
(16,'L2104081553343','2021-01-08 20:53:27',1.0000,6712.2785,6643.9385,68.3400,'2021-02-08',6712.2785,6643.9385,68.3400,0.0000,0),(17,'L2104081553343','2021-01-08 20:53:27',1.0000,6712.2785,6666.6408,45.6377,'2021-03-08',6712.2785,6666.6408,45.6377,0.0000,0),(18,'L2104081553343','2021-01-08 20:53:27',1.0000,6712.2785,6689.4207,22.8578,'2021-04-08',6712.2785,6689.4207,22.8578,0.0000,0);

/*!40000 ALTER TABLE `repay_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(4) NOT NULL,
  `name` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stock_code_uindex` (`code`),
  UNIQUE KEY `stock_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,'GP01','vavi'),(2,'GP02','media'),(3,'GP03','nokia');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_price_time`
--

DROP TABLE IF EXISTS `stock_price_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_price_time` (
  `stock_code` char(4) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `price` double NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `stock_price_stock_code_fk` (`stock_code`),
  CONSTRAINT `stock_price_stock_code_fk` FOREIGN KEY (`stock_code`) REFERENCES `stock` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_price_time`
--

LOCK TABLES `stock_price_time` WRITE;
/*!40000 ALTER TABLE `stock_price_time` DISABLE KEYS */;
INSERT INTO `stock_price_time` VALUES ('GP01','2021-04-11 14:03:58',18.1,1),('GP02','2021-04-11 14:03:58',6.09,2),('GP03','2021-04-11 14:03:58',9.32,3),('GP01','2021-04-12 02:41:51',90.9,4);
/*!40000 ALTER TABLE `stock_price_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term`
--

DROP TABLE IF EXISTS `term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(4) NOT NULL,
  `name` varchar(8) NOT NULL,
  `rate` double NOT NULL DEFAULT '0',
  `min_term` int(11) NOT NULL DEFAULT '0' COMMENT 'min months',
  PRIMARY KEY (`id`),
  UNIQUE KEY `term_code_uindex` (`code`),
  UNIQUE KEY `term_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term`
--

LOCK TABLES `term` WRITE;
/*!40000 ALTER TABLE `term` DISABLE KEYS */;
INSERT INTO `term` VALUES (1,'TM01','term1',3.8,6),(2,'TM02','term2',3.9,6);
/*!40000 ALTER TABLE `term` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-22 19:33:06
