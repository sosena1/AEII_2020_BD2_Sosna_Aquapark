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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-16 20:57:20
