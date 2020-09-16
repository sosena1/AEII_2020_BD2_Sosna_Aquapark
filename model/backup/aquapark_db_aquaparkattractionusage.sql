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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-16 20:57:20
