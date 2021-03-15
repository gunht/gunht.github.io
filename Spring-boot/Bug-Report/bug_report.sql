-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: bug_report
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `modified_at` datetime DEFAULT NULL,
  `commenter_id` bigint DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jh8ht3vtgr6ibapo4yxe81gr` (`commenter_id`),
  KEY `FKh4c7lvsc298whoyd4w9ta25cr` (`post_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK4jh8ht3vtgr6ibapo4yxe81gr` FOREIGN KEY (`commenter_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKh4c7lvsc298whoyd4w9ta25cr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Cái này chịu thôi mình cũng không biết nữa!','2021-03-14 08:20:06',NULL,1,12,NULL);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(5000) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `image1` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `image3` varchar(255) DEFAULT NULL,
  `modified_at` datetime DEFAULT NULL,
  `title` varchar(300) NOT NULL,
  `created_by_id` bigint DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2pi26lplw3d2i5w7ueidhb981` (`created_by_id`),
  KEY `FK5syv2sal7orecv10vvb54tbkv` (`status_id`),
  KEY `FK5lidm6cqbc7u4xhqpxm898qme` (`user_id`),
  CONSTRAINT `FK2pi26lplw3d2i5w7ueidhb981` FOREIGN KEY (`created_by_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK5lidm6cqbc7u4xhqpxm898qme` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK5syv2sal7orecv10vvb54tbkv` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Điện thoại bị lỗi nhấp nháy ánh sáng trên Iphone','2021-03-14 05:45:04','no-image.png','no-image.png','no-image.png',NULL,'Lỗi nhấp nháy ánh sáng khi quay video trên iPhone',2,1,NULL),(2,'Lỗi youtube','2021-03-14 08:14:50','no-image.png','no-image.png','no-image.png',NULL,'Lỗi cấp quyền ứng dụng Youtube',2,1,NULL),(3,'Máy kết nối internet không ổn định!','2021-03-14 08:15:29','no-image.png','no-image.png','no-image.png',NULL,'Kết nối mạng không ổn định',2,1,NULL),(4,'Lỗi không tải được ','2021-03-14 08:15:57','no-image.png','no-image.png','no-image.png',NULL,'Không tải được video từ Youtube',2,1,NULL),(5,'Lỗi bị văng ứng dụng','2021-03-14 08:16:21','no-image.png','no-image.png','no-image.png',NULL,'Ứng dụng đang dùng thì bị văng trên Iphun',2,1,NULL),(6,'Lỗi không xem được video','2021-03-14 08:16:44','no-image.png','no-image.png','no-image.png',NULL,'Không xem được video trên điện thoại Hứa Wei',2,1,NULL),(7,'Lỗi khó hiểu','2021-03-14 08:17:04','no-image.png','no-image.png','no-image.png',NULL,'Không upload được video lên youtube',2,1,NULL),(8,'Lỗi treo logo trên điện thoại mì xào','2021-03-14 08:17:32','no-image.png','no-image.png','no-image.png',NULL,'Điện thoại mì xào đang dùng thì bị treo logo',2,1,NULL),(9,'đang chơi game máy hỏng luôn','2021-03-14 08:18:06','no-image.png','no-image.png','no-image.png',NULL,'Samsung bị đột tử khi đang chơi PUBG:O ',2,1,NULL),(10,'Momo bị lỗi','2021-03-14 08:18:37','no-image.png','no-image.png','no-image.png',NULL,'Lỗi không chuyển tiền được trên MOMO',2,1,NULL),(11,'điện thoại không vào được chplay','2021-03-14 08:19:07','no-image.png','no-image.png','no-image.png',NULL,'Điện thoại oppo không vào được CHPlay help help',2,1,NULL),(12,'Lỗi kính thông minh','2021-03-14 08:19:28','no-image.png','no-image.png','no-image.png','2021-03-14 08:28:50','Kính thông mình của google không thông minh nữa',2,3,NULL);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'EDITOR'),(3,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Not Fixed'),(2,'Fixed'),(3,'Escalated');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `full_name` varchar(200) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2021-03-06 10:56:12','admin@gmail.com','ADMIN','$2a$10$pDvKXk3JNwwDS8YcKfRUTeaOzuTz6RLqzwtIGPa4hgeQBA4RnN.Hm',_binary ''),(2,'2021-03-06 10:57:12','user@gmail.com','USER','$2a$10$pDvKXk3JNwwDS8YcKfRUTeaOzuTz6RLqzwtIGPa4hgeQBA4RnN.Hm',_binary ''),(7,'2021-03-14 08:21:33','tungha@gmail.com','Tung Ha','$2a$10$4zkxVCZeDXP9fntAmdxf1eK7Stc5AT9v4da9ywVeqY13nmQIIVg3G',_binary ''),(8,'2021-03-14 08:24:24','mongmo@gmail.com','Nguyễn Thị Mộng Mơ','$2a$10$CjNcf0zZwXatQ2/jEsFHIeLi3qV0IBw4i5yeL6zTE17Sy7xu/fPv6',_binary ''),(9,'2021-03-14 08:27:20','hellokitty@gmail.com','Helo Kitty','$2a$10$SX78VHqEQX1cBMMkdavgDO8zr3T.rejviHmkH/uuTm3sc0/SzSAzS',_binary '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,3),(7,3),(8,3),(9,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-14 18:59:13
