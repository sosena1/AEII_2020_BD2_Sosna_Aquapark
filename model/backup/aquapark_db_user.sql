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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-16 20:57:20
