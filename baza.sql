/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.21-MariaDB : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `seminarski`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `AdministratorID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(100) NOT NULL,
  `Prezime` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `administrator` */

insert  into `administrator`(`AdministratorID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Admin','Admin','admin','admin'),
(2,'Aleksa','Djordjevic','aleksa','aleksa');

/*Table structure for table `pecivo` */

DROP TABLE IF EXISTS `pecivo`;

CREATE TABLE `pecivo` (
  `PecivoID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivPeciva` varchar(50) NOT NULL,
  `CenaPoKomadu` decimal(7,2) NOT NULL,
  `Opis` varchar(200) NOT NULL,
  `TipPecivaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`PecivoID`),
  KEY `fk_tipPeciva` (`TipPecivaID`),
  CONSTRAINT `fk_tipPeciva` FOREIGN KEY (`TipPecivaID`) REFERENCES `tippeciva` (`TipPecivaID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pecivo` */

insert  into `pecivo`(`PecivoID`,`NazivPeciva`,`CenaPoKomadu`,`Opis`,`TipPecivaID`) values 
(1,'Sava hleb',55.00,'Sava hleb',1),
(2,'Burek sa sirom',200.00,'Ukusan burek sa sirom pravljen po tradicionalnom receptu.',2),
(3,'Kroasan punjen džemom od jagode',90.00,'Sladak i ukusan kroasan punjen domacim džemom od jagode',4),
(5,'Burek sa mesom',200.00,'Domaci burek sa svežim mesom',2);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `RacunID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Vreme` datetime NOT NULL,
  `Cena` decimal(7,2) NOT NULL,
  `KolicinskiRabat` decimal(7,2) NOT NULL,
  `KonacnaCena` decimal(7,2) NOT NULL,
  `AdministratorID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`RacunID`),
  KEY `fk_administrator` (`AdministratorID`),
  CONSTRAINT `fk_administrator` FOREIGN KEY (`AdministratorID`) REFERENCES `administrator` (`AdministratorID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `racun` */

insert  into `racun`(`RacunID`,`Vreme`,`Cena`,`KolicinskiRabat`,`KonacnaCena`,`AdministratorID`) values 
(1,'2023-08-24 23:55:57',2550.00,20.00,2040.00,2),
(2,'2023-08-25 15:51:11',110.00,0.00,110.00,2),
(3,'2023-08-25 20:50:04',550.00,10.00,495.00,2);

/*Table structure for table `sastojak` */

DROP TABLE IF EXISTS `sastojak`;

CREATE TABLE `sastojak` (
  `PecivoID` bigint(10) unsigned NOT NULL,
  `Rb` int(7) NOT NULL,
  `NazivSastojka` varchar(40) NOT NULL,
  PRIMARY KEY (`PecivoID`,`Rb`),
  CONSTRAINT `fk_pecivo` FOREIGN KEY (`PecivoID`) REFERENCES `pecivo` (`PecivoID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sastojak` */

insert  into `sastojak`(`PecivoID`,`Rb`,`NazivSastojka`) values 
(1,1,'Kvasac'),
(1,2,'Belo brasno'),
(2,1,'Sir'),
(2,2,'Kore za pitu'),
(3,1,'Belo brasno '),
(3,2,'Džem od jagode'),
(3,3,'Kvasac'),
(5,1,'Kore za pitu'),
(5,2,'Mesno');

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `RacunID` bigint(10) unsigned NOT NULL,
  `RB` int(10) NOT NULL,
  `Kolicina` int(10) NOT NULL,
  `Cena` decimal(7,2) NOT NULL,
  `PecivoID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`RacunID`,`RB`),
  KEY `fk_pecivo1` (`PecivoID`),
  CONSTRAINT `fk_pecivo1` FOREIGN KEY (`PecivoID`) REFERENCES `pecivo` (`PecivoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_racun` FOREIGN KEY (`RacunID`) REFERENCES `racun` (`RacunID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`RacunID`,`RB`,`Kolicina`,`Cena`,`PecivoID`) values 
(1,1,10,550.00,1),
(1,3,5,1000.00,2),
(2,1,2,110.00,1),
(3,1,10,550.00,1);

/*Table structure for table `tippeciva` */

DROP TABLE IF EXISTS `tippeciva`;

CREATE TABLE `tippeciva` (
  `TipPecivaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`TipPecivaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tippeciva` */

insert  into `tippeciva`(`TipPecivaID`,`Naziv`) values 
(1,'Hleb'),
(2,'Burek'),
(3,'Kilfe'),
(4,'Slatka peciva');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
