-- MySQL dump 10.13  Distrib 5.5.24, for osx10.6 (i386)
--
-- Host: localhost    Database: bancoSMH
-- ------------------------------------------------------
-- Server version	5.5.24

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
  CONSTRAINT `FK14DFC4012357E1E0` FOREIGN KEY (`post_id`) REFERENCES `Post` (`id`),
  CONSTRAINT `FK14DFC401EE26A36F` FOREIGN KEY (`owner_id`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comentario`
--

LOCK TABLES `Comentario` WRITE;
/*!40000 ALTER TABLE `Comentario` DISABLE KEYS */;
INSERT INTO `Comentario` VALUES (5,'Mussum ipsum! Que legal!','2012-11-08 18:10:11',1,2),(6,'Bacon Ipsum!!','2012-11-08 18:11:23',1,1);
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
  `title` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `contentTextile` longtext,
  PRIMARY KEY (`id`),
  KEY `FK260CC07CC97210` (`owner_id`),
  KEY `FK260CC0EE26A36F` (`owner_id`),
  CONSTRAINT `FK260CC07CC97210` FOREIGN KEY (`owner_id`) REFERENCES `Usuario` (`id`),
  CONSTRAINT `FK260CC0EE26A36F` FOREIGN KEY (`owner_id`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post`
--

LOCK TABLES `Post` WRITE;
/*!40000 ALTER TABLE `Post` DISABLE KEYS */;
INSERT INTO `Post` VALUES (1,'<p>Bacon ipsum dolor sit amet swine cow pig venison, pork loin shoulder salami pork belly rump tongue ham hock. T-bone rump tri-tip short loin short ribs doner ham hock, brisket boudin meatloaf cow frankfurter spare ribs capicola bresaola. Strip steak cow jerky meatloaf, pastrami pork loin capicola venison. Capicola bacon ball tip ham hock pig cow. Meatloaf shankle beef turducken. Kielbasa tri-tip doner frankfurter, short loin hamburger jerky boudin short ribs. Fatback andouille rump cow tail jerky.</p>\n\n	<p>Beef ribs pork chop chicken doner, flank boudin spare ribs t-bone meatloaf cow tri-tip. Boudin pancetta ham hock, pig ribeye chuck pastrami turducken fatback pork belly sausage tri-tip tenderloin chicken. Shankle pork t-bone flank, spare ribs tenderloin pancetta biltong. Short ribs ham shankle tri-tip pork chop.</p>\n\n	<p>Tongue kielbasa meatball sirloin, short loin salami shoulder ham hock filet mignon jerky. Ham hock hamburger doner, beef turducken ribeye tenderloin short loin pork belly biltong cow. Sausage ball tip t-bone, cow tail pig swine. Bacon filet mignon hamburger, cow pastrami andouille sirloin jowl chicken boudin venison tail pork belly. Sirloin capicola shank ham hock, shankle frankfurter spare ribs andouille kielbasa tail beef pastrami.</p>','2012-11-08 18:11:10','Testando Post 2',1,'Bacon ipsum dolor sit amet swine cow pig venison, pork loin shoulder salami pork belly rump tongue ham hock. T-bone rump tri-tip short loin short ribs doner ham hock, brisket boudin meatloaf cow frankfurter spare ribs capicola bresaola. Strip steak cow jerky meatloaf, pastrami pork loin capicola venison. Capicola bacon ball tip ham hock pig cow. Meatloaf shankle beef turducken. Kielbasa tri-tip doner frankfurter, short loin hamburger jerky boudin short ribs. Fatback andouille rump cow tail jerky.\r\n\r\nBeef ribs pork chop chicken doner, flank boudin spare ribs t-bone meatloaf cow tri-tip. Boudin pancetta ham hock, pig ribeye chuck pastrami turducken fatback pork belly sausage tri-tip tenderloin chicken. Shankle pork t-bone flank, spare ribs tenderloin pancetta biltong. Short ribs ham shankle tri-tip pork chop.\r\n\r\nTongue kielbasa meatball sirloin, short loin salami shoulder ham hock filet mignon jerky. Ham hock hamburger doner, beef turducken ribeye tenderloin short loin pork belly biltong cow. Sausage ball tip t-bone, cow tail pig swine. Bacon filet mignon hamburger, cow pastrami andouille sirloin jowl chicken boudin venison tail pork belly. Sirloin capicola shank ham hock, shankle frankfurter spare ribs andouille kielbasa tail beef pastrami.'),(2,'<p>Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.</p>\n\n	<p>Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Interagi no mé, cursus quis, vehicula ac nisi. Aenean vel dui dui. Nullam leo erat, aliquet quis tempus a, posuere ut mi. Ut scelerisque neque et turpis posuere pulvinar pellentesque nibh ullamcorper. Pharetra in mattis molestie, volutpat elementum justo. Aenean ut ante turpis. Pellentesque laoreet mé vel lectus scelerisque interdum cursus velit auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ac mauris lectus, non scelerisque augue. Aenean justo massa.</p>\n\n	<p>Casamentiss faiz malandris se pirulitá, Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer Ispecialista im mé intende tudis nuam golada, vinho, uiski, carirí, rum da jamaikis, só num pode ser mijis. Adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>','2012-11-08 18:09:02','Testando Post 1',1,'Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.\r\n\r\nSuco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Interagi no mé, cursus quis, vehicula ac nisi. Aenean vel dui dui. Nullam leo erat, aliquet quis tempus a, posuere ut mi. Ut scelerisque neque et turpis posuere pulvinar pellentesque nibh ullamcorper. Pharetra in mattis molestie, volutpat elementum justo. Aenean ut ante turpis. Pellentesque laoreet mé vel lectus scelerisque interdum cursus velit auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ac mauris lectus, non scelerisque augue. Aenean justo massa.\r\n\r\nCasamentiss faiz malandris se pirulitá, Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer Ispecialista im mé intende tudis nuam golada, vinho, uiski, carirí, rum da jamaikis, só num pode ser mijis. Adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('Admin',1,'nenhumPorEnquanto','root','Joaquim','','7b24afc8bc80e548d66c4e7ff72171c5');
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

-- Dump completed on 2012-11-08 18:15:46
