-- MySQL dump 10.13  Distrib 5.5.25a, for osx10.6 (i386)
--
-- Host: localhost    Database: bancosmh
-- ------------------------------------------------------
-- Server version	5.5.25a

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Comentario`
--

DROP TABLE IF EXISTS `Comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comentario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(150) NOT NULL,
  `dateOfCreation` datetime DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK14DFC4012357E1E0` (`post_id`),
  KEY `FK14DFC401EE26A36F` (`owner_id`),
  CONSTRAINT `FK14DFC401EE26A36F` FOREIGN KEY (`owner_id`) REFERENCES `Usuario` (`id`),
  CONSTRAINT `FK14DFC4012357E1E0` FOREIGN KEY (`post_id`) REFERENCES `Post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comentario`
--

LOCK TABLES `Comentario` WRITE;
/*!40000 ALTER TABLE `Comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post`
--

DROP TABLE IF EXISTS `Post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `dateOfCreation` datetime DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK260CC07CC97210` (`owner_id`),
  CONSTRAINT `FK260CC07CC97210` FOREIGN KEY (`owner_id`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post`
--

LOCK TABLES `Post` WRITE;
/*!40000 ALTER TABLE `Post` DISABLE KEYS */;
INSERT INTO `Post` VALUES (1,'Teste\r\nteste2','2012-11-07 02:37:32',2),(2,'Testetest','2012-11-07 02:41:49',2),(3,'Testetest','2012-11-07 02:42:11',2),(4,'Testetest\r\nTeste','2012-11-07 02:42:29',2),(5,'Teste','2012-11-07 02:44:03',NULL),(6,'Teste de postagem','2012-11-07 02:45:20',2),(7,'	<p>Teste 22</p>','2012-11-07 02:50:20',2),(8,'	<p>Teste 22</p>','2012-11-07 02:51:43',NULL),(9,'<p>Teste<br />\nteste alisosn <strong>negrito</strong> teste <em>teste</em><br />\nTeste 2</p>','2012-11-07 02:53:04',2),(10,'<p>Teste</p>\n\n	<p>teste alisosn <strong>negrito</strong> teste <em>teste</em></p>\n\n	<p>Teste 2</p>','2012-11-07 02:53:18',2),(11,'<p>Teste</p>\n\n	<p>Teste 2</p>\n\n	<p>Teste 3</p>','2012-11-07 02:57:09',2),(12,'<p>Teste 2</p>\n\n	<p>teste3</p>','2012-11-07 02:58:51',1);
/*!40000 ALTER TABLE `Post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `DTYPE` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('Usuario',1,NULL,'alissonperez@gmail.com','Alisson','Perez','202cb962ac59075b964b07152d234b70'),('Admin',2,NULL,'alissonperez2@gmail.com','Alisson ADM','Perez','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-07  3:07:11
