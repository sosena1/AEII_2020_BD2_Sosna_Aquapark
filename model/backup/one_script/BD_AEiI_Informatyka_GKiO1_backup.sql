-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: aquapark_db
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `aquaparkattraction`
--

DROP TABLE IF EXISTS `aquaparkattraction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aquaparkattraction` (
  `attractionId` int NOT NULL AUTO_INCREMENT,
  `maxUsers` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`attractionId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aquaparkattraction`
--

LOCK TABLES `aquaparkattraction` WRITE;
/*!40000 ALTER TABLE `aquaparkattraction` DISABLE KEYS */;
INSERT INTO `aquaparkattraction` VALUES (1,20,'Pool'),(2,30,'Slide'),(3,30,'Big pool');
/*!40000 ALTER TABLE `aquaparkattraction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aquaparkattractiongate`
--

DROP TABLE IF EXISTS `aquaparkattractiongate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aquaparkattractiongate` (
  `gateId` int NOT NULL AUTO_INCREMENT,
  `attractionId` int NOT NULL,
  PRIMARY KEY (`gateId`),
  KEY `fk_aquaparkattractiongate_aquaparkattraction_idx` (`attractionId`),
  CONSTRAINT `fk_aquaparkattractiongate_aquaparkattraction` FOREIGN KEY (`attractionId`) REFERENCES `aquaparkattraction` (`attractionId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aquaparkattractiongate`
--

LOCK TABLES `aquaparkattractiongate` WRITE;
/*!40000 ALTER TABLE `aquaparkattractiongate` DISABLE KEYS */;
INSERT INTO `aquaparkattractiongate` VALUES (1,1),(2,2),(5,2),(3,3),(4,3);
/*!40000 ALTER TABLE `aquaparkattractiongate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aquaparkattractiongateevent`
--

DROP TABLE IF EXISTS `aquaparkattractiongateevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aquaparkattractiongateevent` (
  `eventId` int NOT NULL AUTO_INCREMENT,
  `isEntering` tinyint NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `gateId` int NOT NULL,
  `identificatorId` int NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `fk_aquaparkattractiongateevent_aquaparkattractiongate_idx` (`gateId`) /*!80000 INVISIBLE */,
  KEY `fk_aquaparkattractiongateevent_clientidentificator_idx` (`identificatorId`),
  CONSTRAINT `fk_aquaparkattractiongateevent_aquaparkattractiongate` FOREIGN KEY (`gateId`) REFERENCES `aquaparkattractiongate` (`gateId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_aquaparkattractiongateevent_clientidentificator` FOREIGN KEY (`identificatorId`) REFERENCES `clientidentificator` (`identificatorId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aquaparkattractiongateevent`
--

LOCK TABLES `aquaparkattractiongateevent` WRITE;
/*!40000 ALTER TABLE `aquaparkattractiongateevent` DISABLE KEYS */;
INSERT INTO `aquaparkattractiongateevent` VALUES (1,1,'2020-08-06','11:00:00',2,1),(2,0,'2020-08-06','13:00:00',2,1),(3,1,'2020-08-09','11:40:00',2,2),(4,0,'2020-08-09','13:50:00',2,2),(5,1,'2020-08-09','08:40:00',1,3),(6,0,'2020-08-09','11:50:00',1,3),(7,1,'2020-08-09','17:45:00',3,4),(8,0,'2020-08-09','18:53:00',3,4),(9,1,'2020-08-09','09:52:00',5,5),(10,0,'2020-08-09','13:38:00',2,6),(11,0,'2020-08-09','13:40:00',2,7),(12,0,'2020-08-09','15:39:00',3,6);
/*!40000 ALTER TABLE `aquaparkattractiongateevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aquaparkattractionmaintenance`
--

DROP TABLE IF EXISTS `aquaparkattractionmaintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aquaparkattractionmaintenance` (
  `attractionMaintenanceId` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `date` date NOT NULL,
  `employeeId` int NOT NULL,
  `attractionId` int NOT NULL,
  PRIMARY KEY (`attractionMaintenanceId`),
  KEY `fk_aquaparkattractionmaintenance_employee_idx` (`employeeId`) /*!80000 INVISIBLE */,
  KEY `fk_aquaparkattractionmaintenance_aquaparkattraction_idx` (`attractionId`),
  CONSTRAINT `fk_aquaparkattractionmaintenance_aquaparkattraction` FOREIGN KEY (`attractionId`) REFERENCES `aquaparkattraction` (`attractionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_aquaparkattractionmaintenance_employee` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aquaparkattractionmaintenance`
--

LOCK TABLES `aquaparkattractionmaintenance` WRITE;
/*!40000 ALTER TABLE `aquaparkattractionmaintenance` DISABLE KEYS */;
INSERT INTO `aquaparkattractionmaintenance` VALUES (1,'Cleaning','2019-08-31',2,3),(2,'Water change','2020-02-09',2,3),(3,'Repair','2019-07-21',1,3),(4,'Modernization','2020-02-22',2,2),(5,'Water quality test','2019-11-14',2,2),(6,'Repair','2020-01-22',4,3),(7,'Cleaning','2012-10-14',5,3);
/*!40000 ALTER TABLE `aquaparkattractionmaintenance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aquaparkattractionusage`
--

DROP TABLE IF EXISTS `aquaparkattractionusage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aquaparkattractionusage` (
  `usageId` int NOT NULL AUTO_INCREMENT,
  `attractionId` int NOT NULL,
  `priceListItemId` int NOT NULL,
  `visitId` int NOT NULL,
  `enteringEventId` int NOT NULL,
  `leavingEventId` int DEFAULT NULL,
  PRIMARY KEY (`usageId`),
  KEY `fk_aquaparkattracionusage_aquaparkattraction_idx` (`attractionId`) /*!80000 INVISIBLE */,
  KEY `fk_aquaparkattracionusage_pricelistitem_idx` (`priceListItemId`),
  KEY `fk_aquaparkattracionusage_visit_idx` (`visitId`),
  KEY `fk_aquaparkattracionusage_aquaparkattractiongateevent_enter_idx` (`enteringEventId`) /*!80000 INVISIBLE */,
  KEY `fk_aquaparkattracionusage_aquaparkattractiongateevent_leave_idx` (`leavingEventId`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_aquaparkattracionusage_aquaparkattraction` FOREIGN KEY (`attractionId`) REFERENCES `aquaparkattraction` (`attractionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_aquaparkattracionusage_aquaparkattractiongateevent_enter` FOREIGN KEY (`enteringEventId`) REFERENCES `aquaparkattractiongateevent` (`eventId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_aquaparkattracionusage_aquaparkattractiongateevent_leave` FOREIGN KEY (`leavingEventId`) REFERENCES `aquaparkattractiongateevent` (`eventId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_aquaparkattracionusage_pricelistitem` FOREIGN KEY (`priceListItemId`) REFERENCES `pricelistitem` (`priceListItemId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_aquaparkattracionusage_visit` FOREIGN KEY (`visitId`) REFERENCES `visit` (`visitId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aquaparkattractionusage`
--

LOCK TABLES `aquaparkattractionusage` WRITE;
/*!40000 ALTER TABLE `aquaparkattractionusage` DISABLE KEYS */;
INSERT INTO `aquaparkattractionusage` VALUES (1,2,1,1,1,2),(2,2,1,2,3,4),(3,1,2,3,5,6),(4,3,2,4,7,8),(5,2,3,5,9,10);
/*!40000 ALTER TABLE `aquaparkattractionusage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `clientId` int NOT NULL AUTO_INCREMENT,
  `ownsAccount` tinyint NOT NULL,
  `userId` int NOT NULL,
  PRIMARY KEY (`clientId`),
  KEY `fk_client_user_idx` (`userId`),
  CONSTRAINT `fk_client_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,0,1),(2,1,3),(3,1,5),(4,0,7),(5,1,10),(6,0,4),(7,1,6);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientidentificator`
--

DROP TABLE IF EXISTS `clientidentificator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientidentificator` (
  `identificatorId` int NOT NULL AUTO_INCREMENT,
  `isInUse` tinyint NOT NULL,
  PRIMARY KEY (`identificatorId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientidentificator`
--

LOCK TABLES `clientidentificator` WRITE;
/*!40000 ALTER TABLE `clientidentificator` DISABLE KEYS */;
INSERT INTO `clientidentificator` VALUES (1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0);
/*!40000 ALTER TABLE `clientidentificator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conditions`
--

DROP TABLE IF EXISTS `conditions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conditions` (
  `conditionId` int NOT NULL AUTO_INCREMENT,
  `weekendOnly` tinyint NOT NULL,
  `childOnly` tinyint NOT NULL,
  `seniorOnly` tinyint NOT NULL,
  PRIMARY KEY (`conditionId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conditions`
--

LOCK TABLES `conditions` WRITE;
/*!40000 ALTER TABLE `conditions` DISABLE KEYS */;
INSERT INTO `conditions` VALUES (1,1,0,0),(2,0,1,0),(3,0,0,1),(4,0,0,0);
/*!40000 ALTER TABLE `conditions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employeeId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `fk_employee_user_idx` (`userId`),
  CONSTRAINT `fk_employee_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (3,2),(1,5),(2,7),(4,8),(5,9);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `genderId` int NOT NULL AUTO_INCREMENT,
  `genderName` varchar(10) NOT NULL,
  PRIMARY KEY (`genderId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Female'),(2,'Male'),(3,'N/A');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pricelist`
--

DROP TABLE IF EXISTS `pricelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pricelist` (
  `priceListId` int NOT NULL AUTO_INCREMENT,
  `validityStartDate` date NOT NULL,
  `employeeId` int NOT NULL,
  PRIMARY KEY (`priceListId`),
  KEY `fk_pricelist_employee_idx` (`employeeId`),
  CONSTRAINT `fk_pricelist_employee` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricelist`
--

LOCK TABLES `pricelist` WRITE;
/*!40000 ALTER TABLE `pricelist` DISABLE KEYS */;
INSERT INTO `pricelist` VALUES (1,'2019-05-31',2),(2,'2019-07-02',1),(3,'2019-10-16',2);
/*!40000 ALTER TABLE `pricelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pricelistitem`
--

DROP TABLE IF EXISTS `pricelistitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pricelistitem` (
  `priceListItemId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `value` decimal(15,5) NOT NULL,
  `description` varchar(45) NOT NULL,
  `priceListId` int NOT NULL,
  `conditionalId` int NOT NULL,
  `attractionId` int NOT NULL,
  PRIMARY KEY (`priceListItemId`),
  KEY `fk_pricelistitem_conditions_idx` (`conditionalId`) /*!80000 INVISIBLE */,
  KEY `fk_pricelistitem_pricelist_idx` (`priceListId`) /*!80000 INVISIBLE */,
  KEY `fk_priceListItem_aquaparkattraction_idx` (`attractionId`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_priceListItem_aquaparkattraction_idx` FOREIGN KEY (`attractionId`) REFERENCES `aquaparkattraction` (`attractionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_pricelistitem_conditions` FOREIGN KEY (`conditionalId`) REFERENCES `conditions` (`conditionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_pricelistitem_pricelist` FOREIGN KEY (`priceListId`) REFERENCES `pricelist` (`priceListId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricelistitem`
--

LOCK TABLES `pricelistitem` WRITE;
/*!40000 ALTER TABLE `pricelistitem` DISABLE KEYS */;
INSERT INTO `pricelistitem` VALUES (1,'Pool',174.06000,'Pool price/All',1,4,1),(2,'Slide',72.18000,'Slide price/All',2,4,2),(3,'Pool',20.00000,'Pool price/Weekend',3,1,1),(4,'Pool',5.00000,'Pool price/Child',3,2,1),(5,'Pool',7.30000,'Pool price/Senior',3,3,1),(6,'Pool',10.20000,'Pool price/All',3,4,1),(7,'Slide',30.00000,'Slide price/Weekend',3,1,2),(8,'Slide',15.00000,'Slide price/Child',3,2,2),(9,'Slide',15.00000,'Slide price/Senior',3,3,2),(10,'Slide',15.00000,'Slide price/All',3,4,2),(11,'Big pool',20.00000,'Big pool price/Weekend',3,1,3),(12,'Big pool',10.20000,'Big pool price/Child',3,2,3),(13,'Big pool',5.50000,'Big pool price/Senior',3,3,3),(14,'Big pool',16.20000,'Big pool price/All',3,4,3);
/*!40000 ALTER TABLE `pricelistitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleId` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Cashier'),(2,'Gate'),(3,'AnonymousClient'),(4,'Client'),(5,'Maintainer'),(6,'Analyst'),(7,'PriceManager'),(8,'Owner'),(9,'SuperUser');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_has_employee`
--

DROP TABLE IF EXISTS `role_has_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_has_employee` (
  `roleId` int NOT NULL,
  `employeeId` int NOT NULL,
  PRIMARY KEY (`roleId`,`employeeId`),
  KEY `fk_Role_has_Employee_Employee1_idx` (`employeeId`),
  KEY `fk_Role_has_Employee_Role1_idx` (`roleId`),
  CONSTRAINT `employeeId` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_has_employee`
--

LOCK TABLES `role_has_employee` WRITE;
/*!40000 ALTER TABLE `role_has_employee` DISABLE KEYS */;
INSERT INTO `role_has_employee` VALUES (5,1),(1,2),(2,2),(5,2),(6,2),(7,2),(8,2),(3,3),(5,4),(5,5);
/*!40000 ALTER TABLE `role_has_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `contactNumber` varchar(45) DEFAULT NULL,
  `otherInformation` varchar(45) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `pesel` varchar(45) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `genderId` int NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `fk_user_gender_idx` (`genderId`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_user_gender` FOREIGN KEY (`genderId`) REFERENCES `gender` (`genderId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Mariel','Elener','3 Canary Place','749084822','1i395p30KU0LlQNo77t1','Landon','fvVbgTDC492','93139441283','1929-05-12',2),(2,'Mic','Meert','490 Gale Avenue','930174978','6E3L8j9452npx88rh144','Rodolfo','NvcdTBDF729','57557309332','1994-05-13',2),(3,'Aloin','Hew','755 Duke Terrace','569692874','33P4BSaS1r8cv1614104','Theo','coeWasgIuP072','01057686270','1971-08-10',2),(4,'Kassi','McCuaig','75 Elka Lane','056062630','5RCpr3al974Va2Ko7685','Zonia','SXfQ173','72813884844','2019-04-01',3),(5,'Kassey','Kobierski','7280 Russell Drive','908392332','363977F1j7L3k6B7dsB3','Sherman','sdYb203','20187632915','1988-09-02',1),(6,'Wain','Foss','861 Upham Drive','179955264','F5B51d62WRT7V9047F28','Cindie','oplzSD747','23186618323','1921-08-04',2),(7,'Jaquelin','Reboul','8 Delaware Junction','619535243','s7t6w3P831m33J31271o','Bethel','YxMnFhSUv630','42585405712','2018-07-16',3),(8,'Tamara','Gibben','82 Hallows Drive','796073444','XmOs2gg87Ks7iv8AVkZP','Mellie','EgNpYAvDao101','65283193734','1956-03-01',1),(9,'Mead','Sowle','3 High Crossing Junction','625283530','5x139Iv916gW7123F28D','Newton','lRHyXID467','40087205549','1961-06-18',2),(10,'Ramsey','Randal','86 Forster Pass','414392355','8XM98NCEzce74O9X5B0l','Charmaine','ryCnN277','08352120086','2008-01-23',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit` (
  `visitId` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time DEFAULT NULL,
  `value` decimal(15,5) NOT NULL,
  `identificatorId` int NOT NULL,
  `clientId` int NOT NULL,
  PRIMARY KEY (`visitId`),
  KEY `fk_visit_clientidentificator_idx` (`identificatorId`),
  KEY `fk_visit_user_idx` (`clientId`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_visit_clientidentificator` FOREIGN KEY (`identificatorId`) REFERENCES `clientidentificator` (`identificatorId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_visit_user` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
INSERT INTO `visit` VALUES (1,'2020-05-06','10:30:00','13:30:00',50.50000,1,1),(2,'2020-07-09','11:30:00','14:00:00',17.30000,2,2),(3,'2020-07-11','08:30:00','12:00:00',10.20000,3,2),(4,'2020-07-21','09:30:00','13:00:00',20.60000,5,4),(5,'2020-07-18','17:30:00','19:00:00',9.80000,4,3),(6,'2020-07-23','10:30:00','13:00:00',22.60000,7,6),(7,'2020-07-23','10:30:00','13:00:00',12.80000,6,7);
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'aquapark_db'
--

--
-- Dumping routines for database 'aquapark_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-16 20:58:07
