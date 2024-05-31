CREATE DATABASE  IF NOT EXISTS `polyglotplanet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `polyglotplanet`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: polyglotplanet
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `carrello`
--

DROP TABLE IF EXISTS `carrello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrello` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `IDUtente` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDUtente` (`IDUtente`),
  CONSTRAINT `carrello_ibfk_1` FOREIGN KEY (`IDUtente`) REFERENCES `utente` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrello`
--

LOCK TABLES `carrello` WRITE;
/*!40000 ALTER TABLE `carrello` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colloquio`
--

DROP TABLE IF EXISTS `colloquio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colloquio` (
  `IDProdotto` int NOT NULL,
  `dataOra` datetime NOT NULL,
  `prenotato` tinyint(1) NOT NULL,
  `IDEsperto` int NOT NULL,
  `avvenuto` tinyint(1) NOT NULL,
  `votoUtente` int DEFAULT NULL,
  PRIMARY KEY (`IDProdotto`),
  KEY `IDEsperto` (`IDEsperto`),
  CONSTRAINT `colloquio_ibfk_1` FOREIGN KEY (`IDProdotto`) REFERENCES `prodotto` (`ID`),
  CONSTRAINT `colloquio_ibfk_2` FOREIGN KEY (`IDEsperto`) REFERENCES `esperto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colloquio`
--

LOCK TABLES `colloquio` WRITE;
/*!40000 ALTER TABLE `colloquio` DISABLE KEYS */;
/*!40000 ALTER TABLE `colloquio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `composizione`
--

DROP TABLE IF EXISTS `composizione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `composizione` (
  `IDOrdine` int NOT NULL,
  `IDProdotto` int NOT NULL,
  `dataOra` datetime NOT NULL,
  `prezzoAcquisto` double NOT NULL,
  PRIMARY KEY (`IDOrdine`,`IDProdotto`,`dataOra`),
  KEY `IDProdotto` (`IDProdotto`),
  CONSTRAINT `composizione_ibfk_1` FOREIGN KEY (`IDProdotto`) REFERENCES `prodotto` (`ID`),
  CONSTRAINT `composizione_ibfk_2` FOREIGN KEY (`IDOrdine`) REFERENCES `ordine` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composizione`
--

LOCK TABLES `composizione` WRITE;
/*!40000 ALTER TABLE `composizione` DISABLE KEYS */;
/*!40000 ALTER TABLE `composizione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conoscenza`
--

DROP TABLE IF EXISTS `conoscenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conoscenza` (
  `codISOLingua` char(2) NOT NULL,
  `IDEsperto` int NOT NULL,
  PRIMARY KEY (`codISOLingua`,`IDEsperto`),
  KEY `IDEsperto` (`IDEsperto`),
  CONSTRAINT `conoscenza_ibfk_1` FOREIGN KEY (`codISOLingua`) REFERENCES `lingua` (`codISOLingua`),
  CONSTRAINT `conoscenza_ibfk_2` FOREIGN KEY (`IDEsperto`) REFERENCES `esperto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conoscenza`
--

LOCK TABLES `conoscenza` WRITE;
/*!40000 ALTER TABLE `conoscenza` DISABLE KEYS */;
/*!40000 ALTER TABLE `conoscenza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corso`
--

DROP TABLE IF EXISTS `corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corso` (
  `IDProdotto` int NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `numeroUnita` int NOT NULL,
  `livello` char(2) NOT NULL,
  `codISOLingua` char(2) NOT NULL,
  PRIMARY KEY (`IDProdotto`),
  KEY `codISOLingua` (`codISOLingua`),
  CONSTRAINT `corso_ibfk_1` FOREIGN KEY (`IDProdotto`) REFERENCES `prodotto` (`ID`),
  CONSTRAINT `corso_ibfk_2` FOREIGN KEY (`codISOLingua`) REFERENCES `lingua` (`codISOLingua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corso`
--

LOCK TABLES `corso` WRITE;
/*!40000 ALTER TABLE `corso` DISABLE KEYS */;
/*!40000 ALTER TABLE `corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esperto`
--

DROP TABLE IF EXISTS `esperto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esperto` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `passwordHash` varchar(50) NOT NULL,
  `dataNascita` date NOT NULL,
  `genere` char(1) NOT NULL,
  `valutazione` int DEFAULT NULL,
  `fotoRiconoscitiva` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esperto`
--

LOCK TABLES `esperto` WRITE;
/*!40000 ALTER TABLE `esperto` DISABLE KEYS */;
/*!40000 ALTER TABLE `esperto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formazione`
--

DROP TABLE IF EXISTS `formazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formazione` (
  `IDCarrello` int NOT NULL,
  `IDProdotto` int NOT NULL,
  PRIMARY KEY (`IDCarrello`,`IDProdotto`),
  KEY `IDProdotto` (`IDProdotto`),
  CONSTRAINT `formazione_ibfk_1` FOREIGN KEY (`IDCarrello`) REFERENCES `carrello` (`ID`),
  CONSTRAINT `formazione_ibfk_2` FOREIGN KEY (`IDProdotto`) REFERENCES `prodotto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formazione`
--

LOCK TABLES `formazione` WRITE;
/*!40000 ALTER TABLE `formazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `formazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incontro`
--

DROP TABLE IF EXISTS `incontro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incontro` (
  `IDProdotto` int NOT NULL,
  `dataOra` datetime NOT NULL,
  `CAP` varchar(20) NOT NULL,
  `via` varchar(50) NOT NULL,
  `civico` varchar(10) NOT NULL,
  `prenotato` tinyint(1) NOT NULL,
  `IDEsperto` int NOT NULL,
  `avvenuto` tinyint(1) NOT NULL,
  `votoUtente` int DEFAULT NULL,
  PRIMARY KEY (`IDProdotto`),
  KEY `IDEsperto` (`IDEsperto`),
  CONSTRAINT `incontro_ibfk_1` FOREIGN KEY (`IDProdotto`) REFERENCES `prodotto` (`ID`),
  CONSTRAINT `incontro_ibfk_2` FOREIGN KEY (`IDEsperto`) REFERENCES `esperto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incontro`
--

LOCK TABLES `incontro` WRITE;
/*!40000 ALTER TABLE `incontro` DISABLE KEYS */;
/*!40000 ALTER TABLE `incontro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lingua`
--

DROP TABLE IF EXISTS `lingua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lingua` (
  `codISOLingua` char(2) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `parlanti` int NOT NULL,
  `fotoStatoOrigine` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codISOLingua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lingua`
--

LOCK TABLES `lingua` WRITE;
/*!40000 ALTER TABLE `lingua` DISABLE KEYS */;
INSERT INTO `lingua` VALUES ('AF','afrikaans',7,'img/stati/sudafrica.png'),('AZ','azerbaigiano',24,'img/stati/azerbaigian.png'),('BE','bielorusso',8,'img/stati/bielorussia.png'),('BG','bulgaro',8,'img/stati/bulgaria.png'),('BS','bosniaco',2,'img/stati/bosnia.png'),('CA','catalano',5,'img/stati/catalogna.png'),('CS','ceco',11,'img/stati/cechia.png'),('CY','gallese',1,'img/stati/galles.png'),('DA','danese',6,'img/stati/danimarca.png'),('DE','tedesco',77,'img/stati/germania.png'),('EL','greco',13,'img/stati/grecia.png'),('EN','inglese',370,'img/stati/uk.png'),('ES','spagnolo',471,'img/stati/spagna.png'),('ET','estone',1,'img/stati/estonia.png'),('EU','basco',1,'img/stati/euskadi.png'),('FI','finlandese',6,'img/stati/finlandia.png'),('FO','faroense',0,'img/stati/isole_far_oer.png'),('FR','francese',80,'img/stati/francia.png'),('GA','irlandese',2,'img/stati/irlanda.png'),('HI','hindi',342,'img/stati/india.png'),('HR','croato',6,'img/stati/croazia.png'),('HU','ungherese',13,'img/stati/ungheria.png'),('HY','armeno',6,'img/stati/armenia.png'),('IS','islandese',0,'img/stati/islanda.png'),('IT','italiano',65,'img/stati/italia.png'),('JA','giapponese',126,'img/stati/giappone.png'),('KA','georgiano',4,'img/stati/georgia.png'),('KO','coreano',82,'img/stati/corea_del_sud.png'),('LT','lituano',3,'img/stati/lituania.png'),('LV','lettone',2,'img/stati/lettonia.png'),('MK','macedone',4,'img/stati/macedonia_del_nord.png'),('NL','olandese',23,'img/stati/paesi_bassi.png'),('NO','norvegese',4,'img/stati/norvegia.png'),('PL','polacco',40,'img/stati/polonia.png'),('PT','portoghese',232,'img/stati/portogallo.png'),('RO','rumeno',25,'img/stati/romania.png'),('RU','russo',154,'img/stati/russia.png'),('SK','slovacco',5,'img/stati/slovacchia.png'),('SL','sloveno',3,'img/stati/slovenia.png'),('SQ','albanese',1,'img/stati/albania.png'),('SR','serbo',6,'img/stati/serbia.png'),('SV','svedese',9,'img/stati/svezia.png'),('TR','turco',82,'img/stati/turchia.png'),('UK','ucraino',27,'img/stati/ucraina.png'),('ZH','cinese',921,'img/stati/cina.png');
/*!40000 ALTER TABLE `lingua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordine`
--

DROP TABLE IF EXISTS `ordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `prezzoTotale` double NOT NULL,
  `IDUtente` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDUtente` (`IDUtente`),
  CONSTRAINT `ordine_ibfk_1` FOREIGN KEY (`IDUtente`) REFERENCES `utente` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotto` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `prezzoBase` double NOT NULL,
  `scontoPercentuale` double NOT NULL,
  `IDCategoria` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDCategoria` (`IDCategoria`),
  CONSTRAINT `prodotto_ibfk_1` FOREIGN KEY (`IDCategoria`) REFERENCES `categoria` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `dataNascita` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `passwordHash` varchar(50) NOT NULL,
  `genere` char(1) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Gianfranco','Vitiello','2024-05-03','giavit7@gmail.com','15354e5c217608d5f74eec2f5d379907a6e422a2','M',0),(2,'Sebastiano','Caliendo','2024-05-17','sebcal2@gmail.com','36111b97be6d7b2a9e38c71184b8bf39f6d463a4','M',0),(3,'Matteo','Politano','2003-06-06','matpol89@gmail.com','ee8f7e3e8ad8fc98eeef0f68e972ae17f73664cf','M',1);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'polyglotplanet'
--

--
-- Dumping routines for database 'polyglotplanet'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-31  8:07:46
