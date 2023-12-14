-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kbt1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kbt1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kbt1` DEFAULT CHARACTER SET utf8 ;
USE `kbt1` ;

-- -----------------------------------------------------
-- Table `kbt1`.`family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kbt1`.`family` (
                                               `family_id` BIGINT NOT NULL AUTO_INCREMENT,
                                               `created_at` DATETIME NOT NULL,
                                               `modified_at` DATETIME NULL,
                                               PRIMARY KEY (`family_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kbt1`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kbt1`.`user` (
                                             `user_id` BIGINT NOT NULL AUTO_INCREMENT,
                                             ` user_name` VARCHAR(45) NULL,
    `family_id` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL,
    `modified_at` DATETIME NULL,
    PRIMARY KEY (`user_id`),
    INDEX `familyId_idx` (`family_id` ASC) VISIBLE,
    CONSTRAINT `user_familyId`
    FOREIGN KEY (`family_id`)
    REFERENCES `kbt1`.`family` (`family_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kbt1`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kbt1`.`account` (
                                                `account_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '시리얼 넘버',
                                                `user_id` BIGINT NOT NULL,
                                                `bank_name` VARCHAR(45) NOT NULL,
    `account_number` VARCHAR(45) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `modified_at` DATETIME NULL,
    PRIMARY KEY (`account_id`),
    INDEX `userId_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `account_userId`
    FOREIGN KEY (`user_id`)
    REFERENCES `kbt1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kbt1`.`transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kbt1`.`transfer` (
                                                 `transfer_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                 `amount` BIGINT NOT NULL,
                                                 `sender_id` BIGINT NOT NULL,
                                                 `receivcer_id` BIGINT NOT NULL,
                                                 `created_at` DATETIME NOT NULL,
                                                 `modified_at` DATETIME NULL,
                                                 PRIMARY KEY (`transfer_id`),
    INDEX `userId_idx` (`sender_id` ASC) VISIBLE,
    INDEX `transfer_receiverId_idx` (`receivcer_id` ASC) VISIBLE,
    CONSTRAINT `transfer_senderId`
    FOREIGN KEY (`sender_id`)
    REFERENCES `kbt1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `transfer_receiverId`
    FOREIGN KEY (`receivcer_id`)
    REFERENCES `kbt1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kbt1`.`relation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kbt1`.`relation` (
                                                 `relation_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                 `targeter_id` BIGINT NOT NULL,
                                                 `targeted_id` BIGINT NOT NULL,
                                                 `nickname` VARCHAR(45) NULL,
    `relation_type` INT NULL COMMENT '부 - 1\n모 - 2\n형제 - 3\n자식 - 4\n부인 - 5\n남편 - 6',
    `created_at` DATETIME NOT NULL,
    `modified_at` DATETIME NULL,
    PRIMARY KEY (`relation_id`),
    INDEX `userId_idx` (`targeter_id` ASC) VISIBLE,
    INDEX `relation_targetedId_idx` (`targeted_id` ASC) VISIBLE,
    CONSTRAINT `relation_targeterId`
    FOREIGN KEY (`targeter_id`)
    REFERENCES `kbt1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `relation_targetedId`
    FOREIGN KEY (`targeted_id`)
    REFERENCES `kbt1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kbt1`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kbt1`.`event` (
                                              `event_id` BIGINT NOT NULL AUTO_INCREMENT,
                                              `family_id` BIGINT NOT NULL,
                                              `title` VARCHAR(45) NULL,
    `content` VARCHAR(45) NULL,
    `writer` VARCHAR(45) NULL,
    `start_time` DATETIME NULL,
    `end_time` DATETIME NULL,
    `created_at` DATETIME NOT NULL,
    `modified_at` DATETIME NULL,
    PRIMARY KEY (`event_id`),
    INDEX `calandar_id_idx` (`family_id` ASC) VISIBLE,
    CONSTRAINT `event_familyId`
    FOREIGN KEY (`family_id`)
    REFERENCES `kbt1`.`family` (`family_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kbt1`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kbt1`.`message` (
                                                `message_id` BIGINT NOT NULL,
                                                `sender_id` BIGINT NOT NULL,
                                                `receiver_id` BIGINT NOT NULL,
                                                `video_url` VARCHAR(45) NULL,
    `transfer_id` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL,
    `modified_at` DATETIME NULL,
    PRIMARY KEY (`message_id`),
    INDEX `sender_id_idx` (`sender_id` ASC) VISIBLE,
    INDEX `transfer_id_idx` (`transfer_id` ASC) VISIBLE,
    INDEX `message_receiverId_idx` (`receiver_id` ASC) VISIBLE,
    CONSTRAINT `message_senderId`
    FOREIGN KEY (`sender_id`)
    REFERENCES `kbt1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `message_transferId`
    FOREIGN KEY (`transfer_id`)
    REFERENCES `kbt1`.`transfer` (`transfer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `message_receiverId`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `kbt1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
