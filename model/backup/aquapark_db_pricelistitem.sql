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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-16 20:57:20
