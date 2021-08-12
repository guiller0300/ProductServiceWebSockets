-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: people2
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `notificacion`
--

DROP TABLE IF EXISTS `notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notificacion` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `subscriber` varchar(8) DEFAULT NULL,
  `titulo` varchar(30) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `leido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
INSERT INTO `notificacion` VALUES (1,'19221','Se insertó un nuevo producto','Aquí se agrega una descripcion breve de lo que se acaba de hacer (opcional)','2021-08-05 11:26:19','2021-08-06',0),(2,'20911','Se insertó un nuevo producto','Aquí se agrega una descripcion breve de lo que se acaba de hacer (opcional)','2021-08-05 11:26:19','2021-08-06',0),(3,'9913','Se insertó un nuevo producto','Aquí se agrega una descripcion breve de lo que se acaba de hacer (opcional)','2021-08-05 11:26:35','2021-08-06',0),(4,'10293','Se insertó un nuevo producto','Aquí se agrega una descripcion breve de lo que se acaba de hacer (opcional)','2021-08-05 11:26:35','2021-08-06',0),(5,'8188','Se insertó un nuevo producto','Aquí se agrega una descripcion breve de lo que se acaba de hacer (opcional)','2021-08-05 11:26:35','2021-08-06',1),(6,'9193','Se insertó un nuevo producto','Aquí se agrega una descripcion breve de lo que se acaba de hacer (opcional)','2021-08-05 11:26:35','2021-08-06',0),(7,'0','Se insertó un nuevo producto','Aquí se agrega una descripcion breve de lo que se acaba de hacer (opcional)','2021-08-05 11:28:48','2021-08-06',1);
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `subscriber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'a',200,'juan'),(2,'a',300,'juan'),(3,'a',200,'memo'),(4,'insertando producto',230,'juan'),(5,'insertando producto',230,'juan'),(6,'insertando producto',230,'juan'),(7,'a',200,'memo'),(8,'a',200,'memo'),(9,'a',200,'memo'),(10,'a',200,'memo'),(11,'a',200,'memo');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_transaction`
--

DROP TABLE IF EXISTS `user_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `transaction_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_transaction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_transaction`
--

LOCK TABLES `user_transaction` WRITE;
/*!40000 ALTER TABLE `user_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'sam',1000),(2,'mike',3000),(3,'jake',800),(4,'marshal',2000),(5,'sam',1000),(6,'mike',1200),(7,'jake',800),(8,'marshal',2000);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `departamento` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (8188,'Guillermo Guzmán','CF'),(9193,'Gerardo Martínez','CF'),(9913,'Judith Juarez','CA'),(10293,'Maria Romo','CA'),(19221,'Ernesto López','CO'),(20911,'Pedro Sánchez','CO');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-12  1:32:07
