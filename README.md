-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema im20db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `im20db` ;

-- -----------------------------------------------------
-- Schema im20db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `im20db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
SHOW WARNINGS;
USE `im20db` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(255) NULL DEFAULT NULL,
  `user_login_id` VARCHAR(255) NULL DEFAULT NULL,
  `user_password` VARCHAR(255) NULL DEFAULT NULL,
  `user_login_type` INT NULL DEFAULT NULL COMMENT '로그인 방식',
  `user_sns_key` INT NULL DEFAULT NULL COMMENT 'sns 로그인 키',
  `user_phone` INT NULL DEFAULT NULL,
  `user_email` VARCHAR(255) NULL DEFAULT NULL,
  `user_parent_password` VARCHAR(255) NULL DEFAULT NULL,
  `user_profile_photo` VARCHAR(255) NULL DEFAULT NULL COMMENT '프로필 사진',
  `user_level` INT NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `user_id_UNIQUE` (`user_login_id` ASC) VISIBLE,
  UNIQUE INDEX `user_phone_UNIQUE` (`user_phone` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `manage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `manage` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `manage` (
  `manage_id` INT NOT NULL AUTO_INCREMENT,
  `manage_date` DATE NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  `breathing_feedback` LONGTEXT NULL DEFAULT NULL,
  `fluency_feedback` LONGTEXT NULL DEFAULT NULL,
  `pronunciation_feedback` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`manage_id`),
  INDEX `fk_manage_user` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_manage_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `breathing_training`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `breathing_training` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `breathing_training` (
  `breathing_training_id` INT NOT NULL AUTO_INCREMENT,
  `manage_id` INT NOT NULL,
  `total_breaths` INT NULL DEFAULT NULL COMMENT '하루 동안 풍선을 분 횟수',
  `average_length` FLOAT NULL DEFAULT NULL COMMENT '평균 풍선 불기 시간',
  `total_success_cnt` INT NULL DEFAULT NULL COMMENT '하루 동안 성공한 횟수',
  PRIMARY KEY (`breathing_training_id`),
  INDEX `fk_breathing_summary_manage_idx` (`manage_id` ASC) VISIBLE,
  CONSTRAINT `fk_breathing_summary_manage`
    FOREIGN KEY (`manage_id`)
    REFERENCES `manage` (`manage_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `breathing_training_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `breathing_training_details` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `breathing_training_details` (
  `bt_detail_id` INT NOT NULL AUTO_INCREMENT,
  `bt_summary_id` INT NOT NULL,
  `bt_length` FLOAT NULL DEFAULT NULL COMMENT '지속 시간',
  `bt_level1` FLOAT NULL DEFAULT NULL,
  `bt_level2` FLOAT NULL DEFAULT NULL,
  `bt_level3` FLOAT NULL DEFAULT NULL,
  `bt_level4` FLOAT NULL DEFAULT NULL,
  `bt_level5` FLOAT NULL DEFAULT NULL,
  `bt_level6` FLOAT NULL DEFAULT NULL,
  `bt_success_cnt` INT NULL DEFAULT NULL,
  PRIMARY KEY (`bt_detail_id`),
  INDEX `bt_summary_id_idx` (`bt_summary_id` ASC) VISIBLE,
  CONSTRAINT `fk_breathing_training_summary`
    FOREIGN KEY (`bt_summary_id`)
    REFERENCES `breathing_training` (`breathing_training_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `fluency_training`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fluency_training` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `fluency_training` (
  `fluency_training_id` INT NOT NULL AUTO_INCREMENT,
  `manage_id` INT NOT NULL,
  PRIMARY KEY (`fluency_training_id`),
  INDEX `ft_manage_id_idx` (`manage_id` ASC) VISIBLE,
  CONSTRAINT `fk_fluency_training_manage`
    FOREIGN KEY (`manage_id`)
    REFERENCES `manage` (`manage_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pronunciation_training`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pronunciation_training` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pronunciation_training` (
  `pronunciation_training_id` INT NOT NULL AUTO_INCREMENT,
  `pt_attempt` INT NULL DEFAULT NULL,
  `pt_success_cnt` TINYINT(1) NULL DEFAULT NULL,
  `manage_id` INT NOT NULL,
  PRIMARY KEY (`pronunciation_training_id`),
  INDEX `fk_pronunciation_training_manage` (`manage_id` ASC) VISIBLE,
  CONSTRAINT `fk_pronunciation_training_manage`
    FOREIGN KEY (`manage_id`)
    REFERENCES `manage` (`manage_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pronunciation_training_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pronunciation_training_details` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pronunciation_training_details` (
  `pt_detail_id` INT NOT NULL AUTO_INCREMENT,
  `pronunciation_training_id` INT NOT NULL,
  `pt_word` VARCHAR(45) NULL DEFAULT NULL,
  `pt_text` VARCHAR(45) NULL DEFAULT NULL,
  `pt_child_voice` VARCHAR(255) NULL DEFAULT NULL,
  `pt_teacher_voice` VARCHAR(255) NULL DEFAULT NULL,
  `pt_score` INT NULL DEFAULT NULL,
  `pt_feedback` VARCHAR(255) NULL DEFAULT NULL,
  `pt_index` INT NOT NULL,
  PRIMARY KEY (`pt_detail_id`),
  INDEX `fk_pronunciation_training_details` (`pronunciation_training_id` ASC) VISIBLE,
  CONSTRAINT `fk_pronunciation_training_details`
    FOREIGN KEY (`pronunciation_training_id`)
    REFERENCES `pronunciation_training` (`pronunciation_training_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
