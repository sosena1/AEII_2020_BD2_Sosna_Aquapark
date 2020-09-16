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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-16 20:57:20
