-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`end_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`end_user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`end_user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`auction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`auction` ;

CREATE TABLE IF NOT EXISTS `mydb`.`auction` (
  `idItem` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `enddate` DATETIME NOT NULL,
  `initialprice` DOUBLE(9,2) NOT NULL,
  `increment` DOUBLE(9,2) NOT NULL,
  `minimumprice` DOUBLE(9,2) NULL,
  `description` LONGTEXT NOT NULL,
  `seller` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`idItem`),
  INDEX `seller_idx` (`seller` ASC) VISIBLE,
  CONSTRAINT `seller`
    FOREIGN KEY (`seller`)
    REFERENCES `mydb`.`end_user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bid`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`bid` ;

CREATE TABLE IF NOT EXISTS `mydb`.`bid` (
  `idItem` INT NOT NULL,
  `idUser` INT NOT NULL,
  `price` DOUBLE(9,2) NULL,
  PRIMARY KEY (`idItem`, `idUser`),
  INDEX `idUser_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `idItem_bid`
    FOREIGN KEY (`idItem`)
    REFERENCES `mydb`.`auction` (`idItem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idUser_bid`
    FOREIGN KEY (`idUser`)
    REFERENCES `mydb`.`end_user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`autobid`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`autobid` ;

CREATE TABLE IF NOT EXISTS `mydb`.`autobid` (
  `idItem` INT NOT NULL,
  `idUser` INT NOT NULL,
  `upperlimit` DOUBLE(9,2) NULL,
  PRIMARY KEY (`idItem`, `idUser`),
  INDEX `idUser_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `idItem_autobid`
    FOREIGN KEY (`idItem`)
    REFERENCES `mydb`.`auction` (`idItem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idUser_autobid`
    FOREIGN KEY (`idUser`)
    REFERENCES `mydb`.`end_user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`representatives`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`representatives` ;

CREATE TABLE IF NOT EXISTS `mydb`.`representatives` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);


-- -----------------------------------------------------
-- Table `mydb`.`administrative_stuff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`administrative_stuff` ;

CREATE TABLE IF NOT EXISTS `mydb`.`administrative_stuff` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);


-- -----------------------------------------------------
-- Table `mydb`.`property`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`property` ;

CREATE TABLE IF NOT EXISTS `mydb`.`property` (
  `idproperty` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproperty`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`itemProperty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`itemProperty` ;

CREATE TABLE IF NOT EXISTS `mydb`.`itemProperty` (
  `idItem` INT NOT NULL,
  `idproperty` INT NOT NULL,
  `describtion` VARCHAR(45) NULL,
  PRIMARY KEY (`idItem`, `idproperty`),
  INDEX `property_idx` (`idproperty` ASC) VISIBLE,
  CONSTRAINT `item_itemp`
    FOREIGN KEY (`idItem`)
    REFERENCES `mydb`.`auction` (`idItem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `property_itemp`
    FOREIGN KEY (`idproperty`)
    REFERENCES `mydb`.`property` (`idproperty`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`alert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alert` ;

CREATE TABLE IF NOT EXISTS `mydb`.`alert` (
  `idalert` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idalert`, `idUser`),
  INDEX `idUser_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `idUser_alert`
    FOREIGN KEY (`idUser`)
    REFERENCES `mydb`.`end_user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`alertproperty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alertproperty` ;

CREATE TABLE IF NOT EXISTS `mydb`.`alertproperty` (
  `idalert` INT NOT NULL,
  `idproperty` INT NOT NULL,
  `detail` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idalert`, `idproperty`),
  INDEX `property_idx` (`idproperty` ASC) VISIBLE,
  CONSTRAINT `alert_prop`
    FOREIGN KEY (`idalert`)
    REFERENCES `mydb`.`alert` (`idalert`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `property_prop`
    FOREIGN KEY (`idproperty`)
    REFERENCES `mydb`.`property` (`idproperty`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
