-- MySQL dump 10.13  Distrib 8.0.32, for macos13 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `administrative_stuff`
--
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
DROP TABLE IF EXISTS `administrative_stuff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrative_stuff` (
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrative_stuff`
--

LOCK TABLES `administrative_stuff` WRITE;
/*!40000 ALTER TABLE `administrative_stuff` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrative_stuff` ENABLE KEYS */;
UNLOCK TABLES;

insert into mydb.administrative_stuff (username,email,password) values ('Admin','admin@example.com','adminPassword');
--
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alert` (
  `idalert` int NOT NULL AUTO_INCREMENT,
  `idUser` int NOT NULL,
  `ItemName` varchar(45) NOT NULL,
  PRIMARY KEY (`idalert`),
  KEY `idUser_idx` (`idUser`),
  CONSTRAINT `idUser_alert` FOREIGN KEY (`idUser`) REFERENCES `end_user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auction`
--

DROP TABLE IF EXISTS `auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auction` (
  `idItem` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `enddate` datetime NOT NULL,
  `initialprice` double(9,2) NOT NULL,
  `increment` double(9,2) NOT NULL,
  `minimumprice` double(9,2) DEFAULT NULL,
  `description` longtext NOT NULL,
  `seller` int NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `currentPrice` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`idItem`),
  KEY `seller_idx` (`seller`) /*!80000 INVISIBLE */,
  FULLTEXT KEY `search` (`name`,`description`,`type`),
  CONSTRAINT `seller` FOREIGN KEY (`seller`) REFERENCES `end_user` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction`
--

LOCK TABLES `auction` WRITE;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
INSERT INTO `auction` VALUES (1,'Laptop','2023-04-24 20:00:00',500.00,10.00,550.00,'A brand new laptop with great specifications.',1,'Electronics',520),(2,'Bicycle','2023-04-24 18:00:00',200.00,5.00,220.00,'A lightweight and durable bicycle for daily use.',2,'Sports',225),(3,'Guitar','2023-04-24 21:30:00',150.00,3.00,170.00,'An acoustic guitar in excellent condition.',3,'Musical Instruments',180),(4,'Smartphone','2023-04-24 19:00:00',300.00,8.00,330.00,'A brand new smartphone with the latest features.',4,'Electronics',308),(5,'Blender','2023-04-24 22:00:00',50.00,2.00,60.00,'A powerful blender, perfect for smoothies and soups.',5,'Home Appliances',62),(6,'Laptop','2023-05-01 20:00:00',600.00,15.00,650.00,'A high-performance laptop with the latest features.',6,'Electronics',650),(7,'Smartphone','2023-05-02 18:00:00',350.00,10.00,400.00,'An advanced smartphone with a sleek design.',7,'Electronics',380),(8,'Bicycle','2023-05-03 19:00:00',250.00,5.00,275.00,'A mountain bike with comfortable suspension.',8,'Sports',265),(9,'Blender','2023-05-05 22:00:00',70.00,2.00,80.00,'A versatile blender with multiple speed settings.',10,'Home Appliances',75),(10,'Headphones','2023-05-06 20:00:00',100.00,3.00,120.00,'A pair of noise-canceling headphones with excellent sound quality.',11,'Electronics',108),(11,'Camera','2023-05-07 18:00:00',800.00,20.00,900.00,'A professional DSLR camera with a high-quality lens.',12,'Photography',820),(12,'Watch','2023-05-08 19:00:00',200.00,10.00,250.00,'An elegant wristwatch with a stainless steel band.',13,'Fashion',210),(13,'Microwave','2023-05-09 21:00:00',120.00,4.00,130.00,'A compact microwave with various cooking options.',14,'Home Appliances',124),(14,'Sneakers','2023-05-10 22:00:00',80.00,3.00,100.00,'A pair of stylish sneakers for casual wear.',15,'Fashion',88),(15,'Laptop','2023-05-11 20:00:00',650.00,15.00,700.00,'A gaming laptop with high-quality graphics.',16,'Electronics',665),(16,'Smartphone','2023-05-12 18:00:00',400.00,10.00,450.00,'A smartphone with a large display and long battery life.',17,'Electronics',410),(17,'Bicycle','2023-05-13 19:00:00',300.00,5.00,325.00,'A road bike with a lightweight frame.',18,'Sports',305),(18,'Guitar','2023-05-14 21:00:00',200.00,5.00,230.00,'A classical guitar with a solid wood top.',19,'Musical Instruments',215),(19,'Blender','2023-05-15 22:00:00',60.00,2.00,70.00,'An immersion blender for easy blending and mixing.',20,'Home Appliances',62),(20,'Headphones','2023-05-16 20:00:00',120.00,3.00,140.00,'A pair of wireless headphones with a long battery life.',1,'Electronics',123),(21,'Camera','2023-05-17 18:00:00',900.00,20.00,1000.00,'A mirrorless camera with a high-resolution sensor.',2,'Photography',900),(22,'Watch','2023-05-18 19:00:00',250.00,10.00,300.00,'A luxury wristwatch with a leather strap.',3,'Fashion',250),(23,'Microwave','2023-05-19 21:00:00',150.00,4.00,160.00,'A large microwave with a spacious interior.',4,'Home Appliances',150),(24,'Sneakers','2023-05-20 22:00:00',90.00,3.00,110.00,'A pair of running shoes with great support.',5,'Fashion',90);
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autobid`
--

DROP TABLE IF EXISTS `autobid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autobid` (
  `idItem` int NOT NULL,
  `idUser` int NOT NULL,
  `upperlimit` double(9,2) NOT NULL,
  PRIMARY KEY (`idItem`,`idUser`),
  KEY `idUser_idx` (`idUser`),
  CONSTRAINT `idItem_autobid` FOREIGN KEY (`idItem`) REFERENCES `auction` (`idItem`),
  CONSTRAINT `idUser_autobid` FOREIGN KEY (`idUser`) REFERENCES `end_user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autobid`
--

LOCK TABLES `autobid` WRITE;
/*!40000 ALTER TABLE `autobid` DISABLE KEYS */;
INSERT INTO `autobid` VALUES (6,1,690.00);
/*!40000 ALTER TABLE `autobid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bid`
--

DROP TABLE IF EXISTS `bid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bid` (
  `idItem` int NOT NULL,
  `idUser` int NOT NULL,
  `price` double(9,2) NOT NULL,
  PRIMARY KEY (`idItem`,`idUser`,`price`),
  KEY `idUser_idx` (`idUser`),
  CONSTRAINT `idItem_bid` FOREIGN KEY (`idItem`) REFERENCES `auction` (`idItem`),
  CONSTRAINT `idUser_bid` FOREIGN KEY (`idUser`) REFERENCES `end_user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bid`
--

LOCK TABLES `bid` WRITE;
/*!40000 ALTER TABLE `bid` DISABLE KEYS */;
INSERT INTO `bid` VALUES (1,1,510.00),(6,1,650.00),(7,1,380.00),(8,1,265.00),(9,1,75.00),(10,1,108.00),(14,1,88.00),(18,1,215.00),(20,1,123.00),(1,2,510.00),(1,2,520.00),(2,3,225.00),(3,4,153.00),(3,4,180.00),(4,5,308.00),(5,6,62.00),(6,7,615.00),(7,8,360.00),(8,9,255.00),(9,10,72.00),(10,11,103.00),(11,12,820.00),(12,13,210.00),(13,14,124.00),(14,15,83.00),(15,16,665.00),(16,17,410.00),(17,18,305.00),(18,19,205.00),(19,20,62.00);
/*!40000 ALTER TABLE `bid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `end_user`
--

DROP TABLE IF EXISTS `end_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `end_user` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  `earning` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `end_user`
--

LOCK TABLES `end_user` WRITE;
/*!40000 ALTER TABLE `end_user` DISABLE KEYS */;
INSERT INTO `end_user` VALUES (1,'JohnDoe','password123','johndoe@example.com',0),(2,'JaneSmith','password456','janesmith@example.com',0),(3,'AliceBrown','password789','alicebrown@example.com',0),(4,'BobJohnson','password111','bobjohnson@example.com',0),(5,'CharlieMiller','password222','charliemiller@example.com',0),(6,'DavidLee','password333','davidlee@example.com',0),(7,'EveWilliams','password444','evewilliams@example.com',0),(8,'FrankTaylor','password555','franktaylor@example.com',0),(9,'GraceAnderson','password666','graceanderson@example.com',0),(10,'HankThomas','password777','hankthomas@example.com',0),(11,'IvyJackson','password888','ivyjackson@example.com',0),(12,'JackWhite','password999','jackwhite@example.com',0),(13,'KateHarris','password101','kateharris@example.com',0),(14,'LukeMartin','password202','lukemartin@example.com',0),(15,'MiaClark','password303','miaclark@example.com',0),(16,'NathanLewis','password404','nathanlewis@example.com',0),(17,'OliviaYoung','password505','oliviayoung@example.com',0),(18,'PeterHall','password606','peterhall@example.com',0),(19,'QuincyKing','password707','quincyking@example.com',0),(20,'RitaTurner','password808','ritaturner@example.com',0);
/*!40000 ALTER TABLE `end_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemProperty`
--

DROP TABLE IF EXISTS `itemProperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemProperty` (
  `idItem` int NOT NULL,
  `idproperty` int NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`idItem`,`idproperty`),
  KEY `property_idx` (`idproperty`),
  CONSTRAINT `item_itemp` FOREIGN KEY (`idItem`) REFERENCES `auction` (`idItem`),
  CONSTRAINT `property_itemp` FOREIGN KEY (`idproperty`) REFERENCES `property` (`idproperty`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemProperty`
--

LOCK TABLES `itemProperty` WRITE;
/*!40000 ALTER TABLE `itemProperty` DISABLE KEYS */;
INSERT INTO `itemProperty` VALUES (1,1,'Red'),(2,2,'Blue'),(3,3,'Green'),(4,4,'New'),(5,5,'Powerful'),(6,7,'High-Quality'),(7,10,'Advanced'),(8,12,'Comfortable'),(9,8,'Versatile'),(10,21,'Noise-cancelling'),(11,14,'Professional'),(12,15,'Elegant'),(13,6,'Compact'),(14,17,'Stylish'),(15,7,'High-quality'),(16,23,'Large'),(17,9,'LightWeight'),(18,11,'Classical'),(19,4,'New'),(20,22,'Brand'),(21,13,'High-resolution'),(22,16,'Luxury'),(23,23,'Large'),(24,18,'Support');
/*!40000 ALTER TABLE `itemProperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `idproperty` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`idproperty`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'Red','Electronics'),(2,'Blue','Sports'),(3,'Green','Musical Instruments'),(4,'New','Electronics'),(5,'Powerful','Home Appliances'),(6,'Compact','Home Appliances'),(7,'High-Quality','Electronics'),(8,'Versatile','Home Appliances'),(9,'LightWeight','Sports'),(10,'Advanced','Electronics'),(11,'Classical','Musical Instruments'),(12,'Comfortable','Sports'),(13,'High-resolution','Photography'),(14,'Professional','Photography'),(15,'Elegant','Fashion'),(16,'Luxury','Fashion'),(17,'Stylish','Fashion'),(18,'Support','Fashion'),(19,'Sleek','Electronics'),(20,'Acoustic','Musical Instruments'),(21,'Noise-cancelling','Electronics'),(22,'Brand','Electronics'),(23,'Large','Electronics');
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `idquestion` int NOT NULL AUTO_INCREMENT,
  `idUser` int NOT NULL,
  `idAdmin` int DEFAULT NULL,
  `question` longtext NOT NULL,
  `answer` longtext,
  `questionTitle` longtext NOT NULL,
  `answerTitle` longtext,
  PRIMARY KEY (`idquestion`),
  KEY `question_repre_idx` (`idAdmin`),
  KEY `question_user_idx` (`idUser`) /*!80000 INVISIBLE */,
  FULLTEXT KEY `searchQuestion` (`question`,`answer`,`questionTitle`,`answerTitle`),
  FULLTEXT KEY `searchOnlyQuestion` (`question`,`questionTitle`) /*!80000 INVISIBLE */,
  CONSTRAINT `question_repre` FOREIGN KEY (`idAdmin`) REFERENCES `representatives` (`idRep`),
  CONSTRAINT `question_user` FOREIGN KEY (`idUser`) REFERENCES `end_user` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,1,NULL,'I am new to this platform, how can I place a bid on an item?','To place a bid, go to the item page, enter your bid amount.','How to place a bid?','Placing a bid'),(2,2,NULL,'What payment methods are accepted on this platform?','We accept credit cards, debit cards, and PayPal for payments.','Payment methods','Accepted payment methods'),(3,3,NULL,'How are items shipped, and how much does shipping cost?','Shipping costs vary depending on the item and your location. You can find shipping information on the item page.','Shipping and handling','Shipping information'),(4,4,NULL,'What is the refund policy for items purchased on this platform?',NULL,'Refund policy',NULL),(5,5,NULL,'How long do auctions usually last?',NULL,'Auction duration',NULL);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `representatives`
--

DROP TABLE IF EXISTS `representatives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `representatives` (
  `idRep` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idRep`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `representatives`
--

LOCK TABLES `representatives` WRITE;
/*!40000 ALTER TABLE `representatives` DISABLE KEYS */;
INSERT INTO `representatives` VALUES (1,'Rep1','rep1@example.com','rep1_password','2023-04-26 00:54:02'),(2,'Rep2','rep2@example.com','rep2_password','2023-04-26 00:54:02'),(3,'Rep3','rep3@example.com','rep3_password','2023-04-26 00:54:02'),(4,'Rep4','rep4@example.com','rep4_password','2023-04-26 00:54:02'),(5,'Rep5','rep5@example.com','rep5_password','2023-04-26 00:54:02');
/*!40000 ALTER TABLE `representatives` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-28 23:28:10
