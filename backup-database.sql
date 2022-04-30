/*
	Création des tables pour la base de données superheroes
*/
DROP DATABASE IF EXISTS `superheroes`;
CREATE DATABASE `superheroes`;
USE `superheroes`;
/*
	Table Hero
*/
DROP TABLE IF EXISTS `hero`;
CREATE TABLE `hero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `incidents` varchar(45) NOT NULL,
  `home` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

INSERT INTO `hero` VALUES (1,'GregLeHero','5,7,3','49.309451812998255, 1.0061058294793028','07 83 89 02 76');

/*
	Table IncidentType
*/
DROP TABLE IF EXISTS `incidenttype`;
CREATE TABLE `incidenttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `incidentName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `incidenttype` VALUES (1,'Incendie'),(2,'Accident routier'),(3,'Accident fluviale'),(4,'Accident a├®rien'),(5,'Eboulement'),(6,'Invasion de serpent'),(7,'Fuite de gaz'),(8,'Manifestation'),(9,'Braquage'),(10,'Evasion d\'un prisionnier');

/*
	Table Incident
*/
DROP TABLE IF EXISTS `incident`;
CREATE TABLE `incident` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `incidentType` int(11) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `lattitudeLongitude` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_incident_incidentType` (`incidentType`),
  CONSTRAINT `fk_incident_incidentType` FOREIGN KEY (`incidentType`) REFERENCES `incidenttype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
