#create SMS DataBase
CREATE SCHEMA `sms` ;

#create course

CREATE TABLE `sms`.`course` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

#create courseMainDetails

CREATE TABLE `sms`.`cor_main_details` (
  `cr_id` INT NOT NULL,
  `cr_name` VARCHAR(20) NOT NULL,
  `duration` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `description` VARCHAR(200) NULL,
  `category_id` INT NOT NULL,
  `type_id` INT NOT NULL,
  `level_id` INT NOT NULL,
  PRIMARY KEY (`cr_id`),
  UNIQUE INDEX `cr_id_UNIQUE` (`cr_id` ASC));

#create courseCategory

CREATE TABLE `sms`.`cor_category` (
  `id` INT NOT NULL,
  `label_en` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  PRIMARY KEY (`id`));

#create courseType

CREATE TABLE `sms`.`cor_type` (
  `id` INT NOT NULL,
  `label_en` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

#create courseLevel

CREATE TABLE `sms`.`cor_level` (
  `id` INT NOT NULL,
  `label_en` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
